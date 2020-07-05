import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.ljf.dao.IUserDao;
import com.ljf.dao.impl.IUserDaoImpl;
import com.ljf.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {


    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);

        //使用工厂创建dao对象
        IUserDao iUserDao = new IUserDaoImpl(factory);

        //使用代理对象执行方法
        List<User> users = iUserDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        //释放资源
        is.close();

    }
}
