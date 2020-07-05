package com.ssm.service;

import com.ssm.domain.Account;

import java.util.List;
//業務層
public interface AccountService {

    List<Account> findAll();

    void saveAccount(Account account);
}
