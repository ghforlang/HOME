package com.tarena.test;

import org.apache.log4j.Logger;

public class TestLog4j {

	
	public static void main(String[] args) {
	  //创建日志记录器
		Logger logger=Logger.getLogger(TestLog4j.class);
		logger.debug("只是调试");
		logger.info("普通信息");
		logger.warn("警告，此处有危险");
		logger.error("报错了，你行不行");
		logger.fatal("傻逼，你可以滚了");

	}

}
