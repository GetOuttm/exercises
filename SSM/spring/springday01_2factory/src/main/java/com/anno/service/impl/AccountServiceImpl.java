package com.anno.service.impl;

import com.anno.dao.AccountDao;
import com.anno.factory.BeanFactory;
import com.anno.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
