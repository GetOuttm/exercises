package com.annoaop.service;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 修改账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除账户
     * @return
     */
    int deleteAccount();
}
