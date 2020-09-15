package com.example.repository;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.inject.Singleton;

import org.jboss.logging.Logger;

import com.example.AccountRepositoryQualifier;
import com.example.MyQuarkusApplication;
import com.example.entity.Account;

//@ApplicationScoped 
//@SessionScoped
//@RequestScoped
//@Singleton   
//@AccountRepositoryQualifier(tech = "jdbc")
public class JdbcAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger(MyQuarkusApplication.class);

	public JdbcAccountRepository() {
		logger.info("JdbcAccountRepository instance created..");
	}

	@Override
	public Account loadAccount(String number) {
		// ..
		logger.info("loading account : " + number);
		return null;
	}

	@Override
	public Account updateAccount(Account account) {
		logger.info("updating account ");
		// ..
		return null;
	}

}
