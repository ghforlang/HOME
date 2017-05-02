package com.tarena.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tarena.dao.NoteBookMapper;
import com.tarena.entity.NoteBook;

@Service
public class NoteBookService {
     @Resource
      private NoteBookMapper noteBookMapper; 
     
     private Logger logger=Logger.getLogger(NoteBookService.class);
     
       //普通笔记本
     public List<NoteBook> findNormal(String userId){
    	
    	 if(userId==""){
    		 throw new RuntimeException("用户Id不能为空");
    	 }
    	 
    	 List<NoteBook> list=new ArrayList<NoteBook>();
    	 
    	 list=noteBookMapper.findNormal(userId);
    	 
    	 return list;
     }
     
     
     //特殊笔记本
     public List<NoteBook> findSpecial(String userId){
    	 
    	 if(userId==""){
    		 throw new RuntimeException("用户Id不能为空");
    	 }
    	 
    	 List<NoteBook> list=new ArrayList<NoteBook>();
    	 
    	 list=noteBookMapper.findSpecial(userId);
    	 
    	 return list;
     }
       
       //添加笔记本
     public NoteBook addNote(String userId,String noteBookName,String noteBookTypeId){
    	 
    	 if(userId==null||noteBookName==null||noteBookTypeId==null){
    		 throw new RuntimeException("参数不能为空");
    	 }
    	 
    	 NoteBook n=new NoteBook();
    	 n.setCn_notebook_id(UUID.randomUUID().toString());
    	 n.setCn_user_id(userId);
    	 n.setCn_notebook_name(noteBookName);
    	 n.setCn_notebook_type_id(noteBookTypeId);
    	 n.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
    	 noteBookMapper.save(n);
    	 return n;
    	 
     }
     
      //修改笔记本的名字
     public void update(NoteBook noteBook){
    	 
    	 if(noteBook==null){
    		 throw new RuntimeException("参数不能为空"); 
    	 }
    	 
    	 noteBookMapper.update(noteBook);
    	  
     }
       //删除笔记本
     public void delete(String noteBookId){
    	 if(noteBookId==""){
    		 throw new RuntimeException("参数不能为空");
    	 }
    	 
    	 noteBookMapper.delete(noteBookId);
     }
}
