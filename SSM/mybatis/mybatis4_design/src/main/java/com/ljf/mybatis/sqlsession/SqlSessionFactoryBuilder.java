package com.ljf.mybatis.sqlsession;

import com.ljf.mybatis.cfg.Configuration;
import com.ljf.mybatis.sqlsession.defaults.DefaultsSqlSessionFactory;
import com.ljf.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultsSqlSessionFactory(cfg);
    }
}
