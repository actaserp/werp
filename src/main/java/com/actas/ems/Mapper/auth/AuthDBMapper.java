package com.actas.ems.Mapper.auth;

import com.actas.ems.DTO.UserFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuthDBMapper {
    public void TBXUSERS_Insert(UserFormDto userinfo);    //입력
}
