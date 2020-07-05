package com.ljf.dao;

import com.ljf.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();
}
