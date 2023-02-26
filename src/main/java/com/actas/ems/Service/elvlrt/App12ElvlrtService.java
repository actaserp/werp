package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App12ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App12ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App12GaonMapper;
import com.actas.ems.Mapper.kyoung.App12KyoungMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App12ElvlrtService")
public class App12ElvlrtService {

    @Autowired
    App12ElvlrtMapper app12ElvMapper;
    @Autowired
    App12GaonMapper app12ElvMapperG;
    @Autowired
    App12KyoungMapper app12ElvMapperK;
    @Autowired
    App12ElvlrtMapper app12ElvMapperN;
    @Autowired
    App12ElvlrtMapper app12ElvMapperH;

    /** 고장내용별현황 / 기간별 고장내용 */
    public List<App12ElvlrtDto> GetApp12List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app12ElvMapper.GetApp12List001(parm);
            case "ELV_KYOUNG":
                return  app12ElvMapperK.GetApp12List001(parm);
            case "ELV_GAON":
                return  app12ElvMapperG.GetApp12List001(parm);
            case "nmyang":
                return  app12ElvMapperN.GetApp12List001(parm);
            case "hanyangs":
                return  app12ElvMapperH.GetApp12List001(parm);
            default:
                List<App12ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app12ElvMapper.GetApp12List001(parm);}
    /** 고장내용별현황 / 현장별 고장내용 */
    public List<App12ElvlrtDto> GetApp12List002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app12ElvMapper.GetApp12List002(parm);
            case "ELV_KYOUNG":
                return  app12ElvMapperK.GetApp12List002(parm);
            case "ELV_GAON":
                return  app12ElvMapperG.GetApp12List002(parm);
            case "nmyang":
                return  app12ElvMapperN.GetApp12List002(parm);
            case "hanyangs":
                return  app12ElvMapperH.GetApp12List002(parm);
            default:
                List<App12ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app12ElvMapper.GetApp12List002(parm);}
    /** 고장내용별현황 / 호기별 고장내용 */
    public List<App12ElvlrtDto> GetApp12List003(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app12ElvMapper.GetApp12List003(parm);
            case "ELV_KYOUNG":
                return  app12ElvMapperK.GetApp12List003(parm);
            case "ELV_GAON":
                return  app12ElvMapperG.GetApp12List003(parm);
            case "nmyang":
                return  app12ElvMapperN.GetApp12List003(parm);
            case "hanyangs":
                return  app12ElvMapperH.GetApp12List003(parm);
            default:
                List<App12ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app12ElvMapper.GetApp12List003(parm);}



}
