package com.annoioc.service.impl;

import com.annoioc.service.AccountService;
import com.annoioc.dao.AccountDao;
import com.annoioc.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

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
