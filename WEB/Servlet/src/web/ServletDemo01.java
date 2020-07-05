package web;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet快速入门
 */
public class ServletDemo01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供方法的服务
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello servlet");
    }

    /**
     * 执行原理：
     * 	1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
     * 	2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
     * 	3. 如果有，则在找到对应的<servlet-class>全类名
     * 	4. tomcat会将字节码文件加载进内存，并且创建其对象
     * 	5. 调用其方法
     */

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
