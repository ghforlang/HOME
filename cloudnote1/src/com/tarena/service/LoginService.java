package com.tarena.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.dao.NoteBookMapper;
import com.tarena.dao.UserMapper;
import com.tarena.entity.NoteBook;
import com.tarena.entity.User;
import com.tarena.util.Md5Util;
import com.tarena.util.SystemConstant;

/*
 * 登录模块业务组建
 * 将来要使用Spring声明事务来管理
 * 该业务组建的事务，声明式事务很简单
 * 但要求这些业务方法有一定的规律，以便
 * 事务管理组建可以识别该方法
 */

@Service
public class LoginService implements SystemConstant{
	
	@Resource
	private UserMapper userMapper;
	@Resource
	private NoteBookMapper noteBookMapper;
	        
			//注册
			public boolean addUser(User user){
				//抛出异常，等学后面进行异常统一处理
				if(user==null){
					throw new RuntimeException("参数不能为空");
				}
				//先根据名字去查数据库是不是有这这条记录
				User u=userMapper.findByName(user.getCn_user_name());
				//没有这条记录，创建新的记录
				if(u==null){
					//没有用户时候创建用户，把数据放入数据库
					createUser(user);
					
					//没有这个用户时候，给用户插入三个表
					initNoteBook(user.getCn_user_id());
					return true;
				}
				//代表用户名存在
				else{
					return false;
				}
			}

			public void initNoteBook(String userId) {
				NoteBook n1=new NoteBook();
				//初始化收藏笔记本
				n1.setCn_notebook_id(UUID.randomUUID().toString());
				n1.setCn_notebook_type_id(FAVORITES_TYPE_ID);
				n1.setCn_notebook_name("FAVORITES_TYPE_NAME");
				n1.setCn_user_id(userId);
				n1.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
				noteBookMapper.save(n1);
				//初始化回收笔记本
				NoteBook n2=new NoteBook();
				n2.setCn_notebook_id(UUID.randomUUID().toString());
				n2.setCn_notebook_type_id(RECYCLE_TYPE_ID);
				n2.setCn_notebook_name("RECYCLE_TYPE_NAME");
				n2.setCn_user_id(userId);
				n2.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
				noteBookMapper.save(n2);
				//活动笔记本
				NoteBook n3=new NoteBook();
				n3.setCn_notebook_id(UUID.randomUUID().toString());
				n3.setCn_notebook_type_id(ACTION_TYPE_ID);
				n3.setCn_notebook_name("ACTION_TYPE_NAME");
				n3.setCn_user_id(userId);
				n3.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
				noteBookMapper.save(n3);
				//推送笔记本
				NoteBook n4=new NoteBook();
				n4.setCn_notebook_id(UUID.randomUUID().toString());
				n4.setCn_notebook_type_id(PUSH_TYPE_ID);
				n4.setCn_notebook_name("PUSH_TYPE_NAME");
				n4.setCn_user_id(userId);
				n4.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
				noteBookMapper.save(n4);
			}

			public void createUser(User user) {
				user.setCn_user_id(UUID.randomUUID().toString());
				String md5Password=Md5Util.md5(user.getCn_user_password());
				user.setCn_user_password(md5Password);
				userMapper.save(user);
			}
			
			
			//登录
			public Map<String,Object> checkUser(String userName,String password){
				
				if(userName==null){
					throw new RuntimeException("用户名不能为空");
				}
				if(password==null){
					throw new RuntimeException("密码不能为空");
				}
				Map<String,Object> map=new HashMap<String,Object>();
				
				User user=userMapper.findByName(userName);
				
				if(user==null){
					map.put("flag", USER_NAME_ERROR);
					return map;
				}
				
				String md5Password=Md5Util.md5(password);
				
				if(!md5Password.equals(user.getCn_user_password())){
					map.put("flag", USER_PASSWORD_ERROR);
					return map;
				}
				
				map.put("flag", SUCCESS);
				map.put("user",user);
				return map;
				
			}
			
			
			//更新密码
			public Map<String,Object> modifyPassword(String userName,
					String password,String pwd){
				
				//检查用户名
				if(userName==""){
					throw new RuntimeException("用户名不能为空");	
				}
				
				//检查旧密码
				if(password==""){
					throw new RuntimeException("密码不能为空");
				}
				//检查新密码
				if(pwd==""){
					throw new RuntimeException("新密码不能为空");
				}
				
				//根据给的用户名查找数据，看这个用户是否存在
				User user=userMapper.findByName(userName);
				Map<String,Object> map=new HashMap<String,Object>();
				
				//用户名不存在
				if(user==null){
					map.put("flag", USER_NAME_ERROR);
					return map;
				}
				
				//用户名存在，但是还是有两个可能
				
            String md5Password=Md5Util.md5(password);
				
        	   //可能1 旧密码错误
				if(!md5Password.equals(user.getCn_user_password())){
					map.put("flag", USER_PASSWORD_ERROR);
					return map;
				}
				
				
				//可能2 旧密码正确，开始修改密码
				String md5Password1=Md5Util.md5(pwd);
				user.setCn_user_password(md5Password1);
				userMapper.modifyByPassword(user);
				map.put("flag", SUCCESS);
					return map;
						
			}
}
