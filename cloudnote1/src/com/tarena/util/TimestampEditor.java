package com.tarena.util;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;

/*
 * 日期类型转换器，可以将页面传入的日期字符串转换成java.sql.Timesstamp
 * 该日期转换器
 */

public class TimestampEditor extends PropertyEditorSupport{
     
	/*
	 *
	 * 类型转换方法，参数
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		if(text!=null){
			//如果传入null，直接注入
			setValue(null);
		}else{
			//如果传入的不是null,转型后注入
			Timestamp t=new Timestamp(Long.valueOf(text));
			setValue(t);
		}
	}
          
}
