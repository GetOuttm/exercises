<%@ page import="el.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
获取值
		1. el表达式只能从域对象中获取值
		2. 语法：
			1. ${域名称.键名}：从指定域中获取指定键的值
				* 域名称：
					1. pageScope		--> pageContext
					2. requestScope 	--> request
					3. sessionScope 	--> session
					4. applicationScope --> application（ServletContext）
				* 举例：在request域中存储了name=张三
				* 获取：${requestScope.name}

			2. ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。
        3. 获取对象、List集合、Map集合的值
				1. 对象：${域名称.键名.属性名}
					* 本质上会去调用对象的getter方法

				2. List集合：${域名称.键名[索引]}
                    索引越界不会报错
				3. Map集合：
					* ${域名称.键名.key名称}
					* ${域名称.键名["key名称"]}

--%>

    <%
        request.setAttribute("name","zhangsan");
        session.setAttribute("age","18");
        pageContext.setAttribute("address","shanxi");
        application.setAttribute("height","188");
    %>
    ${requestScope.name}<br>
    ${sessionScope.age}<br>
    ${pageScope.address}<br>
    ${applicationScope.height}<br>
        ${name}

    <h3>获取对象、List集合、Map集合的值</h3>
        <%
            User user = new User();
            user.setName("张三");
            user.setAge(18);
            user.setBirthday(new Date());
            request.setAttribute("u",user);

            List list = new ArrayList();
            list.add("aaa");
            list.add("ddd");
            list.add(user);
            request.setAttribute("list",list);

            Map map = new HashMap();
            map.put("haha","哇哈哈");
            map.put("fenjiu","山西汾酒");
            map.put("user",user);
            request.setAttribute("map",map);
        %>
    <h4>获取对象的值</h4>
        ${requestScope.u.name}<br>
        ${u.name}<br>
        ${u.birthday}<br>
        ${u.birStr}<br>
    <h4>获取list的值</h4>
        ${list}<br>
        ${list[0]}<br>
        ${list[1]}<br>
        ${list[10]}<br>
        ${list[2].name}<br>
    <h4>获取Map的值</h4>
        ${map.haha}<br>
        ${map["fenjiu"]}<br>
        ${map.user.name}<br>
</body>
</html>
