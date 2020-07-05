package com.day03.utils;

/**
 * 和事务管理相关的类，包含开启事务，提交事务，回滚事务，释放连接
 */
public class TransactionManager {

    private ConnectionUtil connectionUtil;

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commitTransaction() {
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollbackTransaction() {
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void closeTransaction() {
        try {
            connectionUtil.getThreadConnection().close();//还回连接池中
            connectionUtil.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
