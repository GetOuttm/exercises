package com.vue.web;

import com.vue.entity.User;
import com.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
    @RequestMapping("/findById")
    public User findByID(Integer id) {
        return userService.findByID(id);
    }

    @RequestMapping("/updateUser")
    public void UpdateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
