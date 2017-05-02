/**********公共函数**********/
//格式化字符串，转义<和>
function formate_name(e){
	e=e.replace(/</g,'&lt;');
	e=e.replace(/>/g,'&gt;');
	return e;
}
//去掉空格
function check_null(s){
	s=s.replace(/ /g,'');
	s=s.length;
	return s;
}


/**********HTML初始化时直接调用的函数**********/
//获取笔记本列表,edit.html初始化时调用
function get_nb_list(){
	loadNormalNoteBook();
}

//获取特殊笔记本列表,edit.html初始化时调用
function get_spnb_list(){
	loadSpecialNoteBook();
}

//获取活动列表,activity.html初始化时调用
function activity_list(){
	getActivityList();
}

//获取活动页面参加活动笔记列表,activity_detail.html初始化时调用
function get_activity_list(){
	var param=window.location.hash;
	global_ac_id=param.replace(/#/,'');
	getNoteActivitys();
}



/**********HTML初始化后为其按钮绑定函数**********/
//注册事件
$(function(){
	//从login页面中利用Cookie传过来的数据
	$(".profile-username").text(getCookie("userName"));
	
	//----关闭，取消
	$(document).on("click", ".close,.cancle", function() {
		//清空弹出页面中输入的内容
		$('#input_notebook,#input_note').val('');
		//隐藏弹出页面
        $('.modal.fade.in').hide();
        //隐藏背景的div
        $('.opacity_bg').hide();
    }),
	
    
    /***********笔记本模块************/
	//----单击笔记本,查询笔记，即单击事件，是给li注入
	$(document).on("click", "#pc_part_1 li", function() {
		
		//显示出笔记和编辑笔记的div
		$('#pc_part_2,#pc_part_3').show();
		
		$('#pc_part_2 ul').empty();
		//将回车站笔记，收藏笔记，活动比较，搜搜笔记，预览笔记隐藏
		$('#pc_part_4,#pc_part_5,#pc_part_6,#pc_part_7,#pc_part_8').hide();
		
		//回收站 收藏活动按钮移除样式
		$('#rollback_button,#like_button,#action_button').removeClass('clicked');
		
		//this指当前的li  siblings是获取当前元素的所有兄弟元素，但是不包括自己
		//$(this).siblings('li')选择其他的li，选择其他li的a元素
		//其中checked是选中的样式，结果只有选中的那个li样式为checked
		$(this).siblings('li').children('a').removeClass('checked');
		$(this).children('a').addClass('checked');
		
		
		//先把noteBookId查找出来，在传入进去,，因为最后是根据这个查询
		var checked_li = $("#first_side_right .checked").parent();
		
		var notebook = checked_li.data("notebook");
		
		
		//获取笔记本下的笔记列表
		getNormalNoteList(notebook);
    }),
    
    
    
    
    
    //1 创建笔记
	//创建笔记本----打开创建笔记本界面，给添加按钮注入单击事件，打开创建页面
	$(document).on("click", "#add_notebook", function() {
		$('#can').load('./alert/alert_notebook.html', function(){
			$('#input_notebook').focus();
		});
		$('.opacity_bg').show();
    }),
    
	//创建笔记本----创建笔记本，注入单击事件，注意谈出框的那个确定按钮注入单击事件
	$(document).on("click", "#modalBasic .btn.btn-primary.sure", function() {
		//调用notebook.js中的函数
		addNoteBook();
    }),
    
    
    
    
    
    
    //2 修改笔记本名字
	//修改笔记本名字----双击,打开修改笔记本界面，注入双击事件，是给li注入
	$(document).on("dblclick", "#pc_part_1 li:gt(0)", function() {
		$('#can').load('./alert/alert_rename.html',function(){
			$('#input_notebook_rename').focus();
		});
		//弹出半透明的背景图
		$('.opacity_bg').show();
    }),
    
    //修改笔记本名字----修改笔记本，给修改那个弹出框的确定按钮注入单击确定事件
	$(document).on("click",'#modalBasic_4 .sure',function() {
		//获取新名称
		var newName=$("#input_notebook_rename").val();
	
		//获取选中的li,取得绑定的笔记本数据
		//var newName = $("#input_notebook_rename").val();
		//获取选中的li，取得绑定的笔记本数据
		var checked_li = $("#first_side_right .checked").parent();
		var notebook = checked_li.data("notebook");
		
		//alert("7")
		//校验新名称非空，
		if(newName && newName!=notebook.cn_notebook_name){
			updateNoteBook(newName,notebook,checked_li);
		}
		//alert("9");
		
		
	});
	
	
	
    
	
	
	//3 删除笔记本
	//删除笔记本----打开删除笔记本界面，给删除按钮注入单击事件
	$(document).on("click", "#first_side_right .btn_delete", function() {
		$('#can').load('./alert/alert_delete_notebook.html');
		$('.opacity_bg').show();
    }),
	
    //删除笔记本----删除笔记本，给删除按钮谈出来的那个框注入单击确定删除按钮
	$(document).on('click','#modalBasic_6 .btn.btn-primary.sure',function(){
		
		//根据样式找到当前那个li
		var checked_li = $("#first_side_right .checked").parent();
		var notebook = checked_li.data("notebook");
		deleteNoteBook(notebook.cn_notebook_id,checked_li);
	});
	
	
	
    
	
	
	
	
	
	
	
	/***********笔记模块************/
	//----点击笔记
	$(document).on("click", "#pc_part_2 li", function() {
		$(this).siblings('li').children('a').removeClass('checked');
		$(this).children('a').addClass('checked');
		getNoteDetail();
    }),
    
    
    
    
    
    
    //1 创建笔记
	//----打开创建笔记界面，给添加按钮注入单击事件
	$(document).on("click", "#add_note", function() {
		$('#can').load('./alert/alert_note.html',function() {
			$('#input_note').focus();
		});
		$('.opacity_bg').show();
    }),
    
	//----创建笔记，创建笔记弹出的页面的确定按钮注入单击事件
	$(document).on("click", "#modalBasic_2 .btn.btn-primary.sure", function() {
		//保存
		
		//传入的名字
		var noteTitle=$("#input_note").val();
		var checked_li = $("#first_side_right .checked").parent();
		var notebook = checked_li.data("notebook");
		
		createNormalNote(noteTitle,notebook);
    }),
    
    
    
    
    
    
    
    
    //修改笔记的内容以后保存
    //----保存笔记内容
    $(document).on("click","#save_note", function() {
		//修改
		updateNormalNote();
    }),
    
    
    
    
    
    
    
    //----点击笔记下拉按钮
	$(document).on("click", ".btn_slide_down", function() {
		$(this).parents('li').children('.note_menu').addClass('note_menu_show').mouseleave(function(){
			$(this).removeClass('note_menu_show');
		});
    }),
    
    
    
    
    
    //1 删除
    //----打开删除笔记界面
	$(document).on("click", "#second_side_right .btn_delete", function() {
		$('#can').load('./alert/alert_delete_note.html');
		$('.opacity_bg').show();
    }),
    
	//----确认删除
	$(document).on('click','#modalBasic_7 .btn.btn-primary.sure', function() {
		
		
		//获得选中的笔记
		var checked_li = $("#second_side_right .checked").parent();
		//获得选中的笔记绑定的数据
		var note = checked_li.data("note");
		//调用函数
		deleteNormalNote(note,checked_li);
	});
    
	
	
	
	
	// 2 移动
	//----打开移动笔记界面
	$(document).on("click", "#second_side_right .btn_move", function() {
		$('#can').load('./alert/alert_move.html',function(){
			
			//先获得是哪个笔记被选中要移动,并把这个笔记中绑定的数据取出
			//var checked_li=$("#second_side_right .checked").parent();
			//var note=checked_li.data("note");
			
			//获得点中那个笔记本的笔记名字，并把这个笔记本中绑定的数据取出
			//var checked_li1=$("#first_side_right .checked").parent();
			//var notebook=checked_li1.data("notebook");
			
			
			// 获取笔记本列表
			setNoteBookToSelect();
			
			
			$('#moveSelect').focus();
		});
		$('.opacity_bg').show();
    }),
    
	//----确认移动
	$(document).on('click','#modalBasic_11 .btn.btn-primary.sure',function(){
		
		//获得选中的要移动的那个笔记
		var checked_li = $("#second_side_right .checked").parent();
		//获得选中的笔记绑定的数据
		var note = checked_li.data("note");
		//调用函数
		moveNote(note,checked_li);
	});
    
	
	
	
	
	// 3 分享
	//----分享笔记
	$(document).on("click", "#second_side_right .btn_share", function() {
		$(this).fadeOut(600);
		createShareNote();
    }),
    
    
    
    
    
    
    
    /***********回收站模块************/
	//----点击回收站按钮
	$(document).on("click", "#rollback_button", function() {
		$('#pc_part_2,#pc_part_3,#pc_part_6,#pc_part_7,#pc_part_8').hide();
		$('#pc_part_4,#pc_part_5').show();
		$('#first_side_right li a').removeClass('checked');
		$('#like_button,#action_button').removeClass('clicked');
		$(this).addClass('clicked');
		//每次加载前先清空所有li
		$('#pc_part_4 ul').empty();
		getRecycleNoteList();
    }),
    
    
    //点击回收站里面的笔记，给选择的那个绑定样式
	//----点击回收站笔记
	$(document).on("click", "#pc_part_4 li", function() {
		$(this).siblings('li').children('a').removeClass('checked');
		$(this).children('a').addClass('checked');
		getRecycleNoteDetail();
    }),
    
    
    
    
    //1 恢复
    //恢复回收站里面的笔记
	//----点击回收站恢复按钮
	$(document).on("click", "#four_side_right .btn_replay", function() {
		$('#can').load('./alert/alert_replay.html',function(){
			setNoteBookToSelect();
			$('#replaySelect').focus();
		});
		$('.opacity_bg').show();
    }),
    
	//----确认恢复
	$(document).on('click','#modalBasic_3 .btn.btn-primary.sure', function(){
		
		var checked_li = $("#four_side_right .checked").parent();
		//获得选中的笔记绑定的数据
		var note = checked_li.data("note");
		
		moveNote(note,checked_li);
	});
	
	
	
	
	
    //2 删除
	//删除回收站里面的笔记
	//----点击回收站删除按钮
	$(document).on("click", "#four_side_right .btn_delete", function() {
		$('#can').load('./alert/alert_delete_rollback.html');
		$('.opacity_bg').show();
    }),
    
	//----确认删除
	$(document).on('click','#modalBasic_10 .btn.sure', function() {
		alert("123")
		//找到回收中被选择的那个笔记
		var checked_li = $("#four_side_right .checked").parent();
		//获得选中的笔记绑定的数据
		var note = checked_li.data("note");
		
		deleteRecycleNote(note,checked_li);
	});
    
	
	
	
	
	
	
	
	
	/***********搜索笔记模块************/
	//----搜索笔记
	$(document).on("keyup", "body", function(e) {
		
		
      $('#pc_part_6,#pc_part_5').show();
		
		$('#pc_part_6 ul').empty();
		//将回车站笔记，收藏笔记，活动比较，搜搜笔记，预览笔记隐藏
		$('#pc_part_2,#pc_part_3,#pc_part_4,#pc_part_7,#pc_part_8').hide();
		
		if($('#search_note').is(':focus')&&(e.keyCode==108||e.keyCode==13)){
			var m=$('#search_note').val();
			//alert(m);
			var n=m.replace(/ /g,'');
			var a=n.length;
			if(a!=0){
				//$('#sixth_side_right ul').empty();
				$("#more_note").data("currentPage",1);
				getShareNoteList(n,1);
			}
		}
    }),
    
	//----更多搜索笔记
	$(document).on("click", "#more_note", function() {
		
		  $('#pc_part_6,#pc_part_5').show();
			
			$('#pc_part_6 ul').empty();
			//将回车站笔记，收藏笔记，活动比较，搜搜笔记，预览笔记隐藏
			$('#pc_part_2,#pc_part_3,#pc_part_4,#pc_part_7,#pc_part_8').hide();
			
			
				var m=$('#search_note').val();
				//alert(m);
				var n=m.replace(/ /g,'');
				var a=n.length;
				if(a!=0){
					//$('#sixth_side_right ul').empty();
					var p=$("#more_note").data("currentPage");
					$("#more_note").data("currentPage",p+1)
					getShareNoteList(n,p+1);
				
			}
    }),
    
	//----点击搜索笔记
	$(document).on("click", "#sixth_side_right li", function() {
		$(this).siblings('li').children('a').removeClass('checked');
		$(this).children('a').addClass('checked');
		getShareNoteDetail();
    }),
    
	//----收藏搜索笔记
	$(document).on("click", "#pc_part_6 .btn_like", function() {
		$('#can').load('./alert/alert_like.html', function(){
			$('#modalBasic_5 .btn.btn-primary.sure').click(function(){
				
				//获得中的那个搜索分享出来的分享笔记
				var checked_li=$("#sixth_side_right .checked").parent();
				var share=checked_li.data("share");
				likeShareNote(share,checked_li);
			});
		});
		$('.opacity_bg').show();
    }),
    
    
    /***********注册收藏笔记相关操作************/
	//----点击收藏按钮
	$(document).on("click", "#like_button", function() {
		$('#pc_part_2,#pc_part_3,#pc_part_4,#pc_part_6,#pc_part_8').hide();
		$('#pc_part_7,#pc_part_5').show();
		$('#first_side_right li a').removeClass('checked');
		$('#rollback_button,#action_button').removeClass('clicked');
		$(this).addClass('clicked');
		//每次加载前先清空所有li
		$('#pc_part_7 ul').empty();
		getLikeNoteList();
    }),
	
	//----点击收藏笔记
	$(document).on("click", "#pc_part_7 li", function() {
		$(this).siblings('li').children('a').removeClass('checked');
		$(this).children('a').addClass('checked');
		getLikeNoteDetail();
    }),
    
	//----点击取消收藏
	$(document).on("click", "#pc_part_7 li .btn_delete", function() {
		$('#can').load('./alert/alert_delete_like.html');
		$('.opacity_bg').show();
    }),
    
	//----确认取消
	$(document).on('click','#modalBasic_9 .btn.btn-primary.sure', function(){
		deleteLikeNote();
		
	});
    
	
	/***********参加活动笔记模块************/
	//----点击参加活动笔记按钮
	$(document).on("click", "#action_button", function() {
		$('#pc_part_2,#pc_part_3,#pc_part_6,#pc_part_7,#pc_part_4').hide();
		$('#pc_part_8,#pc_part_5').show();
		$('#first_side_right li a').removeClass('checked');
		$('#rollback_button,#like_button').removeClass('clicked');
		$(this).addClass('clicked');
		//$("#eighth_side_right ul").empty();
		getNoteActivityList();
    }),
    
    //----点击参加活动笔记
	$(document).on("click", "#pc_part_8 li", function() {
		$(this).siblings('li').children('a').removeClass('checked');
		$(this).children('a').addClass('checked');
		getActivityNoteDetail();
    }),
	
    
    
    
    
    /***********活动模块************/
	//----更多活动笔记
	$(document).on("click", "#more_activity_note", function() {
		getNoteActivitys();
    });
	
	//----点击笔记(活动页面)
	$(document).on("click", "#action_part_1 li", function() {
		$('#rollback_button').removeClass('clicked');
		$(this).siblings('li').children('a').removeClass('checked');
		$(this).children('a').addClass('checked');
		$("#content_body").empty();
		getNoteActivityDetail();
    }),
	
	//----点击参加活动（活动页面）
	$(document).on("click", "#join_action", function() {
		$('#modalBasic_15,.opacity_bg').show();
		//$('#select_notebook ul').empty();
		//$('#select_note ul').empty();
		getSelectNoteBook();
    }),
    
	//----准备选择参加活动笔记（活动页面）
	$(document).on("click", "#select_notebook li", function() {
		$(this).siblings('li').children('a').removeClass('checked');
		$(this).children('a').addClass('checked');
		//$('#select_note ul').empty();
		getSelectNoteList();
    }),
    
	//----选择笔记（活动页面）
	$(document).on("click", "#select_note li", function() {
		$(this).siblings('li').children('a').removeClass('checked');
		$(this).children('a').addClass('checked');
    }),

	//----确认选择的笔记（活动页面）
	$(document).on("click", "#modalBasic_15 .btn.btn-primary.sure", function() {
		//var get_notename=$('#select_note li a.checked').text();
		//$('.close,.cancle').trigger('click');
		createNoteActivity();
    }),
    
	//----点击收藏（活动页面）
	$(document).on('click',"#first_action .btn_like", function() {
		likeActivityNote();
    }),
	
	//----顶笔记（活动页面）
	$(document).on("click", "#first_action .btn_up", function() {
		up();
    }),
    
	//----踩笔记（活动页面）
	$(document).on("click", "#first_action .btn_down", function() {
		down();
    });
	
});