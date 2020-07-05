import com.day03.entity.Account;
import com.day03.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit测试，测试我们的配置
 */
@ContextConfiguration(locations = "classpath:bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class text {

    @Autowired
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
