package com.di.util;

import com.di.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟表现层，用于调用业务层   实际中是servlet
 */
public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象

        AccountService service = (AccountService) context.getBean("accountService2");
        service.saveAccount();
    }
}
