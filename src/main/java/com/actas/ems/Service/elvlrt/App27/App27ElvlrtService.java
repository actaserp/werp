package com.actas.ems.Service.elvlrt.App27;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.kyoung.App27KyoungMapper;
import com.actas.ems.Mapper.gaon.App27GaonMapper;
import com.actas.ems.Mapper.Elvlrt.App27ElvlrtMapper;
import com.actas.ems.Mapper.nm.App27NmyangMapper;
import com.actas.ems.Mapper.samjung.App15SamMapper;
import com.actas.ems.Mapper.samjung.App27SamMapper;
import com.actas.ems.Mapper.sjilsan.App15SjilsanMapper;
import com.actas.ems.Mapper.sjilsan.App27SjilsanMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("App27ElvlrtServicd")
@RequiredArgsConstructor
public class App27ElvlrtService {


    @Autowired
    App27ElvlrtMapper app27ElvlrtMapper;
    @Autowired
    App27GaonMapper app27ElvlrtMapperG;
    @Autowired
    App27KyoungMapper app27ElvlrtMapperK;
    @Autowired
    App27NmyangMapper app27ElvlrtMapperN;
    @Autowired
    App27GaonMapper app27ElvlrtMapperH;
    @Autowired
    App27SamMapper app27ElvlrtMapperS;
    @Autowired
    App27SjilsanMapper app27ElvlrtMapperSj;

    public List<App16ElvlrtDto> GetApp27List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app27ElvlrtMapper.GetApp27List001(parm);
            case "ELV_KYOUNG":
                return  app27ElvlrtMapperK.GetApp27List001(parm);
            case "ELV_GAON":
                return  app27ElvlrtMapperG.GetApp27List001(parm);
            case "nmyang":
                return  app27ElvlrtMapperN.GetApp27List001(parm);
            case "hanyangs":
                return  app27ElvlrtMapperH.GetApp27List001(parm);
            case "samjung":
                return  app27ElvlrtMapperS.GetApp27List001(parm);
            case "samjungilsan":
                return  app27ElvlrtMapperSj.GetApp27List001(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app27ElvlrtMapper.GetApp27List001(parm);}
    public List<App16ElvlrtDto> GetApp27List002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app27ElvlrtMapper.GetApp27List002(parm);
            case "ELV_KYOUNG":
                return  app27ElvlrtMapperK.GetApp27List002(parm);
            case "ELV_GAON":
                return  app27ElvlrtMapperG.GetApp27List002(parm);
            case "nmyang":
                return  app27ElvlrtMapperN.GetApp27List002(parm);
            case "hanyangs":
                return  app27ElvlrtMapperH.GetApp27List002(parm);
            case "samjung":
                return  app27ElvlrtMapperS.GetApp27List002(parm);
            case "samjungilsan":
                return  app27ElvlrtMapperSj.GetApp27List002(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app27ElvlrtMapper.GetApp27List002(parm);}

    public List<App16ElvlrtDto> GetApp27List003(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app27ElvlrtMapper.GetApp27List003(parm);
            case "ELV_KYOUNG":
                return  app27ElvlrtMapperK.GetApp27List003(parm);
            case "ELV_GAON":
                return  app27ElvlrtMapperG.GetApp27List003(parm);
            case "nmyang":
                return  app27ElvlrtMapperN.GetApp27List003(parm);
            case "hanyangs":
                return  app27ElvlrtMapperH.GetApp27List003(parm);
            case "samjung":
                return  app27ElvlrtMapperS.GetApp27List003(parm);
            case "samjungilsan":
                return  app27ElvlrtMapperSj.GetApp27List003(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app27ElvlrtMapper.GetApp27List003(parm);}

    public List<App16ElvlrtDto> GetApp27List004(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app27ElvlrtMapper.GetApp27List004(parm);
            case "ELV_KYOUNG":
                return  app27ElvlrtMapperK.GetApp27List004(parm);
            case "ELV_GAON":
                return  app27ElvlrtMapperG.GetApp27List004(parm);
            case "nmyang":
                return  app27ElvlrtMapperN.GetApp27List004(parm);
            case "hanyangs":
                return  app27ElvlrtMapperH.GetApp27List004(parm);
            case "samjung":
                return  app27ElvlrtMapperS.GetApp27List004(parm);
            case "samjungilsan":
                return  app27ElvlrtMapperSj.GetApp27List004(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app27ElvlrtMapper.GetApp27List004(parm);}

    public List<App16ElvlrtDto> GetApp27popuplist(App16ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app27ElvlrtMapper.GetpopupList(parm);
            case "ELV_KYOUNG":
                return  app27ElvlrtMapperK.GetpopupList(parm);
            case "ELV_GAON":
                return  app27ElvlrtMapperG.GetpopupList(parm);
            case "nmyang":
                return  app27ElvlrtMapperN.GetpopupList(parm);
            case "hanyangs":
                return  app27ElvlrtMapperH.GetpopupList(parm);
            case "samjung":
                return  app27ElvlrtMapperS.GetpopupList(parm);
            case "samjungilsan":
                return  app27ElvlrtMapperSj.GetpopupList(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app27ElvlrtMapper.GetpopupList(parm);}

}
