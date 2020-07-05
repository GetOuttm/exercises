package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssm.domain.Account;
import com.ssm.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("testAccount")
    public String testAccount(Model model) {
        System.out.println("表现层查询所有用户");
        //调用service方法
        List<Account> accounts = accountService.findAll();

        model.addAttribute("accounts",accounts);
        return "list";
    }

    @RequestMapping("testSave")
    public void testSave(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层保存用户");
        //调用service方法
        accountService.saveAccount(account);

        response.sendRedirect(request.getContextPath() + "/account/testAccount");
    }
}
