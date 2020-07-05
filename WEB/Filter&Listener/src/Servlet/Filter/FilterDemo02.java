package Servlet.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo02 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息的增强
        System.out.println("FilterDemo02....");
        chain.doFilter(req, resp);
        //对response对象响应消息增强
        System.out.println("...filterDemo02");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
