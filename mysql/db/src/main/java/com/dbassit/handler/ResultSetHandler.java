package com.dbassit.handler;

import java.sql.ResultSet;

/**
 * 结果集封装接口
 */
public interface ResultSetHandler {

    /**
     * 结果集封装的方法
     * @param resultSet
     * @return
     */
    Object handler(ResultSet resultSet);
}
