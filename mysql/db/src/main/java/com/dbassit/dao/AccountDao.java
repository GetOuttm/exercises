package com.dbassit.dao;

import com.dbassit.entity.Account;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface AccountDao {

    void save(Account account);

    void update(Account account);

    void delete(Integer id);

    Account findByID(Integer id);

    List<Account> findAll();
}
