package com.tarena.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.entity.Result;
import com.tarena.entity.User;
import com.tarena.service.LoginService;
import com.tarena.util.SystemConstant;

/*
 * 登录模块
 */

@Controller
@RequestMapping("/login")
   public class LonginController {
	
	@Resource	
	private LoginService loginService;
			
	/*
	 * 页面传入的数据的参数，springmvc会自动接受，接受的的
	 * 时机是调用方法之前。实际上springmvc仅仅是傻瓜式的处理
	 * 方式进行判断，它会遍历该方法的所有参数，然后判断页面传入
	 * 的参数是否与该参数匹配，若匹配赋值，否则不做任何处理
	 * 
	 * 匹配规则：如果实体或Map springmvc会将参数与实体属性
	 * 或者map的key值进行匹配，如果是基本类型，springmvc会
	 * 直接按照参数名匹配
	 * 
	 */
	
	  @ResponseBody
	  @RequestMapping("/register.do")
		public Result register(User user){
			boolean b=loginService.addUser(user);
			return new Result(b);
		}
	  
	  @ResponseBody
	  @RequestMapping("/login.do")
	  public Result login(String userName,String password,HttpSession session){
		 
		  //定义一个map放接受回来的信息
		  Map<String,Object> map=new HashMap<String,Object>();
		  
		  //定义一个map放将返回给客户端的信息
		  Map<String,Object> map1=new HashMap<String,Object>();
		  
		  
		   map=loginService.checkUser(userName, password);
		   
		   int flag=Integer.valueOf(map.get("flag").toString());  
		   	
		   	//登录验证成功
		   if(flag==SystemConstant.SUCCESS){
			   
			 User user=new User();
			 user=(User)map.get("user");
			 
			 //把返回的user绑定到session中
			 session.setAttribute("user", user);
			 
			 //绑定数据到map1中，返回给客户端
			 map1.put("flag",flag);
			 map1.put("userName", user.getCn_user_name());
			 map1.put("userId", user.getCn_user_id());
			 return new Result(map1);
		 }
		   //验证失败，可能是密码错误，也可能是用户名没有
		   else{
			  map1.put("flag",flag);
			  return new Result(map1);
		   }
	  }
	  
	  
	  //退出
	  @RequestMapping("/logout.do")
	  @ResponseBody
	  public Result logout(HttpSession session){
		  //注销session
		  session.invalidate();
		  return new Result();
		  
	  }
	  
	  
	  //修改密码
	  @RequestMapping("/modifypwd.do")
	  @ResponseBody
	  public Result modifyPwd(String password,
			  String pwd,HttpSession session){
		     System.out.println(123);
		     //获得登录成功时候绑定的session
		    User user=(User)session.getAttribute("user");
		      //从session中得到userName	    			
		    String userName=user.getCn_user_name();
		     //调用业务层
		    Map<String,Object> map=new HashMap<String,Object>();      
		    map=loginService.modifyPassword(userName, password, pwd);
		    
		    Integer flag1=(Integer)map.get("flag");
		    int flag=flag1;
		       
		    return new Result(flag);
	  }
}
