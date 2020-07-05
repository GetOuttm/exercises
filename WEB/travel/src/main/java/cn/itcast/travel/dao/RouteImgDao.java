package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {

    /**
     * 根据route的id查询图片的集合信息
     * @param rid
     * @return
     */
    List<RouteImg> findByRid(int rid);
}
