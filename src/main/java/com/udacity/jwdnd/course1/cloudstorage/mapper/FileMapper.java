package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES")
    List<File> findAll();


    @Select("SELECT * FROM FILES WHERE fileId=#{id}")
    File findById(Integer id);

    @Select("SELECT * FROM FILES WHERE userid=#{userId}")
    List<File> findByUserId(Integer userId);


    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) "+
            " VALUES (#{fileName}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    Integer insert(File file);


    @Delete("DELETE FROM FILES WHERE fileId=#{id}")
    void delete(Integer id);


}
