package Session.yzm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf8");
        //获取Map参数
        Enumeration<String> names = request.getParameterNames();
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //先获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");

        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");

        //先判断验证码是否正确
        if (checkCode_session != null &&  checkCode_session.equalsIgnoreCase(checkCode)) {
            //忽略大小写字符串
            //判断用户名和密码是否一致
            if ("zhangsan".equals(username) && "123".equals(password)) {
                //登陆成功
                //存储用户信息
                session.setAttribute("user",username);
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                //登陆失败
                //存储用户信息
                request.setAttribute("login_error","用户名或密码错误");
                //重定向到success.jsp
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        } else {
            //验证码不一致
            //存储信息到request
            request.setAttribute("code_error","验证码错误");
            //转发到登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
