package com.tarena.util;

public interface SystemConstant {
			/*
			 * 系统常量的接口
			 */
	
	String FAVORITES_TYPE_ID="1";
	String RECYCLE_TYPE_ID="2";
	String ACTION_TYPE_ID="3";
	String PUSH_TYPE_ID="4";
	String NORMAL_TYPE_ID="5";
	
	//笔记本类型名
	String FAVORITES_TYPE_NAME="收藏";
	String RECYCLE_TYPE_NAME="回收站";
	String ACTION_TYPE_NAME="活动";
	String PUSH_TYPE_NAME="推送";
	String NORMAL_TYPE_NAME="正常";
	
	
	//登录验证结果
	int SUCCESS=0;
	int USER_NAME_ERROR=1;
	int USER_PASSWORD_ERROR=2;
	
	//分页时，每页显示的行数
	int PAGE_SIZE=5;
	
}
