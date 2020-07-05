<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
    <%--c:if标签
        属性：test:接受boolean表达式，如果表达式为true则显示if标签体内容  如果为false则不显示标签体内容
                    一般情况下test结合el表达式一起使用

           没有else
        --%>
    <c:if test="false">
        我是你的小ℹ
    </c:if><br>

    <%
        //判断request域中的一个list集合是否为空，如果不为null则显示遍历集合
        List list = new ArrayList();
        list.add("aaa");
        request.setAttribute("list",list);
        
        request.setAttribute("number",3);
    %>
    <c:if test="${not empty list}">
        遍历集合。。。
    </c:if><br>

    <c:if test="${number %2 != 0}">
        ${number}为奇数
    </c:if>
</body>
</html>
