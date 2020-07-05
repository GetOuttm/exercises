import com.kk.dao.UserDao;
import com.kk.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 二级缓存测试
 */
public class LevelCacheTest {
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

    @Test
    public void testFindOne() {
        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findById(56);
        System.out.println(user);

        sqlSession.close();//释放一级缓存

        SqlSession sqlSession1 = factory.openSession();
        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
        User user1 = userDao1.findById(56);
        System.out.println(user1);

        System.out.println(user == user1);
    }



}
