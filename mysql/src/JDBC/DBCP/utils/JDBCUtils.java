package JDBC.DBCP.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池工具类
 */
public class JDBCUtils {
    //1.定义一个成员变量 DataSource
    private static DataSource dataSource;

    static {
        try {
            //加载配置文件
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取DataSource
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


    /**
     * 释放资源
     */
    public static void close(Statement statement,Connection connection) {
        if (statement != null) {
            try {
                statement.close();//释放
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                statement.close();//归还
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet resultSet,Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                statement.close();//释放
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();//释放
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                statement.close();//归还
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
}
