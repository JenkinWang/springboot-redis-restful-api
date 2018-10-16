# springboot-reids-restful-api
![](https://img.shields.io/badge/jdk-1.8+-green.svg?longCache=true&jdk=1.8+)
![](https://img.shields.io/badge/maven-3.5.4-red.svg?longCache=true&maven=3.5.4)
![](https://img.shields.io/badge/springboot-2.0.5.RELEASE-brightgreen.svg?longCache=true&springboot=2.0.5.RELEASE)
### SpringBoot整合Redis开发RESTful API接口
## 项目框架
```java
   ├── pom.xml
   ├── springbootreidsrestfulapi.iml
   ├── src
   │   ├── main
   │   │   ├── java
   │   │   │   └── com
   │   │   │       └── jenkin
   │   │   │           └── springboot
   │   │   │               ├── App.java
   │   │   │               ├── controller
   │   │   │               │   └── UserController.java
   │   │   │               ├── pojo
   │   │   │               │   ├── RedisConfigBean.java
   │   │   │               │   └── User.java
   │   │   │               ├── redis
   │   │   │               │   └── RedisConfig.java
   │   │   │               └── service
   │   │   │                   ├── UserService.java
   │   │   │                   └── impl
   │   │   │                       └── UserServiceImpl.java
   │   │   └── resources
   │   │       └── application.properties
```
## 配置文件
在[SpringBoot](https://spring.io/guides/gs/spring-boot/)里的application.properties文件中配置[Redis](https://redis.io/)信息
```java
# REDIS (RedisProperties)
# Database index used by the connection factory.
spring.redis.database=0

# Redis server host.
spring.redis.host=localhost

# Login password of the redis server.
spring.redis.password=

# Redis server port.
spring.redis.port=6379

# Maximum number of connections that can be allocated by the pool at a given time. Use a negative value for no limit.
spring.redis.lettuce.pool.max-active=8

# Maximum number of "idle" connections in the pool. Use a negative value to indicate an unlimited number of idle connections.
spring.redis.lettuce.pool.max-idle=8

# Maximum amount of time a connection allocation should block before throwing an exception when the pool is exhausted. Use a negative value to block indefinitely.
spring.redis.lettuce.pool.max-wait=-1ms

# Target for the minimum number of idle connections to maintain in the pool. This setting only has an effect if it is positive.
spring.redis.lettuce.pool.min-idle=0

# Shutdown timeout.
spring.redis.lettuce.shutdown-timeout=100ms
```

[Redis](https://redis.io/)有两种连接方式：一个是[Jedis](https://github.com/xetorthio/jedis)，另一个是[Lettuce](https://lettuce.io/)。它俩间的区别：使用Jedis，如果多线程使用同一个连接，线程时不安全的，需要使用连接池，为每一个Jedis实例分配一个连接；而使用Lettuce，当多线程连接同一个连接实例时，是线程安全的。
SpringBoot2.0以后，默认的连接方式是Lettuce，我这里使用的也是Lettuce，首先添加Redis包：
```java
<!--redis包-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
如果使用的是Jedis连接，需要修改一下配置：
```java
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
	<exclusions>
		<exclusion>
			<groupId>io.lettuce</groupId>
			<artifactId>lettuce-core</artifactId>
		</exclusion>
	</exclusions>
</dependency>
<dependency>
	<groupId>redis.clients</groupId>
	<artifactId>jedis</artifactId>
</dependency>
```
建立连接
```java
    /**
     * 使用Lettuce连接Redis
     * @return
     */
    @Bean
    public LettuceConnectionFactory connectionFactory() {
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
        lettuceConnectionFactory.setDatabase(redisConfigBean.getDatabase());
        lettuceConnectionFactory.setHostName(redisConfigBean.getHost());
        lettuceConnectionFactory.setPassword(redisConfigBean.getPassword());
        lettuceConnectionFactory.setPort(redisConfigBean.getPort());

        return lettuceConnectionFactory;
    }
```
## 效果演示
- **POST**请求：设置ContentType=application/json，添加RequestBody中的内容，格式为Json格式
 ![](https://github.com/JenkinWang/springboot-reids-restful-api/blob/master/images/Screen%20Shot%202018-10-16%20at%2011.34.09.png)

- **GET**请求
 ![](https://github.com/JenkinWang/springboot-reids-restful-api/blob/master/images/Screen%20Shot%202018-10-16%20at%2011.36.15.png)
- **PUT**请求：设置ContentType=application/json，修改RequestBody中的内容，格式为Json格式
 ![](https://github.com/JenkinWang/springboot-reids-restful-api/blob/master/images/Screen%20Shot%202018-10-16%20at%2011.37.25.png)
 ![](https://github.com/JenkinWang/springboot-reids-restful-api/blob/master/images/Screen%20Shot%202018-10-16%20at%2011.37.45.png)
- **DELETE**请求
 ![](https://github.com/JenkinWang/springboot-reids-restful-api/blob/master/images/Screen%20Shot%202018-10-16%20at%2011.38.09.png)
 ![](https://github.com/JenkinWang/springboot-reids-restful-api/blob/master/images/Screen%20Shot%202018-10-16%20at%2011.38.25.png)
 ## 交流一下
 &emsp;&emsp;![](https://github.com/JenkinWang/WeChatOfficialAccount/blob/master/images/qrcode_for_gh_7e1da67205e4_258.jpg)
