package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domian.Province;
import jedis.util.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用redis缓存
     * @return
     */
    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        //1.1获取redis客户端连接
        Jedis jedis = JedisPoolUtil.getJedis();
        String province_json = jedis.get("province");

        //1.2判断province_json数据是否为null
        if (province_json == null || province_json.length() == 0) {
            //redis中没有数据
            System.out.println("redis中没有数据，查询数据库");
            //2.1从数据库中查询
            List<Province> list = dao.findAll();
            //2。2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3将json数据存入到redis
            jedis.set("province",province_json);

            jedis.close();
        } else {
            System.out.println("redis中有数据查询缓存");
        }

        return province_json;
    }
}
