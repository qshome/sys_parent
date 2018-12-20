package com.sys.entity.base;

public enum TradeCode {
	
	w("10001"),w1("10002"),w3("10003");
	
	private String code;
	
	private String name;
	
	private TradeCode(String code) {
		this.code = code;
		switch(code) {
			case "10001":
				name ="list查询";
				break;
			case "10002":
				name ="get查询";
				break;
			case "10003":
				name ="save保存";
				break;
			default:
				break;
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String getName(String code) {
		for(TradeCode exp : values()) {
			if(code.equals(exp.getCode())) {
				return exp.getName();
			}
		}
		return null;
	}
}
