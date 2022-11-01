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
    public String GetClientInfo(UserFormDto parm){return authMapper.GetClientInfo(parm);}
    public void UpdateDbInfo(UserFormDto parm){authMapper.UpdateDbInfo(parm);}


}
