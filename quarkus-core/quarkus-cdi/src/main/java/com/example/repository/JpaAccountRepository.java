package com.example.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import org.jboss.logging.Logger;

import com.example.AccountRepositoryQualifier;
import com.example.MyQuarkusApplication;
import com.example.entity.Account;

@Singleton   
//@AccountRepositoryQualifier(tech = "jpa")
public class JpaAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger(MyQuarkusApplication.class);

	public JpaAccountRepository() {
		logger.info("JpaAccountRepository instance created..");
	}
	
	public Account loadAccount(String number) {
		// ..
		return null;
	}

	public Account updateAccount(Account account) {

		// ..
		return null;
	}

}
