package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App13ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App13ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App13GaonMapper;
import com.actas.ems.Mapper.kyoung.App13KyoungMapper;
import com.actas.ems.Mapper.nm.App13NmyangMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App13ElvlrtService")
public class App13ElvlrtService {

    @Autowired
    App13ElvlrtMapper app13ElvlrtMapper;
    @Autowired
    App13GaonMapper app13ElvlrtMapperG;
    @Autowired
    App13KyoungMapper app13ElvlrtMapperK;
    @Autowired
    App13NmyangMapper app13ElvlrtMapperN;
    @Autowired
    App13ElvlrtMapper app13ElvlrtMapperH;

    /** 고장내용별현황/ 기간별 고장내용 */
    public List<App13ElvlrtDto> GetApp13List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app13ElvlrtMapper.GetApp13List001(parm);
            case "ELV_KYOUNG":
                return  app13ElvlrtMapperK.GetApp13List001(parm);
            case "ELV_GAON":
                return  app13ElvlrtMapperG.GetApp13List001(parm);
            case "nmyang":
                return  app13ElvlrtMapperN.GetApp13List001(parm);
            case "hanyangs":
                return  app13ElvlrtMapperH.GetApp13List001(parm);
            default:
                List<App13ElvlrtDto> object = null;
                return object;
        }
    }
//    { return app13ElvlrtMapper.GetApp13List001(parm);}

    /** 고정내용별현황 / 현장별 고장내용 */

    public List<App13ElvlrtDto> GetApp13List002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app13ElvlrtMapper.GetApp13List002(parm);
            case "ELV_KYOUNG":
                return  app13ElvlrtMapperK.GetApp13List002(parm);
            case "ELV_GAON":
                return  app13ElvlrtMapperG.GetApp13List002(parm);
            case "nmyang":
                return  app13ElvlrtMapperN.GetApp13List002(parm);
            case "hanyangs":
                return  app13ElvlrtMapperH.GetApp13List002(parm);
            default:
                List<App13ElvlrtDto> object = null;
                return object;
        }
    }
//    { return app13ElvlrtMapper.GetApp13List002(parm);}

    public List<App13ElvlrtDto> GetApp13List003(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app13ElvlrtMapper.GetApp13List003(parm);
            case "ELV_KYOUNG":
                return  app13ElvlrtMapperK.GetApp13List003(parm);
            case "ELV_GAON":
                return  app13ElvlrtMapperG.GetApp13List003(parm);
            case "nmyang":
                return  app13ElvlrtMapperN.GetApp13List003(parm);
            case "hanyangs":
                return  app13ElvlrtMapperH.GetApp13List003(parm);
            default:
                List<App13ElvlrtDto> object = null;
                return object;
        }
    }
//    { return app13ElvlrtMapper.GetApp13List003(parm);}

}
