package com.exception.ex;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) {
        //获取异常对象
        SysException sys = null;
        if (ex instanceof SysException) {
            sys = (SysException) ex;
        } else {
            sys = new SysException("系统正在维护");
        }

        //创建ModelAndView对象
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg",sys.getMessage());
        mav.setViewName("error");

        return mav;
    }
}
