package com.exception.controller;

import com.exception.ex.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() {
        System.out.println("testException执行了");
        return "success";
    }

    @RequestMapping("/testException1")
    public String testException1() throws SysException {
        System.out.println("testException1执行了");

        try {
            //模拟异常
            int i = 10/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常
            throw new SysException("查询所有用户出现错误");
        }
        return "success";
    }
}
