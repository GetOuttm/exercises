package JDBC;

import JDBC.JDBCUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 事务操作
 */
public class JDBCDemo02 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        //1.获取链接
        try {
            connection = JDBCUtils.getconnection();

            //开启事务
            connection.setAutoCommit(false);
            //定义sql
            String sql1 = "UPDATE account SET balance = balance - ? WHERE id = ?;";
            String sql2 = "UPDATE account SET balance = balance + ? WHERE id = ?;";

            //获取sql对象
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);

            //设置参数
            preparedStatement1.setDouble(1,500);
            preparedStatement1.setInt(2,2);
            preparedStatement2.setDouble(1,500);
            preparedStatement2.setInt(2,3);

            //执行sql
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();

            //手动制造异常
            int i = 1/0;

            connection.commit();
        } catch (Exception e) {
            //事务回滚
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JDBCUtils.close(preparedStatement1,connection);
            JDBCUtils.close(preparedStatement2,null);
        }
    }
}
