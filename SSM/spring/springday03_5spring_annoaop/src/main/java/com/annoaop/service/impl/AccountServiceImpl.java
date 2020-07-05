package com.annoaop.service.impl;

import com.annoaop.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现
 */
@Service("accountService")
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
