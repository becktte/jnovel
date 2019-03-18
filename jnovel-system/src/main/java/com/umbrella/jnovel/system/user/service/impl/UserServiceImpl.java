package com.umbrella.jnovel.system.user.service.impl;

import com.umbrella.jnovel.system.user.mapper.UserMapper;
import com.umbrella.jnovel.system.user.model.User;
import com.umbrella.jnovel.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUser() {
        return userMapper.findUser();
    }
}
