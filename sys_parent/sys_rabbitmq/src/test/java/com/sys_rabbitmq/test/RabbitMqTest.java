package com.sys_rabbitmq.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sys.entity.user.User;
import com.sys_rabbitmq.App;
import com.sys_rabbitmq.conf.DemoConf;
import com.sys_rabbitmq.service.RabbitService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class RabbitMqTest {

	@Autowired
	private RabbitService rabbitService;
	
	@Test
	public void send() {
		User user = new User();
		user.setId("3");
		user.setAge(23);
		user.setCreateDate(new Date());
		rabbitService.send(DemoConf.topicExchage.getExchange(), DemoConf.topicExchage.getKey(), user);
		rabbitService.send(DemoConf.directExchage.getExchange(), DemoConf.directExchage.getKey(), user);
		System.out.println("--------------------------");
		System.out.println("--------------------------");
	}
}
