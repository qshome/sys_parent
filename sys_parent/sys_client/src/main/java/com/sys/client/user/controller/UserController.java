package com.sys.client.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sys.entity.base.TransactionData;
import com.sys.entity.user.User;

@RestController
public class UserController extends BaseController<User>{

	@RequestMapping("/user/list")
	public TransactionData<User> list(HttpServletRequest request,HttpServletResponse response,User user) {
		TransactionData<User> transactionData = new TransactionData<User>();
		transactionData.setTradeCode("W10001");
		transactionData.setServiceName("userService");
		transactionData.setEntity(user);
		super.execute(request,transactionData);
		return transactionData;
	}
	
	@RequestMapping("/user/get")
	public TransactionData<User> get(HttpServletRequest request,HttpServletResponse response,User user) {
		TransactionData<User> transactionData = new TransactionData<User>();
		transactionData.setTradeCode("W10002");
		transactionData.setServiceName("userService");
		transactionData.setEntity(user);
		super.execute(request,transactionData);
		return transactionData;
	}
	
	@RequestMapping("/user/save")
	public TransactionData<User> save(HttpServletRequest request,HttpServletResponse response,User user) {
		TransactionData<User> transactionData = new TransactionData<User>();
		transactionData.setTradeCode("W10003");
		transactionData.setServiceName("userService");
		transactionData.setEntity(user);
		super.execute(request,transactionData);
		return transactionData;
	}
}
