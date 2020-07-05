package com.ljf.mybatis.sqlsession;

public interface SqlSessionFactory {

    /**
     * 用于打开一个新的sqlsession对象
     * @return
     */
    SqlSession openSession();
}
