package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS WHERE userid = #{userId}")
    User findById(Integer userId);

    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) VALUES (#{username}, #{salt}, #{password}, #{firstname}, #{lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    Integer insert(User user);

    @Delete("DELETE FROM USERS WHERE userid = #{id}")
    void delete(Integer id);
}
