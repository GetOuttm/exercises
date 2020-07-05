import com.day03.entity.Account;
import com.day03.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit测试，测试我们的配置
 */
@ContextConfiguration(locations = "classpath:bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class text {

    //不使用Qualifier注解指定service会导致由于布置一个配置而走相应的配置而出现不走事务控制导致出现bug，错误出现但是错误之前依旧运行
    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService accountService;

    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer() {
        accountService.transfer("aaa","bbb",100F);
    }
}
