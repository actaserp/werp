package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App26ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App26ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App26GaonMapper;
import com.actas.ems.Mapper.kyoung.App26KyoungMapper;
import com.actas.ems.Mapper.nm.App26NmyangMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App26ElvlrtService")
public class App26ElvlrtService {

    @Autowired
    App26ElvlrtMapper app26ElvMapper;
    @Autowired
    App26GaonMapper app26ElvMapperG;
    @Autowired
    App26KyoungMapper app26ElvMapperK;
    @Autowired
    App26NmyangMapper app26ElvMapperN;
    @Autowired
    App26ElvlrtMapper app26ElvMapperH;

    public List<App26ElvlrtDto> GetApp26List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app26ElvMapper.GetApp26List001(parm);
            case "ELV_KYOUNG":
                return  app26ElvMapperK.GetApp26List001(parm);
            case "ELV_GAON":
                return  app26ElvMapperG.GetApp26List001(parm);
            case "nmyang":
                return  app26ElvMapperN.GetApp26List001(parm);
            case "hanyangs":
                return  app26ElvMapperH.GetApp26List001(parm);
            default:
                List<App26ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app26ElvMapper.GetApp26List001(parm);}

    public List<App26ElvlrtDto> GetApp26List002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app26ElvMapper.GetApp26List002(parm);
            case "ELV_KYOUNG":
                return  app26ElvMapperK.GetApp26List002(parm);
            case "ELV_GAON":
                return  app26ElvMapperG.GetApp26List002(parm);
            case "nmyang":
                return  app26ElvMapperN.GetApp26List002(parm);
            case "hanyangs":
                return  app26ElvMapperH.GetApp26List002(parm);
            default:
                List<App26ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app26ElvMapper.GetApp26List002(parm);}

    public List<App26ElvlrtDto> GetApp26List003(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app26ElvMapper.GetApp26List003(parm);
            case "ELV_KYOUNG":
                return  app26ElvMapperK.GetApp26List003(parm);
            case "ELV_GAON":
                return  app26ElvMapperG.GetApp26List003(parm);
            case "nmyang":
                return  app26ElvMapperN.GetApp26List003(parm);
            case "hanyangs":
                return  app26ElvMapperH.GetApp26List003(parm);
            default:
                List<App26ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app26ElvMapper.GetApp26List003(parm);}
    public List<App26ElvlrtDto> GetApp26List004(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app26ElvMapper.GetApp26List004(parm);
            case "ELV_KYOUNG":
                return  app26ElvMapperK.GetApp26List004(parm);
            case "ELV_GAON":
                return  app26ElvMapperG.GetApp26List004(parm);
            case "nmyang":
                return  app26ElvMapperN.GetApp26List004(parm);
            case "hanyangs":
                return  app26ElvMapperH.GetApp26List004(parm);
            default:
                List<App26ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app26ElvMapper.GetApp26List004(parm);}

}
