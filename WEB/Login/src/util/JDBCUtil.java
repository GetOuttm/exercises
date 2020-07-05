package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类，
 */
public class JDBCUtil {

    private static DataSource dataSource;

    static {
        //1.加载配置文件
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));

            //2.初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     * @return
     */
    public static DataSource getDateSource(){
        return dataSource;
    }

    /**
     * 获取连接Connection对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
