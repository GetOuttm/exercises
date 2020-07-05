package com.ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.ssm.domain.Account;

import java.util.List;

//持久層
@Repository
public interface AccountDao {

    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account(name,money) values (#{name},#{money})")
    void saveAccount(Account account);
}
