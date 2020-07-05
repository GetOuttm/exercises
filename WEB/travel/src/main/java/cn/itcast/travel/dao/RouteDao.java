package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {


    /**
     * 根据cid查询总记录数
     * @param cid
     * @return
     */
    int findTotalCount(int cid, String rname);

    /**
     * 根据参数查询当前页的数据集合
     * @param cid
     * @param start     开始
     * @param pageSize   查询多少条记录
     * @return
     */
    List<Route> findByPage(int cid,int start,int pageSize, String rname);


    /**
     * 根据id查询一个旅游线路的详细信息
     * @param rid
     * @return
     */
    Route findOne(int rid);
}
