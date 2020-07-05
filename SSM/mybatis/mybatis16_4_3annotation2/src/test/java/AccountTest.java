import com.kk.dao.AccountDao;
import com.kk.dao.UserDao;
import com.kk.domain.Account;
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

public class AccountTest {

    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private AccountDao accountDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取sqlsessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取sqlSession对象
        sqlSession = factory.openSession(true);//自动提交事务
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAccount();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
