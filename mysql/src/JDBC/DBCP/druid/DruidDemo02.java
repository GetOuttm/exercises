package JDBC.DBCP.druid;

import JDBC.DBCP.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用工具类
 */
public class DruidDemo02 {
    public static void main(String[] args) {
        /**
         * 完成添加操作,给account添加记录
         */
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //定义sql
            String sql = "INSERT INTO account VALUES(null,?,?)";
            //获取PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"好累");
            preparedStatement.setDouble(2,2222);
            //执行sql
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(preparedStatement,connection);
        }


    }
}
