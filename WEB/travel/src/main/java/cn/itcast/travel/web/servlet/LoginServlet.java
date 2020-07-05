package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        Map<String, String[]> map = request.getParameterMap();

        //封装user对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service查询user
        UserService userService = new UserServiceImpl();
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
            request.getSession().setAttribute("user",u);
            //登陆成功
            info.setFlag(true);
        }
        response.setContentType("application/json;charset=utf-8");
        //响应数据
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
