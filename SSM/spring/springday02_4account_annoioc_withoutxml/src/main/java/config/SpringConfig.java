package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是一个配置类   和bean.xml是一样的
 *
 * spring中的新注解
 *      @Configuration   作用：指定当前类是一个配置类      作用于类上
 *                      当配置类作为AnnotationConfigApplicationContext对象创建的参数时可以不写
 *      @ComponentScan   作用：用于通过注解指定spring在创建容器时所需要扫描的包   作用于类上
 *                      属性
 *                          value：和basePackages的作用是一样的，都是用于指定创建容器时所需要扫描的包
 *                                 我们使用此注解，相当于在xml文件中配置了注解扫描
 *                                 <context:component-scan base-package="com.withoutxml"/>
 *      @Bean   作用：用于把当前方法的放回置值作为bean对象存入spring的ioc容器中  作用于方法上
 *              属性：
 *                  name：用于指定bean的id，默认值是当前不写值，当前方法的名称
 *             当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找会有没有可用的bean对象
 *             查找的方式和@Autowired注解的方式是一样的
 *      @Import   作用：用于导入其他的配置类
 *                属性： value   用于指定其他配置类的字节码
 *                          当我们使用import注解之后，有import注解的类就是主配置类，导入的配置类就是子配置类
 *      @PropertySource    作用：用于指定propertiesw文件的位置
 *                          属性：value  指定文件的名称和路径
 *                                      关键字：classpath   表示类路径下
 */
/*@Configuration*/
@Import(JdbcConfig.class)
@ComponentScan(basePackages = "com.withoutxml")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfig {

   /* *//**
     * 用于创建QueryRunner对象
     * @param dataSource
     * @return
     *//*
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    *//**
     * 创建数据源对象
     * @return
     *//*
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/springdb");
            cpds.setUser("root");
            cpds.setPassword("123");
            return cpds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}
