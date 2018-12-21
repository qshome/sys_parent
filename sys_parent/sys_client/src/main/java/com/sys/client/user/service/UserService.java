package com.sys.client.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sys.api.user.UserInterface;
import com.sys.entity.base.BusinessException;
import com.sys.entity.base.TransactionData;
import com.sys.entity.user.User;

@Service("userService")
public class UserService implements BaseService<User>{
	
	public static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Reference(version = "1.0.0")
	private UserInterface<User> userInterface;
	
	@Autowired
	private UserCache userCache;
	
	@Override
	public TransactionData<User> execute(TransactionData<User> transactionData) throws BusinessException {
		String tradeCode = transactionData.getTradeCode();
		if("W10001".equals(tradeCode)) {
			findList(transactionData);
		}else if("W10002".equals(tradeCode)) {
			get(transactionData);
		}else if("W10003".equals(tradeCode)) {
			save(transactionData);
		}
		return transactionData;
	}
	
	/**
	 * 按主键查询
	 * @param transactionData
	 * @return
	 */
	public TransactionData<User> get(TransactionData<User> transactionData){
		User user = userCache.get(transactionData.getEntity());
		transactionData.setData(user);
		throw new BusinessException("999");
		//return transactionData;
	}
	
	/**
	 * 简单的条件查询
	 * @param transactionData
	 * @return
	 */
	public TransactionData<User> simpleFindList(TransactionData<User> transactionData){
		List<User> userList = userInterface.simpleFindList(transactionData.getEntity());
		transactionData.setData(userList);;
		return transactionData;
	}
	
	/**
	 * 自定义sql查询
	 * @param transactionData
	 * @return
	 */
	public TransactionData<User> findList(TransactionData<User> transactionData){
		List<User> userList = userInterface.findList(transactionData.getEntity());
		for(User u : userList) {
			logger.info(u.toString());
		}
		transactionData.setData(userList);;
		return transactionData;
	}
	
	/**
	 * 简单的分页查询
	 * @param transactionData
	 * @return
	 */
	public TransactionData<User> simpleFindPage(TransactionData<User> transactionData){
		userInterface.simpleFindPage(transactionData.getPageInfo(),transactionData.getEntity());
		return transactionData;
	}
	
	/**
	 * 自定义sql分页查询
	 * @param transactionData
	 * @return
	 */
	public TransactionData<User> findPage(TransactionData<User> transactionData){
		userInterface.findPage(transactionData.getPageInfo(),transactionData.getEntity());
		return transactionData;
	}
	
	/**
	 * 保存
	 * @param transactionData
	 * @return
	 */
	public TransactionData<User> save(TransactionData<User> transactionData){
		userCache.save(transactionData.getEntity());
		return transactionData;
	}
	
	/**
	 * 非空字段保存
	 * @param transactionData
	 * @return
	 */
	public TransactionData<User> saveSelective(TransactionData<User> transactionData){
		userCache.saveSelective(transactionData.getEntity());
		return transactionData;
	}
	
	/**
	 * 更新
	 * @param transactionData
	 * @return
	 */
	public TransactionData<User> update(TransactionData<User> transactionData){
		userCache.update(transactionData.getEntity());
		return transactionData;
	}
	
	/**
	 * 非空字段更新
	 * @param transactionData
	 * @return
	 */
	public TransactionData<User> updateSelective(TransactionData<User> transactionData){
		userCache.updateSelective(transactionData.getEntity());
		return transactionData;
	}
	
	/**
	 * 删除
	 * @param transactionData
	 * @return
	 */
	public TransactionData<User> delete(TransactionData<User> transactionData){
		userCache.delete(transactionData.getEntity());
		return transactionData;
	}
}
