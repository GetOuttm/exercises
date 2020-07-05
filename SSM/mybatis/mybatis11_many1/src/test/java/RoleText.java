import com.d.dao.IRoleDao;
import com.d.dao.IUserDao;
import com.d.domain.Role;
import com.d.domain.User;
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

public class RoleText {

    private InputStream is;
    private SqlSession sqlSession;
    private IRoleDao roleDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlsessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取sqlSession对象
        sqlSession = factory.openSession(true);//自动提交事务
        roleDao = sqlSession.getMapper(IRoleDao.class);
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
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }


}
