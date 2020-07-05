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

public class SecondLevelCacheText {

    private InputStream is;
    private SqlSessionFactory factory;

    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlsessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{
        is.close();
    }

    /**
     * 测试二级缓存
     * 二级缓存:
     * 			它指的是Mybatis中SqlSessionFactory对象的缓存。
     * 			由同一个SqlSessionFactory对象创建的SqlSession共享其缓存。
     * 			二级缓存的使用步骤：
     * 				第一步：让Mybatis框架支持二级缓存（在SqlMapConfig.xml中配置）
     * 				第二步：让当前的映射文件支持二级缓存（在IUserDao.xml中配置）
     * 				第三步：让当前的操作支持二级缓存（在select标签中配置）
     *
     *
     * 	两次查询的数据不一致
     * 	    二级缓存存放的是数据不是对象
     */
    @Test
    public void testCache() {
        SqlSession sqlSession1 = factory.openSession();
        IUserDao dao1 = sqlSession1.getMapper(IUserDao.class);
        User user = dao1.findById(41);
        System.out.println(user);
        sqlSession1.close();//一级缓存消失

        SqlSession sqlSession2 = factory.openSession();
        IUserDao dao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = dao2.findById(41);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user == user2);
    }

}
