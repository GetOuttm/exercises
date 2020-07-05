<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--&lt;%&ndash;请求参数绑定&ndash;%&gt;
    <a href="/param/testParam">请求参数绑定</a>

    <a href="/param/testParam1?username=haha">请求参数绑定1</a>--%>

    <%--把数据封装到account--%>
    <form action="/param/saveAccount" method="post">
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        金额：<input type="text" name="money"><br>
        用户姓名：<input type="text" name="user.name"><br>
        用户年龄：<input type="text" name="user.age"><br>
        <input type="submit" value="提交"><br>
    </form>

    <hr>
    <hr>

    <%--把数据封装到accounts类中，类中存在list和map--%>
    <form action="/param/saveAccounts" method="post">
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        金额：<input type="text" name="money"><br>

        用户姓名：<input type="text" name="list[0].name"><br>
        用户年龄：<input type="text" name="list[0].age"><br>

        用户姓名：<input type="text" name="map['one'].name"><br>
        用户年龄：<input type="text" name="map['one'].age"><br>
        <input type="submit" value="提交">
    </form>

    <hr>
    <hr>

    <%--自定义类型转换器--%>
    <form action="/param/saveUser" method="post">

        用户姓名：<input type="text" name="name"><br>
        用户年龄：<input type="text" name="l.age"><br>
        用户生日：<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>


    <a href="/param/testServlet">Servlet原声API</a>
</body>
</html>
