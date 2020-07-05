package com.orcl.demo;

import oracle.jdbc.OracleTypes;
import org.junit.Test;

import java.sql.*;

public class OracleDemo {

    @Test
    public void javaJdbcOracle() throws Exception {
        //加载数据库驱动
        Class.forName("oracle.jdbc.OracleDriver");
        //得到connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
        //得到预编译对象
        PreparedStatement statement = connection.prepareStatement("select * from emp where empno = ?");
        //给参数赋值
        statement.setObject(1,7788);
        //执行数据库操作
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
            System.out.println(resultSet.getString("ename"));
        }
        //释放资源
        resultSet.close();
        connection.close();
        statement.close();
    }

    /**
     * java调用存储过程
     *  {?= call <procedure-name>[(<arg1>,<arg2>, ...)]} 调用存储函数
     *  {call <procedure-name>[(<arg1>,<arg2>, ...)]}   调用存储过程
     * @throws Exception
     */
    @Test
    public void javaCallProcedure() throws Exception {
        //加载数据库驱动
        Class.forName("oracle.jdbc.OracleDriver");
        //得到connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
        //得到预编译对象
        CallableStatement statement = connection.prepareCall("{call p_yearsal(?,?)}");
        //给参数赋值
        statement.setObject(1,7788);
        statement.registerOutParameter(2, OracleTypes.NUMBER);
        /*//执行数据库操作
        ResultSet resultSet = statement.executeQuery();*/
        statement.execute();
        //输出结果   第二个参数
        System.out.println(statement.getObject(2));
        //释放资源
        connection.close();
        statement.close();
    }

    /**
     * java调用存储过程
     *  {?= call <procedure-name>[(<arg1>,<arg2>, ...)]} 调用存储函数
     *  {call <procedure-name>[(<arg1>,<arg2>, ...)]}   调用存储过程
     * @throws Exception
     */
    @Test
    public void javaCallFunction() throws Exception {
        //加载数据库驱动
        Class.forName("oracle.jdbc.OracleDriver");
        //得到connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
        //得到预编译对象
        CallableStatement statement = connection.prepareCall("{?= call f_yearsal(?)}");
        //给参数赋值
        statement.setObject(2,7788);
        statement.registerOutParameter(1, OracleTypes.NUMBER);
        /*//执行数据库操作
        ResultSet resultSet = statement.executeQuery();*/
        statement.execute();
        //输出结果   第一个参数
        System.out.println(statement.getObject(1));
        //释放资源
        connection.close();
        statement.close();
    }
}
