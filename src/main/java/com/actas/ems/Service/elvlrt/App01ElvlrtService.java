package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App01ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("App01ElvlrtService")
public class App01ElvlrtService {

    @Autowired
    App01ElvlrtMapper appMapper;
    public App01ElvlrtDto GetCallXenv(App01ElvlrtDto parm){return appMapper.GetCallXenv(parm);}





}
