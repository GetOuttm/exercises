<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询所有账户</h3>

    ${accounts}

    <hr>

    <c:forEach items="${accounts}" var="account">
        ${account.name}
        ${account.money}<br>
    </c:forEach>

</body>
</html>
