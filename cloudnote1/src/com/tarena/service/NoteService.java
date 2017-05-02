package com.tarena.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.dao.NoteBookMapper;
import com.tarena.dao.NoteMapper;
import com.tarena.entity.Note;
import com.tarena.entity.NoteBook;


@Service
public class NoteService {
       @Resource
	    private NoteMapper noteMapper;
         
       @Resource
       private NoteBookMapper noteBookMapper;
       
       public List<Note> findNote(String noteBookId){
    	   List<Note> list=new ArrayList<Note>();
    	   if(noteBookId==null){
    		   throw new RuntimeException("参数不能为空");
    	   }
    	   list=noteMapper.findNoteBynoteBookId(noteBookId);
    	   return list;
       }
       
       
       public Note addNote(String noteTitle,String noteBookId,String userId){
    	    
    	   if(noteTitle==""||noteBookId==""||userId==""){
    		   throw new RuntimeException("参数不能为空");
    	   }
    	   Note note=new Note();
    	   
    	   note.setCn_note_id(UUID.randomUUID().toString());
    	   note.setCn_notebook_id(noteBookId);
    	   note.setCn_user_id(userId);
    	   note.setCn_note_title(noteTitle);
    	   note.setCn_note_create_time(System.currentTimeMillis());
    	   note.setCn_note_modify_time(System.currentTimeMillis());
 
    	   noteMapper.saveNote(note);
    	   
    	   return note;
       }
       
         //删除
       public  void deleteNote(String noteId){
    	   
    	   if(noteId==""){
    		   throw new RuntimeException("参数不能为空");
    	   }
    	   
    	   noteMapper.deleteNote(noteId);
    	   
       }
       
       
       
       public Note updateNote(String noteId,String noteBookId){
    	    
    	   Note note=new Note();
    	   note=noteMapper.findByNoteId(noteId);
    	   note.setCn_note_modify_time(System.currentTimeMillis());
    	   note.setCn_notebook_id(noteBookId);
    	   noteMapper.updateNote(note);
    	   
    	   return note;
       }
       
       public void update(Note note){
    	   note.setCn_note_modify_time(System.currentTimeMillis());
    	   noteMapper.updateNote(note);
       }
       
       
       public void addlike(String shareTitle,String shareBody,String noteBookId,String userId){
    	   Note note=new Note();
    	   note.setCn_note_id(UUID.randomUUID().toString());
    	   note.setCn_notebook_id(noteBookId);
    	   note.setCn_user_id(userId);
    	   note.setCn_note_title(shareTitle);
    	   note.setCn_note_body(shareBody);
    	   note.setCn_note_create_time(System.currentTimeMillis());
    	   note.setCn_note_modify_time(System.currentTimeMillis());
    	   noteMapper.saveNote(note);
       }
       
       
}
