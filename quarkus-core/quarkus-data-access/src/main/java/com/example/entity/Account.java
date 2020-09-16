package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="ACCOUNTS")
public class Account /*extends PanacheEntityBase*/ {

	@Id
	@Column(name = "num")
	private String number;
	private double balance;

//	public List<Account> findAccountByBalance(double balance) {
//		return list("balance", balance);
//	}

	public Account() {
	}

	public Account(String number, double balance) {
		super();
		this.number = number;
		this.balance = balance;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
