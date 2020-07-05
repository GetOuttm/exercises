package com.vue.service;

import com.vue.entity.User;

import java.util.List;

/**
 * 业务层接口
 */
public interface UserService {

    /**
     * 查询用户列表
     */
    List<User> findAll();

    /**
     * 根据id查询
     */
    User findByID(Integer id);

    /**
     * 更新数据
     */
    void updateUser(User user);
}
