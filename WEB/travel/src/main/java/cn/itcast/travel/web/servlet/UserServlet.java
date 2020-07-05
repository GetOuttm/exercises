package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    /**
     * 注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码校验
        String check = request.getParameter("check");
        //从session中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //保证验证码只能使用一次
        session.removeAttribute("CHECKCODE_SERVER");
        //比较
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)) {
            //验证码错误
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误!");
            //将info对象序列化为json  写会客户端
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);

            //设置content-type
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }


        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();

        //2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //3.调用Service完成注册
//        UserService userService = new UserServiceImpl();
        boolean falg = userService.register(user);
        ResultInfo info = new ResultInfo();

        //4.响应结果
        if (falg) {
            info.setFlag(true);
        } else {
            info.setFlag(false);
            info.setErrorMsg("注册失败!");
        }

        //将info对象序列化为json  写会客户端
        /*ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);*/
        String json = writeValueAsString(info);

        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        Map<String, String[]> map = request.getParameterMap();

        //封装user对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service查询user
//        UserService userService = new UserServiceImpl();
        User u = userService.login(user);

        ResultInfo info = new ResultInfo();
        //判断用户是否存在
        if (u == null) {
            //用户名密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名密码错误");
        }

        //判断用户账号是否激活
        if (u != null && !"Y".equals(u.getStatus())) {
            //用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("该账号尚未激活,请先激活");
        }

        //登陆成功
        if (u != null && "Y".equals(u.getStatus())) {
            request.getSession().setAttribute("user", u);
            //登陆成功
            info.setFlag(true);
        }
        response.setContentType("application/json;charset=utf-8");
        //响应数据
        /*ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), info);*/
        writeValue(info,response);
    }

    /**
     * 查询单个对象
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中获取登录用户
        Object user = request.getSession().getAttribute("user");
        //将user写会客户端
        /*ObjectMapper mapper = new ObjectMapper();
        //设置response
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), user);*/
        writeValue(user,response);
    }

    /**
     * 退出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //销毁session
        request.getSession().invalidate();

        //跳转页面
        response.sendRedirect(request.getContextPath() + "/login.html");
    }

    /**
     * 激活
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取激活码
        String code = request.getParameter("code");
        if (code != null) {
            //调用service完成激活
//            UserService userService = new UserServiceImpl();
            boolean flag = userService.active(code);

            //判断标记
            String msg = null;
            if (flag) {
                //激活成功
                msg = "激活成功,请<a href='login.html'>登录</a>";
            } else {
                //激活失败
                msg = "激活失败,请联系管理员";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }
}