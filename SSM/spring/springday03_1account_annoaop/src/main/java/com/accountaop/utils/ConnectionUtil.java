package com.accountaop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，它用于从数据源中获取一个连接，并实现和线程的绑定
 */
@Component("connectionUtil")
public class ConnectionUtil {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    //获取当前线程干的连接
    public Connection getThreadConnection(){
        try {
            //1.先从ThreadLocal上获取
            Connection connection = tl.get();
            //2.判断当前线程是否有链接
            if (connection == null) {
                //3.从数据源中获取一个线程，存入ThreadLocal中
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            //4.返回当前线程上的连接
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }

}
