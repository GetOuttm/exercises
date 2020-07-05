package com.day03.dao;

import com.day03.entity.Account;

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

    /**
     * 根据用户名查询账户信息
     * @param name
     * @return   如果有唯一的结果就返回，没有就返回null，如果超过一个就返回异常
     */
    Account findByName(String name);

}
