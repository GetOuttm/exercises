package JDBC;

import JDBC.JDBCUtils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 练习
 *  需求
 *      1.通过键盘录入用户名以及密码
 *      2.判断用户是否登录成功
 */
public class JDBCDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();

        boolean login = new JDBCDemo01().login(username, password);
        if (login == true) {
            System.out.println("登陆成功");
        } else {
            System.out.println("用户名或密码错误");
        }
    }

    /**
     * 登陆方法
     */
    public boolean login(String username,String password) {
        if (username == null || password == null) {
            return false;
        }

        Connection connection = null;
        PreparedStatement  statement = null;
        ResultSet resultSet = null;
        //连接数据库判断是否登录成功
        //1.获取连接
        try {
            connection = JDBCUtils.getconnection();
            //获取当前事务的提交方式   true：自动提交  false：不自动提交
//            System.out.println(connection.getAutoCommit());
            //2.定义sql
            String sql =
                    "SELECT * FROM user WHERE username = ? AND password = ?;";
            //3.获取执行sql的对象
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            //4.执行查询
            resultSet = statement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet,statement,connection);
        }
        return false;
    }
}
