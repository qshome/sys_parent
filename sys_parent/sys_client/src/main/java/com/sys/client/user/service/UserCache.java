package com.sys.client.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sys.api.user.UserInterface;
import com.sys.entity.user.User;

@Service
public class UserCache {

	public static final Logger logger = LoggerFactory.getLogger(UserCache.class);
	@Reference(version = "1.0.0")
	private UserInterface<User> userInterface;
	
	@Cacheable(value = "user", key = "#user.id")
	public User get(User user) {
		logger.info("-----------------------------");
		logger.info("进入get方式里");
		logger.info("-----------------------------");
		user = userInterface.get(user.getId());
		return user;
	}
	
	@CachePut(value = "user", key = "#user.id")
	public User save(User user) {
		userInterface.save(user);
		return user;
	}
	
	@CachePut(value = "user", key = "#user.id")
	public User saveSelective(User user) {
		userInterface.saveSelective(user);
		return get(user);
	}
	
	@CachePut(value = "user", key = "#user.id")
	public User update(User user) {
		userInterface.update(user);
		return user;
	}
	
	@CachePut(value = "user", key = "#user.id")
	public User updateSelective(User user) {
		userInterface.updateSelective(user);
		return get(user);
	}
	
	@CacheEvict(value = "user", key = "#user.id")
	public void delete(User user) {
		userInterface.delete(user);
	}
}
