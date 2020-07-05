package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        //接收线路名称
        String rname = request.getParameter("rname");
        //解决乱码
        rname = new String(rname.getBytes("iso-8859-1"),"utf-8");

        int cid = 0;
        //处理参数
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            //不为空
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0; //当前页码，如果不传递默认第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            //不为空
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        int pageSize = 0;//每页显示条数 如果不传递。默认每页显示5条数据
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            //不为空
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }


        //调用service查询PageBean对象
        PageBean<Route> pageBean =
                routeService.pageQuery(cid, currentPage, pageSize,rname);

        //将PageBean对象序列化为json返回
        writeValue(pageBean,response);

    }

    /**
     * 根据id查询一个旅游线路的详细信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收id
        String rid = request.getParameter("rid");

        //2.调用service查询route对象
        Route route = routeService.findOne(rid);

        //3.转为json写会客户端
        writeValue(route,response);
    }

    /**
     * 判断当前登录用户是否收藏该线路
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取线路id
        String rid = request.getParameter("rid");

        //2.获取当前登录用户user
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null) {
            //尚未登录、
            uid = 0;
        } else {
            //用户登录
            uid = user.getUid();
        }

        //3.调用FavoriteService查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);

        //4.写回客户端
        writeValue(flag,response);
    }

    /**
     * 添加收藏
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路id
        String rid = request.getParameter("rid");

        //获取当前用户
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null) {
            //尚未登录、
            return;
        } else {
            //用户登录
            uid = user.getUid();
        }

        //3.调用Service
        favoriteService.addFavorite(rid,uid);

    }
}
