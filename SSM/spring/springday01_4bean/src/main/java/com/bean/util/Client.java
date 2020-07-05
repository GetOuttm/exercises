package com.bean.util;

import com.bean.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * 模拟表现层，用于调用业务层   实际中是servlet
 */
public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        AccountService service = (AccountService) context.getBean("accountService");
//        AccountService service1 = (AccountService) context.getBean("accountService");


//        System.out.println(service == service1);
//        System.out.println(service);
//        System.out.println(service1);
        service.saveAccount();

        //静态方法getInstance()，来创建Calender杜希昂
        //创建对象的静态方法称为 静态工厂方法
        Calendar cal = Calendar.getInstance();

        //Spring对静态工厂方法创建对象，Spring可以去调用静态工厂方法，
        //将创建的对象访问Spring容器管理起来，提供给外部使用
        Calendar cal1 = context.getBean("cal1",Calendar.class);
        System.out.println(cal1);


        //手动关闭容器
        context.close();


    }
}
