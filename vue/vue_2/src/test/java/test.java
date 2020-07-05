import com.vue.entity.User;
import com.vue.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll() {
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindById() {
        User user = userService.findByID(2);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        User user = userService.findByID(2);
        System.out.println("修改之前:" + user);

        user.setAge(1000);

        userService.updateUser(user);
        user = userService.findByID(2);
        System.out.println("修改之后:" + user);

    }

}
