package com.bean.service.impl;

import com.bean.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    //applicationcontext创建过程
    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }

    public void init() {
        System.out.println("对象初始化");
    }

    public void destory() {
        System.out.println("对象销毁");
    }
}
