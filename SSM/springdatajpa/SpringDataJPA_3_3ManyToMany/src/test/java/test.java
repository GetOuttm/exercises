import org.junit.Test;
import org.junit.runner.RunWith;
import com.manytomany.dao.RoleDao;
import com.manytomany.dao.UserDao;
import com.manytomany.entity.Role;
import com.manytomany.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * 保存一个用户，保存一个角色
     *
     *  多对多放弃维护权：被动的一方放弃
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testAdd() {
        User user = new User();
        user.setUserName("爸爸");
        user.setUserAge("47");

        Role role = new Role();
        role.setRoleName("父亲");
        //用户到角色关系
        user.getRoles().add(role);
        //角色到用户
        role.getUsers().add(user);

        userDao.save(user);
        roleDao.save(role);
    }

    //测试级联添加（保存一个用户的同时保存用户的关联角色）
    @Test
    @Transactional
    @Rollback(false)
    public void testAdd1() {
        User user = new User();
        user.setUserName("爸爸");
        user.setUserAge("47");

        Role role = new Role();
        role.setRoleName("父亲");
        //用户到角色关系
        user.getRoles().add(role);
        //角色到用户
        role.getUsers().add(user);

        userDao.save(user);
    }


    //删除id为1的用户，同时删除他的关联对象
    @Test
    @Transactional
    @Rollback(false)
    public void testDel() {
        User user = userDao.findOne(1L);

        userDao.delete(user);
    }
}
