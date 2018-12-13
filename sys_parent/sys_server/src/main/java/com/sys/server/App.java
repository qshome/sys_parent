package com.sys.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.sys.entity.page.PageInfo;
import com.sys.entity.user.User;
import com.sys.server.user.service.UserService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class,args);
    }
}
