package com.sys.server.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.sys.api.user.UserInterface;
import com.sys.entity.page.PageInfo;
import com.sys.entity.user.User;

@Service(version = "1.0.0")
@Component
public class UserServiceFace implements UserInterface<User>{
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
	public void save(User entity) {
		userService.save(entity);
	}

	@Override
	public void saveSelective(User entity) {
		userService.saveSelective(entity);
	}

	@Override
	public void update(User entity) {
		userService.update(entity);
	}

	@Override
	public void updateSelective(User entity) {
		userService.updateSelective(entity);
	}

	@Override
	public void delete(User entity) {
		userService.delete(entity);
	}

}
