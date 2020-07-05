package com.ssm.test;

import com.ssm.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run() {
        //加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationConfig.xml");

        //获取对象
        AccountService service = (AccountService) context.getBean("accountService");

        //调用方法
        service.findAll();
    }
}
