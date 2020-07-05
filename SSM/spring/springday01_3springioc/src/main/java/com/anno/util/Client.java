package com.anno.util;

import com.anno.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟表现层，用于调用业务层   实际中是servlet
 */
public class Client {
    /**
     * 获取spring容器的ioc核心容器，并根据id获取对象
     *
     * applicationContext的三个常用实现类：
     *      1.ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话加载不了
     *      2.FileSystemXmlApplicationContext：它可以在家磁盘任意路径下的配置文件(必须有访问权限)
     *      3.AnnotationConfigApplicationContext：它是用于读取注解创建容器的
     *
     *  核心容器的两个接口引发的问题   使用debug测试创建对象的过程
     *      ApplicationContext    单例对象适用
     *           它在构建核心容器时创建对象的策略时采用立即加载的方式，也就是说，只要以读取完配置文件马上就创建配置文件中配置的对象
     *      BeanFactory           多例对象适用
     *         它在构建核心容器时创建对象采用的是延迟加载的方式，也就是说，什么时候根据id获取对象了，什么时候才创建按对象
     * @param args
     */
    public static void main(String[] args) {
        /*//1.获取核心容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //上面那种更常见
//        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\IDEA\\java\\BigDemo\\SSM\\spring\\springday01_3springioc\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象
        AccountService service = (AccountService) context.getBean("accountService");
        AccountDao dao = context.getBean("accountDao", AccountDao.class);
        System.out.println(service);
        System.out.println(dao);
        service.saveAccount();*/

        //------------------BeanFactory-----------------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService service = (AccountService) factory.getBean("accountService");
        System.out.println(service);
    }
}
