import com.h.dao.IUserDao;
import com.h.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisText {

    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlsessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取sqlSession对象
        sqlSession = factory.openSession(true);//自动提交事务
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{
        //提交事务
        /*sqlSession.commit();*/
        //6.释放资源
        sqlSession.close();
        is.close();
    }

    /**
     * 测试一级缓存
     * 一级缓存：
     * 			它指的是Mybatis中SqlSession对象的缓存。
     * 			当我们执行查询之后，查询的结果会同时存入到SqlSession为我们提供一块区域中。
     * 			该区域的结构是一个Map。当我们再次查询同样的数据，mybatis会先去sqlsession中
     * 			查询是否有，有的话直接拿出来用。
     * 			当SqlSession对象消失时，mybatis的一级缓存也就消失了。
     */
    @Test
    public void testCache() {
        User user = userDao.findById(41);
        System.out.println(user);

        /*sqlSession.close();
        //再次获取sqlsession对象
        sqlSession = factory.openSession();*/
        sqlSession.clearCache();//此方法也可以清空缓存
        userDao = sqlSession.getMapper(IUserDao.class);


        User user1 = userDao.findById(41);
        System.out.println(user1);

        System.out.println(user == user1);
    }

    /**
     *测试缓存同步
     * 一级缓存是sqlsession范围的缓存，当调用sqlsession的修改，添加,删除，commit(),close()等方法，就回清空一级缓存
     */
    @Test
    public void testClearCache() {
        //先查询
        User user = userDao.findById(41);
        System.out.println(user);
        //更新
        user.setUsername("haha");
        user.setAddress("北京");
        userDao.update(user);
        //在查询
        User user1 = userDao.findById(41);
        System.out.println(user1);

        System.out.println(user == user1);
    }


}
