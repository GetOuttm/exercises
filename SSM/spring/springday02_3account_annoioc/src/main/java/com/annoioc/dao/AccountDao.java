package com.annoioc.dao;

import com.annoioc.entity.Account;

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
