
import com.dbassit.dao.AccountDao;
import com.dbassit.dao.impl.AccountDaoImpl;
import com.dbassit.entity.Account;

import java.util.List;


public class text {

    public static void main(String[] args) {
        /*Account account = new Account();

        account.setName("zhangsan");
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
