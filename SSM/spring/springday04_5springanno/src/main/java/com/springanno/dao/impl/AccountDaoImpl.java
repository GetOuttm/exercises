package com.springanno.dao.impl;

import com.springanno.dao.AccountDao;
import com.springanno.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account findAccountById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=?,money=? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
