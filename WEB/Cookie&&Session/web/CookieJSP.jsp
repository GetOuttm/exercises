<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/4/23
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP改造Cookie</title>
</head>
<body>
    <%
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

                    //设置Cookie的value
                    //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日-HH:mm:ss");
                    String format = sdf.format(date);
                    System.out.println("编码前" + format);
                    format = URLEncoder.encode(format, "utf-8");
                    System.out.println("编码后" + format);

                    //响应数据
                    //获取Cookie的value
                    String str_value = cookie.getValue();
                    System.out.println("解码前" + str_value);
                    str_value = URLDecoder.decode(str_value, "utf-8");
                    System.out.println("解码后" + str_value);


    %>
    <h1>欢迎回来，您上次访问的时间为:<%=str_value%></h1>
    <%
                    cookie.setValue(format);
                    //设置cookie的存活时间
                    cookie.setMaxAge(60*60*24*30);//存活一个月
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            //第一次访问

            //设置Cookie的value
            //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日-HH:mm:ss");
            String format = sdf.format(date);
            System.out.println("编码前" + format);
            format = URLEncoder.encode(format, "utf-8");
            System.out.println("编码后" + format);
            Cookie cookie = new Cookie("lastTime",format);
            cookie.setValue(format);

            //设置cookie的存活时间
            cookie.setMaxAge(60*60*24*30);//存活一个月
            response.addCookie(cookie);
    %>
    <h1>欢迎您首次访问！</h1>
    <%
        }
    %>

</body>
</html>
