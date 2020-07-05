package com.ljf.dao.impl;

import com.ljf.dao.IUserDao;
import com.ljf.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class IUserDaoImpl implements IUserDao
{

    private SqlSessionFactory factory;

    public IUserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //根据factory获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //调用sqlSession的方法查询列表
        List<User> users = sqlSession.selectList("com.ljf.dao.IUserDao.findAll");//参数是获取到能获取到配置信息的key
        //释放资源
        sqlSession.close();
        return users;
    }

    public void saveUser(User user) {
        //根据factory获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //调用方法
        sqlSession.insert("com.ljf.dao.IUserDao.saveUser",user);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    public void updateUser(User user) {
        //根据factory获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //调用方法
        int update = sqlSession.update("com.ljf.dao.IUserDao.updateUser", user);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    public void deleteUser(Integer userId) {
//根据factory获取sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //调用方法
        int update = sqlSession.delete("com.ljf.dao.IUserDao.deleteUser");
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    public User findById(Integer userId) {
        SqlSession sqlSession = factory.openSession();
        //调用方法
        User user = sqlSession.selectOne("com.ljf.dao.IUserDao.findById", userId);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        return user;
    }

    public List<User> findByUsername(String username) {

        SqlSession sqlSession = factory.openSession();
        //调用方法
        List<User> users = sqlSession.selectList("com.ljf.dao.IUserDao.findByUsername", username);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        return users;
    }

    public int totalCount() {
        SqlSession sqlSession = factory.openSession();
        //调用方法
        int total = sqlSession.selectOne("com.ljf.dao.IUserDao.totalCount");
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        return total;
    }
}
