package com.tarena.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.entity.Note;
import com.tarena.entity.Result;
import com.tarena.entity.Share;
import com.tarena.service.ShareService;

@RequestMapping("/share")
@Controller
public class ShareController {
     
	@Resource
	ShareService shareService;
	
	@ResponseBody
	@RequestMapping("/insertshare.do")
	public Result saveShare(Note note){
		//System.out.println(123);
		shareService.saveShare(note);
		
		return new Result();
	}
	
	
	@ResponseBody
	@RequestMapping("/findshare.do")
	public Result findByKeyWords(String searchKey,int currentPage){
		
		List<Share> list=new ArrayList<Share>();
		list=shareService.findByKeyWords(searchKey,currentPage);
		//System.out.println(123);
		return new Result(list);
	}
}
