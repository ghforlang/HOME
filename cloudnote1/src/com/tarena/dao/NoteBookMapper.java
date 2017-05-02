package com.tarena.dao;

import java.util.List;

import com.tarena.entity.NoteBook;

@MyBatisRepository
public interface NoteBookMapper {
       void save(NoteBook notoBook);
         //查询某用户所有的普通笔记本
       List<NoteBook> findNormal(String userId);
         //查询某用户所有的默认的四个笔记本
       List<NoteBook> findSpecial(String userId);
         //更新笔记本名字
        void update(NoteBook noteBook);
         //删除笔记本
        void delete(String noteBookId); 
         
}
