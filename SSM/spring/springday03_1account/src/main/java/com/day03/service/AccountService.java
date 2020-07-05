package com.day03.service;

import com.day03.entity.Account;

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

    /**
     * 转账
     * @param sourceName   转出账户的名称
     * @param targetName   转入账户的名称
     * @param money         转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
