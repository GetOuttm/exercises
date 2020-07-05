package com.account_tx.service.impl;

import com.account_tx.dao.AccountDao;
import com.account_tx.domain.Account;
import com.account_tx.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService {

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer id) {
        return transactionTemplate.execute(new TransactionCallback<Account>() {
            @Override
            public Account doInTransaction(TransactionStatus transactionStatus) {
                return accountDao.findAccountById(id);
            }
        });
    }

    public void transfer(String sourceName, String targetName, Float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
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

//                int i = 1/0;
                //更新转入账户
                accountDao.updateAccount(target);


                return null;
            }
        });
    }
}
