package com.sys_rabbitmq.conf;

public enum DemoConf {
	
	topicExchage("MQ_Queue_Topic_User","MQ_Exchange_Topic_User","MQ_RouteKey_Topic_User"),
	
	directExchage("MQ_Queue_Direct_User","MQ_Exchange_Direct_User","MQ_RouteKey_Direct_User");
	
	private final String queue;
	private final String exchange;
	private final String key;
	
	
	private DemoConf(String queue,String exchange,String key) {
		this.queue = queue;
		this.exchange = exchange;
		this.key  = key;
	}

	public String getQueue() {
		return queue;
	}

	public String getExchange() {
		return exchange;
	}

	public String getKey() {
		return key;
	}
	
}
