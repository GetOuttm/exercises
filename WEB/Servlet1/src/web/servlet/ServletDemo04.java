package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet路径配置
 */
/*@WebServlet({"/d4","/d04","/d004"})*/
//@WebServlet("/user/demo04")
//@WebServlet("/user/*")
//@WebServlet("/*")
@WebServlet("*.do")
public class ServletDemo04 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo04 ....");
        System.out.println(req);
    }

}
