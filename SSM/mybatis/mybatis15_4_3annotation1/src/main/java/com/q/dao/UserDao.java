package com.q.dao;

import com.q.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * mybatis中针对CRUD有4个注解
 * @Select @Insert @Update @Delete
 */
public interface UserDao {

    /**
     * 查询所有用户
     * 当注解与xml配置文件同时存在会报错
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values (#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除
     * @param userId
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer userId);

    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like '%${value}%'")
    List<User> findByUsername(String username);
}
