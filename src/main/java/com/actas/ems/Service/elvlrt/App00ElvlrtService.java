package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App00ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App00ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App00GaonMapper;
import com.actas.ems.Mapper.kyoung.App00KyoungMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App00ElvlrtService")
public class App00ElvlrtService {


    @Autowired
    App00ElvlrtMapper app00ElvMapper;
    @Autowired
    App00GaonMapper app00ElvMapperG;
    @Autowired
    App00KyoungMapper app00ElvMapperK;
    @Autowired
    App00ElvlrtMapper app00ElvMapperN;
    @Autowired
    App00ElvlrtMapper app00ElvMapperH;

    /** 현장별월별통계, 기간별*/
    public List<App00ElvlrtDto> GetApp00List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app00ElvMapper.GetApp00List001(parm);
            case "ELV_GAON":
                return  app00ElvMapperG.GetApp00List001(parm);
            case "ELV_KYOUNG":
                return  app00ElvMapperK.GetApp00List001(parm);
            case "nmyang":
                return  app00ElvMapperN.GetApp00List001(parm);
            case "hanyangs":
                return  app00ElvMapperH.GetApp00List001(parm);
            default:
                List<App00ElvlrtDto> Object = null;
                return Object;
        }

    }
    //{ return app00ElvMapper.GetApp00List001(parm);}

}
