import cn.urils.JpaUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * 测试JPQL
 */
public class TestJpql {

    /**
     * 查询全部
     *      jpql:    from cn.jpa1.Customer    不支持 select *
     *      sql:    select * from cst_customer
     */
    @Test
    public void testFindAll() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();

        //
        String jpql = "from Customer";
        Query query = entityManager.createQuery(jpql);//创建Query对象，query对象才是执行jpql的对象
        //发送查询封装结果集    查询结果封装成list
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }

        transaction.commit();
        entityManager.close();
    }


    //倒序排序   id
    @Test
    public void testOrder() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();

        //
        String jpql = "from Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);//创建Query对象，query对象才是执行jpql的对象
        //发送查询封装结果集
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }

        transaction.commit();
        entityManager.close();
    }

    //统计
    @Test
    public void testCount() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();

        String jpql = "select count(custId) from Customer";
        Query query = entityManager.createQuery(jpql);//创建Query对象，query对象才是执行jpql的对象
        //发送查询封装结果集
        //得到唯一的结果集
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);

        transaction.commit();
        entityManager.close();
    }

    //分页
    @Test
    public void testLimit() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();

        String jpql = "from Customer";
        Query query = entityManager.createQuery(jpql);//创建Query对象，query对象才是执行jpql的对象
        //发送查询封装结果集
        //起始索引
        query.setFirstResult(0);
        //每页查询的条数
        query.setMaxResults(2);

        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }

        transaction.commit();
        entityManager.close();
    }

    //条件
    @Test
    public void testWhere() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();//获取事务对象
        transaction.begin();

        //
        String jpql = "from Customer where custName like ?1";
        Query query = entityManager.createQuery(jpql);//创建Query对象，query对象才是执行jpql的对象

        //对参数赋值
        //参数1 占位符的索引位置从1开始   参数2 取值
        query.setParameter(1,"%2%");

        //发送查询封装结果集
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);
        }

        transaction.commit();
        entityManager.close();
    }

}
