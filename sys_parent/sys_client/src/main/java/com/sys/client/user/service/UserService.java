package com.sys.client.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sys.api.user.UserInterface;
import com.sys.entity.user.User;

@Service
public class UserService {
	
	public static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Reference(version = "1.0.0")
	private UserInterface<User> userInterface;
	
	public List<User> simpleFindList(User user){
		List<User> list = userInterface.simpleFindList(user);
		for(User u : list) {
			logger.info(u.toString());
		}
		return list;
	}
	
	public List<User> findList(User user){
		List<User> list = userInterface.findList(user);
		for(User u : list) {
			logger.info(u.toString());
		}
		return list;
	}
}
