/***
 * 加载普通笔记
 */
function getNormalNoteList(notebook){
	
	var notebookid=notebook.cn_notebook_id;
	
	$.post(basePath+"/note/findnote.do",
			{"noteBookId":notebookid},
			function(result){
				//alert("2");
				if(result.success){
					//数据传输成功
					
				var list=result.data;
				
				  //$('#second_side_right ul li').remove();
				
				$(list).each(function(){
					
					var li='<li class="online"><a><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+this.cn_note_title+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down">'+
					      '<i class="fa fa-chevron-down"></i></button></a><div class="note_menu" tabindex="-1"><dl><dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button>'+
					      '</dt><dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt><dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除">'+
					      '<i class="fa fa-times"></i></button></dt></dl></div></li>'
					      
					 $("#second_side_right ul").append(li);
					
					$("#second_side_right ul li:last").data("note",this);
					    
					
				});	
				}
				else{
					//数据传输失败
					alert("result.message");
				}
			}
			);
}

/***
 * 查询普通笔记内容
 */
function getNoteDetail(){
	//取得选中笔记
	var checked_li=$("#second_side_right .checked").parent();
	var note=checked_li.data("note");
	$("#input_note_title").val(note.cn_note_title);
	$("#myEditor").html(note.cn_note_body);
}

/***
 * 创建普通笔记
 */
function createNormalNote(noteTitle,notebook){
	
	if(noteTitle==""){
		return ;
	}
	//alert(34)
	$.post(basePath+"/note/addnote.do",
			{"noteTitle":noteTitle,
		    "noteBookId":notebook.cn_notebook_id},
			function(result){
				if(result.success){
					//关闭弹出框
					  $('.modal.fade.in').hide();
				     $('.opacity_bg').hide();
				     //追加
				     var note=result.data;
				     
				     var li='<li class="online"><a><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+note.cn_note_title+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down">'+
				      '<i class="fa fa-chevron-down"></i></button></a><div class="note_menu" tabindex="-1"><dl><dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button>'+
				      '</dt><dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt><dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除">'+
				      '<i class="fa fa-times"></i></button></dt></dl></div></li>'
				     
				      $("#second_side_right ul").append(li);
						
						$("#second_side_right ul li:last").data("note",note);
						
						$("#second_side_right ul li:last a").addClass("checked");
				        
						
				}
				else{
					alert(result.message);
				}
				
			});
}


/***
 * 更新普通笔记
 */
function updateNormalNote(){
	
	var checked_li = $("#second_side_right .checked").parent();
	var note = checked_li.data("note");
	
	var title=$("#input_note_title").val();
	var body=um.getContent();
	
	note.cn_note_title=title;
	note.cn_note_body=body;
	
	$.post(basePath+"/note/update.do",
			
			 note,
			function(result){
				if(result.success){
					
					//$("#second_side_right .checked")
					//var checked_li = $("#second_side_right .checked").parent();
					checked_li.data("note",note);
					//$("#second_side_right ul")
					//alert("保存成功");
					$("footer strong").text("保存成功");
					$("footer div").show();
					//setTimeout(function(){
					//$("footer div").hide();	
					//},2000)
					$("footer div").fadeIn(100);
					$("footer div").fadeOut(3000);
				}else{
					alert(result.message);
				}
			});
	
	
}

/***
 * 删除普通笔记
 */
function deleteNormalNote(note,check_li){
	//alert("1")
	//获得绑定数据中的noteId
	var noteId=note.cn_note_id;
	
	//获得回收站笔记本绑定的数据,从而到底里面的笔记本id
	var noteBook=$("#rollback_button").data("notebook");
	var noteBookId=noteBook.cn_notebook_id;
	
	$.post(basePath+"/note/updatenote.do",
			{"noteId":noteId,
			 "noteBookId":noteBookId},
			function(result){
				if(result.success){
				$(".close,.cancle").trigger("click");
				check_li.remove();
					
				}else{
					alert(result.message);
				}
			});
	
}

/***
 * 移动笔记
 */
function moveNote(note,checked_li){
	//alert("123");
	//获得笔记id
	var noteId=note.cn_note_id;
	//获得要传入的那个笔记本的id
	var noteBookId=$("#moveSelect").val();
	//获得从垃圾站移动到新的笔记本的id
	var noteBookId1=$("#replaySelect").val();
	if(noteBookId==null&&noteBookId1==null){
		moveNote(note,checked_li);
	}
	
	//发送请求更新数据
	if(noteBookId!=null){
		
	$.post(basePath+"/note/updatenote.do",
			{"noteId":noteId,
			 "noteBookId":noteBookId},
			function(result){
				if(result.success){
				$(".close,.cancle").trigger("click");
				checked_li.remove();
					
				}else{
					alert(result.message);
				}
			});
	}
	
	if(noteBookId1!=null){
		
	$.post(basePath+"/note/updatenote.do",
			{"noteId":noteId,
			 "noteBookId":noteBookId1},
			function(result){
				if(result.success){
				$(".close,.cancle").trigger("click");
				checked_li.remove();
					
				}else{
					alert(result.message);
				}
			});
	}
	
}

/***
 * 分享笔记
 */
function createShareNote(){
	
	//获得选择的那个笔记的名字，从而得出数据
	var checked_li = $("#second_side_right .checked").parent();
	var note = checked_li.data("note");
	
	$.post(basePath+"/share/insertshare.do",
			note,
			function(result){
		if(result.success){
			
			$("footer div strong").text("分享成功").parent().fadeIn(100);
			setTimeout(function(){
				$("footer div").fadeOut(500);
			}, 1500);
			
		}else{
			alert(result.message);
		}
	}
			);
	
	
	
}

/***
 * 查询回收站笔记列表
 */
function getRecycleNoteList(){
	
	var noteBook=$("#rollback_button").data("notebook");
	var noteBookId=noteBook.cn_notebook_id;
	
	//$('#four_side_right ul li').remove();
	
	$.post(basePath+"/note/findnote.do",
			{"noteBookId":noteBookId},
			function(result){
				if(result.success){
					
					var list=result.data;
					
					  $('#second_side_right ul li').remove();
					
					$(list).each(function(){
						//alert(this.cn_note_title)
						
						var li='<li class="disable"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+this.cn_note_title+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button><button type="button" class="btn btn-default btn-xs btn_position_2 btn_replay"><i class="fa fa-reply"></i></button></a></li>'
						      
						 $("#four_side_right ul").append(li);
						
						$("#four_side_right ul li:last").data("note",this);
						    
						
					});	
				
					
				}else{
					alert(result.message);
				}
			}
			);
}

/***
 * 查看回收站笔记内容
 */
function getRecycleNoteDetail() {
	console.log("查看回收站笔记内容");
}

/***
 * 删除回收站笔记
 */
function deleteRecycleNote(note,checked_li){
	
	$.post(basePath+"/note/deletenote.do",
			{"noteId":note.cn_note_id},
			function(result){
				if(result.success){
					$(".close,.cancle").trigger("click");
					checked_li.remove();
				}
				else{
					alert(result.message);
				}
			}
			);
	
}

/***
 * 搜索分享笔记列表
 */
function getShareNoteList(n,currentPage){
	
	$.post(basePath+"/share/findshare.do",
			{"searchKey":n,
		     "currentPage":currentPage},
			function(result){
			if(result.success){
				
			var list=result.data;
			
			
			$(list).each(function(){
				//alert(this.cn_share_title);
				
				var li='<li class="online"><a href="#"><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+this.cn_share_title+'<button type="button" class="btn btn-default btn-xs btn_position btn_like"><i class="fa fa-star-o"></i></button><div class="time"></div></a></li>'
				      
				 $("#sixth_side_right ul").append(li);
				
				$("#sixth_side_right ul li:last").data("share",this);
				    
				
			});	
			
				
				
			}else{
				alert(result.message);
			}	
			});
}

/***
 * 查询分享笔记内容
 */
function getShareNoteDetail(){
	
	var checked_li=$("#sixth_side_right .checked").parent();
	var share=checked_li.data("share");
	//alert(share.cn_share_title);
	$("#noput_note_title").text(share.cn_share_title);
	
	$("#noput_note_body").html(share.cn_share_body);
}

/***
 * 收藏分享笔记
 */
function likeShareNote(share,checked_li){
	
	var noteBook=$("#like_button").data("notebook");
	var noteBookId=noteBook.cn_notebook_id;
	
	$.post(basePath+"/note/addlike.do",
			{"shareTitle":share.cn_share_title,
			 "shareBody":share.cn_share_body,
			 "noteBookId":noteBookId},
	function(result){
		if(result.success){
			alert("收藏成功");
		}else{
			alert(result.message);
		}
	}
			);
}

/***
 * 加载收藏笔记
 */
function getLikeNoteList(likeNoteId){
	
	var noteBook=$("#like_button").data("notebook");
	var noteBookId=noteBook.cn_notebook_id;
	
	$.post(basePath+"/note/findnote.do",
			{"noteBookId":noteBookId},
			function(result){
				if(result.success){
					
					var list=result.data;
					
					$(list).each(function(){
						
						var li='<li class="idle"><a><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+this.cn_note_title+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button></a></li>'
						 $("#seventh_side_right ul").append(li);
						
						$("#seventh_side_right ul li:last").data("share",this);
						    
						
					});	
					
					
					
				}else{
					alert(result.message);
				}
			}
			);
}

/***
 * 查看收藏笔记内容
 */
function getLikeNoteDetail(noteId) {
	console.log("查看收藏笔记内容");
}

/***
 * 删除收藏笔记
 */
function deleteLikeNote(noteId,dom){
	alert("删除收藏笔记");
}

/***
 * 加载本用户参加活动笔记列表
 */
function getNoteActivityList(noteBookId){
	alert("加载本用户参加活动笔记列表");
}

/***
 * 查询参加活动的笔记内容
 */
function getActivityNoteDetail(noteId) {
	console.log("查询参加活动的笔记内容");
}