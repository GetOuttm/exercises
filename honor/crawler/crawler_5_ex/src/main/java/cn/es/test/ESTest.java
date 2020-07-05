package cn.es.test;

import cn.es.pojo.Item;
import cn.es.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ESTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    //创建索引和映射
    @Test
    public void createIndex() {
        this.elasticsearchTemplate.createIndex(Item.class);
        this.elasticsearchTemplate.putMapping(Item.class);
    }


    //增
    // 删
    // 改
    //批量保存
}
