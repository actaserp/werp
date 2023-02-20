package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppCallElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App01ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App01GaonMapper;
import com.actas.ems.Mapper.kyoung.App01KyoungMapper;
import com.actas.ems.Mapper.nm.App01NmMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class App01ElvlrtService {
    @Autowired
    App01ElvlrtMapper appMapper;
    @Autowired
    App01GaonMapper   appMapperG;
    @Autowired
    App01KyoungMapper appMapperK;
    @Autowired
    App01NmMapper     appMapperN;

    public App01ElvlrtDto GetCallXenv(App01ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                System.out.println("ELV_LRT 로그인");
                return  appMapper.GetCallXenv(parm);
            case "ELV_KYOUNG":
                System.out.println("ELV_KYOUNG 로그인");
                return  appMapperK.GetCallXenv(parm);
            case "ELV_GAON":
                System.out.println("ELV_GAON 로그인");
                return  appMapperG.GetCallXenv(parm);
            case "nmyang":
                System.out.println("ELV_NMYANG 로그인");
                return  appMapperN.GetCallXenv(parm);
            case "hanyangs":
                System.out.println("ELV_HANYANGS 로그인");
                return  appMapper.GetCallXenv(parm);
            default:
                System.out.println("default 로그인");
                App01ElvlrtDto Object = null;
                return Object;
        }

    }

    /** 관제현황 / 접수현황 리스트 */
    public List<App03ElvlrtDto> GetApp01List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetApp01List001(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetApp01List001(parm);
            case "ELV_GAON":
                return  appMapperG.GetApp01List001(parm);
            case "nmyang":
                return  appMapperN.GetApp01List001(parm);
            case "hanyangs":
                return  appMapper.GetApp01List001(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }

    /** 관제현황 / 수리기사 리스트 */
    public List<App03ElvlrtDto> GetApp01List002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetApp01List002(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetApp01List002(parm);
            case "ELV_GAON":
                return  appMapperG.GetApp01List002(parm);
            case "nmyang":
                return  appMapperN.GetApp01List002(parm);
            case "hanyangs":
                return  appMapper.GetApp01List002(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }

    /** 관제현황 / 상단통계 리스트 */
    public List<App03ElvlrtDto> GetApp01List003(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetApp01List003(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetApp01List003(parm);
            case "ELV_GAON":
                return  appMapperG.GetApp01List003(parm);
            case "nmyang":
                return  appMapperN.GetApp01List003(parm);
            case "hanyangs":
                return  appMapper.GetApp01List003(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }


    /** 관제현황 / 기사 이동라인 리스트 */
    public List<App03ElvlrtDto> GetApp01List004(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetApp01List004(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetApp01List004(parm);
            case "ELV_GAON":
                return  appMapperG.GetApp01List004(parm);
            case "nmyang":
                return  appMapperN.GetApp01List004(parm);
            case "hanyangs":
                return  appMapper.GetApp01List004(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }


    /** 고객상담센터 / 전화메모 리스트 */
    public List<App03ElvlrtDto> GetApp01List005(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetApp01List005(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetApp01List005(parm);
            case "ELV_GAON":
                return  appMapper.GetApp01List005(parm);
            case "nmyang":
                return  appMapperN.GetApp01List005(parm);
            case "hanyangs":
                return  appMapper.GetApp01List005(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }


    /** 고객상담센터 / 문자전송 리스트 */
    public List<App03ElvlrtDto> GetApp01List006(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetApp01List006(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetApp01List005(parm);
            case "ELV_GAON":
                return  appMapper.GetApp01List005(parm);
            case "nmyang":
                return  appMapperN.GetApp01List005(parm);
            case "hanyangs":
                return  appMapper.GetApp01List005(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }

    public String get10RecenumMaxSeq(String parm){return appMapper.get10RecenumMaxSeq(parm);}
    public int InsertE401(App10ElvlrtDto parm){  return appMapper.InsertE401(parm);}
    public int UpdateE401(App10ElvlrtDto parm){return appMapper.UpdateE401(parm);}
    public int DeleteE401(App10ElvlrtDto parm){return appMapper.DeleteE401(parm);}
    public String getCllMaxSeq(String parm){return appMapper.getCllMaxSeq(parm);}
    public int InsertCall(AppCallElvlrtDto parm){  return appMapper.InsertCall(parm);}
    public int UpdateCall(AppCallElvlrtDto parm){return appMapper.UpdateCall(parm);}
    public int DeleteCall(AppCallElvlrtDto parm){return appMapper.DeleteCall(parm);}


    public int InsertE401Sms(AppCallElvlrtDto parm){return appMapper.InsertE401Sms(parm);}

    public String getSmsMaxSeq(String parm){return appMapper.getSmsMaxSeq(parm);}

//    public List<App03ElvlrtDto> GetApp01List001(PopupDto parm){return appMapper.GetApp01List001(parm);}
//    /** 관제현황 / 수리기사 리스트 */
//    public List<App03ElvlrtDto> GetApp01List002(PopupDto parm){return appMapper.GetApp01List002(parm);}
//    /** 관제현황 / 상단통계 리스트 */
//    public List<App03ElvlrtDto> GetApp01List003(PopupDto parm){return appMapper.GetApp01List003(parm);}
//    /** 관제현황 / 기사 이동라인 리스트 */
//    public List<App03ElvlrtDto> GetApp01List004(PopupDto parm){return appMapper.GetApp01List004(parm);}
//    /** 고객상담센터 / 전화메모 리스트 */
//    public List<App03ElvlrtDto> GetApp01List005(PopupDto parm){return appMapper.GetApp01List005(parm);}



}
