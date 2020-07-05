import com.a.dao.IUserDao;
import com.a.domain.QueryVo;
import com.a.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{
        //提交事务
        sqlSession.commit();
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

    /*
    添加
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("mybatis last insertid");
        user.setAddress("北京市昌平区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存之前" + user);

        userDao.saveUser(user);

        System.out.println("保存之后" + user);
    }

    /**
     * 更新
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(54);
        user.setUsername("呵呵");
        user.setAddress("山西");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    /**
     * 删除
     */
    @Test
    public void testDeleteUser() {
        userDao.deleteUser(52);
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(52);
        System.out.println(user);
    }


    @Test
    public void testFindOneByUsername() {
        List<User> users = userDao.findByUsername("小");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 总记录数
     */
    @Test
    public void testTotalCount() {
        int count = userDao.totalCount();
        System.out.println(count);
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
}
