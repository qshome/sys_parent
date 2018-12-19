package com.sys_rabbitmq.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

	@Bean
    public Queue topicQueueMessage() {
        return new Queue(DemoConf.topicExchage.getQueue());
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(DemoConf.topicExchage.getExchange());
    }

    @Bean
    Binding topicBindingExchangeMessage(Queue topicQueueMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueMessage).to(topicExchange).with(DemoConf.topicExchage.getKey());
    }

    @Bean
    public Queue directQueueMessage() {
        return new Queue(DemoConf.directExchage.getQueue());
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DemoConf.directExchage.getExchange());
    }

    @Bean
    Binding directBindingExchangeMessage(Queue directQueueMessage, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueMessage).to(directExchange).with(DemoConf.directExchage.getKey());
    }
	
	
	/*final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }*/
}
