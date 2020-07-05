package web;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo02 implements Servlet {

    /**
     * 生命周期
     * 1.实例化--容器调用servlet的构造器，创建servlet对象
     *      默认情况第一次访问时被创建
     *      也可以在web.xml里配置
     * 2.初始化--容器在创建完servlet对象之后，会立即调用该对象的init方法。该方法只会执行一次
     *      init方法只执行一次说明一个servlet在内存中只存在一个对象，servlet是单例的
     *          多个用户同时访问可能存在线程安全问题
     *          解决：尽量不要再servlet中定义成员变量。
     *              即使定义了成员变量也不要对其进行修改值
     * 3.就绪--容器在收到请求之后，会调用servlet对象的service方法
     * 4.销毁--容器在删除servlet对象之前，会调用该方法的destroy方法。该方法只会执行一次
     *      只有服务器正常关闭时，才会执行destroy方法
     *      destroy是在servlet销毁之前执行，一般用于释放资源
     */


    /**
     * 初始化方法
     * 在servlet创建时执行，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init....");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：servlet配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每一次servlet被访问时执行。执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service....");
    }

    /**
     * 获取Servlet的一些信息：版本，作者等等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁
     * servlet  容器在删除servlet对象之前，会调用该对象的destroy方法
     */
    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
