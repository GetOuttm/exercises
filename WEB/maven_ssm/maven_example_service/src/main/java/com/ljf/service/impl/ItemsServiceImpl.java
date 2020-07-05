package com.ljf.service.impl;

import com.ljf.service.ItemsService;
import com.ljf.dao.ItemsDao;
import com.ljf.domain.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

    /**
     * @Autowired(required=true)：当使用@Autowired注解的时候，其实默认就是@Autowired(required=true)，
     *      表示注入的时候，该bean必须存在，否则就会注入失败。
     * @Autowired(required=false)：表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错。
     */
    @Autowired(required = false)
    private ItemsDao itemsDao;

    public Items findById(Integer id) {
        return itemsDao.findById(id);
    }
}
