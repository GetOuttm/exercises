package com.dbassit.dbassti;

import com.dbassit.handler.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.*;

/**
 * 封装的工具类
 */
public class DBAssit {

    private DataSource dataSource;

    public DBAssit(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 执行增删改的方法
     * @param sql
     * @param params
     * @return
     */
    public int update(String sql,Object... params) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.得到连接
            connection = dataSource.getConnection();
            //2.使用连接和参数的sql语句创建预编译对象
            statement = connection.prepareStatement(sql);
            //3.得到sql语句参数的源信息(有什么参数，什么类型等等)
            ParameterMetaData metaData = statement.getParameterMetaData();
            //4.判断参数语句中参数的个数和方法参数params的个数是否一致，不一致无法执行
            int parameterCount = metaData.getParameterCount();
            if (parameterCount > 0) {
                if (params == null) {
                    throw new NullPointerException("没有sql语句执行必须的参数");
                }
                if (params.length != parameterCount) {
                    throw new RuntimeException("传入的参数个数和语句所需的参数个数不一致，语句无法执行");
                }
            }
            //5.给sql语句的参数赋值
            for (int i = 0; i < parameterCount; i++) {
                statement.setObject(i+1,params[i]);
            }
            //6.执行语句
            int update = statement.executeUpdate();
            //7.返回执行结果
            return update;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        } finally {
            release(connection,statement,null);
        }
    }

    public Object query(String sql, ResultSetHandler rsh, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.得到连接
            connection = dataSource.getConnection();
            //2.使用连接和参数的sql语句创建预编译对象
            statement = connection.prepareStatement(sql);
            //3.得到sql语句参数的源信息(有什么参数，什么类型等等)
            ParameterMetaData metaData = statement.getParameterMetaData();
            //4.判断参数语句中参数的个数和方法参数params的个数是否一致，不一致无法执行
            int parameterCount = metaData.getParameterCount();
            if (parameterCount > 0) {
                if (params == null) {
                    throw new NullPointerException("没有sql语句执行必须的参数");
                }
                if (params.length != parameterCount) {
                    throw new RuntimeException("传入的参数个数和语句所需的参数个数不一致，语句无法执行");
                }
            }
            //5.给sql语句的参数赋值
            for (int i = 0; i < parameterCount; i++) {
                statement.setObject(i+1,params[i]);
            }
            //6.执行语句
            resultSet = statement.executeQuery();
            //7.返回执行结果
            return rsh.handler(resultSet);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        } finally {
            release(connection,statement,resultSet);
        }
    }

    private void release(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
