package com.example.test;

import com.example.Springboot2MybatisApplication;
import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)//用谁执行
@SpringBootTest(classes = Springboot2MybatisApplication.class)//引导类
public class JunitTestMybatis {

    @Autowired
    private UserMapper mapper;

    @Test
    public void test() {
        List<User> users = mapper.queryUserList();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println(users);
    }
}
