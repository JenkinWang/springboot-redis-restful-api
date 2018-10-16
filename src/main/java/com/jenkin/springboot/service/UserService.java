package com.jenkin.springboot.service;

import com.jenkin.springboot.pojo.User;

import java.util.Map;

/**
 * @author: jenkinwang
 * @date: 2018/10/14 13:32
 * @description:
 */
public interface UserService {
    Map<String, User> getAll();

    void addUser(User user);

    void deleteUserById(String id);

    void updateUserById(User user, String id);

    User getUserById(String id);
}
