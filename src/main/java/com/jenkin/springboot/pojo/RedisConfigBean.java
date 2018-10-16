package com.jenkin.springboot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: jenkinwang
 * @date: 2018/10/16 09:32
 * @description:
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfigBean {
    private int database;
    private String host;
    private String password;
    private int port;

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
