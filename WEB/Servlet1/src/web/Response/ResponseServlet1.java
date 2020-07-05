package web.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/requestServlet1")
public class ResponseServlet1 extends HttpServlet {
    /**
     * 功能：设置响应消息
     * 	1. 设置响应行
     * 		1. 格式：HTTP/1.1 200 ok
     * 		2. 设置状态码：setStatus(int sc)
     * 	2. 设置响应头：setHeader(String name, String value)
     *
     * 	3. 设置响应体：
     * 		* 使用步骤：
     * 			1. 获取输出流
     * 				* 字符输出流：PrintWriter getWriter()
     *
     * 				* 字节输出流：ServletOutputStream getOutputStream()
     *
     * 			2. 使用输出流，将数据输出到客户端浏览器
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ResponseServlet1被访问");
        /*resp.setStatus(302);
        resp.setHeader("location","/requestServlet2");*/

        //url是重定向地址
        resp.sendRedirect("https://www.baidu.com/");
    }
}
