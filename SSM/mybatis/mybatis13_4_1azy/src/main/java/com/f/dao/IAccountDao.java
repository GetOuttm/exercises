package com.f.dao;

import com.f.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAccount();


    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountByUid(Integer uid);
}
