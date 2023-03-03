package com.actas.ems.Service.elvlrt.App24;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.kyoung.App24KyoungMapper;
import com.actas.ems.Mapper.gaon.App24GaonMapper;
import com.actas.ems.Mapper.Elvlrt.App24ElvlrtMapper;
import com.actas.ems.Mapper.nm.App24NmyangMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App24ElvlrtService")
public class App24ElvlrtService {


    @Autowired
    App24ElvlrtMapper app24ElvlrtMapper;
    @Autowired
    App24GaonMapper app24ElvlrtMapperG;
    @Autowired
    App24KyoungMapper app24ElvlrtMapperK;
    @Autowired
    App24NmyangMapper app24ElvlrtMapperN;
    @Autowired
    App24GaonMapper app24ElvlrtMapperH;

    public List<App16ElvlrtDto> GetApp24List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app24ElvlrtMapper.GetApp24List001(parm);
            case "ELV_KYOUNG":
                return  app24ElvlrtMapperK.GetApp24List001(parm);
            case "ELV_GAON":
                return  app24ElvlrtMapperG.GetApp24List001(parm);
            case "nmyang":
                return  app24ElvlrtMapperN.GetApp24List001(parm);
            case "hanyangs":
                return  app24ElvlrtMapperH.GetApp24List001(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app24ElvlrtMapper.GetApp24List001(parm);}

    public List<App16ElvlrtDto> GetApp24List002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app24ElvlrtMapper.GetApp24List002(parm);
            case "ELV_KYOUNG":
                return  app24ElvlrtMapperK.GetApp24List002(parm);
            case "ELV_GAON":
                return  app24ElvlrtMapperG.GetApp24List002(parm);
            case "nmyang":
                return  app24ElvlrtMapperN.GetApp24List002(parm);
            case "hanyangs":
                return  app24ElvlrtMapperH.GetApp24List002(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app24ElvlrtMapper.GetApp24List002(parm);}
}
