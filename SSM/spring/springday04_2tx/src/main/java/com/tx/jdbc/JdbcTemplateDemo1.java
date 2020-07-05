package com.tx.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate基本用法
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //1.获取连接
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        jdbcTemplate.execute("insert into account(name,money) values('eee',10000)");

    }
}
