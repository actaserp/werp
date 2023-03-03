package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App23ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App23ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App23GaonMapper;
import com.actas.ems.Mapper.kyoung.App23KyoungMapper;
import com.actas.ems.Mapper.nm.App23NmyangMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App23ElvlrtService")
public class App23ElvlrtService {

    @Autowired
    App23ElvlrtMapper app23ElvMapper;
    @Autowired
    App23GaonMapper app23ElvMapperG;
    @Autowired
    App23KyoungMapper app23ElvMapperK;
    @Autowired
    App23NmyangMapper app23ElvMapperN;
    @Autowired
    App23ElvlrtMapper app23ElvMapperH;

    public List<App23ElvlrtDto> GetApp23List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app23ElvMapper.GetApp23List001(parm);
            case "ELV_KYOUNG":
                return  app23ElvMapperK.GetApp23List001(parm);
            case "ELV_GAON":
                return  app23ElvMapperG.GetApp23List001(parm);
            case "nmyang":
                return  app23ElvMapperN.GetApp23List001(parm);
            case "hanyangs":
                return  app23ElvMapperH.GetApp23List001(parm);
            default:
                List<App23ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app23ElvMapper.GetApp23List001(parm);}

    public List<App23ElvlrtDto> GetApp23List002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app23ElvMapper.GetApp23List002(parm);
            case "ELV_KYOUNG":
                return  app23ElvMapperK.GetApp23List002(parm);
            case "ELV_GAON":
                return  app23ElvMapperG.GetApp23List002(parm);
            case "nmyang":
                return  app23ElvMapperN.GetApp23List002(parm);
            case "hanyangs":
                return  app23ElvMapperH.GetApp23List002(parm);
            default:
                List<App23ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app23ElvMapper.GetApp23List002(parm);}



}
