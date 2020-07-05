package com.tx.jdbc;

import com.tx.dao.AccountDao;
import com.tx.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * JdbcTemplate基本用法
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        //1.获取连接
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        //3.执行操作
        Account account = accountDao.findAccountById(13);
        System.out.println(account);


        account.setMoney(987654321F);
        accountDao.updateAccount(account);
    }
}
