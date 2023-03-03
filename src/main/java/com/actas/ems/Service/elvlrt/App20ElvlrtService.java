package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App20ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App20ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App20GaonMapper;
import com.actas.ems.Mapper.kyoung.App20KyoungMapper;
import com.actas.ems.Mapper.nm.App20NmyangMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App20ElvlrtService")
public class App20ElvlrtService {

    @Autowired
    App20ElvlrtMapper app20ElvMapper;
    @Autowired
    App20GaonMapper app20ElvMapperG;
    @Autowired
    App20KyoungMapper app20ElvMapperK;
    @Autowired
    App20NmyangMapper app20ElvMapperN;
    @Autowired
    App20ElvlrtMapper app20ElvMapperH;

    public List<App20ElvlrtDto> GetApp20List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app20ElvMapper.GetApp20List001(parm);
            case "ELV_KYOUNG":
                return  app20ElvMapperK.GetApp20List001(parm);
            case "ELV_GAON":
                return  app20ElvMapperG.GetApp20List001(parm);
            case "nmyang":
                return  app20ElvMapperN.GetApp20List001(parm);
            case "hanyangs":
                return  app20ElvMapperH.GetApp20List001(parm);
            default:
                List<App20ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app20ElvMapper.GetApp20List001(parm);}



}
