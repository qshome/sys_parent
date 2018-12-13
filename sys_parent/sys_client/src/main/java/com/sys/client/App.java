package com.sys.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.sys.client.user.service.UserService;
import com.sys.entity.user.User;


/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableDubboConfiguration
public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext run = SpringApplication.run(App.class,args);
    	UserService userService = run.getBean(UserService.class);
    	User user = new User();
    	userService.findList(user);
    }
}
