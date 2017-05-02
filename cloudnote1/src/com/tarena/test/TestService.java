package com.tarena.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.entity.User;
import com.tarena.service.LoginService;

public class TestService {
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("config/applicationContext.xml");
	
	//@Test
	public void test1(){
		LoginService login=ctx.getBean(LoginService.class);
		User user=new User();
		user.setCn_user_name("shabi");
		user.setCn_user_password("123456");
		user.setCn_user_desc("shabi");
		login.addUser(user);
	}
	
	@Test
	public void test2(){
		LoginService login=ctx.getBean(LoginService.class);
		Map map=login.checkUser("wangxianwang", "1234567");
		System.out.println(map);
	}
}
