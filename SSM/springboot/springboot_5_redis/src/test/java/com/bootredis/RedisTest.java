package com.bootredis;


import com.bootredis.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bootredis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot5RedisApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws JsonProcessingException {
        //从redis查询  数据的形式json字符串
        String user_json = redisTemplate.boundValueOps("user.findAll").get();

        //判断redis是否存在
        if (null == user_json) {
            //不存在。从数据查询
            List<User> users = userRepository.findAll();
            //将查询的数据存到redis
            //先将集合转换为json  使用jackson进行转换
            ObjectMapper objectMapper = new ObjectMapper();
            user_json = objectMapper.writeValueAsString(users);
            redisTemplate.boundValueOps("user.findAll").set(user_json);

            System.out.println("=======从数据库中查询========");
        } else {
            System.out.println("=======从redis中查询========");
        }
        //将数据在控制台打印
        System.out.println(user_json);

    }
}
