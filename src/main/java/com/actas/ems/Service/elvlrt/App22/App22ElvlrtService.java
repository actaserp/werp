package com.actas.ems.Service.elvlrt.App22;

import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.kyoung.App22KyoungMapper;
import com.actas.ems.Mapper.gaon.App22GaonMapper;
import com.actas.ems.Mapper.Elvlrt.App22ElvlrtMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App22ElvlrtService")
public class App22ElvlrtService {


    @Autowired
    App22ElvlrtMapper app22ElvlrtMapper;
    @Autowired
    App22GaonMapper app22ElvlrtMapperG;
    @Autowired
    App22KyoungMapper app22ElvlrtMapperK;
    @Autowired
    App22GaonMapper app22ElvlrtMapperN;
    @Autowired
    App22GaonMapper app22ElvlrtMapperH;

    public List<App16ElvlrtDto> GetApp22List(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app22ElvlrtMapper.GetApp22List001(parm);
            case "ELV_KYOUNG":
                return  app22ElvlrtMapperK.GetApp22List001(parm);
            case "ELV_GAON":
                return  app22ElvlrtMapperG.GetApp22List001(parm);
            case "nmyang":
                return  app22ElvlrtMapperN.GetApp22List001(parm);
            case "hanyangs":
                return  app22ElvlrtMapperH.GetApp22List001(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app22ElvlrtMapper.GetApp22List001(parm);}

    public List<App16ElvlrtDto> GetApp22List002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app22ElvlrtMapper.GetApp22List002(parm);
            case "ELV_KYOUNG":
                return  app22ElvlrtMapperK.GetApp22List002(parm);
            case "ELV_GAON":
                return  app22ElvlrtMapperG.GetApp22List002(parm);
            case "nmyang":
                return  app22ElvlrtMapperN.GetApp22List002(parm);
            case "hanyangs":
                return  app22ElvlrtMapperH.GetApp22List002(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app22ElvlrtMapper.GetApp22List002(parm);}


}
