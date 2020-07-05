package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 和spring连接数据库相关的配置
 */
public class JdbcConfig {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String username;
    @Value("${password}")
    private String password;

    /**
     * 用于创建QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass(driver);
            cpds.setJdbcUrl(url);
            cpds.setUser(username);
            cpds.setPassword(password);
            return cpds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "ds1")
    public DataSource createDataSource1() {
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass(driver);
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/springdb");
            cpds.setUser(username);
            cpds.setPassword(password);
            return cpds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
