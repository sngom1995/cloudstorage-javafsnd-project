package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES")
    List<Note> findAll();

    @Select("SELECT * FROM NOTES WHERE noteid = #{id}")
    Note findById(Integer id);


    @Select("SELECT * FROM  NOTES WHERE userid = #{userId}")
    List<Note> findByUserId(Integer userId);


    @Insert("INSERT INTO NOTES (notetitle, notedescription,userid) VALUES (#{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    Integer insert(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{id}")
    void delete(Integer id);

    @Update("UPDATE NOTES SET notetitle = #{noteTitle}, notedescription = #{noteDescription} WHERE noteid = #{noteId}")
    void update(Note note);

}
