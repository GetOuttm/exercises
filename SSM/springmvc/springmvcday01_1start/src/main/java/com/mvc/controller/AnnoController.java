package com.mvc.controller;

import com.mvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})//把msg=爸爸存入到session域中
public class AnnoController {

    /**
     * RequestParam
     * required  是否必须是这个字段  如果不是那么执行不成功
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username) {
        System.out.println("RequestParam---");
        System.out.println(username);
        return "success";
    }

    /**
     * RequestBody
     * 用于获取请求体内容    get请求不适应   因为get请求把请求体都封装到了地址栏
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("RequestBody---");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testRequestParam(@PathVariable("sid") Integer id) {
        System.out.println("PathVariable---");
        System.out.println(id);
        return "success";
    }

    /**
     * RequestHeader   获取请求体信息
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String header) {
        System.out.println("RequestHeader---");
        System.out.println(header);
        return "success";
    }

    /**
     * CookieValue  用于指定cookie名称的值传入控制器方法参数
     * @param cookeValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookeValue) {
        System.out.println("CookieValue---");
        System.out.println(cookeValue);
        return "success";
    }

    /**
     * ModelAttribute  用于修饰方法和参数
     *  1.出现在方法上表示当前方法会在控制器的方法之前执行，它可以修饰没有返回值的方法，也可以修饰有具体返回值的方法
     *  2.出现在参数上，获取指定的数据给参数赋值
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("ModelAttribute---");
        System.out.println(user);
        return "success";
    }

   /* //先执行
    @ModelAttribute
    public User testModelAttribute1(String username) {
        System.out.println("testModelAttribute执行");
        //通过用户名查数据(模拟)
        User user = new User();
        user.setName(username);
        user.setAge("20");
        user.setDate(new Date());
        return user;
    }*/

    @ModelAttribute
    public void testModelAttribute2(String username, Map<String,User> map) {
        System.out.println("testModelAttribute2执行");
        //通过用户名查数据(模拟)
        User user = new User();
        user.setName(username);
        user.setAge("20");
        user.setDate(new Date());
        map.put("abc",user);
    }

    /**
     * SessionAttributes   用于多次执行控制器方法间的参数共享
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("SessionAttributes---");
        //底层会存储到request域对象当中
        model.addAttribute("msg","爸爸");

        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap model) {
        System.out.println("getSessionAttributes---");
        String msg = (String) model.get("msg");
        System.out.println(msg);

        return "success";
    }

    /**
     * 清楚session
     * @param status
     * @return
     */
    @RequestMapping("/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status) {
        System.out.println("deleteSessionAttributes---");
       status.setComplete();

        return "success";
    }
}
