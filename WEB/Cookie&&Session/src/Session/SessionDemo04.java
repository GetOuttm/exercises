package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sessionDemo04")
public class SessionDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * session什么时候被销毁？
         * 		1. 服务器关闭
         * 		2. session对象调用invalidate() 。
         * 		3. session默认失效时间 30分钟
         * 			选择性配置修改
         * 			<session-config>
         * 		        <session-timeout>30</session-timeout>
         * 		    </session-config>
         */



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
