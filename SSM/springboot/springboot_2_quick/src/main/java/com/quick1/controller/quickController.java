package com.quick1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController  //将controller和ResponseBody放到一块
public class quickController {

    @RequestMapping("/quick")
    public String testQuick() {
        return "SpringBoot !!!";
    }
}
