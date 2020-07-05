<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载,绑定单击事件
        $(function () {
            $("#but").click(function () {
               /* alert("hello btn")*/
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    type:"post",
                    url:"/user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"haha","password":"123","age":20}',
                    dataType:"json",
                    success:function (data) {
                        //data服务器端响应的json数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>

    <a href="/user/testString">testString</a>
    <a href="/user/testUser">testUser</a>
    <hr>
    <a href="/user/testVoid">testVoid</a>
    <hr>
    <a href="/user/tesModelAndView">tesModelAndView</a>
    <hr>
    <a href="/user/tesForwardOrRedirect">tesForwardOrRedirect</a>
    <hr><hr>
    <button id="but">发送Ajax请求</button>
</body>
</html>
