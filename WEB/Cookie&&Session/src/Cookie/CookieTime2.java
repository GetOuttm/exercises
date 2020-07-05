package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 需求：
 * 		1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 		2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 */
@WebServlet("/cookieTime2")
public class CookieTime2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//设置消息体的数据格式以及编码
        Cookie[] cs = request.getCookies();
        if (cs!=null) {
            int i =0;
            for (Cookie c : cs) {
                if((c.getName()).equals("lasttime")) {
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前"+str_date);
                    str_date = URLEncoder.encode(str_date,"utf-8");//URL编码
                    System.out.println("编码后"+str_date);
                    String value = c.getValue();
                    //URL解码
                    System.out.println("解码前："+value);
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);
                    response.getWriter().write("欢迎回来 你上次的访问时间是："+value);
                    c.setValue(str_date);
                    //设置存活时间
                    c.setMaxAge(60 * 60);
                    response.addCookie(c);
                    break;
                }else if (cs.length==++i){//所有的cookie都不是last time 添加一个 name 为lasttime 的
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
                    String str_date = sdf.format(date);
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    Cookie cookie = new Cookie("lasttime",str_date);
                    cookie.setMaxAge(60 * 60);   //设置存活时间
                    response.addCookie(cookie);
                    response.getWriter().write("欢迎首次访问");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
