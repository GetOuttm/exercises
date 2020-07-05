package com.accountaop.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的类，包含开启事务，提交事务，回滚事务，释放连接
 */
@Component("transactionManager")
@Aspect//表示当前类是一个切面类
public class TransactionManager {

    @Autowired
    private ConnectionUtil connectionUtil;

    @Pointcut("execution(* com.accountaop.service.impl.*.*(..))")
    private void pt() {};

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


    @Around("pt()")
    public Object arroudTran(ProceedingJoinPoint pjp) {
        /*System.out.println("[环绕前：]");
        pjp.proceed();             // 执行目标方法
        System.out.println("[环绕后：]");*/
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            System.out.println("[前置]");
            beginTransaction();
            rtValue = pjp.proceed(args);//明确调用业务层方法(切入点方法)
            System.out.println("[后置通知]");
            commitTransaction();
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("[异常通知]");
            rollbackTransaction();
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("[最终通知]");
            closeTransaction();
        }
    }
}
