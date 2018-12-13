package com.sys.server.user.service;

import org.springframework.stereotype.Service;

import com.sys.entity.user.User;
import com.sys.server.base.service.CrudService;
import com.sys.server.user.dao.UserDao;

@Service
public class UserService extends CrudService<UserDao,User>{

}
