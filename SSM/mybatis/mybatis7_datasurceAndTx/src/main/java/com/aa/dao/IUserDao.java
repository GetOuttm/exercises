package com.aa.dao;

import com.aa.domain.QueryVo;
import com.aa.domain.User;

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
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除
     * @param userId
     */
    void deleteUser(Integer userId);


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
     * 查询总记录条数
     * @return
     */
    int totalCount();

    /**
     * 根据QueryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

}
