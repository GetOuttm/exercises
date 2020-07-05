package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//标注当前类为springboot启动类
public class MySpringBootApplication {

    //main方法是java程序的入口
    public static void main(String[] args) {
        //run方法表示运行springboot的启动类，run的参数是spring启动类的字节码对象
        SpringApplication.run(MySpringBootApplication.class);
    }
}
