package com.b.dao;

import com.b.domain.QueryVo;
import com.b.domain.User;

import java.util.List;

/**
 * 持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有
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
     * 模糊查询
     * @param username
     * @return
     */
    List<User> findByUsername(String username);


    /**
     * 根据QueryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);


    /**
     * 根据传入的参数条件查询
     * @param user  查询的条件，有可能是user的信息
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo中提供的id
     * 集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
