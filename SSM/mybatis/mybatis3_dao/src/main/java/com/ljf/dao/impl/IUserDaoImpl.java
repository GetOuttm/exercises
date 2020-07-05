package com.ljf.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.ljf.dao.IUserDao;
import com.ljf.domain.User;

import java.util.List;

public class IUserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public IUserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        //使用工厂创建sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //使用sqlsession执行查询所有方法
        List<User> users = sqlSession.selectList("IUserDao.findAll");
        sqlSession.close();
        //返回查询结果
        return users;
    }
}
