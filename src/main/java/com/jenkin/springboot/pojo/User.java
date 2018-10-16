package com.jenkin.springboot.pojo;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @author: jenkinwang
 * @date: 2018/10/14 13:21
 * @description:
 */
@Configuration
public class User implements Serializable {

    private String id;
    private String name;
    private Integer age;
    private String email;

    public User() {};

    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
