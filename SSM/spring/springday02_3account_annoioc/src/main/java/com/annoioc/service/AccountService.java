package com.annoioc.service;

import com.annoioc.entity.Account;

import java.util.List;

/*
账户的业务层接口
 */
public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 查一个
     * @return
     */
    Account findOne(Integer id);

    /**
     * 增
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 改
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删
     * @param id
     */
    void deleteAccount(Integer id);
}
