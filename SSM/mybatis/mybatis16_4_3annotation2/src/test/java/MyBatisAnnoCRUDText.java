import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kk.dao.UserDao;
import com.kk.domain.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisAnnoCRUDText {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlsessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取sqlSession对象
        sqlSession = factory.openSession(true);//自动提交事务
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(56);
        System.out.println(user);

        User user1 = userDao.findById(56);
        System.out.println(user1);

        System.out.println(user == user1);
    }

    @Test
    public void testFindByUsername() {
        List<User> users = userDao.findByUsername("大");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
