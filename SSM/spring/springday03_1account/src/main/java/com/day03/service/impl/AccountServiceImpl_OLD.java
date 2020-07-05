package com.day03.service.impl;

import com.day03.dao.AccountDao;
import com.day03.entity.Account;
import com.day03.service.AccountService;
import com.day03.utils.TransactionManager;

import java.util.List;

/**
 * 事务控制在业务层实现类
 */
public class AccountServiceImpl_OLD implements AccountService {

    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        try {
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            List<Account> accounts = accountDao.findAll();
            //提交事务
            transactionManager.commitTransaction();
            //返回结果
            return accounts;
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //释放连接
            transactionManager.closeTransaction();
        }
    }

    public Account findOne(Integer id) {
        try {
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            Account account = accountDao.findByID(id);
            //提交事务
            transactionManager.commitTransaction();
            //返回结果
            return account;
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //释放连接
            transactionManager.closeTransaction();
        }
    }

    public void saveAccount(Account account) {
        try {
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            accountDao.save(account);
            //提交事务
            transactionManager.commitTransaction();
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
        } finally {
            //释放连接
            transactionManager.closeTransaction();
        }
    }

    public void updateAccount(Account account) {
        try {
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            accountDao.update(account);
            //提交事务
            transactionManager.commitTransaction();
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
        } finally {
            //释放连接
            transactionManager.closeTransaction();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
            accountDao.delete(id);
            //提交事务
            transactionManager.commitTransaction();
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
        } finally {
            //释放连接
            transactionManager.closeTransaction();
        }
    }


    public void transfer(String sourceName, String targetName, Float money) {

        try {
            //开启事务
            transactionManager.beginTransaction();
            //执行操作
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

            /*int i = 1/0;*/
            //更新转入账户
            accountDao.update(target);

            //提交事务
            transactionManager.commitTransaction();
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        } finally {
            //释放连接
            transactionManager.closeTransaction();
        }

    }
}
