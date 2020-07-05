package com.anno.util;

import com.anno.dao.AccountDao;
import com.anno.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟表现层，用于调用业务层   实际中是servlet
 */
public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        AccountService service = (AccountService) context.getBean("accountService");
        AccountService service1 = (AccountService) context.getBean("accountService");
        System.out.println(service == service1);
        /*System.out.println(service);

        AccountDao dao = context.getBean("accountDao",AccountDao.class);
        System.out.println(dao);*/

        service.saveAccount();
        context.close();
    }
}
