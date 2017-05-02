package com.tarena.web;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.tarena.entity.NoteBook;
import com.tarena.entity.Result;
import com.tarena.entity.User;
import com.tarena.service.NoteBookService;
import com.tarena.util.SystemConstant;
import com.tarena.util.TimestampEditor;

	@RequestMapping("/notebook")
	@Controller
	public class NoteBookController implements SystemConstant,WebBindingInitializer{
		
		@Resource
		private NoteBookService noteBookService;
		
		
		//查找普通笔记本
		@ResponseBody
		@RequestMapping("/findNormal.do")
		public Result findNormal(HttpSession session){
			
			User user=(User)session.getAttribute("user");
			List<NoteBook> list=noteBookService.findNormal(user.getCn_user_id());
			//{"success":true,"message":null,"data":[{},{},{}}
			return new Result(list);
		}
		
		//查找特殊笔记本
		@ResponseBody
		@RequestMapping("/findSpecial.do")
		public Result findSpecial(HttpSession session){
			User user=(User)session.getAttribute("user");
			List<NoteBook> list=noteBookService.findSpecial(user.getCn_user_id());
			//System.out.println(list);
			return new Result(list);
		}
		
		//添加普通笔记本
		@ResponseBody
		@RequestMapping("/addNormal.do")
		public Result addNormal(String noteBookName,HttpSession session){
			
			User user=(User)session.getAttribute("user");
			NoteBook noteBook=new NoteBook();
			noteBook =noteBookService.addNote(user.getCn_user_id(), noteBookName, NORMAL_TYPE_ID);
			return new Result(noteBook);
		}
		
		/*
		 * 参数noteBook用来接受页面传入的数据，该操作
		 * 是由SpringMVC自动处理的。
		 * 
		 * 实际上SpringMVC会将页面上所有的数据看字符串，
		 * 然后将字符串数据设置给notebook中的属性，若
		 * 实体类中的属性不是字符串，那么它需要将字符串
		 * 数据自动转换成属性类型再赋值
		 * 
		 * SpringMVC在自动转换时，会调用不同的类型的转换器
		 * 来处理转换，这些类型转换器都继承于PropertyEditorSupport
		 * ,并覆盖写该类的setAsTest
		 */
		
		//更新普通笔记本的名字
		@ResponseBody
		@RequestMapping("/updateNormal.do")
		public Result update(NoteBook noteBook){
			//System.out.println(123);
			noteBookService.update(noteBook);
			//System.out.println(456);
			return new Result();
		}
		
		
		
		
		@InitBinder
		public void initBinder(WebDataBinder binder, WebRequest request) {
			binder.registerCustomEditor(Timestamp.class,new TimestampEditor());
			
		}

		//删除笔记本
		@ResponseBody
		@RequestMapping("/deleteNormal.do")
		public Result delete(String noteBookId){
			noteBookService.delete(noteBookId);
			return new Result();
		}

			}
