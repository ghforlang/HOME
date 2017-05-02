/**
 * 登录页面初始化后，绑定函数。
 */
$(function(){
	//注册
	$("#regist_button").click(function(){
		//调用业务方法
		register();
	});
	
	//登录
	$("#login").click(function(){
		login();
	});
	
	//登出
	$("#logout").click(function(){
		logout();
	});
	
	//修改密码
	$("#changePassword").click(function(){
		changepwd();
	})
	
});

//注册
function register() {
	//客户端验证
	var userName=$("#regist_username").val();
	var nickName=$("#nickname").val();
	var password=$("#regist_password").val();
	var finalPassword=$("#final_password").val();
	var reg=/^\w{3,20}$/;
	
	
	//检测用户名的合法性
	if(!reg.test(userName)){
	$("#warning_1 span").text("请输入3-20位字母,数字,下划线");
	$("#warning_1").show();
	   return;
	}else{
		$("#warning_1").hide();
	}
	
	
	//检测密码的合法性
	if(password.length<6){
		$("#warning_2 span").text("密码必须大于6位");
		$("#warning_2").show();
		return;
		}else{
			$("#warning_2").hide();
		}
	
	//检测两次密码是否一致
	if(password!=finalPassword){
		$("#warning_3 span").text("两次密码不一致");
		$("#warning_3").show();
		return;
		}else{
			$("#warning_3").hide();
		}
	
	
	
     $.post(basePath+"/login/register.do",
		     {"cn_user_name":userName,
    	 		"cn_user_desc":nickName,
    	 		"cn_user_password":password},
		      function(result){
    	 			
    	 			if(result.success){
    	 			//代码执行成功，没有报错
    	 			//检测用户名是否存在
    	 				if(result.data){
    	 					alert("注册成功");
    	 					$("#zc").attr("class","sig sig_out");
    	 					$("#dl").attr("class","log log_in");
    	 			}
    	 				else{
    	 					//注册失败
    	 					$("#warning_1 span").text("用户名已经存在");
    	 					$("#warning_1").show();
    	 				}
			}
    	 			else{
    	 			alert(result.message);
    	 			}
    	 		}
			);	
}

//登陆
function login() {
	  //取出用户名和密码框的信息
	 var userName=$("#count").val();
	 var password=$("#password").val();
	 //姓名框验证
	 if(userName==""){
		 alert("傻逼啊，请输入用户名傻逼");
		 return;
	 }
	 //密码框验证
	 else if(password==""){
	 alert("傻逼啊，请输入密码");
	 return;
	 }
	 
	 //验证结束，准备发送异步请求

		 
		 $.post(basePath+"/login/login.do",
				 {"userName":userName,
			 		"password":password},
				 function(result){
			 	    //执行成功，代码没有出错
				   if(result.success){
				   var map=result.data;
				   //用户名密码都正确
				   if(map.flag==0){
					   
					   /*
					    * 在客户端用js创建Cookie，以前我们创建Cookie
					    * 都是在服务器端创建的，在服务器和客户端都可以获取
					    * 该Cookie，现在我们在客户端创建Cookie，是用js创建的，
					    * 同理在服务器端和客户端我们都可以获取到，就是发送请
					    * 求时候也可以获取
					    */
					   
					   addCookie("userId",map.userId,10);
					   addCookie("userName",userName,10);
					   
					   location.href="edit.html";
					   
					  
				   }
				   //用户名错了
				   else if(map.flag==1){
				   alert("用户名不存在")
				   }
				   //密码错了
				   else{
					   alert("密码错了")
				   }
				   }
				   //程序执行报错
				   else{
					   alert(result.message)
				   }
				 }
		 );
	 }


/**
 * 退出登录
 */
function logout(){
	//发送异步请求注销Session
	$.post(basePath+"/login/logout.do",
			{},
			function(result){
			if(result.success){
				location.href="login.html";
			}
			else{
				alert(result.messgae);
			}
			}
	);
	
}

/**
 * 修改密码
 */
function changepwd(){
	
	 var password=$("#last_password").val();
	 var pwd=$("#new_password").val();
	 var pwd1=$("#final_password").val();
	 
	 //旧密码必须不能为空
	 if(password==""){
			$("#warning_1 span").text("密码必须大于6位");
			$("#warning_1").show();
			return;
			}else{
				$("#warning_1").hide();
			}
	 
	 //新密码不能为空
	 if(pwd.length<6){
			$("#warning_2 span").text("密码必须大于6位");
			$("#warning_2").show();
			return;
			}else{
				$("#warning_2").hide();
			}
	 
	 //新二次密码不能为空
	 if(pwd1.length<6){
			$("#warning_3 span").text("密码必须大于6位");
			$("#warning_3").show();
			return;
			}else{
				$("#warning_3").hide();
			}
	 
	    //两次密码必须一致
	   if(pwd!=pwd1){
		   $("#warning_3 span").text("两次密码必须一样");
			$("#warning_3").show();
		   return;
	      }
	   else{
			$("#warning_3").hide();
		}
	   
	   //发送异步请求
	   $.post(basePath+"/login/modifypwd.do",
				 {"password":password,
				 	"pwd":pwd},
				 function(result){
			 	    //执行成功，代码没有出错
				  
				 		if(result.success){
				   //用户名密码都正确
					   
				   if(result.data==0){
	                   alert("修改成功");
					  logout();	  
				   }
				   
				   else {
				   alert("旧密码错误");
				   }
				   
				   }
				   //程序执行报错
				   else{
					   alert(result.message);
				   }
				 }
		 );
}


