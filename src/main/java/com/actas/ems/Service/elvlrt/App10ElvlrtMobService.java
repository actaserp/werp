package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppMob001tDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMapper;
import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.*;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App10ElvlrtMobService")
public class App10ElvlrtMobService {

    @Autowired
    App10ElvlrtMobMapper app10ElvMobMapper;
    int queryResult = 1;


    /** view page **/
    public List<AppMob001tDto> GetAppMobList001(App10ElvlrtDto parm){return app10ElvMobMapper.GetAppMobList001(parm);}

    /** app03-05 view page **/
    public List<AppMob003tDto> GetApp06MobList001(App06ElvlrtDto parm){return app10ElvMobMapper.GetApp06MobList001(parm);}

    public List<AppMob004tDto> GetApp0bMobList001(App08_mbmanual parm){return app10ElvMobMapper.GetApp0bMobList001(parm);}
    public List<AppMob005tDto> GetApp28MobList001(App28ElvlrtDto parm){return app10ElvMobMapper.GetApp28MobList001(parm);}
    public List<AppMob005tDto> GetApp28MobList002(App28ElvlrtDto parm){return app10ElvMobMapper.GetApp28MobList002(parm);}


//    public List<AttachDTO> GetApp06MobList002(AttachDTO parm){

//        return app10ElvMobMapper.GetApp06MobList002(parm);
//    }

    /**박광열, 현장별고장부위(모바일), view page**/
    public List<App16ElvlrtDto> GetAppMobList_002(PopupDto parm) {return app10ElvMobMapper.GetAppMobList_002(parm);}

    /** 박광열, 직원정보조회(모바일)**/
    public List<App14ElvlrtDto> GetAppMobList_003(PopupDto parm) {return app10ElvMobMapper.GetAppMobList_003(parm);}

    /**박광열, 보수현장조회(모바일)*/
    public List<App26ElvlrtDto> GetAppMobListr_004(PopupDto parm){return app10ElvMobMapper.GetAppMobListr_004(parm);}


    /**박광열 고장이력(모바일)*/
    public List<App16ElvlrtDto> GetAppMobListr_005(PopupDto parm){return app10ElvMobMapper.GetAppMobListr_005(parm);}

    public List<App04ElvlrtDto> GetAppMobList_004(PopupDto parm) {return app10ElvMobMapper.GetAppMobList_004(parm);}

    public List<App04ElvlrtDto> GetAppMobList_e(PopupDto parm) {return app10ElvMobMapper.GetAppMobList_e(parm);}

    public List<App04ElvlrtDto> GetAppMobList_d(PopupDto parm) {return app10ElvMobMapper.GetAppMobList_d(parm);}

    public List<AttachDTO> GetMobThumbList_001(PopupDto parm) {return app10ElvMobMapper.GetMobThumbList_001(parm);}
}
