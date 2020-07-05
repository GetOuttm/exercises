import com.annoioc.entity.Account;
import com.annoioc.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit测试，测试我们的配置
 */
public class text {

    private ApplicationContext context;
    private AccountService accountService;
    @Before
    public void afterClass() throws Exception {
        context = new ClassPathXmlApplicationContext("bean.xml");
        accountService = context.getBean("accountService",AccountService.class);
    }

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
