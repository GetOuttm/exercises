import com.utils.dao.AccountDao;
import com.utils.dao.impl.AccountDaoImpl;
import com.utils.entity.Account;

import java.util.List;

public class text {

    public static void main(String[] args) {
       /* Account account = new Account();

        account.setName("lisi");
        account.setMoney(123F);*/
        AccountDao accountDao = new AccountDaoImpl();

//        accountDao.save(account);
        /*Account account = accountDao.findByID(2);
        System.out.println(account);*/

        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
