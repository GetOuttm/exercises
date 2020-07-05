package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        //封装pageBean
        PageBean<Route> pageBean = new PageBean<>();
        //设置当前页码
        pageBean.setCurrentPage(currentPage);
        //设置每页显示条数
        pageBean.setPageSize(pageSize);
        //设置总记录数
        int totalCount = routeDao.findTotalCount(cid,rname);
        pageBean.setTotalCount(totalCount);
        //设置当前页显示数据集合
        //开始的记录数
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid,start,pageSize,rname);
        pageBean.setList(list);
        //设置总页数 = 总记录数 / 每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

    @Override
    public Route findOne(String rid) {
        //根据id 查询route对象
        Route route = routeDao.findOne(Integer.parseInt(rid));

        //根据route的id查询图片的集合信息
        List<RouteImg> routeImgs = routeImgDao.findByRid(route.getRid());
        //将集合设置到route对象
        route.setRouteImgList(routeImgs);

        //根据route的sid查询商家信息
        Seller seller = sellerDao.find(route.getSid());
        route.setSeller(seller);

        //查询收藏次数
        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);

        return route;
    }
}
