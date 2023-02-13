package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppMob003tDto;
import com.actas.ems.Mapper.Elvlrt.App06ElvlrtMobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App06ElvlrtMobService")
public class App06ElvlrtMobService {

    @Autowired
    App06ElvlrtMobMapper app06ElvMobMapper;
    int queryResult = 1;

    /** view page **/
    public List<AppMob003tDto> GetApp06MobList001(App06ElvlrtDto parm){return app06ElvMobMapper.GetApp06MobList001(parm);}


}
