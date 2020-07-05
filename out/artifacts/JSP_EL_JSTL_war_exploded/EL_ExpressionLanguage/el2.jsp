<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--运算
        运算符：
            1.算数运算符：+ - * /(div) %(mod)
            2.比较运算符：< > <= >= == !=
            3.逻辑运算符：&&(and) ||(or) !(not)
            4.空运算符：empty
                用于判断字符串、集合、数组对象是否为null或者长度是否为0
                * ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0
				* ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0
    --%>

    <h2>运算符</h2>
    <h3>算数运算符</h3>
        ${3 + 4}<br>
        ${3 - 4}<br>
        ${3 * 4}<br>
        ${3 / 4}<br>
        ${3 % 4}<br>
        ${3 div 4}<br>
        ${3 mod 4}<br>
    <h3>比较运算符</h3>
        ${3 == 4}<br>
    <h3>逻辑运算符</h3>
        ${3>4 && 3<4}<br>
        ${3>4 and 3<4}<br>
    <h3>空运算符</h3>
        ${empty list}<br>
        <%
            String str = "abc";
            request.setAttribute("str",str);

            List list = new ArrayList();
            request.setAttribute("list",list);
        %>
        ${empty str}<br>
        ${not empty str}<br>
        ${empty list}
</body>
</html>
