package com.anno.util;

import com.anno.factory.BeanFactory;
import com.anno.service.AccountService;

/**
 * 模拟表现层，用于调用业务层   实际中是servlet
 */
public class Client {

    public static void main(String[] args) {
//        AccountService service = new AccountServiceImpl();
        AccountService service = (AccountService) BeanFactory.getBean("accountService");
        service.saveAccount();
    }
}
