package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.entity.Credential;
import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialMapper {

    @Select("SELECT * FROM CREDENTIALS")
    List<Credential> findAll();

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{id}")
    Credential findById(Integer id);

    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{id}")
    Credential findByUserId(Integer id);

    @Insert("INSERT INTO CREDENTIALS(url, username, key, password, userid) VALUES (#{url}, #{username}, #{key}, #{password}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialid")
    Integer insert(Credential credential);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialid=#{id}")
    void delete(Integer id);

    @Update("UPDATE CREDENTIALS SET url=#{url}, username=#{username}, key=#{key},password=#{password} WHERE credentialId = #{credentialId}")
    void update(Credential credential);

}
