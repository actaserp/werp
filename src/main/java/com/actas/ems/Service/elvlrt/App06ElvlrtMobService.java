package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppMob003tDto;
import com.actas.ems.Mapper.Elvlrt.App06ElvlrtMobMapper;
import com.actas.ems.Mapper.gaon.App06GaonMobMapper;
import com.actas.ems.Mapper.kyoung.App06KyoungMobMapper;
import com.actas.ems.Mapper.nm.App06NmyangMobMapper;
import com.actas.ems.Mapper.samjung.App06SamMobMapper;
import com.actas.ems.Mapper.sjilsan.App06SjilsanMobMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App06ElvlrtMobService")
public class App06ElvlrtMobService {

    @Autowired
    App06ElvlrtMobMapper app06ElvMobMapper;
    @Autowired
    App06GaonMobMapper app06ElvMobMapperG;
    @Autowired
    App06KyoungMobMapper app06ElvMobMapperK;
    @Autowired
    App06NmyangMobMapper app06ElvMobMapperN;
    @Autowired
    App06ElvlrtMobMapper app06ElvMobMapperH;
    @Autowired
    App06SamMobMapper app06ElvMobMapperS;
    @Autowired
    App06SjilsanMobMapper app06ElvMobMapperSj;
    int queryResult = 1;

    /** view page **/
    public List<AppMob003tDto> GetApp06MobList001(App06ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app06ElvMobMapper.GetApp06MobList001(parm);
            case "ELV_KYOUNG":
                return  app06ElvMobMapperK.GetApp06MobList001(parm);
            case "ELV_GAON":
                return  app06ElvMobMapperG.GetApp06MobList001(parm);
            case "nmyang":
                return  app06ElvMobMapperN.GetApp06MobList001(parm);
            case "hanyangs":
                return  app06ElvMobMapperH.GetApp06MobList001(parm);
            case "samjung":
                return  app06ElvMobMapperS.GetApp06MobList001(parm);
            case "samjungilsan":
                return  app06ElvMobMapperSj.GetApp06MobList001(parm);
            default:
                break;
        }
        List<AppMob003tDto> Object = null;
        return Object;
    }
//    {return app06ElvMobMapper.GetApp06MobList001(parm);}


}
