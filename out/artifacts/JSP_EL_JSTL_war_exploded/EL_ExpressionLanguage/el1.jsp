<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--isELIgnored：是否原样输出
    true:原样输出,忽略当前jsp页面中所有的el表达式  false:反之
    也可以\${表达式} 忽略当前这个el表达式
    --%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    ${3 > 4}
    \${3 > 4}
</body>
</html>
