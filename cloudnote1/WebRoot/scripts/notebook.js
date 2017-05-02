/***
 * 加载普通笔记本
 */
function loadNormalNoteBook(){
	//console.log("进入");
	$.post(basePath+"/notebook/findNormal.do",
				{},
				function(result){
					//console.log("回来了");
					if(result.success){
						//json对象用var list表示
						var list=result.data;
						//console.log("得到数据了");
						$(list).each(function(){
							
						//每次循环都执行这个函数
						//this代表本次循环的对象
							//alert("中国");
							
							//console.log(this.cn_notebook_name);
							//申明要插入的对象，本次动态的笔记本名字
							var li='<li class="online"><a class="unchecked"><i class="fa fa-book" title="笔记本" rel="tooltip-bottom"></i>'+this.cn_notebook_name+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button></a></li>'
							//追加到最后节点去
							$("#first_side_right ul").append(li);
							
							//jQuery可以绑定任何元素值，这值在页面是不显示的
							//给li绑定笔记本数据，将来修改删除笔记本，或者根据
							//笔记本查询，笔记本要使用这个绑定的数据,说明绑定的数据可以
							//是json对象，也可以是基本你类型的值，这个都可以
							$("#first_side_right ul li:last").data("notebook",this);
							
						});
					}else{
						alert(result.message);
					}
				});
}

/***
 * 加载特殊笔记本
 */
function loadSpecialNoteBook(){
	//alert("欢迎你进入");
	$.post(basePath+"/notebook/findSpecial.do",
			{},
			function(result){
			//alert("欢迎回来");
			if(result.success){
				var list=result.data;
				
				$(list).each(function(){
					if(this.cn_notebook_type_id=='1')
					{
					$("#like_button").data("notebook",this);
					
					}
					else if(this.cn_notebook_type_id=='2'){
					$("#rollback_button").data("notebook",this);
					}
					else if(this.cn_notebook_type_id=='3'){
					$("#action_button").data("notebook",this);
					}
					else if(this.cn_notebook_type_id=='4'){
					
					$("#first_side_right ul li:first").data("notebook",this);
					}
				});
			}
			else{
				alert(result.message);
			}
			}
			);
}

/****
 * 添加笔记本
 */
function addNoteBook(){
	
	var noteBookName=$("#input_notebook").val();
	//alert(noteBookName);
	if(noteBookName==""){
		return;
	}
	$.post(basePath+"/notebook/addNormal.do",
			{"noteBookName":noteBookName},
			function(result){
				if(result.success){
					//首先关闭弹出框
					//1 隐藏弹出页面
			        $('.modal.fade.in').hide();
			        //2 隐藏背景的div
			        $('.opacity_bg').hide();
			        
			        //获取新增加的那个笔记本对象
			      var notebook=result.data;
				//location.href=basePath+"/edit.html";
			        //把新数据追加到最后一行，所以不用选li:last
			      var li='<li class="online"><a class="unchecked"><i class="fa fa-book" title="笔记本" rel="tooltip-bottom"></i>'+notebook.cn_notebook_name+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button></a></li>'
					$("#first_side_right ul").append(li);
			        //绑定数据，因为此时不知道是那行，所以需要选定
			      $("#first_side_right ul li:last").data("notebook",notebook);
				}else{
					alert(result.message);
				}
			}
		);
	
	
}

/***
 * 重命名笔记本
 */
function updateNoteBook(newName,notebook,checked_li){
	
	notebook.cn_notebook_name=newName;
	
	$.post(basePath+"/notebook/updateNormal.do",
			notebook,
			function(result){
		    	//alert(newName+"1");
				if(result.success){
					$(".close,.cancle").trigger("click");
					var a='<a class="unchecked"><i class="fa fa-book" title="笔记本" rel="tooltip-bottom"></i>'+newName+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button></a>';
					checked_li.html(a);
					checked_li.data("notebook",notebook);
				}else{
					alert(reslut.message);
				}
			}
			);
}

/***
 * 删除笔记本
 */
function deleteNoteBook(noteBookId,checked_li){
	
	//完成笔记查询功能后在补充
	//判断删除的笔记本中是否有笔记
	var noteSize=$("#second_side_right ul li").length;
	if(noteSize>0){
		alert("该笔记本中笔记，不能删除");
		return;
	}
	
	$.post(basePath+"/notebook/deleteNormal.do",
			{"noteBookId":noteBookId},
			function(result){
				if(result.success){
					$(".close,.cancle").trigger("click");
					checked_li.remove();
				//执行成功	
				}else{
					//执行失败
					alert(result.message);
				}
			}
	  );
}

/**
 * 将笔记本列表放置到select组件中
 */
function setNoteBookToSelect(){
	
	//获取默认笔记本
	var li0=$("#first_side_right ul li:first");
	//获得里面绑定的数据
	var notebook=li0.data("notebook");
	//获得绑定数据里面的notebookid
	var notebookId=notebook.cn_notebook_id;
	
	var op='<option value="'+notebookId+'">默认笔记本</option>';
	$("#moveSelect").append(op);
    
	$.post(basePath+"/notebook/findNormal.do",
			{},
			function(result){
				if(result.success){
					var list=result.data;
					$(list).each(function(){
					
					
						//if(this.cn_notebook_id!=notebookId)
					var option='<option value="'+this.cn_notebook_id+'">'+this.cn_notebook_name+'</option>'
					$("#moveSelect").append(option);
					
					//$("#replaySelect").append(option);
					});	
				}else{
					alert(result.message);
				}
			});
	
	
	
	$("#replaySelect").append(op);
	$.post(basePath+"/notebook/findNormal.do",
			{},
			function(result){
				if(result.success){
					var list=result.data;
					$(list).each(function(){
					
					
						//if(this.cn_notebook_id!=notebookId)
					var option='<option value="'+this.cn_notebook_id+'">'+this.cn_notebook_name+'</option>'
					//$("#moveSelect").append(option);
					
					$("#replaySelect").append(option);
					});	
				}else{
					alert(result.message);
				}
			});
    
	
}