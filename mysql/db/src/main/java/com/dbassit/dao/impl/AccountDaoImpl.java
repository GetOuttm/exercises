package com.dbassit.dao.impl;

import com.dbassit.dao.AccountDao;
import com.dbassit.dbassti.DBAssit;
import com.dbassit.entity.Account;
import com.dbassit.handler.impl.BeanHandler;
import com.dbassit.handler.impl.BeanListHandler;
import com.dbassit.utils.C3P0Util;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private DBAssit dbAssit = new DBAssit(C3P0Util.getDataSource());

    public void save(Account account) {
        dbAssit.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
    }

    public void update(Account account) {
        dbAssit.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    public void delete(Integer id) {
        dbAssit.update("delete from account where id=? ",id);
    }

    public Account findByID(Integer id) {
        return (Account) dbAssit.query("select * from account where id =?",new BeanHandler(Account.class),id);
    }

    public List<Account> findAll() {
        return (List<Account>) dbAssit.query("select * from account",new BeanListHandler(Account.class));
    }

}
