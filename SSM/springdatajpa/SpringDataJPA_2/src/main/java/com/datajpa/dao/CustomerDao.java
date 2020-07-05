package com.datajpa.dao;

import com.datajpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 持久层接口
 *
 *   jpa只需要编写dao层接口
 *   需要继承两个接口
 *      JpaRepository<实体类类型，主键类型>：用来完成基本CRUD操作
 *      JpaSpecificationExecutor<实体类类型>：用于复杂查询（分页等查询操作）
 *    提供响应的泛型
 */
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {

    /**
     * 根据客户姓名查询客户    使用jpql形式查询
     *
     * @param name
     * @return
     */
    @Query("from Customer where custName = ?1")
    Customer findJpql(String name);


    /**
     * 根据客户名称和客户id查询客户
     * <p>
     * 赋值的时候，使用?索引指定是第几个参数
     */
    @Query("from Customer where custName = ?2 and custId = ?1")
    Customer findJpqlIdAndAndName(Long id, String name);


    /**
     * 更新
     *
     * @Query 代表的是进行查询
     * @Modifying 来将该操作标识为修改查询，这样框架最终会生成一个更新的操作，而非查询   声明此方法是一个更新操作
     */
    @Query(value = "update Customer set custName = ?1 where custId = ?2")
    @Modifying
    public void updateCustomer(String custName, Long custId);

    /**
     * 使用sql查询
     * <p>
     * 注解@Query  value 可以使用是jpql sql进行操作
     * nativeQuery  true(使用sql进行查询)  |  false(使用jpql进行查询)
     */
    @Query(value = "select * from cst_customer", nativeQuery = true)
    List<Object[]> findSql();

    /**
     * 根据用户名模糊查询
     */
    @Query(value = "select * from cst_customer where cust_name like ?", nativeQuery = true)
    List<Object[]> findSqlLike(String name);


    Customer findByCustName(String custName);

    List<Customer> findByCustNameLike(String custName);

    //使用客户名称模糊匹配和客户行业精准匹配
    List<Customer> findByCustNameLikeAndCustIndustry(String custName, String custIndustry);
}
