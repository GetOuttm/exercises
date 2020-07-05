package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("1111");
        UserDao userDao = new UserDao();
        User login = userDao.login(user);
        System.out.println(login);
    }
}
