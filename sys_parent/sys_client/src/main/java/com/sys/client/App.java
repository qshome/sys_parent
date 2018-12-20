package com.sys.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;


/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableDubboConfiguration
@EnableCaching            //开启缓存
public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext run = SpringApplication.run(App.class,args);
    }
}
