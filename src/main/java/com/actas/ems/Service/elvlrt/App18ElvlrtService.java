package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App18ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App18ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App18GaonMapper;
import com.actas.ems.Mapper.kyoung.App18KyoungMapper;
import com.actas.ems.Mapper.nm.App18NmyangMapper;
import com.actas.ems.Mapper.samjung.App14SamMapper;
import com.actas.ems.Mapper.samjung.App18SamMapper;
import com.actas.ems.Mapper.sjilsan.App14SjilsanMapper;
import com.actas.ems.Mapper.sjilsan.App18SjilsanMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App18ElvlrtService")
public class App18ElvlrtService {

    @Autowired
    App18ElvlrtMapper app18ElvMapper;
    @Autowired
    App18GaonMapper app18ElvMapperG;
    @Autowired
    App18KyoungMapper app18ElvMapperK;
    @Autowired
    App18NmyangMapper app18ElvMapperN;
    @Autowired
    App18ElvlrtMapper app18ElvMapperH;
    @Autowired
    App18SamMapper app18ElvMapperS;
    @Autowired
    App18SjilsanMapper app18ElvMapperSj;

    public List<App18ElvlrtDto> GetApp18List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app18ElvMapper.GetApp18List001(parm);
            case "ELV_KYOUNG":
                return  app18ElvMapperK.GetApp18List001(parm);
            case "ELV_GAON":
                return  app18ElvMapperG.GetApp18List001(parm);
            case "nmyang":
                return  app18ElvMapperN.GetApp18List001(parm);
            case "hanyangs":
                return  app18ElvMapperH.GetApp18List001(parm);
            case "samjung":
                return  app18ElvMapperS.GetApp18List001(parm);
            case "samjungilsan":
                return  app18ElvMapperSj.GetApp18List001(parm);
            default:
                List<App18ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app18ElvMapper.GetApp18List001(parm);}



}
