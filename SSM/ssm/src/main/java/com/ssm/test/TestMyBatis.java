package com.ssm.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.ssm.dao.AccountDao;
import com.ssm.domain.Account;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testFindAll() throws Exception {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapperConfig.xml");

        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //创建SqlSession
        SqlSession sqlSession = factory.openSession();

        //获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);

        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

        sqlSession.close();
        is.close();
    }

    @Test
    public void testSave() throws Exception {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapperConfig.xml");

        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //创建SqlSession
        SqlSession sqlSession = factory.openSession();

        //获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);

        Account account = new Account();
        account.setName("爸爸");
        account.setMoney(789456F);
        dao.saveAccount(account);

        //提交事务
        sqlSession.commit();

        sqlSession.close();
        is.close();
    }
}
