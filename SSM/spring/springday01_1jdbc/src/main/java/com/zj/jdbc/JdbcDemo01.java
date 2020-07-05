package com.zj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序耦合
 *      耦合：程序之间的依赖关系
 *          包括：类之间的依赖
 *               方法间的依赖
 *     解耦：降低程序之间的依赖关系
 *          第一步：使用反射来创建对象，而避免使用new关键字
 *          第二步：通过读取配置文件来获取要创建对象的全限定类名
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///springdb", "root", "123");
        //3.获取操作数据库的预编译对象
        PreparedStatement statement = connection.prepareStatement("select * from account");
        //4.执行sql，获取结果集
        ResultSet resultSet = statement.executeQuery();
        //5.遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }

}
