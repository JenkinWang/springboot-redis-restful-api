package com.jenkin.springboot.service;

import com.jenkin.springboot.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jenkinwang
 * @date: 2018/10/14 13:32
 * @description:
 */
public interface UserService {
    public List<User> getAll();

    void addUser(User user);

    void deleteUserByName(String name);

    void updateUserByName(User user, String name);
}
