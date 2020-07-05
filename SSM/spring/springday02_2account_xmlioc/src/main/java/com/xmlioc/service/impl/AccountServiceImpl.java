package com.xmlioc.service.impl;

import com.xmlioc.dao.AccountDao;
import com.xmlioc.entity.Account;
import com.xmlioc.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findOne(Integer id) {
        return accountDao.findByID(id);
    }

    public void saveAccount(Account account) {
        accountDao.save(account);
    }

    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.delete(id);
    }
}
