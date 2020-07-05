package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * 修改一条记录
 */
public class JdbcUpdateDemo {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "UPDATE account SET balance = balance +10000 WHERE id = 1;";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
            statement = connection.createStatement();
            int executeUpdate = statement.executeUpdate(sql);
            System.out.println(executeUpdate);
            if (executeUpdate > 0) {
                System.out.println("修改成功！");
            } else {
                System.out.println("修改失败！");
            }
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
