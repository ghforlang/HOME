package com.tarena.dao;

import com.tarena.entity.User;

@MyBatisRepository
public interface UserMapper {
			
	        //根据用户名查询用户
			User findByName(String userName);
			
			//插入一个用户
			 void save(User user);
			 
			//更新密码的方法
			void modifyByPassword(User user); 
			
}
