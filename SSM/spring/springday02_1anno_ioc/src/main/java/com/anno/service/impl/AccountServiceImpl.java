package com.anno.service.impl;

import com.anno.dao.AccountDao;
import com.anno.dao.impl.AccountDaoImpl;
import com.anno.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 * 曾经的xml配置
 * <bean id="accountService" class="com.anno.service.impl.AccountServiceImpl"scope=""
 *     init-method="init" destroy-method="destory">
 *     <property name="" value="" | ref = ""></property>
 * </bean>
 * 用于创建对象的注解
 *      他们的作用和在xml里编写bean标签实现的功能是一样的
 *      @Component:用于把当前类对象存入spring容器中
 *          属性：
 *              value   用于指定bean的id，当我们不写值默认当前类名且首字母小写
 *      @Controller         表现层
 *      @Service            业务层
 *      @Repository         持久层
 *              以上三个注解他们的作用和属性与Component是一样的，  都是作用于类上
 *              他们是spring框架为我们提供明确的三层使用注解，是我们的三层对象更加清晰
 * 用于注入数据的注解
 *      它们的作用和在xml里编写bean标签下的property标签作用是一样的
 *      @Autowired   作用：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的类型匹配就可以注入成功
 *                                  如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *                                  如果ioc容器中有多个类型匹配时，先按照类型圈定出匹配对象，再按照变量名称作为bean的id
 *                                  在圈定出的多个对象进行查找，如果找到则注入成功，如果找不到则报错
 *                  出现位置：可以是成员变量或者方法上
 *                  细节：使用注解注入时，set方法就不是必须的了
 *      @Qualifier   作用：在按照类型注入的基础上再按照名称注入，他在给类成员注入时不能单独使用，但在给方法参数注入时可以使用
 *                  属性：value  用于指定注入的id
 *                  必须配合Autowired使用
 *      @Resource    作用：直接按照bean的id注入，他可以独立使用
 *                   属性：name   用于指定注入的id
 *      以上三个注入注解只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解
 *      另外集合类型的注入只能使用xml的方式来实现
 *
 *      @Value    作用：用于注入基本类型和String类型的数据
 *                 属性：value  用于指定数据的值，它可以使用spring中的SpEL(也就是spring的EL表达式)
 *                      SpEL写法：${表达式}
 * 用于改变作用范围的注解
 *      它们的作用和在xml里编写bean标签中使用scope属性实现的功能时一样的
 * @Scope   作用：用于指定bean的作用范围     作用于类上
 *          属性：value  指定范围的取值     常用取值：prototype多例   singleton单例(默认)
 * 和生命周期相关的注解
 *      它们的作用和在xml里编写bean标签中使用init-method和destroy-method的作用是一样的
 *      @PreDestroy   作用：用于指定销毁方法
 *
 *      @PostConstruct   作用：用于指定初始化方法
 */
@Component("accountService")
/*@Scope("prototype")*/
public class AccountServiceImpl implements AccountService {

    /*@Autowired
    @Qualifier("accountDao2")*/
    @Resource(name = "accountDao1")
    private AccountDao accountDao;
    @PostConstruct
    public void init() {
        System.out.println("初始化方法");
    }
    @PreDestroy
    public void destory() {
        System.out.println("销毁方法");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
