package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginUserFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //判断是否是登录相关的资源
        HttpServletRequest request = (HttpServletRequest) req;

        String uri = request.getRequestURI();

        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")) {
            chain.doFilter(req, resp);
        } else {
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                request.setAttribute("login_msg","您尚未登录请先登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
