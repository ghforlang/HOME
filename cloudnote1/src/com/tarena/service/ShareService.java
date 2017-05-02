package com.tarena.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.dao.ShareMapper;
import com.tarena.entity.Note;
import com.tarena.entity.Share;
import com.tarena.util.SystemConstant;

@Service
public class ShareService implements SystemConstant{
	
	@Resource
	private ShareMapper shareMapper;
	
	public void saveShare(Note note){
		
		Share share=new Share();
		share.setCn_share_id(UUID.randomUUID().toString());
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		share.setCn_note_id(note.getCn_note_id());
		shareMapper.saveShare(share);
	}
	
	public List<Share> findByKeyWords(String searchKey,int currentPage){
		
		if(searchKey==null||searchKey.length()==0){
			return null;
		}
		
		int begin=(currentPage-1)*PAGE_SIZE;
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("searchKey", searchKey);
		map.put("begin", begin);
	   map.put("pageSize",PAGE_SIZE);
		return shareMapper.findByPage(map);
		
	}
	

}
