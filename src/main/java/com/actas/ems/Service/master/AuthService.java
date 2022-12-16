package com.actas.ems.Service.master;

import com.actas.ems.Mapper.master.AuthDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.actas.ems.DTO.UserFormDto;

@RequiredArgsConstructor
@Service("AuthService")
public class AuthService {
    @Autowired
    AuthDBMapper authMapper;

    public void authInsert(UserFormDto parm){authMapper.TBXUSERS_Insert(parm);}
    public UserFormDto GetUserInfo(UserFormDto parm){return authMapper.GetUserInfo(parm);}
    public UserFormDto GetUserInfoDto(UserFormDto parm){return authMapper.GetUserInfoDto(parm);}

    public String GetClientInfo(UserFormDto parm){return authMapper.GetClientInfo(parm);}
    public String GetClientInfoName(UserFormDto parm){return authMapper.GetClientInfoName(parm);}

    public void UpdateDbInfo(UserFormDto parm){authMapper.UpdateDbInfo(parm);}

    public String TB_XUSER_DUPCHK(UserFormDto parm){
        return authMapper.TB_XUSER_DUPCHK(parm);
    }

    public String TB_XUSER_PHDUPCHK(UserFormDto parm){
        return authMapper.TB_XUSER_PHDUPCHK(parm);
    }
    public String TB_XCLIENT_SELECT(UserFormDto parm){
        return authMapper.TB_XCLIENT_SELECT(parm);
    }

    public void TB_XLOGIN_INSERT(UserFormDto parm) { authMapper.TB_XLOGIN_INSERT(parm);}

    public void TB_XUSERS_LOGFAIL(UserFormDto parm) { authMapper.TB_XUSERS_LOGFAIL(parm);}

    public void TB_XUSERS_LOGSUCC(UserFormDto parm) { authMapper.TB_XUSERS_LOGSUCC(parm);}
}
