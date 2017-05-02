package com.tarena.entity;

import java.io.Serializable;
/*
 * Controller方法向页面返回数据的实体
 * 该实体对返回页面的数据做了一个明确的规范和封装
 * 
 * 对于程序执行是否报错的判断，不需要在每一个controller
 * 方法中做，这样做比较麻烦，最后我们来使用AOP来统一判断
 * 是否报错，届时在给success和message
 */

public class Result implements Serializable{
	
	private static final long serialVersionUID = -37307741506878404L;
	         //程序执行是否成功，默认成功
			private boolean success=true;
			//程序执行成功与否提示消息，成功时一般不必给予提示，失败时一定要给予提示
			private String message;
			//用来封装返回给页面的业务数据
			private Object data;
			
			public Result(){
				
			}
			
			
			
			public Result(Object data) {
				this.data = data;
			}



			public Result(boolean success, String message, Object data) {
				this.success = success;
				this.message = message;
				this.data = data;
			}



			public boolean isSuccess() {
				return success;
			}
			public void setSuccess(boolean success) {
				this.success = success;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			public Object getData() {
				return data;
			}
			public void setData(Object data) {
				this.data = data;
			}
			
			
	
}
