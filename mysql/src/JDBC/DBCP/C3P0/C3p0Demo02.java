package JDBC.DBCP.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0参数演示
 */
public class C3p0Demo02 {
    public static void main(String[] args) throws SQLException {
        //1.创建连接池对象
        //使用默认配置
        DataSource dataSource = new ComboPooledDataSource();
        //2.获取连接对象
        for (int i = 1;i<=11;i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + ":" + connection);
            if (i == 5) {
                connection.close();//归还连接到连接池
            }
        }
        testNameConfig();
    }

    public static void testNameConfig() throws SQLException {
        //使用指定名称配置
        DataSource dataSource = new ComboPooledDataSource("otherc3p0");
        //2.获取连接对象
        for (int i = 1;i<=10;i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + ":" + connection);

            /*if (i == 5) {
                connection.close();//归还连接到连接池
            }*/
        }
    }
}
