package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App03ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App03GaonMapper;
import com.actas.ems.Mapper.kyoung.App03KyoungMapper;
import com.actas.ems.Mapper.nm.App03NmyangMapper;
import com.actas.ems.Mapper.samjung.App01SamMapper;
import com.actas.ems.Mapper.samjung.App03SamMapper;
import com.actas.ems.Mapper.sjilsan.App01SjilsanMapper;
import com.actas.ems.Mapper.sjilsan.App03SjilsanMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App03ElvlrtService")
public class App03ElvlrtService {

    @Autowired
    App03ElvlrtMapper appMapper;
    @Autowired
    App03GaonMapper appMapperG;
    @Autowired
    App03KyoungMapper appMapperK;
    @Autowired
    App03NmyangMapper appMapperN;
    @Autowired
    App03SamMapper appMapperS;
    @Autowired
    App03SjilsanMapper appMapperSj;


    /** 고장내용별현황 / 기간별 고장내용 */
    public List<App03ElvlrtDto> GetApp03List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetApp03List001(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetApp03List001(parm);
            case "ELV_GAON":
                return  appMapperG.GetApp03List001(parm);
            case "nmyang":
                return  appMapperN.GetApp03List001(parm);
            case "hanyangs":
                return  appMapper.GetApp03List001(parm);
            case "samjung":
                return  appMapperS.GetApp03List001(parm);
            case "samjungilsan":
                return  appMapperSj.GetApp03List001(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }


//    {return appMapper.GetApp03List001(parm);}
    /** 고장내용별현황 / 현장별 고장내용 */
    public List<App03ElvlrtDto> GetApp03List002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetApp03List002(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetApp03List002(parm);
            case "ELV_GAON":
                return  appMapperG.GetApp03List002(parm);
            case "nmyang":
                return  appMapperN.GetApp03List002(parm);
            case "hanyangs":
                return  appMapper.GetApp03List002(parm);
            case "samjung":
                return  appMapperS.GetApp03List002(parm);
            case "samjungilsan":
                return  appMapperSj.GetApp03List002(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }

//    {return app03ElvMapper.GetApp03List002(parm);}
    /** 고장내용별현황 / 호기별 고장내용 */
    public List<App03ElvlrtDto> GetApp03List003(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetApp03List003(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetApp03List003(parm);
            case "ELV_GAON":
                return  appMapperG.GetApp03List003(parm);
            case "nmyang":
                return  appMapperN.GetApp03List003(parm);
            case "hanyangs":
                return  appMapper.GetApp03List003(parm);
            case "samjung":
                return  appMapperS.GetApp03List003(parm);
            case "samjungilsan":
                return  appMapperSj.GetApp03List003(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }
//    {return app03ElvMapper.GetApp03List003(parm);}



}
