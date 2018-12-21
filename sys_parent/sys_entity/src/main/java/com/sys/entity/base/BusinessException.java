package com.sys.entity.base;

public class BusinessException extends RuntimeException{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 6986059123113773679L;
	private String code;
    private String msg;
    private String tradeCode;
    
	public BusinessException() {
		// TODO Auto-generated constructor stub
	}   
	
	public BusinessException(String code) {
		this.code = code;
    }
	
	public BusinessException(String code, String msg,String tradeCode) {
        this.code = code;
        this.msg = msg;
        this.tradeCode= tradeCode;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		if(msg==null) {
			this.msg=BizExpCode.getExpName(code);
		}
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	public String getTradeCode() {
		return tradeCode;
	}
	
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	
	@Override
	public String toString() {
		return "BusinessException [code=" + code + ", msg=" + msg + ", tradeCode=" + tradeCode + "]";
	}

}
