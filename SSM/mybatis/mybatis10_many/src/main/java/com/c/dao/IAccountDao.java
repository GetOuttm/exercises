package com.c.dao;

import com.c.domain.Account;
import com.c.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAccount();

    /**
     * 查询所有账户，并且带由用户信息和地址信息
     * @return
     */
    List<AccountUser> findAccounts();
}
