<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/verificationCode?time=" + new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <form action="/loginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/verificationCode"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
        ${requestScope.code_error}
    <div><%=request.getAttribute("code_error") == null ? "" : request.getAttribute("code_error")%></div>
    <div><%=request.getAttribute("login_error") == null ? "" :
            request.getAttribute("login_error")%></div>
</body>
</html>
