package Servlet.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo4 implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4执行了...");
        chain.doFilter(req, resp);
        System.out.println("filterDemo4回来了...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
