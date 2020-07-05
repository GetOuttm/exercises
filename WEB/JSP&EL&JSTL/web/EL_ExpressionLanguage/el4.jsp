<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    3. 隐式对象：
		* el表达式中有11个隐式对象
	隐含对象                    类型                                  说明
    PageContext           javax.servlet.ServletContext   表示此JSP的PageContext
    PageScope             java.util.Map                  取得Page范围的属性名称所对应的值
    RequestScope          java.util.Map                  取得Request范围的属性名称所对应的值
    sessionScope          java.util.Map                  取得Session范围的属性名称所对应的值
    applicationScope      java.util.Map                  取得Application范围的属性名称所对应的值
    param                 java.util.Map                  如同ServletRequest.getParameter(String name)。回传String类型的值
    paramValues           java.util.Map                  如同ServletRequest.getParameterValues(String name)。回传String[]类型的值
    header                java.util.Map                  如同ServletRequest.getHeader(String name)。回传String类型的值
    headerValues          java.util.Map                  如同ServletRequest.getHeaders(String name)。回传String[]类型的值
    cookie                java.util.Map                  如同HttpServletRequest.getCookies()
    initParam             java.util.Map                  如同ServletContext.getInitParameter(String name)。回传String类型的值
		* pageContext：
			* 获取jsp其他八个内置对象
				* ${pageContext.request.contextPath}：动态获取虚拟目录
         Expression                                   说明
    ${pageContext.request.queryString}          取得请求的参数字符串
    ${pageContext.request.requestURL}           取得请求的URL，但不包括请求之参数字符串,即servlet的HTTP地址。
    ${pageContext.request.contextPath}          服务的webapplication的名称
    ${pageContext.request.method}               取得HTTP的方法(GET、POST)
    ${pageContext.request.protocol}             取得使用的协议(HTTP/1.1、HTTP/1.0)
    ${pageContext.request.remoteUser}           取得用户名称
    ${pageContext.request.remoteAddr}           取得用户的IP地址
    ${pageContext.session.new}                  判断session是否为新的，所谓新的session，表示刚由server产生而client尚未使用
    ${pageContext.session.id}                   取得session的ID
    ${pageContext.servletContext.serverInfo}    取得主机端的服务信息
--%>
    ${pageContext.request}
    <h3>在jsp页面动态获取虚拟目录</h3>
    ${pageContext.request.contextPath}
</body>
</html>
