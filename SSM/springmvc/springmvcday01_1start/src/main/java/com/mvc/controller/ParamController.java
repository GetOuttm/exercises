package com.mvc.controller;

import com.mvc.domain.Account;
import com.mvc.domain.Accounts;
import com.mvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam() {
        System.out.println("请求参数执行");
        return "success";
    }

    @RequestMapping("/testParam1")
    public String testParam1(String username) {
        System.out.println("请求参数执行");
        System.out.println("用户名" + username);
        return "success";
    }

    /**
     * 请求参数绑定 把数据封装到javabean当中
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        //Accounts{username='哈哈还是', password='123456', money=123.0, list=[User{name='爸爸', age='47'}], map={one=User{name='妈妈', age='47'}}}
        System.out.println("请求参数执行");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("请求参数执行");
        System.out.println(user);
        return "success";
    }

    /**
     * 请求参数绑定 把数据封装到javabean当中
     * @param accounts
     * @return
     */
    @RequestMapping("/saveAccounts")
    public String saveAccounts(Accounts accounts) {
        System.out.println("请求参数执行");
        System.out.println(accounts);
        return "success";
    }

    /**
     * 原生API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletResponse response, HttpServletRequest request) {
        System.out.println("请求参数执行");
        System.out.println(request);
        System.out.println(response);
        HttpSession session = request.getSession();
        System.out.println(session);
        //最大域对象
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        return "success";
    }
}
