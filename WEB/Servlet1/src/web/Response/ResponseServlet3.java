package web.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/requestServlet3")
public class ResponseServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*//获取流之前设置编码格式
        resp.setCharacterEncoding("utf-8");
        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器也使用该编码解码
        resp.setHeader("content-type","text/html;charset=utf-8");*/

        resp.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter writer = resp.getWriter();

        //2.输出数据
        writer.write("hello, response");
        writer.write("<h1>hello, response</h1>");
        writer.write("你好, response");
    }
}
