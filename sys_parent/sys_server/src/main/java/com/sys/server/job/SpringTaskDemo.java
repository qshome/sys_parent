package com.sys.server.job;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringTaskDemo {

	private static final Logger log = LoggerFactory.getLogger(SpringTaskDemo.class);
	
	@Async  //@Async代表该任务可以进行异步工作，由原本的串行改为并行
    @Scheduled(cron = "0/1 * * * * *")
    public void scheduled1() throws InterruptedException {
        Thread.sleep(3000);
        log.info("scheduled1 每1秒执行一次：{}", LocalDateTime.now());
    }
}