package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppMob001tDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMapper;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service("App10ElvlrtMobService")
public class App10ElvlrtMobService {

    @Autowired
    App10ElvlrtMobMapper app10ElvMobMapper;
    int queryResult = 1;


    /** view page **/
    public List<AppMob001tDto> GetAppMobList001(App10ElvlrtDto parm){return app10ElvMobMapper.GetAppMobList001(parm);}

    public List<AppMob003tDto> GetApp06MobList001(App06ElvlrtDto parm){return app10ElvMobMapper.GetApp06MobList001(parm);}

    /**박광열, 현장별고장부위(모바일), view page**/
    public List<App16ElvlrtDto> GetAppMobList_002(PopupDto parm) {return app10ElvMobMapper.GetAppMobList_002(parm);}


}
