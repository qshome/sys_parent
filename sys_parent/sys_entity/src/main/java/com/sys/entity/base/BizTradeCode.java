package com.sys.entity.base;


/**
 * 交易码定义常量类
 */
public class BizTradeCode  {  

	private enum InnerBizTradeCode {
		// 交易码定义,长度六位：
		// 服务单—公共管理

		//电销首页
		W10001(),W10002(),W10003();

		
		/**
		 * 返回中文
		 * 
		 * @return
		 */
		public String cnname() {
			switch (this) {
				case W10001:
					return "list查询";
				case W10002:
					return "get查询";
				case W10003:
					return "save保存";
				default:
					return null;
			}
		}

	}

	public static String getTradeName(String tradeCode) {
		String str = InnerBizTradeCode.valueOf(tradeCode).cnname();
		return str;
	}

}
