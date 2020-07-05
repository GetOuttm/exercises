package com.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Quick1Controller {

    @Value("${name}")//从spring容器获取name的值放到当前name变量
    private String name;

    @Value("${person.address}")
    private String address;

    @RequestMapping("/quick1")
    @ResponseBody
    public String quick() {
        //获取配置文件信息
        return "name:" + name + ",address:" + address;
    }

}
