import cn.jpa1.Customer;
import cn.urils.JpaUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestJpa {

    /**
     * 测试jpa的保存
     * 案例：保存一个客户到数据库
     * <p>
     * JPA的操作步骤
     * 1.加载配置文件创建工厂(实体管理类工厂)对象
     * 2.通过实体管理类工厂获取实体管理器
     * 3.获取事务对象，开启事务
     * 4.完成增删改查操作
     * 5.提交事务(回滚事务)
     * 6.释放资源
     */
    @Test
    public void testSave() {
        //1.加载配置文件创建工厂(实体管理类工厂)对象     作用：创建实体管理类工厂
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //2.通过实体管理类工厂获取实体管理器
        // 内部维护了很多内容  维护了数据库  维护了缓存信息 维护了所有的实体管理器对象   在创建EntityManagerFactory的过程中会根据配置创建数据库表
        // EntityManagerFactory的创建过程比较浪费资源   特点：线程安全的对象
        //  如何解决EntityManagerFactory的创建过程浪费资源（耗时）的问题？
        //      思路：创建一个公共的EntityManagerFactory的对象
        //	        静态代码块的形式创建EntityManagerFactory
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();
        //4.完成增删改查操作
        Customer customer = new Customer();
        customer.setCustName("阿里里1");
        customer.setCustIndustry("老二");
        //保存
        /*
          persist:保存
          merge:更新
          remove:删除
          find/getReference:根据id查询
         */
        entityManager.persist(customer);
        //5.提交事务(回滚事务)
        transaction.commit();
        //6.释放资源
        entityManager.close();
        entityManagerFactory.close();
    }


    @Test
    public void testSave1() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();
        //4.完成增删改查操作
        Customer customer = new Customer();
        customer.setCustName("阿里里1");
        customer.setCustIndustry("老二");
        //保存
        /*
          persist:保存
          merge:更新
          remove:删除
          find/getReference:根据id查询
         */
        entityManager.persist(customer);
        //5.提交事务(回滚事务)
        transaction.commit();
        //6.释放资源
        entityManager.close();
//        entityManagerFactory.close();
    }

    /**
     * 根据id查询客户
     * 使用find查询
     *         1.查询的对象就是当前的客户对象
     *         2.在调用find方法的时候就会发送sql语句查询数据库
     *  立即加载  得到的是对象本身
     */
    @Test
    public void testFind() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();

        //参数1Class 查询的数据结果需要包装成实体类类型的字节码    参数2  id 查询主键的取值
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer);

        transaction.commit();
        entityManager.close();
    }

    /**
     * 根据id查询客户
     * 使用getReference方法“
     *      1.获取的对象时一个动态代理对象
     *      2.调用getReference方法不会立即发送sql语句查询数据库
     *          当调用查询结果对象的时候，才会发送sql语句查询数据库
     *          什么时候用，什么时候发送sql语句查询数据库
     *  延迟加载(懒加载)  得到时一个动态代理对象  什么时候用什么时候加载   建议
     */
    @Test
    public void testReference() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();

        //参数1Class 查询的数据结果需要包装成实体类类型的字节码    参数2  id 查询主键的取值
        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println(customer);

        transaction.commit();
        entityManager.close();
    }

    /**
     * 删除   根据id删除
     */
    @Test
    public void testRemove() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();

        //先得到客户端对象在删除
        Customer customer = entityManager.find(Customer.class, 1L);
        entityManager.remove(customer);

        transaction.commit();
        entityManager.close();
    }

    /**
     * 更新
     */
    @Test
    public void testUpdate() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();

        //先得到客户端对象在更新
        Customer customer = entityManager.find(Customer.class, 2L);
        customer.setCustAddress("北京");
        entityManager.merge(customer);

        transaction.commit();
        entityManager.close();
    }
}
