package JDBC.JDBCUtils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具列
 */
public class JDBCUtils {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;


    /**
     * 文件的读取只需要读取一次，使用静态代码块
     */
    static {
        //读取资源文件jdbc.properties获取值

        try {
            //1.Properties集合类
            Properties properties = new Properties();

            //获取src路径下文件的方法是  ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            System.out.println(path);

            //2.加载文件
            /*properties.load(new FileReader("D:\\IDEA\\java\\BigDemo\\mysql\\src\\jdbc" +
                    ".properties"));*/
            properties.load(new FileReader(path));
            //3.获取值
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            //4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接对象
     * @return 连接对象
     * 需求：不传参，要保证工具类的通用性
     * 解决：配置文件
     * jdbc.properties
     */
    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }


    /**
     * 释放资源
     */
    public static void close(Statement statement,Connection connection) {
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
    public static void close(ResultSet resultSet,Statement statement, Connection connection) {
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
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
