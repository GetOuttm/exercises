package com.xmlioc.dao.impl;

import com.xmlioc.dao.AccountDao;
import com.xmlioc.entity.Account;
import com.xmlioc.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
//    private QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void save(Account account) {
        try {
            runner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        try {
            runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id) {
        try {
            runner.update("delete from account where id=? ",id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findByID(Integer id) {
        try {
            return (Account) runner.query("select * from account where id =?",new BeanHandler<Account>(Account.class),id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        try {
            return (List<Account>) runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
