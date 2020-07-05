package com.jd.service;

import com.jd.entity.Item;

import java.util.List;

public interface ItemService {

    //保存商品
    void save(Item item);

    //查询商品
    List<Item> findAll(Item item);
}
