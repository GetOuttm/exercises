package web.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContext")
public class ContextDemo01 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //servletContext的获取
        //1.通过request获取
        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);

        //2.通过HttpServlet获取
        ServletContext servletContext1 = this.getServletContext();
        System.out.println(servletContext1);
        System.out.println(servletContext == servletContext1);

        System.out.println("--------------------");
        /*
        获取MIME类型
         */
        //定义文件名称
        String fileName = "a.jpg";
        //获取MINME类型
        String mimeType = servletContext1.getMimeType(fileName);
        System.out.println(mimeType);


        /**
         * 域对象：共享数据
         *      1. setAttribute(String name,Object value)
         * 		2. getAttribute(String name)
         * 		3. removeAttribute(String name)
         *
         * 		* ServletContext对象范围：所有用户所有请求的数据
         */
        servletContext1.setAttribute("msg","哈哈");



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
