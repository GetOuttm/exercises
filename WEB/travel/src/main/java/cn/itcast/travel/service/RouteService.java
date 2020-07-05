package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {

    /**
     * 根据类别分页查询数据
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    /**
     * 根据id查询一个旅游线路的详细信息
     * @param rid
     * @return
     */
    Route findOne(String rid);


}
