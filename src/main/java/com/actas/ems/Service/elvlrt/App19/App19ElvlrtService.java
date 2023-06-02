package com.actas.ems.Service.elvlrt.App19;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.kyoung.App19KyoungMapper;
import com.actas.ems.Mapper.gaon.App19GaonMapper;
import com.actas.ems.Mapper.Elvlrt.App19ElvlrtMapper;
import com.actas.ems.Mapper.nm.App19NmyangMapper;
import com.actas.ems.Mapper.samjung.App16SamMapper;
import com.actas.ems.Mapper.samjung.App19SamMapper;
import com.actas.ems.Mapper.sjilsan.App16SjilsanMapper;
import com.actas.ems.Mapper.sjilsan.App19SjilsanMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service("App19ElvlrtService")
public class App19ElvlrtService {

    @Autowired
    App19ElvlrtMapper app19ElvlrtMapper;
    @Autowired
    App19GaonMapper app19ElvlrtMapperG;
    @Autowired
    App19KyoungMapper app19ElvlrtMapperK;
    @Autowired
    App19NmyangMapper app19ElvlrtMapperN;
    @Autowired
    App19GaonMapper app19ElvlrtMapperH;
    @Autowired
    App19SamMapper app19ElvlrtMapperS;
    @Autowired
    App19SjilsanMapper app19ElvlrtMapperSj;

    /**기간별*/
    public List<App16ElvlrtDto> GetApp19List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app19ElvlrtMapper.GetApp19List001(parm);
            case "ELV_KYOUNG":
                return  app19ElvlrtMapperK.GetApp19List001(parm);
            case "ELV_GAON":
                return  app19ElvlrtMapperG.GetApp19List001(parm);
            case "nmyang":
                return  app19ElvlrtMapperN.GetApp19List001(parm);
            case "hanyangs":
                return  app19ElvlrtMapperH.GetApp19List001(parm);
            case "samjung":
                return  app19ElvlrtMapperS.GetApp19List001(parm);
            case "samjungilsan":
                return  app19ElvlrtMapperSj.GetApp19List001(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app19ElvlrtMapper.GetApp19List001(parm);}

    /** 현장별 고장내용, 막대그래프*/
    public List<App16ElvlrtDto> GetApp19List002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app19ElvlrtMapper.GetApp19List002(parm);
            case "ELV_KYOUNG":
                return  app19ElvlrtMapperK.GetApp19List002(parm);
            case "ELV_GAON":
                return  app19ElvlrtMapperG.GetApp19List002(parm);
            case "nmyang":
                return  app19ElvlrtMapperN.GetApp19List002(parm);
            case "hanyangs":
                return  app19ElvlrtMapperH.GetApp19List002(parm);
            case "samjung":
                return  app19ElvlrtMapperS.GetApp19List002(parm);
            case "samjungilsan":
                return  app19ElvlrtMapperSj.GetApp19List002(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app19ElvlrtMapper.GetApp19List002(parm);}
}
