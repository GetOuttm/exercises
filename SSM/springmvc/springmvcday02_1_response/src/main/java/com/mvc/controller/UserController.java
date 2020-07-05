package com.mvc.controller;

import com.mvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString() {
        System.out.println("testString执行了");
        return "success";
    }

    @RequestMapping("/testUser")
    public String testUser(Model model) {
        System.out.println("testUser执行");
        //模拟从数据库中查询User
        User user = new User();
        user.setUsername("爸爸");
        user.setPassword("123");
        user.setAge(18);
        //存起来  model对象
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 返回值类型是void
     *
     * 无返回值会出现 /WEB-INF/jsp/user/testVoid.jsp找不到这个文件，
     *
     * 请求转发一次请求，不用编写项目名称
     *
     * 转发不会执行视图解析器
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行");
        //编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request,response);

        /**
         * 重定向是两次请求，再次请求无法直接请求/WEB-INF/jsp/
         */
//        response.sendRedirect(request.getContextPath() + "/index.jsp");


        //解决中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接进行响应
        response.getWriter().print("巴啦啦");
    }


    @RequestMapping("/tesModelAndView")
    public ModelAndView tesModelAndView() {
        //1.创建ModelAndView对象
        ModelAndView view = new ModelAndView();

        System.out.println("tesModelAndView执行");
        //模拟从数据库中查询User
        User user = new User();
        user.setUsername("小三");
        user.setPassword("123");
        user.setAge(18);

        //把user对象存储到view对象中，底层也会把user对象存入到request域中
        view.addObject("user",user);

        //你想跳转到那个页面
        view.setViewName("success");

        return view;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/tesForwardOrRedirect")
    public String tesForwardOrRedirect() {
        System.out.println("tesForwardOrRedirect执行");
        //请求转发
//        return "forward:/WEB-INF/jsp/success.jsp";

        //重定向  许需要加项目名
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应

    @RequestMapping("/testAjax")
    public void testAjax(@RequestBody String body) {
        System.out.println("testAjax执行");
        System.out.println(body);
    }*/

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax执行");
        //客户端发送的是ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setUsername("ben");
        user.setAge(30);
        System.out.println(user);
        return user;
    }

}
