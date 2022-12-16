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
    public UserFormDto GetUserInfoDto(UserFormDto userinfo);

    public String GetClientInfo(UserFormDto userinfo);
    public String GetClientInfoName(UserFormDto userinfo);

    public void UpdateDbInfo(UserFormDto userinfo);

    public String TB_XUSER_DUPCHK(UserFormDto PARM);

    public String TB_XUSER_PHDUPCHK(UserFormDto PARM);

    public String TB_XCLIENT_SELECT(UserFormDto PARM);

    public void TB_XLOGIN_INSERT(UserFormDto PARM);


}
