package com.ljf.mybatis.sqlsession.defaults;

import com.ljf.mybatis.cfg.Configuration;
import com.ljf.mybatis.sqlsession.SqlSession;
import com.ljf.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFacvtory接口的实现类
 */
public class DefaultsSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultsSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的连接数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultsSqlSession(cfg);
    }
}
