package com.jenkin.springboot.controller;

import com.jenkin.springboot.pojo.User;
import com.jenkin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author: jenkinwang
 * @date: 2018/10/14 13:12
 * @description:
 */
@RestController
public class UserController {

    @Autowired
    public User user;

    @Autowired
    public UserService userService;

    /**
     * GET
     * @return
     */
    @RequestMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * POST
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    /**
     * DELETE
     */
    @RequestMapping(value = "/users/{name}", method = RequestMethod.DELETE)
    public void deleteUserByName(@PathVariable String name) {
        userService.deleteUserByName(name);
    }

    /**
     * PUT
     */
    @RequestMapping(value = "/users/{name}", method = RequestMethod.PUT)
    public void updateUserByName(@RequestBody User user, @PathVariable String name) {
        userService.updateUserByName(user, name);
    }

}
