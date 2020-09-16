package com.example.service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.transaction.UserTransaction;

import org.jboss.logging.Logger;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import io.quarkus.narayana.jta.runtime.TransactionConfiguration;

@ApplicationScoped
public class TxrServiceImpl implements TxrService {

	@Inject
	private AccountRepository accountRepository;

	@Inject
	UserTransaction userTransaction;

	private static Logger logger = Logger.getLogger(TxrServiceImpl.class);

	@TransactionConfiguration(timeout = 30)
	@Transactional(value = TxType.REQUIRED)
	public void txr(double amount, String fromAccNumber, String toAccNumber) {

		Optional<Account> fromAccountOptional = accountRepository.findByIdOptional(fromAccNumber);
		Account fromAccount = fromAccountOptional.orElseThrow(() -> new AccountNotFoundException());

		Optional<Account> toAccountOptional = accountRepository.findByIdOptional(toAccNumber);
		Account toAccount = toAccountOptional.orElseThrow(() -> new AccountNotFoundException());

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.update("balance=?1 where num=?2", fromAccount.getBalance(), fromAccount.getNumber());
		accountRepository.update("balance=?1 where num=?2", toAccount.getBalance(), toAccount.getNumber());

	}

}
