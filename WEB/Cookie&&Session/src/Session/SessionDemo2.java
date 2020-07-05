package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo2")
public class SessionDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 当客户端关闭后，服务器不关闭，那么两次获取的session默认情况不是同一个
         *
         * 如果需要相同，则可以创建cookie，键为JSESSIIONID,设置最大存活时间，让cookie持久化保存
         */

        //获取session
        HttpSession session = request.getSession();

        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        System.out.println(session);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
