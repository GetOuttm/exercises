package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //接收请求参数currentPage，rows
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }

        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        //获取条件查询参数
        Map<String, String[]> map = request.getParameterMap();

        //调用service查询PageBean
        UserService userService = new UserServiceImpl();
        PageBean<User> pageBean = userService.findUserByPage(currentPage,rows,map);
        System.out.println(pageBean);

        //将PageBean存入request
        request.setAttribute("pb",pageBean);
        request.setAttribute("map",map);
        //转发list.jsp展示
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
