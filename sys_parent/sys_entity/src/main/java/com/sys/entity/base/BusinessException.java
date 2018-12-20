package com.sys.entity.base;

public class BusinessException extends RuntimeException{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 6986059123113773679L;
	private int code;
    private String msg;
    private String tradeCode;
    
	public BusinessException() {
		// TODO Auto-generated constructor stub
	}   
	
	public BusinessException(int code) {
        this.code = code;
    }
	
	public BusinessException(int code, String msg,String tradeCode) {
        this.code = code;
        this.msg = msg;
        this.tradeCode= tradeCode;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		if(msg==null) {
			return ExpCode.getName(code);
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
