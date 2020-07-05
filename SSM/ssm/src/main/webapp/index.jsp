<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/account/testAccount">springmvc测试</a>

    <hr><hr>

    <form action="/account/testSave" method="post" >
        姓名：<input type="text" name="name"><br>
        金额：<input type="text" name="money"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
