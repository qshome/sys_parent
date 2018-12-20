package com.sys.client.user.service;

import com.sys.entity.base.BusinessException;
import com.sys.entity.base.TransactionData;

public interface BaseService<T> {

	public TransactionData<T> execute(TransactionData<T> transactionData) throws BusinessException;
}
