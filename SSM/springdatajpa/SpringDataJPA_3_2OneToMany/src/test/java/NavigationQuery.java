import org.junit.Test;
import org.junit.runner.RunWith;
import com.onetomany.dao.CustomerDao;
import com.onetomany.dao.LinkManDao;
import com.onetomany.entity.Customer;
import com.onetomany.entity.LinkMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class NavigationQuery {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    //could not initialize proxy - no Session
    //测试对象导航查询（查询一个对象的时候，通过此对象查询所有的关联对象）
    @Test
    @Transactional// 解决在java代码中的no session问题
    public void testQuery() {
        //查询id为2的客户   延迟加载
        Customer customer = customerDao.getOne(2l);
        //对象导航查询，此客户下的所有联系人
        Set<LinkMan> linkManSet = customer.getLinkManSet();

        for (LinkMan linkMan : linkManSet) {
            System.out.println(linkMan);
        }
    }

    /**
     * 对象导航查询：
     *      默认使用的是延迟加载的形式查询的
     *          调用getOne方法并不会立即发送查询，而是在使用关联对象的时候才会查询
     *      延迟加载！
     * 修改配置，将延迟加载改为立即加载
     *      fetch，需要配置到多表映射关系的注解上
     */
    @Test
    @Transactional// 解决在java代码中的no session问题
    public void testQuery1() {
        //查询id为2的客户   立即加载
        Customer customer = customerDao.findOne(2l);
        //对象导航查询，此客户下的所有联系人
        Set<LinkMan> linkManSet = customer.getLinkManSet();

        System.out.println(linkManSet.size());
    }

    /**
     * 从联系人对象导航查询他的所属客户
     *      * 默认 ： 立即加载
     *  延迟加载：
     *      查询主体是谁在那边添加延迟加载
     */
    @Test
    @Transactional// 解决在java代码中的no session问题
    public void testQuery2() {
        //查询id为2的客户   立即加载
        LinkMan linkMan = linkManDao.findOne(2l);
        //对象导航查询，此客户下的所有联系人
        Customer customer = linkMan.getCustomer();

        System.out.println(customer);

        HashMap<String,String> hashMap = new HashMap<>();
        Hashtable<String,String> hashtable = new Hashtable<>();
    }
}
