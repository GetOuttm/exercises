import com.q.dao.UserDao;
import com.q.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisAnnoText {
    /**
     *测试基于注解的mybatis使用
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //使用工厂生产sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //使用sqlSession创建dao的接口代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();
        is.close();
    }
}
