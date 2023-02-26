package com.actas.ems.Service.elvlrt.App15;


import com.actas.ems.DTO.Elvlrt.App15ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App15ElvlrtMapper;
import com.actas.ems.Mapper.kyoung.App15KyoungMapper;
import com.actas.ems.Mapper.gaon.App15GaonMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App15ElvlrtService")
public class App15ElvlrtService {


    @Autowired
    App15ElvlrtMapper app15ElvlrtMapper;
    @Autowired
    App15GaonMapper app15ElvlrtMapperG;
    @Autowired
    App15KyoungMapper app15ElvlrtMapperK;
    @Autowired
    App15ElvlrtMapper app15ElvlrtMapperN;
    @Autowired
    App15ElvlrtMapper app15ElvlrtMapperH;

    //호기별고장통계
    public List<App15ElvlrtDto> GetApp15List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app15ElvlrtMapper.GetApp00List001(parm);
            case "ELV_KYOUNG":
                return  app15ElvlrtMapperK.GetApp00List001(parm);
            case "ELV_GAON":
                return  app15ElvlrtMapperG.GetApp00List001(parm);
            case "nmyang":
                return  app15ElvlrtMapperN.GetApp00List001(parm);
            case "hanyangs":
                return  app15ElvlrtMapperH.GetApp00List001(parm);
            default:
                List<App15ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app15ElvlrtMapper.GetApp00List001(parm);}

    //메인화면 당월점검현황
    public List<App15ElvlrtDto> GetApp15List002(App15ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app15ElvlrtMapper.GetApp00List002(parm);
            case "ELV_KYOUNG":
                return  app15ElvlrtMapperK.GetApp00List002(parm);
            case "ELV_GAON":
                return  app15ElvlrtMapperG.GetApp00List002(parm);
            case "nmyang":
                return  app15ElvlrtMapperN.GetApp00List002(parm);
            case "hanyangs":
                return  app15ElvlrtMapperH.GetApp00List002(parm);
            default:
                List<App15ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app15ElvlrtMapper.GetApp00List002(parm);}

    //메인화면 계약만료현장
    public List<App15ElvlrtDto> GetApp15List003(App15ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app15ElvlrtMapper.GetApp00List003(parm);
            case "ELV_KYOUNG":
                return  app15ElvlrtMapperK.GetApp00List003(parm);
            case "ELV_GAON":
                return  app15ElvlrtMapperG.GetApp00List003(parm);
            case "nmyang":
                return  app15ElvlrtMapperN.GetApp00List003(parm);
            case "hanyangs":
                return  app15ElvlrtMapperH.GetApp00List003(parm);
            default:
                List<App15ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app15ElvlrtMapper.GetApp00List003(parm);}

    //메인화면 30일뒤 계약만료현장
    public List<App15ElvlrtDto> GetApp15List004(App15ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app15ElvlrtMapper.GetApp00List004(parm);
            case "ELV_KYOUNG":
                return  app15ElvlrtMapperK.GetApp00List004(parm);
            case "ELV_GAON":
                return  app15ElvlrtMapperG.GetApp00List004(parm);
            case "nmyang":
                return  app15ElvlrtMapperN.GetApp00List004(parm);
            case "hanyangs":
                return  app15ElvlrtMapperH.GetApp00List004(parm);
            default:
                List<App15ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app15ElvlrtMapper.GetApp00List004(parm);}

    //메인화면 당월 고장다발현장
    public List<App15ElvlrtDto> GetApp15List005(App15ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app15ElvlrtMapper.GetApp00List005(parm);
            case "ELV_KYOUNG":
                return  app15ElvlrtMapperK.GetApp00List005(parm);
            case "ELV_GAON":
                return  app15ElvlrtMapperG.GetApp00List005(parm);
            case "nmyang":
                return  app15ElvlrtMapperN.GetApp00List005(parm);
            case "hanyangs":
                return  app15ElvlrtMapperH.GetApp00List005(parm);
            default:
                List<App15ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app15ElvlrtMapper.GetApp00List005(parm);}

    //고객사용자 메인화면 당월 고장다발현장
    public List<App15ElvlrtDto> GetApp15List006(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app15ElvlrtMapper.GetApp00List006(parm);
            case "ELV_KYOUNG":
                return  app15ElvlrtMapperK.GetApp00List006(parm);
            case "ELV_GAON":
                return  app15ElvlrtMapperG.GetApp00List006(parm);
            case "nmyang":
                return  app15ElvlrtMapperN.GetApp00List006(parm);
            case "hanyangs":
                return  app15ElvlrtMapperH.GetApp00List006(parm);
            default:
                List<App15ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app15ElvlrtMapper.GetApp00List006(parm);}


    //고객사용자 메인화면 당월 고장다발현장 그래프
    public List<App15ElvlrtDto> GetApp15List007(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app15ElvlrtMapper.GetApp00List007(parm);
            case "ELV_KYOUNG":
                return  app15ElvlrtMapperK.GetApp00List007(parm);
            case "ELV_GAON":
                return  app15ElvlrtMapperG.GetApp00List007(parm);
            case "nmyang":
                return  app15ElvlrtMapperN.GetApp00List007(parm);
            case "hanyangs":
                return  app15ElvlrtMapperH.GetApp00List007(parm);
            default:
                List<App15ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app15ElvlrtMapper.GetApp00List007(parm);}



    //고객사용자 메인화면 당일 직원 근태현황
    public List<App15ElvlrtDto> GetApp00List014(App15ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app15ElvlrtMapper.GetApp00List014(parm);
            case "ELV_KYOUNG":
                return  app15ElvlrtMapperK.GetApp00List014(parm);
            case "ELV_GAON":
                return  app15ElvlrtMapperG.GetApp00List014(parm);
            case "nmyang":
                return  app15ElvlrtMapperN.GetApp00List014(parm);
            case "hanyangs":
                return  app15ElvlrtMapperH.GetApp00List014(parm);
            default:
                List<App15ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app15ElvlrtMapper.GetApp00List014(parm);}



}
