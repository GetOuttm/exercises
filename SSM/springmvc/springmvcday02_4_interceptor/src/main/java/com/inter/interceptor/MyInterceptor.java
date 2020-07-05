package com.inter.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 预处理，controller方法执行前
     * 返回true ，放行，执行下一个拦截器，如果没有执行controller中的方法
     * 返回false  不放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor执行了。。。。。前111");

//        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);

        return true;
    }

    /**
     * 后处理方法  controller方法执行之后success.jsp执行之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor执行了。。。。。后111");
//        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
    }

    /**
     * success.jsp执行之后该方法执行  可以释放资源
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor执行了。。。。。最后111");
    }
}
