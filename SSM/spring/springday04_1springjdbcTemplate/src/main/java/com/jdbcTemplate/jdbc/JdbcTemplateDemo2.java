package com.jdbcTemplate.jdbc;

import com.jdbcTemplate.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD
 */
public class JdbcTemplateDemo2 {

    public static void main(String[] args) {
        //1.获取连接
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        //保存
//        jdbcTemplate.update("insert into account(name,money) values(?,?)","fff",1234);
        //更新
//        jdbcTemplate.update("update account set name=?,money=? where id = ?","ggg",1234,14);
        //删除
//        jdbcTemplate.update("delete from account where id =?",14);
        //查询所有
//        List<Account> accounts = jdbcTemplate.query("select * from account", new AccountRowMapper());
        /*List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class);
        for (Account account : accounts) {
            System.out.println(account);
        }*/

        //查询一个
        List<Account> accounts = jdbcTemplate.query("select * from account where id =?", new BeanPropertyRowMapper<Account>(Account.class),13);
        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));
        //查询返回一行一列(使用聚合函数，但不加group by子句)
        Long count = jdbcTemplate.queryForObject("select count(*) from account where money > ?", Long.class, 1000F);
        System.out.println(count);

    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {
    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId((resultSet.getInt("id")));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
