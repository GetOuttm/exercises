package web;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/servletLogin")
public class    ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
       /* //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //封装user
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);*/

       //获取所有请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        //创建user对象
        User user = new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserDao的方法login
        UserDao userDao = new UserDao();
        User login = userDao.login(user);
        if (login == null) {
            //失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        } else {
            //成功
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
