package com.account_tx.dao;

import com.account_tx.domain.Account;

/**
 * 账户的持久层接口
 */
public interface AccountDao {

    Account findAccountById(Integer id);

    Account findAccountByName(String name);

    void updateAccount(Account account);
}
