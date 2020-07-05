package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao dao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        //1.从redis中查询
        Jedis jedis = JedisUtil.getJedis();
        //使用sortedSet
//        Set<String> categorys = jedis.zrange("category", 0, -1);
        //查询sortedSet的分数和值
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);

        List<Category> all = null;
        //2.判断查询的集合是否为空
        if (categorys == null || categorys.size() ==0) {
            System.out.println("数据库");
            //3.如果为空，则从数据库中查询在存入redis
            all = dao.findAll();
            //将集合存到redis
            for (int i = 0; i < all.size(); i++) {
                jedis.zadd("category",all.get(i).getCid(),all.get(i).getCname());
            }
        } else {
            System.out.println("redis");
            //4.如果不为空，将set数据存入list
            all = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());
                all.add(category);
            }
        }

        return all;
    }
}
