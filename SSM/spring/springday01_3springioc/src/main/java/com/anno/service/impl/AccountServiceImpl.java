package com.anno.service.impl;

import com.anno.dao.AccountDao;
import com.anno.dao.impl.AccountDaoImpl;
import com.anno.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    //applicationcontext创建过程
    private AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
