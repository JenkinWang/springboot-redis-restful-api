package com.jenkin.springboot.service.impl;

import com.jenkin.springboot.pojo.User;
import com.jenkin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: jenkinwang
 * @date: 2018/10/14 13:32
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private HashOperations hashOperations;

    @Override
    public Map<String, User> getAll() {
        Map<String, User> map = hashOperations.entries("USERS");
        return map;
    }

    @Override
    public void addUser(User user) {
        hashOperations.put("USERS", user.getId(), user);
    }

    @Override
    public void deleteUserById(String id) {
        hashOperations.delete("USERS", id);
    }

    @Override
    public void updateUserById(User user, String id) {
        hashOperations.put("USERS", id, user);
    }

    @Override
    public User getUserById(String id) {
        return (User) hashOperations.get("USERS", id);
    }

}
