package com.actas.ems.Service.auth;

import com.actas.ems.Mapper.auth.AuthDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.actas.ems.DTO.UserFormDto;

@RequiredArgsConstructor
@Service("AuthService")
public class AuthService {
    private  AuthDBMapper authMapper;

    public void authInsert(UserFormDto parm){authMapper.TBXUSERS_Insert(parm);}

}
