package com.h.dao;

import com.h.domain.User;

import java.util.List;

/**
 * 持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有 同时获取到用户下的所有账户信息
     * @return
     */
    List<User> findAll();


    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);
}
