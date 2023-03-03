package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.*;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App01ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App01GaonMapper;
import com.actas.ems.Mapper.kyoung.App01KyoungMapper;
import com.actas.ems.Mapper.nm.App01NmyangMapper;
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
    App01GaonMapper appMapperG;
    @Autowired
    App01KyoungMapper appMapperK;
    @Autowired
    App01NmyangMapper     appMapperN;
    @Autowired
    App01ElvlrtMapper     appMapperH;

    public App01ElvlrtDto GetCallXenv(App01ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetCallXenv(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetCallXenv(parm);
            case "ELV_GAON":
                return  appMapperG.GetCallXenv(parm);
            case "nmyang":
                return  appMapperN.GetCallXenv(parm);
            case "hanyangs":
                return  appMapperH.GetCallXenv(parm);
            default:
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
                return  appMapperH.GetApp01List001(parm);
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
                return  appMapperH.GetApp01List002(parm);
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
                return  appMapperH.GetApp01List003(parm);
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
                return  appMapperH.GetApp01List004(parm);
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
                return  appMapperG.GetApp01List005(parm);
            case "nmyang":
                return  appMapperN.GetApp01List005(parm);
            case "hanyangs":
                return  appMapperH.GetApp01List005(parm);
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
                return  appMapperK.GetApp01List006(parm);
            case "ELV_GAON":
                return  appMapperG.GetApp01List006(parm);
            case "nmyang":
                return  appMapperN.GetApp01List006(parm);
            case "hanyangs":
                return  appMapperH.GetApp01List006(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }


    /** 고객상담센터 / 콜백 리스트 */
    public List<AppCallElvlrtDto> GetCallBackList(AppCallElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetCallBackList(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetCallBackList(parm);
            case "ELV_GAON":
                return  appMapperG.GetCallBackList(parm);
            case "nmyang":
                return  appMapperN.GetCallBackList(parm);
            case "hanyangs":
                return  appMapperH.GetCallBackList(parm);
            default:
                break;
        }
        List<AppCallElvlrtDto> Object = null;
        return Object;
    }

    /** 고객상담센터 /  전화번호부 리스트 */
    public List<AppCall601ElvlrtDto> GetPhonebookList(AppCall601ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.GetPhonebookList(parm);
            case "ELV_KYOUNG":
                return  appMapperK.GetPhonebookList(parm);
            case "ELV_GAON":
                return  appMapperG.GetPhonebookList(parm);
            case "nmyang":
                return  appMapperN.GetPhonebookList(parm);
            case "hanyangs":
                return  appMapperH.GetPhonebookList(parm);
            default:
                break;
        }
        List<AppCall601ElvlrtDto> Object = null;
        return Object;
    }

    public String get10RecenumMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.get10RecenumMaxSeq(parm);
            case "ELV_KYOUNG":
                return  appMapperK.get10RecenumMaxSeq(parm);
            case "ELV_GAON":
                return  appMapperG.get10RecenumMaxSeq(parm);
            case "nmyang":
                return  appMapperN.get10RecenumMaxSeq(parm);
            case "hanyangs":
                return  appMapperH.get10RecenumMaxSeq(parm);
            default:
                break;
        }
        return "";
    }
//    {return appMapper.get10RecenumMaxSeq(parm);}
    public int InsertE401(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {  return appMapper.InsertE401(parm);}
    public int UpdateE401(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.UpdateE401(parm);}
    public int DeleteE401(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.DeleteE401(parm);}
    public int InsertCall(AppCallElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.InsertCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.InsertCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.InsertCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.InsertCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.InsertCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {  return appMapper.InsertCall(parm);}
    public int UpdateCall(AppCallElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.UpdateCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.UpdateCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.UpdateCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.UpdateCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.UpdateCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.UpdateCall(parm);}
    public int DeleteCall(AppCallElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.DeleteCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.DeleteCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.DeleteCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.DeleteCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.DeleteCall(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.DeleteCall(parm);}


    public int InsertE401Sms(AppCallElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.InsertE401Sms(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.InsertE401Sms(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.InsertE401Sms(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.InsertE401Sms(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.InsertE401Sms(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.InsertE401Sms(parm);}
    public int InsertE601CALL(AppCall601ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.InsertE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.InsertE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.InsertE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.InsertE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.InsertE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.InsertE601CALL(parm);}
    public int InsertE601CALL01(AppCall601ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.InsertE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.InsertE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.InsertE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.InsertE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.InsertE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.InsertE601CALL01(parm);}


    public int UpdateE601CALL(AppCall601ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.UpdateE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.UpdateE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.UpdateE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.UpdateE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.UpdateE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.UpdateE601CALL(parm);}
    public int UpdateE601CALL01(AppCall601ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.UpdateE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.UpdateE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.UpdateE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.UpdateE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.UpdateE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.UpdateE601CALL01(parm);}
    public int DeleteE601CALL(AppCall601ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.DeleteE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.DeleteE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.DeleteE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.DeleteE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.DeleteE601CALL(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.DeleteE601CALL(parm);}
    public int DeleteE601CALL01(AppCall601ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.DeleteE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.DeleteE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.DeleteE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.DeleteE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.DeleteE601CALL01(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }
//    {return appMapper.DeleteE601CALL01(parm);}

    public int UpdateCallInfo(App01ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appMapper.UpdateCallInfo(parm) ;
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appMapperG.UpdateCallInfo(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appMapperK.UpdateCallInfo(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appMapperN.UpdateCallInfo(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appMapperH.UpdateCallInfo(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }


    public String getCllMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.getCllMaxSeq(parm);
            case "ELV_KYOUNG":
                return  appMapperK.getCllMaxSeq(parm);
            case "ELV_GAON":
                return  appMapperG.getCllMaxSeq(parm);
            case "nmyang":
                return  appMapperN.getCllMaxSeq(parm);
            case "hanyangs":
                return  appMapper.getCllMaxSeq(parm);
            default:
                break;
        }
        return "";
    }



    //    {return appMapper.getCllMaxSeq(parm);}
    public String getSmsMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.getSmsMaxSeq(parm);
            case "ELV_KYOUNG":
                return  appMapperK.getSmsMaxSeq(parm);
            case "ELV_GAON":
                return  appMapperG.getSmsMaxSeq(parm);
            case "nmyang":
                return  appMapperN.getSmsMaxSeq(parm);
            case "hanyangs":
                return  appMapper.getSmsMaxSeq(parm);
            default:
                break;
        }
        return "";
    }
//    {return appMapper.getSmsMaxSeq(parm);}
    public String getE601CallNM(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.getE601CallNM(parm);
            case "ELV_KYOUNG":
                return  appMapperK.getE601CallNM(parm);
            case "ELV_GAON":
                return  appMapperG.getE601CallNM(parm);
            case "nmyang":
                return  appMapperN.getE601CallNM(parm);
            case "hanyangs":
                return  appMapper.getE601CallNM(parm);
            default:
                break;
        }
        return "";
    }
//    {return appMapper.getE601CallNM(parm);}

    public String gete601CallMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appMapper.gete601CallMaxSeq(parm);
            case "ELV_KYOUNG":
                return  appMapperK.gete601CallMaxSeq(parm);
            case "ELV_GAON":
                return  appMapperG.gete601CallMaxSeq(parm);
            case "nmyang":
                return  appMapperN.gete601CallMaxSeq(parm);
            case "hanyangs":
                return  appMapper.gete601CallMaxSeq(parm);
            default:
                break;
        }
        return "";
    }
//    {return appMapper.gete601CallMaxSeq(parm);}





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
