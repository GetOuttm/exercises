package web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Request功能
 * 1.获取请求消息
 *      a.获取请求行数据
 *          GET /request/demo01?name=zhangsan HTTP/1.1
 *      b.获取请求头数据
 *      c.获取请求体数据
 * 2.其他功能
 */
@WebServlet("/request/demo01")
public class RequestDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1获取请求行数据
        //1.1获取请求方式     GET
        String method = req.getMethod();
        System.out.println("请求方式---" + method);

        //1.2(*)获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println("虚拟目录---" + contextPath);

        //1.3获取Servlet路径   /request/demo01
        String servletPath = req.getServletPath();
        System.out.println("Servlet路径---" + servletPath);

        //1.4获取get请求参数    name=zhangsan
        String queryString = req.getQueryString();
        System.out.println("get请求参数---" + queryString);

        //1.5(*)获取请求URI
        /**
         * URI代表的范围比URL大
         * URL:统一资源定位符
         * URI:统一资源标识符
         */
        // /request/demo01
        String requestURI = req.getRequestURI();
        //http://localhost/request/demo01
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("请求URI---" + requestURI);
        System.out.println("请求URI---" + requestURL);

        //1.6获取协议版本    HTTP/1.1
        String protocol = req.getProtocol();
        System.out.println("协议版本---" + protocol);

        //1.7 获取客户机的IP地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("客户机的IP地址---" + remoteAddr);

        System.out.println("===========================================");

        //2.获取请求头数据
        //2.2 获取所有的请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            //2.1 (*)通过请求头的名称获取请求头的值
            String value = req.getHeader(name);
            System.out.println(name + "----" + value);
        }

        //获取user-agent请求头
        String header = req.getHeader("user-agent");
        if (header.contains("Chrome")) {
            System.out.println("我是谷歌");
        } else if (header.contains("Firefox")){
            System.out.println("我是火狐");
        }

        //获取请求头数据：referer
        String referer = req.getHeader("referer");
        System.out.println(referer);//http://localhost/login.html
        //防盗链
        if (referer != null) {
            if (referer.contains("/request")) {
                System.out.println("播放");
            } else {
                //盗链
                System.out.println("想看电影来优酷");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 3.获取请求体数据
         *  请求体：只有POST请求方式才有请求体，在请求体中封装POST请求的请求参数
         */
        //3.1获取流对象
        /*
            BufferedReader getReader()：获取字符输入流，只能操作字符数据
			ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据
         */
        BufferedReader reader = req.getReader();
        //3.2再从流中拿数据
        String line = null;
        if ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
