<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.e.dao.IUserDao" %>
<%@ page import="com.e.domain.User" %>
<%@ page import="java.util.List" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    //读取配置文件
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
    //创建sqlSessionFactory工厂
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(is);
    //使用工厂生产sqlSession对象
    SqlSession sqlSession = factory.openSession();
    //使用sqlSession创建dao的接口代理对象
    IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
    //使用代理对象执行方法
    List<User> users = iUserDao.findAll();
    for (User user : users) {
        System.out.println(user);
    }
    //释放资源
    sqlSession.close();
    is.close();
%>
</body>
</html>
