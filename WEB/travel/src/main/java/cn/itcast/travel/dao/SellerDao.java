package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

public interface SellerDao {

    /**
     * 查询商家信息
     * @return
     */
    Seller find(int id);
}
