package com.sys.entity.base;

public enum ExpCode {
	
	w(999);
	
	private int code;
	
	private String name;
	
	private ExpCode(int code) {
		this.code = code;
		switch(code) {
			case 999:
				name ="系统错误，请联系管理员";
				break;
			default:
				break;
		}
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String getName(int code) {
		for(ExpCode exp : values()) {
			if(exp.getCode() == code) {
				return exp.getName();
			}
		}
		return null;
	}
}
