package com.txanno.service;

import com.txanno.domain.Account;

/**
 * 账户的业务层接口
 */
public interface AccountService {

    Account findAccountById(Integer id);

    /**
     * 转账
     * @param sourceName   转出账户的名称
     * @param targetName   转入账户的名称
     * @param money         转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
