package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 需求：
 * 		1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 		2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 */
@WebServlet("/cookieTime")
public class CookieTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应消息体数据格式和编码
        response.setContentType("text/html;charset=utf-8");
        //获取所有的Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//没有lastTime的cookie
        //遍历Cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                //获取cookie的名称
                String name = cookie.getName();
                //判断名称是否是lastTime
                if ("lastTime".equals(name)) {
                    //有cookie说明不是第一次访问
                    flag = true;

                    String time = setCookieTime(cookie);

                    //响应数据
                    //获取Cookie的value
                    String str_value = cookie.getValue();
                    System.out.println("解码前" + str_value);
                    str_value = URLDecoder.decode(str_value, "utf-8");
                    System.out.println("解码后" + str_value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间为:" + str_value + "</h1>");

                    cookie.setValue(time);
                    //设置cookie的存活时间
                    cookie.setMaxAge(60*60*24*30);//存活一个月
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            //第一次访问

            Cookie cookie = new Cookie("lastTime",null);
            String time = setCookieTime(cookie);
            cookie.setValue(time);

            //设置cookie的存活时间
            cookie.setMaxAge(60*60*24*30);//存活一个月
            response.addCookie(cookie);
            //响应数据
            response.getWriter().write("<h1>欢迎您首次访问！</h1>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    public String setCookieTime(Cookie cookie) throws UnsupportedEncodingException {
        //设置Cookie的value
        //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日-HH:mm:ss");
        String format = sdf.format(date);
        System.out.println("编码前" + format);
        format = URLEncoder.encode(format, "utf-8");
        System.out.println("编码后" + format);
        return format;
    }
}
