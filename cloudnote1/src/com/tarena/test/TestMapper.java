package com.tarena.test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.NoteBookMapper;
import com.tarena.dao.ShareMapper;
import com.tarena.dao.UserMapper;
import com.tarena.entity.NoteBook;
import com.tarena.entity.Share;
import com.tarena.entity.User;

public class TestMapper {
	private ApplicationContext ctx=new ClassPathXmlApplicationContext("config/applicationContext.xml");
	

	@Test
	public void Test5(){
		ShareMapper mapper=ctx.getBean(ShareMapper.class);
	    Map<String,Object> map=new HashMap<String,Object>();
	    map.put("searchKey", 1);
	    map.put("begin", 5);
	    map.put("pageSize",5 );
	    List<Share> shares=mapper.findByPage(map);
	    
	    for(Share s:shares){
	    	System.out.println(s.getCn_share_title());
	    }
	}
	
	
	
	//@Test
	public void text4(){
		NoteBookMapper mapper=ctx.getBean(NoteBookMapper.class);
		List list=mapper.findSpecial("55eb1254-4e56-4179-ade5-4abd9cada5cd");
		System.out.println(list);
	}
	
	//@Test
	public void text1(){
		UserMapper mapper=ctx.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setCn_user_name("zhangsan");
		user.setCn_user_password("123456");
		mapper.modifyByPassword(user);
		System.out.println(123);
		
	}
	
	//@Test
	public void text2(){
		UserMapper mapper=ctx.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setCn_user_id(UUID.randomUUID().toString());
		user.setCn_user_name("zhangsan");
		user.setCn_user_password("123");
		user.setCn_user_desc("我爱中华");
		mapper.save(user);
		//System.out.println(user);
	}
	
	//@Test
	public void test(){
		NoteBookMapper mapper=ctx.getBean(NoteBookMapper.class);
		NoteBook book=new NoteBook();
		book.setCn_notebook_id(UUID.randomUUID().toString());
		book.setCn_user_id("03590914-a934-4da9-ba4d-b41799f917d1");
		book.setCn_notebook_name("云笔记项目开发");
		book.setCn_notebook_type_id("5");
		book.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		mapper.save(book);
	}
}
