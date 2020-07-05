import com.datajpa.dao.CustomerDao;
import com.datajpa.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class CustomerTest {

    /**
     * springDataJpa的运行过程和原理剖析
     * 	1.通过JdkDynamicAopProxy的invoke方法创建了一个动态代理对象
     * 	2.SimpleJpaRepository当中封装了JPA的操作（借助JPA的api完成数据库的CRUD）
     * 	3.通过hibernate完成数据库操作（封装了jdbc）
     */

    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询
     */
    @Test
    public void testFindOne() {
        Customer customer = customerDao.findOne(4L);
        System.out.println(customer);
    }

    /**
     * 保存或者更新
     *  根据传入的对象是否有id，没有id属性则是保存。有id就是更新
     */
    @Test
    public void testSave() {
        //保存
        Customer customer = new Customer();
        customer.setCustName("爸爸");
        customer.setCustAddress("山西");
        customer.setCustPhone("123456");
        customerDao.save(customer);
    }

    @Test
    public void testSave1() {
        //更新   先查后更新
        Customer customer = new Customer();
        customer.setCustName("妈妈");
        customer.setCustId(5L);
        customerDao.save(customer);
    }

    //删除    先查询。有数据的话删除
    @Test
    public void testDel() {
        customerDao.delete(5L);
    }

    @Test
    public void testFindAll() {
        List<Customer> customers = customerDao.findAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    //统计
    @Test
    public void testCount() {
        long count = customerDao.count();//查询数量
        System.out.println(count);
    }

    //查询判断   id为4的客户是否存在
    @Test
    public void testExists() {
        boolean exists = customerDao.exists(4L);
        System.out.println("id为4的客户是否存在:" + exists);
    }

    /**
     * 根据id从数据库查询
     *
     *  Transactional事务支持，保证getOne正常运行
     *
     *  findOne:
     *      em.find()                   立即加载
     *  getOne:
     *      em.getReference()           延迟加载 与事务有关系
     *          返回的是客户动态代理对象
     */
    @Test
    @Transactional
    public void testGetOne() {
        Customer customer = customerDao.getOne(4L);
        System.out.println(customer);
    }
}
