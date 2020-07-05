import com.datajpa.dao.CustomerDao;
import com.datajpa.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class CustomerJPQLTest {


    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindJPQL() {
        Customer customer = customerDao.findJpql(" 阿里里2");
        System.out.println(customer);
    }


    @Test
    public void testFindJpqlIdAndAndName() {
        Customer customer = customerDao.findJpqlIdAndAndName(2L," 阿里里2");
        System.out.println(customer);
    }


    /**
     * 需要加事务的支持
     *      springdatajpa中使用jpql完成更新/删除操作
     *          需要手动添加事务的支持
     *          默认会执行结束之后，进行回滚操作
     *
     *     @Rollback   设置是否自动回滚   默认true
     *          true | false
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testupdateCustomer() {
        customerDao.updateCustomer("爸爸",2L);
    }

    @Test
    public void testFindAll() {
        List<Object[]> list = customerDao.findSql();
        for (Object[] customer : list) {
            System.out.println(Arrays.toString(customer));
        }
    }

    @Test
    public void testFinLikeAll() {
        List<Object[]> list = customerDao.findSqlLike("%里%");
        for (Object[] customer : list) {
            System.out.println(Arrays.toString(customer));
        }
    }


    /**
     * 使用springdatajpa命名规范测试
     */
    @Test
    public void testName() {
        Customer customer = customerDao.findByCustName("爸爸");
        System.out.println(customer);
    }
    @Test
    public void testNameLike() {
        List<Customer> customers = customerDao.findByCustNameLike("%里%");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void testFindByCustNameLikeAndCustIndustry() {
        List<Customer> customers = customerDao.findByCustNameLikeAndCustIndustry("%里%", "老三");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
