package com.actas.ems.Mapper.master;

import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.TBXLoginDTO;
import com.actas.ems.DTO.TBXuserMenuDTO;
import com.actas.ems.DTO.UserFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuthDBMapper {
    public void TBXUSERS_Insert(UserFormDto userinfo);
    public UserFormDto GetUserInfo(UserFormDto userinfo);
    public UserFormDto GetUserInfoDto2(UserFormDto userinfo);

    public UserFormDto GetCustInfo(UserFormDto userinfo);
    public UserFormDto GetAdminInfo(UserFormDto userinfo);

    public UserFormDto GetUserInfoDto(UserFormDto userinfo);

    public String GetClientInfo(UserFormDto userinfo);
    public String GetClientInfoName(UserFormDto userinfo);

    public void UpdateDbInfo(UserFormDto userinfo);

    public String TB_XUSER_DUPCHK(UserFormDto PARM);

    public String TB_XUSER_PHDUPCHK(UserFormDto PARM);

    public String TB_XCLIENT_SELECT(UserFormDto PARM);
    public String TB_XUSER_DBNM(UserFormDto parm);

    public void TB_XLOGIN_INSERT(UserFormDto PARM);
    public void TB_XLOGOUT_INSERT(UserFormDto PARM);

    public void TB_XUSERS_LOGFAIL(UserFormDto Parm);

    public void TB_XUSERS_LOGSUCC(UserFormDto Parm);

    public void TB_XUSER_UPDATE(UserFormDto Parm);


    public List<UserFormDto> GetUserListDto(UserFormDto userinfo);
    public List<TBXLoginDTO> GetLogListDto(UserFormDto userinfo);
    public List<TBXuserMenuDTO> GetXusersMenuList(TBXuserMenuDTO Parm);
    public List<TBXuserMenuDTO> GetXMenuList(TBXuserMenuDTO Parm);

    public int UpdateUserInfo(UserFormDto Parm);
    public int UpdateUserMenuInfo(TBXuserMenuDTO Parm);

    public int Updatepushid(UserFormDto Parm);




}
