package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器类
 */
@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("SpringMVC");
        return "success";
    }

    /**
     * RequestMapping
     *  method  可以加请求方式   GET POST
     *  params   加参数
     * @return
     */
    @RequestMapping("/equestMapping")
    public String testResponseMapping() {
        System.out.println("测试RequestMapping注解");
        return "success";
    }
}
