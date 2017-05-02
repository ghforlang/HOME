package com.tarena.dao;

import java.util.List;
import java.util.Map;

import com.tarena.entity.Share;


@MyBatisRepository
public interface ShareMapper {
    
	void saveShare(Share share);
	
	List<Share> findByKeyWords(String keyWords);
	
	//Share findByNoteId(String noteId);
	
	//void update(Share share);
	List<Share> findByPage(Map<String,Object> param);
}
