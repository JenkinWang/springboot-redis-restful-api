package com.jenkin.springboot.service.impl;

import com.jenkin.springboot.pojo.User;
import com.jenkin.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: jenkinwang
 * @date: 2018/10/14 13:32
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("jenkin", 24, "jenkin@gmail.com"),
            new User("danny", 25, "danny@gmail.com"),
            new User("Alice", 25, "alice@gmail.com")
    ));

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUserByName(String name) {
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (name.equals(user.getName())) {
                userIterator.remove();
            }
        }
    }

    @Override
    public void updateUserByName(User user, String name) {
        for (User _user : users) {
            if (name.equals(_user.getName())) {
                _user.setName(user.getName());
                _user.setAge(user.getAge());
                _user.setEmail(user.getEmail());
            }
        }
    }
}
