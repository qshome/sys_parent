package com.sys.server;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.sys.entity.user.User;
import com.sys.server.user.service.UserServiceFace;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
@EnableCaching
public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext run = SpringApplication.run(App.class,args);
    	
    	UserServiceFace userServiceFace = run.getBean(UserServiceFace.class);
    	User user = new User();
    	user.setId("1");
    	user.setAge(32);
    	user.setCreateDate(new Date());
    	userServiceFace.save(user);
    	User u = userServiceFace.getUserById(user);
    	System.out.println(u);
    	userServiceFace.delete(user);
    	u = userServiceFace.getUserById(user);
    	System.out.println(u);
    }
}
