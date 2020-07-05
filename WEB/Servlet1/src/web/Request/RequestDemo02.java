package web.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/request/demo02")
public class RequestDemo02 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post获取请求参数
        /*//根据参数名获取参数值
        String username = req.getParameter("username");
        System.out.println("post--" + username);*/

        //根据参数名获取参数值的数组
        /*String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/

        //获取所有参数的请求名称
        Enumeration<String> parameterNames = req.getParameterNames();
       /* while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            if (name.equals("hobby")) {
                String[] hobbies = req.getParameterValues("hobby");
                for (String hobby : hobbies) {
                    System.out.println(hobby);
                }
            } else {
                String value = req.getParameter(name);
                System.out.println(value);
            }
            System.out.println("-----------------");
        }*/

       //获取所有参数的Map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String key : keySet) {
            String[] values = parameterMap.get(key);
            System.out.println(key);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("--------------");
        }
        Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entrySet) {
            System.out.println(entry.getKey());
            String[] value = entry.getValue();
            for (String v : value) {
                System.out.println(v);
            }
            System.out.println("-----------------");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get 获取请求参数
        //根据参数名获取参数值
        /*String username = req.getParameter("username");
        System.out.println("get--" + username);*/
        this.doPost(req,resp);
    }
}
