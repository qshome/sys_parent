package com.sys_rabbitmq.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.sys.entity.user.User;

@Service
public class RabbitConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitConsumer.class);

	/**
     * topic类型 监听器
     * @param user
     * @param message
     * @param channel
     */
    @RabbitListener(queues = "MQ_Queue_Topic_User")
    public void topicListener(User user, Message message, Channel channel) {
    	logger.info("[topicListener 监听的消息] - [{}]", user.toString());
        try {
            // TODO 通知 MQ 消息已被成功消费,可以ACK了
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            // TODO 如果报错了,那么我们可以进行容错处理,比如转移当前消息进入其它队列
        }
    }
    
    /**
     * direct类型 监听器
     * @param user
     * @param message
     * @param channel
     */
    @RabbitListener(bindings = {@QueueBinding(value=@Queue(value="MQ_Queue_Direct_User"),exchange=@Exchange(value="MQ_Exchange_Direct_User"),key="MQ_RouteKey_Direct_User")})
    public void directListener(User user, Message message, Channel channel) {
    	logger.info("[directListener 监听的消息] - [{}]", user.toString());
        try {
            // TODO 通知 MQ 消息已被成功消费,可以ACK了
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            // TODO 如果报错了,那么我们可以进行容错处理,比如转移当前消息进入其它队列
        }
    }
}
