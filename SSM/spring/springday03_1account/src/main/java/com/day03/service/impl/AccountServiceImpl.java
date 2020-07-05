package com.day03.service.impl;

import com.day03.dao.AccountDao;
import com.day03.entity.Account;
import com.day03.service.AccountService;
import com.day03.utils.TransactionManager;

import java.util.List;

/**
 * 事务控制在业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

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


    public void transfer(String sourceName, String targetName, Float money) {
            //根据名称查询转出账户
            Account source = accountDao.findByName(sourceName);
            //根据名称查询转入账户
            Account target = accountDao.findByName(targetName);
            //转出账户减钱
            source.setMoney(source.getMoney()-money);
            //转入账户加钱
            target.setMoney(target.getMoney() + money);
            //更新转出账户
            accountDao.update(source);
            //更新转入账户
            accountDao.update(target);
    }
}
