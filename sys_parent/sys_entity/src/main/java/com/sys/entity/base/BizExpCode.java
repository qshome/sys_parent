package com.sys.entity.base;


/**
 * 交易码定义常量类
 */
public class BizExpCode  {  

	private enum InnerBizExpCode {
		// 交易码定义,长度六位：
		// 服务单—公共管理

		//电销首页
		T00001(),T00002();

		
		/**
		 * 返回中文
		 * 
		 * @return
		 */
		public String cnname() {
			switch (this) {
				case T00001:
					return "用户信息";
				case T00002:
					return "今日工作小结";
				default:
					return null;
			}
		}

	}

	public static String getExpName(String tradeCode) {
		String str = InnerBizExpCode.valueOf(tradeCode).cnname();
		return str;
	}

}
