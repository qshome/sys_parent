package com.sys.entity.base;

import com.sys.entity.page.PageInfo;

public class TransactionData<T> {

	private String serviceName;   //service名称
	
	private String tradeCode;     //交易码
	
	private int status;           //交易状态
	
	private String expMsg;        //错误信息
	
	private PageInfo<T> pageInfo; //page
	
	private Object data;          //数据
	
	private T entity;             //实体对象
	
	private Object obj;           //冗余字段

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getExpMsg() {
		return expMsg;
	}

	public void setExpMsg(String expMsg) {
		this.expMsg = expMsg;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public PageInfo<T> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<T> pageInfo) {
		this.pageInfo = pageInfo;
	}
}
