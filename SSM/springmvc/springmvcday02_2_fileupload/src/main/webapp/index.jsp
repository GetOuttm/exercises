<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>文件上传</h1>

    <form action="/user/testFileupload1" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
    <hr><hr>

    <h1>SpringMVC文件上传</h1>

    <form action="/user/testSpringMVCFileupload" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>

    <hr><hr>

    <h1>SpringMVC跨服务器文件上传</h1>

    <form action="/user/testSpringMVCFileupload1" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
