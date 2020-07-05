package com.txxml.dao;

import com.txxml.domain.Account;

/**
 * 账户的持久层接口
 */
public interface AccountDao {

    Account findAccountById(Integer id);

    Account findAccountByName(String name);

    void updateAccount(Account account);
}
