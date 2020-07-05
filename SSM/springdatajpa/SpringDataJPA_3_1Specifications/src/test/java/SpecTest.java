import org.junit.Test;
import org.junit.runner.RunWith;
import com.specifications.dao.CustomerDao;
import com.specifications.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Specifications动态查询
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testSpecifications() {
        /**
         * 匿名内部类
         * 自定义查询条件
         *      1.实现Specification接口(提供泛型，查询的对象类型)
         *      2.实现toPredicate方法(构造查询条件)
         *      3.需要借助方法参数的两个参数
         *          root：获取需要查询的对象属性
         *          criteriaBuilder：构造查询条件的，内部封装了很多的查询条件(模糊匹配，精准匹配)
         *
         *          criteriaQuery	：代表一个顶层查询对象，用来自定义查询
         *
         *  根据客户名称查询，查询客户为xxx的客户
         */
        Specification<Customer> specifications = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //1.获取比较的属性
                Path<Object> custName = root.get("custName");
                //2.构造查询条件
                //第一个参数需要比较的属性   第二个参数当时需要比较的取值
                Predicate predicate = criteriaBuilder.equal(custName, "里");//进行标准的匹配。  比较的属性，比较的属性的取值
                return predicate;
            }
        };
        Customer customer = customerDao.findOne(specifications);
        System.out.println(customer);
    }

    //根据客户名称和客户所属行业查询
    @Test
    public void testSpecifications1() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");//客户名称
                Path<Object> custIndustry = root.get("custIndustry");//所属行业

                Predicate predicate = criteriaBuilder.equal(custName, "爸");
                Predicate predicate1 = criteriaBuilder.equal(custIndustry, "妈");

                //结合查询条件  满足条件1或者条件2  与的关系    或的关系使用or
                Predicate and = criteriaBuilder.and(predicate, predicate1);

                return and;
            }
        };
        List<Customer> customers = customerDao.findAll(specification);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    //根据客户名称的模糊匹配查询  返回客户列表
    @Test
    public void testSpecifications2() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 * equal ：直接的到path对象（属性），然后进行比较即可
                 * gt，lt,ge,le,like : 得到path对象，根据path指定比较的参数类型，再去进行比较
                 *      指定参数类型：path.as(类型的字节码对象)
                 */
                Path<Object> custName = root.get("custName");//客户名称

                Predicate predicate = criteriaBuilder.like(custName.as(String.class), "%李%");
                return predicate;
            }
        };
        List<Customer> customers = customerDao.findAll(specification);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    //模糊查询进行排序
    @Test
    public void testSpecifications3() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");//客户名称

                Predicate predicate = criteriaBuilder.like(custName.as(String.class), "%李%");
                return predicate;
            }
        };
        //添加排序
        //创建排序对象,需要调用构造方法实例化sort对象
        //第一个参数：排序的顺序（倒序，正序）
        //   Sort.Direction.DESC:倒序
        //   Sort.Direction.ASC ： 升序
        //第二个参数：排序的属性名称
        Sort sort = new Sort(Sort.Direction.DESC,"custId");
        List<Customer> customers = customerDao.findAll(specification,sort);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * 分页查询
     *      Specification: 查询条件
     *      Pageable：分页参数
     *          分页参数：查询的页码，每页查询的条数
     *          findAll(Specification,Pageable)：带有条件的分页
     *          findAll(Pageable)：没有条件的分页
     *  返回：Page（springDataJpa为我们封装好的pageBean对象，数据列表，共条数）
     */
    @Test
    public void testSpecifications4() {
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");//客户名称

                Predicate predicate = criteriaBuilder.like(custName.as(String.class), "%李%");
                return predicate;
            }
        };
//        Specification specification = null;
        //PageRequest对象是Pageable接口的实现类
        /**
         * 创建PageRequest的过程中，需要调用他的构造方法传入两个参数
         *      第一个参数：当前查询的页数（从0开始）
         *      第二个参数：每页查询的数量
         */
        Pageable pageable = new PageRequest(0,2);

        Page page = customerDao.findAll(specification, pageable);
        System.out.println(page);
        System.out.println(page.getTotalElements());//得到总条数
        System.out.println(page.getTotalPages());//得到总页数
        System.out.println(page.getContent());//得到数据集合列表
    }
}
