package com.actas.ems.Mapper.master;

import com.actas.ems.DTO.UserFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuthDBMapper {
    public void TBXUSERS_Insert(UserFormDto userinfo);
    public UserFormDto GetUserInfo(UserFormDto userinfo);
    public String GetClientInfo(UserFormDto userinfo);
    public void UpdateDbInfo(UserFormDto userinfo);

}
