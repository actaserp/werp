package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.AppCallElvlrtDto;
import com.actas.ems.Mapper.SmsMcs.AppSmsMcsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AppSmsMcsService {
    @Autowired
    AppSmsMcsMapper appMapper;
    public int InsertShortSms(AppCallElvlrtDto parm){return appMapper.InsertShortSms(parm);}
    public int InsertLongSms(AppCallElvlrtDto parm){return appMapper.InsertShortSms(parm);}

}
