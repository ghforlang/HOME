package com.tarena.dao;

import java.util.List;
import com.tarena.entity.Note;

@MyBatisRepository
public interface NoteMapper {
    //加载笔记 
	List<Note> findNoteBynoteBookId(String noteBookId);
	
	//添加笔记
	void saveNote(Note note);
	
	//删除笔记
	void deleteNote(String noteId);
	
	//修改笔记
	void updateNote(Note note);
	
	Note findByNoteId(String noteId);
	
}
