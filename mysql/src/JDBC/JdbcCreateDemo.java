package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * 创建一张表  DDL
 */
public class JdbcCreateDemo {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "CREATE TABLE student(id int,name varchar(20));";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
            statement = connection.createStatement();
            int executeUpdate = statement.executeUpdate(sql);
            System.out.println(executeUpdate);
            //因为是增加所以返回是一个0
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //避免空指针异常
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
