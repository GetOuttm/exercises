package servlet;

import service.ProvinceService;
import service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findProvinceServlet")
public class FindProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");

        /*//调用service查询
        ProvinceService service = new ProvinceServiceImpl();

        //序列化list为json
        List<Province> list = service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);*/

        //调用service查询
        ProvinceService service = new ProvinceServiceImpl();

        String json = service.findAllJson();
        System.out.println(json);

        //响应结果
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
