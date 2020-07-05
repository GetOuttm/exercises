package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * 添加一条记录
 */
public class JdbcInsertDemo {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "INSERT INTO account values(null,'赵六',3000);";
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
            statement = connection.createStatement();
            int executeUpdate = statement.executeUpdate(sql);
            System.out.println(executeUpdate);
            if (executeUpdate > 0) {
                System.out.println("添加成功！");
            } else {
                System.out.println("添加失败！");
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
