package com.sys.server.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.sys.api.user.UserInterface;
import com.sys.entity.page.PageInfo;
import com.sys.entity.user.User;

@Service(version = "1.0.0")
@Component
public class UserServiceFace implements UserInterface<User>{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceFace.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public User get(Object key) {
		return userService.get(key);
	}
	
	@Override
	public List<User> simpleFindList(User entity) {
		return userService.simpleFindList(entity);
	}

	@Override
	public List<User> findList(User entity) {
		return userService.findList(entity);
	}

	@Override
	public PageInfo<User> simpleFindPage(PageInfo<User> pageInfo, User entity) {
		return userService.simpleFindPage(pageInfo,entity);
	}

	@Override
	public PageInfo<User> findPage(PageInfo<User> pageInfo, User entity) {
		return userService.findPage(pageInfo,entity);
	}

	@Override
	public User save(User user) {
		userService.save(user);
		return user;
	}

	@Override
	public User saveSelective(User user) {
		userService.saveSelective(user);
		return user;
	}

	@Override
	public User update(User user) {
		userService.update(user);
		return user;
	}

	@Override
	public User updateSelective(User user) {
		userService.updateSelective(user);
		return user;
	}

	@Override
	public void delete(User user) {
		userService.delete(user);
	}

}
