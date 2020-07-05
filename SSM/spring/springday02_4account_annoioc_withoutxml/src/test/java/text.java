import com.withoutxml.entity.Account;
import com.withoutxml.service.AccountService;
import config.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit测试，测试我们的配置
 * spring整合junit的配置
 *  1.导入spring整合junit的jar
 *  2.使用junit提供的一个注解把原有的main方法替换成spring提供的
 *          @RunWith
 *  3.告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *              locations:指定xml文件的位置，加上classpath关键字。表示在类路径下
 *              classes：注解类所在文件的位置
 *  当我们使用spring 5.x版本的时候，junit的jar版本必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class text {

    /*private ApplicationContext context;*/
    @Autowired
    private AccountService accountService = null;
//    @Before
//    public void afterClass() throws Exception {
//        /*context = new ClassPathXmlApplicationContext("bean.xml");*/
//        context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        accountService = context.getBean("accountService",AccountService.class);
//    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    
    @Test
    public void testFindOne() {
        Account account = accountService.findOne(5);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("王五");
        account.setMoney(456F);
        accountService.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        Account account = accountService.findOne(4);
        account.setName("赵六");
        account.setMoney(78F);
        accountService.updateAccount(account);
    }
    @Test
    public void testDelete() {
        accountService.deleteAccount(4);
    }
}
