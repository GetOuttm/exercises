package com.txxml.service.impl;

import com.txxml.dao.AccountDao;
import com.txxml.domain.Account;
import com.txxml.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        //根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //转出账户减钱
        source.setMoney(source.getMoney()-money);
        //转入账户加钱
        target.setMoney(target.getMoney() + money);
        //更新转出账户
        accountDao.updateAccount(source);

//            int i = 1/0;
        //更新转入账户
        accountDao.updateAccount(target);
    }
}
