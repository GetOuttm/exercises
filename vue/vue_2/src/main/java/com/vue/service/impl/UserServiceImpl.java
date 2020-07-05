package com.vue.service.impl;

import com.vue.dao.UserDao;
import com.vue.entity.User;
import com.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByID(Integer id) {
        return userDao.findByID(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
