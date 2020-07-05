package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionDemo03")
public class SessionDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 客户端不关闭，服务器关闭，两次获取到的Session是不一样的
         *
         * 但是要确保数据不丢失。tomcat自动完成以下工作
         * 			* session的钝化：
         * 				* 在服务器正常关闭之前，将session对象系列化到硬盘上
         * 			* session的活化：
         * 				* 在服务器启动后，将session文件转化为内存中的session对象即可。
         */

        HttpSession session = request.getSession();
        System.out.println(session);
        /*
        org.apache.catalina.session.StandardSessionFacade@77ba6de4
        org.apache.catalina.session.StandardSessionFacade@729d426c
         */

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
