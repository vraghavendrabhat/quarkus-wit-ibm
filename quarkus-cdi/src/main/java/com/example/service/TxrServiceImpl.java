package com.example.service;

import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import com.example.AccountRepositoryQualifier;
import com.example.MyQuarkusApplication;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;

import io.quarkus.arc.DefaultBean;

/*
 * 
 * 
 *  design & performance issues
 *  ----------------------------
 *  
 *  => dependent & dependency components are tightly-coupled
 *  	-> can't with new features easily
 *  => too many duplicate dependency instances are created & destroyed
 *  	-> memory/resource use high
 *  => unit-testing not possible
 *  	-> dev/bug fix slow
 *  
 *  
 *  why these issues ?
 *  
 *  	-> dependent itself creating its own dependency
 *  
 *  soln :
 *  
 *  	-> never create dependency in dependent's home ( class ) , use Factory Design Pattern
 *  
 *  
 *   Limitation with  Factory Lookup :
 *   
 *   	-> Factory Location Tight-coupling
 *  
 *  
 *  best soln :
 *  
 *  	--> dont create / lookup , inject through 'third-party'   ( Inversion of Control ) IOC
 *  
 *  
 *  
 *   how to implement IOC ?
 *   
 *   
 *   	==> using dependency injection  ( DI )
 *   
 *   
 *   ----------------------------------------------------------------------------------
 *   
 *   
 *   OO concepts
 *   OO principles   A.K.A SOLID principles
 *   OO patterns
 *   
 *   
 *  ----------------------------------------------------------------------------------
 * 
 */

@ApplicationScoped
public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger(MyQuarkusApplication.class);

	@Inject
//	@AccountRepositoryQualifier(tech = "jdbc")
	AccountRepository accountRepository;
	
	@Inject
	@Named("es_ES")
	Locale locale;

	public TxrServiceImpl(AccountRepository accountRepository) {
//		super();
//		this.accountRepository = accountRepository;
		logger.info("TxrService instance created");
	}

	@Override
	public void txr(double amount, String fromAccNumber, String toAccNumber) {
		// .
		logger.info("txr intiated..");
//		Account fromAccount = accountRepository.loadAccount(fromAccNumber);
//		Account toAccount = accountRepository.loadAccount(toAccNumber);

		// ..

//		accountRepository.updateAccount(fromAccount);
//		accountRepository.updateAccount(toAccount);
		
		System.out.println(locale.getCountry());

		logger.info("txr finished..");
		// ..
	}

}
