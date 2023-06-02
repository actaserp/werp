package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App14ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App14ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App14GaonMapper;
import com.actas.ems.Mapper.kyoung.App14KyoungMapper;
import com.actas.ems.Mapper.nm.App14NmyangMapper;
import com.actas.ems.Mapper.samjung.App12SamMapper;
import com.actas.ems.Mapper.samjung.App14SamMapper;
import com.actas.ems.Mapper.sjilsan.App12SjilsanMapper;
import com.actas.ems.Mapper.sjilsan.App14SjilsanMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App14ElvlrtService")
public class App14ElvlrtService {

    @Autowired
    App14ElvlrtMapper app14ElvMapper;
    @Autowired
    App14GaonMapper app14ElvMapperG;
    @Autowired
    App14KyoungMapper app14ElvMapperK;
    @Autowired
    App14NmyangMapper app14ElvMapperN;
    @Autowired
    App14ElvlrtMapper app14ElvMapperH;
    @Autowired
    App14SamMapper app14ElvMapperS;
    @Autowired
    App14SjilsanMapper app14ElvMapperSj;

    /** 사원 목록 출력 */
    public List<App14ElvlrtDto> GetApp14List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app14ElvMapper.GetApp14List001(parm);
            case "ELV_KYOUNG":
                return  app14ElvMapperK.GetApp14List001(parm);
            case "ELV_GAON":
                return  app14ElvMapperG.GetApp14List001(parm);
            case "nmyang":
                return  app14ElvMapperN.GetApp14List001(parm);
            case "hanyangs":
                return  app14ElvMapperH.GetApp14List001(parm);
            case "samjung":
                return  app14ElvMapperS.GetApp14List001(parm);
            case "samjungilsan":
                return  app14ElvMapperSj.GetApp14List001(parm);
            default:
                List<App14ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app14ElvMapper.GetApp14List001(parm);}


}
