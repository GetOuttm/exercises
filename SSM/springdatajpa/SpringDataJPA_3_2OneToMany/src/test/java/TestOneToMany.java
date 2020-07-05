import org.junit.Test;
import org.junit.runner.RunWith;
import com.onetomany.dao.CustomerDao;
import com.onetomany.dao.LinkManDao;
import com.onetomany.entity.Customer;
import com.onetomany.entity.LinkMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestOneToMany {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;


    /**
     * 保存一个用户一个联系人
     * 效果：客户和联系人作为独立的数据保存到数据库中
     *      *      联系人的外键为空
     *      *  原因？
     *      *      实体类中没有配置关系
     *
     *
     * 如果保存就出现错误，更换数据库方言
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testSave() {
        //创建客户，创建联系人
        Customer customer = new Customer();
        customer.setCustName("百度");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("爸爸");

        /**
         * 配置了客户到联系人的关系
         *      从客户的角度上：发送两条insert语句，发送一条更新语句更新数据库（更新外键）
         * 由于我们配置了客户到联系人的关系：客户可以对外键进行维护
         */
        customer.getLinkManSet().add(linkMan);

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSave1() {
        //创建客户，创建联系人
        Customer customer = new Customer();
        customer.setCustName("百度");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("爸爸");

        /**
         * 配置联系人到客户的关系（多对一）
         *    只发送了两条insert语句
         * 由于配置了联系人到客户的映射关系（多对一）
         */
        linkMan.setCustomer(customer);

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    /**
     * 会有一条多余的update语句
     *      * 由于一的一方可以维护外键：会发送update语句
     *      * 解决此问题：只需要在一的一方放弃维护权即可
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testSave2() {
        //创建客户，创建联系人
        Customer customer = new Customer();
        customer.setCustName("百度");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("爸爸");

        linkMan.setCustomer(customer);//由于配置了多的一方到一的一方的关联关系（当保存的时候，就已经对外键赋值）
        customer.getLinkManSet().add(linkMan);//由于配置了一的一方到多的一方的关联关系（发送一条update语句）


        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    /**
     * 级联添加：保存一个客户的同时，保存客户的所有联系人
     *      需要在操作主体的实体类上，配置casacde属性
     */
    @Test
    @Transactional //配置事务
    @Rollback(false) //不自动回滚
    public void testCascadeAdd() {
        Customer customer = new Customer();
        customer.setCustName("百度1");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小李1");

        linkMan.setCustomer(customer);
        customer.getLinkManSet().add(linkMan);

        customerDao.save(customer);
    }

    /**
     * 级联删除
     *      删除1号客户的同时，删除1号客户的所有联系人
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testDel() {
        //查询1号客户
        Customer customer = customerDao.findOne(1L);

        //2.删除1号客户
        customerDao.delete(customer);
    }
}
