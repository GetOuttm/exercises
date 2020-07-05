package jedis.text;

import jedis.util.JedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Jedis的测试类
 */
public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test1() {
        //1.获取连接
        //127.0.0.1
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        //2.操作
        jedis.set("username", "zhangsan");

        //3.关闭连接
        jedis.close();
    }

    /*1) 字符串类型 string
            set
            get*/
    @Test
    public void testString() {
        Jedis jedis = new Jedis();//如果不传参数，默认为"localhost",6379
        jedis.set("name", "lisi");
        //获取
        String name = jedis.get("name");
        System.out.println(name);

        //可以使用setex()方法存储可以指定过期时间的key value
        jedis.setex("activecode", 20, "hehe");//将activecode：hehe键值对存入内存，20秒后自动删除


        jedis.close();
    }

    /**
     * 2) 哈希类型 hash ： map格式
     * hset
     * hget
     * hgetall
     */
    @Test
    public void testHash() {
        //1.获取连接
        Jedis jedis = new Jedis();//如果不传参数，默认为"localhost",6379

        //2.操作
        jedis.hset("user","name","wangwu");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

        //获取
        String name = jedis.hget("user", "name");
        System.out.println(name);

        //获取hash中的所有map中的数据
        Map<String, String> map = jedis.hgetAll("user");
        Set<String> set = map.keySet();
        for (String key : set) {
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }

        //3.关闭连接
        jedis.close();
    }

    /**
     * 3) 列表类型 list ： linkedlist格式。支持重复元素
     * 			lpush / rpush
     * 			lpop / rpop
     * 			lrange start end : 范围获取
     */
    @Test
    public void testList() {
        //1.获取连接
        Jedis jedis = new Jedis();//如果不传参数，默认为"localhost",6379

        //2.操作
        jedis.lpush("mylist","a","b","c");//从左边存
        jedis.rpush("mylist","a","b","c");//从右边存

        //获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //删除
        String left = jedis.lpop("mylist");//删除左边
        System.out.println(left);
        String right = jedis.rpop("mylist");//删除右边
        System.out.println(right);

        //获取
        List<String> mylist1 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist1);

        //3.关闭连接
        jedis.close();
    }

    /**
     * 4) 集合类型 set  ： 不允许重复元素
     * 			sadd
     * 			smembers:获取所有元素
     */
    @Test
    public void testSet() {
        //1.获取连接
        Jedis jedis = new Jedis();//如果不传参数，默认为"localhost",6379

        //2.操作
        jedis.sadd("myset","a","b","c");

        //获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);


        //3.关闭连接
        jedis.close();
    }

    /**
     * 5) 有序集合类型 sortedset：不允许重复元素，且元素有顺序
     * 			zadd
     * 			zrange
     */
    @Test
    public void testSortedset() {
        //1.获取连接
        Jedis jedis = new Jedis();//如果不传参数，默认为"localhost",6379

        //2.操作
        jedis.zadd("mysset",1,"java");
        jedis.zadd("mysset",3,"c++");
        jedis.zadd("mysset",2,"php");

        //获取。
        Set<String> mysset = jedis.zrange("mysset", 0, -1);
        System.out.println(mysset);

        //获取长度
        Long mysset1 = jedis.zcard("mysset");
        System.out.println(mysset1);

        //3.关闭连接
        jedis.close();
    }


    /**
     * Jedis连接池使用
     */
    @Test
    public void testJedisPool() {
        //0.创建jedis配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);//最大连接数
        jedisPoolConfig.setMaxIdle(10);//最大空闲连接

        //1.创建jedis连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
        
        //2.获取连接
        Jedis resource = jedisPool.getResource();

        //3.使用
        resource.set("wakaka","ai");

        //4.关闭  归还连接池
        resource.close();
    }

    /**
     * jedis连接池工具类的使用
     */
    @Test
    public void test1111() {
        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtil.getJedis();

        jedis.set("nanguo","hehe");

        jedis.close();
    }

}
