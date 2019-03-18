package com.umbrella.jnovel.web.controller;


import com.umbrella.jnovel.system.user.model.User;
import com.umbrella.jnovel.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/findUser")
    public List<User> findUser() {
        return userService.findUser();
    }
}
