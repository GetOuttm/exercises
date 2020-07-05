package com.kk.dao;

import org.apache.ibatis.annotations.*;

import com.kk.domain.User;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * mybatis中针对CRUD有4个注解
 * @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)
public interface UserDao {

    /**
     * 查询所有用户
     * 当注解与xml配置文件同时存在会报错
     *
     * 如果实体类与数据库参数名称不同可使用以下的@Results
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMapper",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(property = "accounts",column = "id",many=@Many(select = "com.kk.dao.AccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
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
    @ResultMap(value ={"userMapper"})
    User findById(Integer id);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like '%${value}%'")
    List<User> findByUsername(String username);
}
