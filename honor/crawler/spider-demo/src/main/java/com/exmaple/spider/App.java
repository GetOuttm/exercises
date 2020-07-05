package com.exmaple.spider;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exmaple.spider.handler.SpiderHandler;

@SpringBootApplication
public class App {
    @Autowired
    private SpiderHandler spiderHandler;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

    //使用@PostConstruct注解会在spring容器实例化bean之前执行这个方法
    @PostConstruct
    public void task() {
        spiderHandler.spiderData();
    }
}
