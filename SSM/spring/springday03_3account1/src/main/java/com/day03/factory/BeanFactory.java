package com.day03.factory;

import com.day03.service.AccountService;
import com.day03.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建service的代理对象的工厂
 */
public class BeanFactory {

    private AccountService accountService;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service代理对象
     * @return
     */
    public AccountService getAccountService() {
        AccountService JDKAccountService = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            //开启事务
                            transactionManager.beginTransaction();
                            //执行操作
                            rtValue = method.invoke(accountService, args);
                            //提交事务
                            transactionManager.commitTransaction();
                            //返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //回滚事务
                            transactionManager.rollbackTransaction();
                            throw new RuntimeException(e);
                        } finally {
                            //释放连接
                            transactionManager.closeTransaction();
                        }
                    }
                });
        return JDKAccountService;
    }
}
