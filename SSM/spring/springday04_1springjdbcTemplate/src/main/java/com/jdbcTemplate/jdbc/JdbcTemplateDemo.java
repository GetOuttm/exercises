package com.jdbcTemplate.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate基本用法
 */
public class JdbcTemplateDemo {

    public static void main(String[] args) {
        //1.获取连接
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        jdbcTemplate.execute("insert into account(name,money) values('eee',10000)");


        /*//准备数据源，spring的内置数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springdb");
        dataSource.setUsername("root");
        dataSource.setPassword("123");

        //1.创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //给jdbcTemplate设置数据源
        jdbcTemplate.setDataSource(dataSource);

        //2.执行操作
        jdbcTemplate.execute("insert into account(name,money) values('ddd',10000)");*/
    }
}
