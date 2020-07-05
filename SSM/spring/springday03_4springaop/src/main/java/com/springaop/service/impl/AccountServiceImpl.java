package com.springaop.service.impl;

import com.springaop.service.AccountService;

/**
 * 账户的业务层实现
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
        int i = 1/0;
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了修改");
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
