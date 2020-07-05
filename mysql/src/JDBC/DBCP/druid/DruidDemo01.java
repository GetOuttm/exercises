package JDBC.DBCP.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid演示
 */
public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        Properties properties = new Properties();
        properties.load(DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties"));
        //3.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //4.获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
