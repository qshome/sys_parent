package com.sys.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubboConfiguration //dubbo
@EnableCaching            //开启缓存
@EnableAsync              //开启@Async注解的解析；作用就是将串行化的任务给并行化了
@EnableScheduling         //开启对@Scheduled注解的解析
public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext run = SpringApplication.run(App.class,args);
    }
}
