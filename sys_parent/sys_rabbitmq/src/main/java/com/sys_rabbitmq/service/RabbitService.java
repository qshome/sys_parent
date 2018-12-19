package com.sys_rabbitmq.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RabbitService {
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitService.class);
	
	private final RabbitTemplate rabbitTemplate; 
	
	@Autowired
	public RabbitService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
    public void send(String exchange,String queue,Serializable obj) {
        this.rabbitTemplate.convertAndSend(exchange,queue,obj);
        logger.info("[RabbitService 发送队列消息] - [{} - {} - {}]","交换机："+exchange,"队列："+queue,"内容："+obj.toString());
    }
    
}
