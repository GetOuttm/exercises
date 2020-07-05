package Servlet.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 注解配置：
 * 				* 设置dispatcherTypes属性
 * 					1. REQUEST：默认值。浏览器直接请求资源
 * 					2. FORWARD：转发访问资源
 * 					3. INCLUDE：包含访问资源
 * 					4. ERROR：错误跳转资源
 * 					5. ASYNC：异步访问资源
 */
//@WebFilter(value = "/*",dispatcherTypes = DispatcherType.REQUEST)
//    @WebFilter(value = "/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo3 implements Filter {

    /**
     * 在服务器关闭后，被服务器销毁。如果服务器正常关闭，则会执行destory方法   只执行一次
     */
    public void destroy() {
        System.out.println("destory...");
    }

    /**
     * 在每一次请求被拦截资源时，会执行。  执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");

        chain.doFilter(req, resp);
    }

    /**
     * 在服务器启动后会创建Filter对象，然后调用init方法   只执行一次
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

}
