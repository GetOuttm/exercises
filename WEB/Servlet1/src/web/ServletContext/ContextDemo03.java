package web.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContext2")
public class ContextDemo03 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        //获取文件服务器的真实路径   String getRealPath(String path)
        String path = context.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(path);

        String path1 = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下资源访问
        System.out.println(path1);


        String path2 = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下资源访问
        System.out.println(path2);
//        File file = new File(path);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
