package com.example.repository;

import javax.enterprise.context.ApplicationScoped;

import com.example.entity.Account;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class AccountRepository implements PanacheRepositoryBase<Account,String> {

}
