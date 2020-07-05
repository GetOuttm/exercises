package com.accountaop.dao.impl;

import com.accountaop.dao.AccountDao;
import com.accountaop.entity.Account;
import com.accountaop.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtil connectionUtil;

    public void save(Account account) {
        try {
            runner.update(connectionUtil.getThreadConnection(),"insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        try {
            runner.update(connectionUtil.getThreadConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id) {
        try {
            runner.update(connectionUtil.getThreadConnection(),"delete from account where id=? ",id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findByID(Integer id) {
        try {
            return runner.query(connectionUtil.getThreadConnection(),"select * from account where id =?",new BeanHandler<Account>(Account.class),id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        try {
            return runner.query(connectionUtil.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String name) {
        try {
            List<Account> accounts = runner.query(connectionUtil.getThreadConnection(),"select * from account where name = ?",new BeanListHandler<Account>(Account.class),name);
            if (accounts == null || accounts.size() == 0) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("结果集不唯一，数据有问题(重复)");
            }
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
