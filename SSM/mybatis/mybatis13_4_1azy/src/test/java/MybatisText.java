import com.f.dao.IUserDao;
import com.f.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisText {

    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlsessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
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
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        //5.执行查询方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testfindById() {
        User u = userDao.findById(55);
        System.out.println(u);
    }
}
