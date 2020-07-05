package com.account_tx.dao.impl;

import com.account_tx.dao.AccountDao;
import com.account_tx.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

//趋于xml配置
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    public Account findAccountById(Integer id) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name=?,money=? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
