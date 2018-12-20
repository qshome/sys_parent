package com.sys.client.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.sys.client.base.SpringUtil;
import com.sys.client.user.service.BaseService;
import com.sys.entity.base.BusinessException;
import com.sys.entity.base.ExpCode;
import com.sys.entity.base.TradeCode;
import com.sys.entity.base.TransactionData;
import com.sys.entity.page.PageInfo;

public class BaseController<T> {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@SuppressWarnings("unchecked")
	public TransactionData<T> execute(HttpServletRequest request, TransactionData<T> transactionData) {
		try {
			if(transactionData.getTradeCode()==null||transactionData.getServiceName()==null) {
				logger.error("[系统交易失败] - [未填写交易码或服务名称] - [交易结束]");
				logger.info("[系统交易失败] - [未填写交易码或服务名称] - [交易结束]");
				transactionData.setStatus(-1);
				transactionData.setExpMsg("[系统交易失败] - [未填写交易码或服务名称] - [交易结束]");
				return transactionData;
			}
			if(null == TradeCode.getName(transactionData.getTradeCode())) {
				logger.error("[系统交易失败] - [未定义交易码] - [交易结束]");
				logger.error("[系统交易失败] - [未定义交易码] - [交易结束]");
				transactionData.setStatus(-1);
				transactionData.setExpMsg("[系统交易失败] - [未定义交易码] - [交易结束]");
				return transactionData;
			}
			String pageNo = request.getParameter("pageNo");
			String pageSize = request.getParameter("pageSize");
			if(StringUtils.isBlank(pageNo)) pageNo = "1"; //默认分页 
			if(StringUtils.isBlank(pageSize)) pageSize = "10"; //默认分页 
			PageInfo<T> pageInfo = new PageInfo<T>();
			pageInfo.setPageNo(Integer.valueOf(pageNo));
			pageInfo.setPageSize(Integer.valueOf(pageSize));
			transactionData.setPageInfo(pageInfo);
			
			@SuppressWarnings("rawtypes")
			BaseService baseService = (BaseService) SpringUtil.getBean(transactionData.getServiceName());
			baseService.execute(transactionData);
			transactionData.setData(1);;
			logger.info("[系统交易成功] -[ 交易码：{}] - [交易结束]",transactionData.getTradeCode());
		}catch(BusinessException e) {
			transactionData.setStatus(-1);
			transactionData.setExpMsg(e.getMsg());
			logger.error("[系统交易异常] -[ 交易码：{}] - 异常信息如下：\n",transactionData.getTradeCode(),e);
			logger.info("[系统交易异常] - [交易码：{}] - [交易名称{}] - [异常码：{} - {}] - [交易结束]",transactionData.getTradeCode(),TradeCode.getName(transactionData.getTradeCode()),e.getCode(),e.getMsg());
		}catch(Exception e) {
			transactionData.setStatus(-1);
			transactionData.setExpMsg(ExpCode.getName(999));
			logger.error("[系统交易异常] - [交易码：{}] - 异常信息如下：\n",transactionData.getTradeCode(),e);
			logger.info("[系统交易异常] - [交易码：{}] - [交易名称{}] - [异常码：{} - {}] - [交易结束]",transactionData.getTradeCode(),TradeCode.getName(transactionData.getTradeCode()),999,ExpCode.getName(999));
		}
		return transactionData;
	}
}
