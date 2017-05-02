package com.tarena.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.entity.Note;
import com.tarena.entity.Result;
import com.tarena.entity.User;
import com.tarena.service.NoteService;

@RequestMapping("/note")
@Controller
  public class NoteController {
     
	@Resource
	private NoteService noteService;
	
	@ResponseBody
	@RequestMapping("/findnote.do")
	public Result findNote(String noteBookId){
		//System.out.println(1);
		List<Note> list=new ArrayList<Note>();
		//System.out.println(2);
		list=noteService.findNote(noteBookId);
		//System.out.println(3);
		return new Result(list);
		
	}
	
	@ResponseBody
	@RequestMapping("/addnote.do")
	public Result addNote(String noteTitle,String noteBookId,HttpSession session){
		User user=new User();
		user=(User)session.getAttribute("user");
		String userId=user.getCn_user_id();
		Note note=noteService.addNote(noteTitle, noteBookId, userId);
		return new Result(note);
	}
	
	@ResponseBody
	@RequestMapping("/deletenote.do")
	public Result deleteNote(String noteId){
		noteService.deleteNote(noteId);
		return new Result();
	}
	
	
	@ResponseBody
	@RequestMapping("/updatenote.do")
	public Result updateNote(String noteId,String noteBookId){
		Note n=noteService.updateNote(noteId, noteBookId);
		//System.out.println(n);
		return new Result(n);
	}
	
	@ResponseBody
	@RequestMapping("/update.do")
	public Result update(Note note){
		noteService.update(note);
		return new Result();
	}
	
	
	@ResponseBody
	@RequestMapping("/addlike.do")
	public Result addLike(String shareTitle,String shareBody,String noteBookId,HttpSession session){
		User user=(User)session.getAttribute("user");
		String userId=user.getCn_user_id();
		noteService.addlike(shareTitle, shareBody, noteBookId, userId);
		return new Result();
	}
	
     }
