package com.actas.ems.Service.elvlrt.App16;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.kyoung.App16KyoungMapper;
import com.actas.ems.Mapper.gaon.App16GaonMapper;
import com.actas.ems.Mapper.Elvlrt.App16ElvlrtMapper;
import com.actas.ems.Mapper.nm.App16NmyangMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App16ElvlrtService")
public class App16ElvlrtService {

    @Autowired
    App16ElvlrtMapper app16ElvlrtMapper;
    @Autowired
    App16GaonMapper app16ElvlrtMapperG;
    @Autowired
    App16KyoungMapper app16ElvlrtMapperK;
    @Autowired
    App16NmyangMapper app16ElvlrtMapperN;
    @Autowired
    App16GaonMapper app16ElvlrtMapperH;

    public List<App16ElvlrtDto> GetApp16List(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app16ElvlrtMapper.GetApp16List001(parm);
            case "ELV_KYOUNG":
                return  app16ElvlrtMapperK.GetApp16List001(parm);
            case "ELV_GAON":
                return  app16ElvlrtMapperG.GetApp16List001(parm);
            case "nmyang":
                return  app16ElvlrtMapperN.GetApp16List001(parm);
            case "hanyangs":
                return  app16ElvlrtMapperH.GetApp16List001(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app16ElvlrtMapper.GetApp16List001(parm);}
}
