<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--常用注解--%>
    <a href="/anno/testRequestParam?name=哈哈">RequestParam</a>

    <hr>

    <form action="/anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="username"><br>
        用户年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交"><br>
    </form>

    <hr>

    <a href="/anno/testPathVariable/10">PathVariable</a>

    <hr>

    <a href="/anno/testRequestHeader">RequestHeader</a>

    <hr>

    <a href="/anno/testCookieValue">CookieValue</a>

    <hr>

    <form action="/anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="username"><br>
        用户年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交"><br>
    </form>

    <hr>

    <a href="/anno/testSessionAttributes">SessionAttributes</a>

    <a href="/anno/getSessionAttributes">getSessionAttributes</a>

    <a href="/anno/deleteSessionAttributes">deleteSessionAttributes</a>
</body>
</html>
