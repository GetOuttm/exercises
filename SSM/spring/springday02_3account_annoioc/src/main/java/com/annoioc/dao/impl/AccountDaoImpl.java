package com.annoioc.dao.impl;

import com.annoioc.dao.AccountDao;
import com.annoioc.entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
//    private QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());

    @Autowired
    private QueryRunner runner;

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
