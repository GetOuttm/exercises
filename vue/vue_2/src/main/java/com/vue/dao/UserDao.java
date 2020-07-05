package com.vue.dao;

import com.vue.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    /**
     * 查询用户列表
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据id查询
     */
    @Select("select * from user where id = #{id}")
    User findByID(Integer id);

    /**
     * 更新数据
     */
    @Update("update user set username=#{username},age=#{age} ,password=#{password} ,email=#{email} ,sex=#{sex} where id=#{id} ")
    void updateUser(User user);
}
