package com.sys.client.base;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.base.BusinessException;

@ControllerAdvice
public class BusinessExceptionControllerAdvice {

	private static final Logger logger =LoggerFactory.getLogger(BusinessExceptionControllerAdvice.class);
	
	@ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandler(Exception ex) {
        Map<String,Object> map = new HashMap<String,Object>();
        logger.error("[系统交易失败] - [交易码：{}] - [异常码：{}] - 异常信息：\n","无","999",ex);
        logger.info("[系统交易失败] - [交易码：{}] - [异常码：{}] - [异常信息：{}]","无","999","请联系系统管理员");
        return map;
    }
	
	@ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public BusinessException errorHandler(BusinessException ex) {
		logger.error("[系统交易失败] - [交易码：{}] - [异常码：{}] - 异常信息：\n",ex.getTradeCode(),ex.getCode(),ex);
		logger.info("[系统交易失败] - [交易码：{}] - [异常码：{}] - [异常信息：{}]",ex.getTradeCode(),ex.getCode(),ex.getMsg());
        return ex;
    }
}
