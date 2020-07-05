package com.springanno.service.impl;

import com.springanno.dao.AccountDao;
import com.springanno.domain.Account;
import com.springanno.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务控制都在业务层
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//只读型事务的配置
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {
        //根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //转出账户减钱
        source.setMoney(source.getMoney()-money);
        //转入账户加钱
        target.setMoney(target.getMoney() + money);
        //更新转出账户
        accountDao.updateAccount(source);

//            int i = 1/0;
        //更新转入账户
        accountDao.updateAccount(target);
    }
}
