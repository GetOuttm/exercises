import com.b.dao.IUserDao;
import com.b.domain.QueryVo;
import com.b.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
        }
    }

    @Test
    public void testFindOneByUsername() {
        List<User> users = userDao.findByUsername("小");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testfindUserByVo() {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("小");
        queryVo.setUser(user);

        List<User> users = userDao.findUserByVo(queryVo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testfindUserByCondition() {
        User user = new User();
        user.setId(55);
        user.setSex("女");
        List<User> userByCondition = userDao.findUserByCondition(user);
        for (User u : userByCondition) {
            System.out.println(u);
        }
    }

    @Test
    public void testfindUserInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(43);
        vo.setIds(list);

        List<User> users = userDao.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
