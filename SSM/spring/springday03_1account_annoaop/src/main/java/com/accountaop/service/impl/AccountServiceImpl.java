package com.accountaop.service.impl;

import com.accountaop.dao.AccountDao;
import com.accountaop.entity.Account;
import com.accountaop.service.AccountService;
import com.accountaop.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 事务控制在业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
       return accountDao.findAll();
    }

    public Account findOne(Integer id) {
        return accountDao.findByID(id);
    }

    public void saveAccount(Account account) {
        accountDao.save(account);
    }

    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.delete(id);
    }


    public void transfer(String sourceName, String targetName, Float money) {
            //根据名称查询转出账户
            Account source = accountDao.findByName(sourceName);
            //根据名称查询转入账户
            Account target = accountDao.findByName(targetName);
            //转出账户减钱
            source.setMoney(source.getMoney()-money);
            //转入账户加钱
            target.setMoney(target.getMoney() + money);
            //更新转出账户
            accountDao.update(source);

            int i = 1/0;
            //更新转入账户
            accountDao.update(target);
    }
}
