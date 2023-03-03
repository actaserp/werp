package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppMob001tDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.*;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMobMapper;
import com.actas.ems.Mapper.gaon.App10GaonMobMapper;
import com.actas.ems.Mapper.kyoung.App10KyoungMobMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service("App10ElvlrtMobService")
public class App10ElvlrtMobService {

    @Autowired
    App10ElvlrtMobMapper app10ElvMobMapper;
    @Autowired
    App10GaonMobMapper app10ElvMobMapperG;
    @Autowired
    App10KyoungMobMapper app10ElvMobMapperK;
    @Autowired
    App10ElvlrtMobMapper app10ElvMobMapperN;
    @Autowired
    App10ElvlrtMobMapper app10ElvMobMapperH;
    int queryResult = 1;


    /** view page **/
    public List<AppMob001tDto> GetAppMobList001(App10ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobList001(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobList001(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobList001(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobList001(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobList001(parm);
            default:
                List<AppMob001tDto> object = null;
                return object;
        }
    }
//    {return app10ElvMobMapper.GetAppMobList001(parm);}

    /** app03-05 view page **/
    public List<AppMob003tDto> GetApp06MobList001(App06ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetApp06MobList001(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetApp06MobList001(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetApp06MobList001(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetApp06MobList001(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetApp06MobList001(parm);
            default:
                List<AppMob003tDto> object = null;
                return object;
        }
    }
            /** 글 등록 */

            public String getMHManualMaxSeq(String parm){
                String ls_dbnm = UIUtils.getElvDataSourceNm();
                switch (ls_dbnm){
                    case "ELV_LRT":
                        return  app10ElvMobMapper.getMHManualMaxSeq(parm);
                    case "ELV_KYOUNG":
                        return  app10ElvMobMapperK.getMHManualMaxSeq(parm);
                    case "ELV_GAON":
                        return  app10ElvMobMapperG.getMHManualMaxSeq(parm);
                    case "nmyang":
                        return  app10ElvMobMapperN.getMHManualMaxSeq(parm);
                    case "hanyangs":
                        return  app10ElvMobMapperH.getMHManualMaxSeq(parm);
                    default:
                        break;
                }
                return "";
            }
                public String getMBManualMaxSeq(String parm){
                    String ls_dbnm = UIUtils.getElvDataSourceNm();
                    switch (ls_dbnm){
                        case "ELV_LRT":
                            return  app10ElvMobMapper.getMBManualMaxSeq(parm);
                        case "ELV_KYOUNG":
                            return  app10ElvMobMapperK.getMBManualMaxSeq(parm);
                        case "ELV_GAON":
                            return  app10ElvMobMapperG.getMBManualMaxSeq(parm);
                        case "nmyang":
                            return  app10ElvMobMapperN.getMBManualMaxSeq(parm);
                        case "hanyangs":
                            return  app10ElvMobMapperH.getMBManualMaxSeq(parm);
                        default:
                            break;
                    }
                    return "";
                }
            public boolean InsertMHManual(App06ElvlrtDto parm){
                int queryResult = 1;
                String ls_dbnm = UIUtils.getElvDataSourceNm();
                switch (ls_dbnm){
                    case "ELV_LRT":
                        queryResult = app10ElvMobMapper.InsertMHManual(parm);
                        if(queryResult < 1){
                            queryResult = 0;
                        }
                        return (queryResult > 0);
                    case "ELV_GAON":
                        queryResult = app10ElvMobMapperK.InsertMHManual(parm);
                        if(queryResult < 1){
                            queryResult = 0;
                        }
                        return (queryResult > 0);
                    case "ELV_KYOUNG":
                        queryResult = app10ElvMobMapperG.InsertMHManual(parm);
                        if(queryResult < 1){
                            queryResult = 0;
                        }
                        return (queryResult > 0);
                    case "nmyang":
                        queryResult = app10ElvMobMapperN.InsertMHManual(parm);
                        if(queryResult < 1){
                            queryResult = 0;
                        }
                        return (queryResult > 0);
                    case "hanyangs":
                        queryResult = app10ElvMobMapperH.InsertMHManual(parm);
                        if(queryResult < 1){
                            queryResult = 0;
                        }
                        return (queryResult > 0);
                    default:
                        break;
                }
                return true;
            }
                public boolean InsertMBManual(App08_mbmanual parm){
                    int queryResult = 1;
                    String ls_dbnm = UIUtils.getElvDataSourceNm();
                    switch (ls_dbnm){
                        case "ELV_LRT":
                            queryResult = app10ElvMobMapper.InsertMBManual(parm);
                            if(queryResult < 1){
                                queryResult = 0;
                            }
                            return (queryResult > 0);
                        case "ELV_GAON":
                            queryResult = app10ElvMobMapperK.InsertMBManual(parm);
                            if(queryResult < 1){
                                queryResult = 0;
                            }
                            return (queryResult > 0);
                        case "ELV_KYOUNG":
                            queryResult = app10ElvMobMapperG.InsertMBManual(parm);
                            if(queryResult < 1){
                                queryResult = 0;
                            }
                            return (queryResult > 0);
                        case "nmyang":
                            queryResult = app10ElvMobMapperN.InsertMBManual(parm);
                            if(queryResult < 1){
                                queryResult = 0;
                            }
                            return (queryResult > 0);
                        case "hanyangs":
                            queryResult = app10ElvMobMapperH.InsertMBManual(parm);
                            if(queryResult < 1){
                                queryResult = 0;
                            }
                            return (queryResult > 0);
                        default:
                            break;
                    }
                    return true;
                }

    public List<AppMob004tDto> GetApp0bMobList001(App08_mbmanual parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetApp0bMobList001(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetApp0bMobList001(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetApp0bMobList001(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetApp0bMobList001(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetApp0bMobList001(parm);
            default:
                List<AppMob004tDto> object = null;
                return object;
        }
    }
    //    {return app10ElvMobMapper.GetApp0bMobList001(parm);}
    public List<AppMob005tDto> GetApp28MobList001(App28ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetApp28MobList001(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetApp28MobList001(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetApp28MobList001(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetApp28MobList001(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetApp28MobList001(parm);
            default:
                List<AppMob005tDto> object = null;
                return object;
        }
    }
    //    {return app10ElvMobMapper.GetApp28MobList001(parm);}
    public List<AppMob005tDto> GetApp28MobList002(App28ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetApp28MobList002(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetApp28MobList002(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetApp28MobList002(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetApp28MobList002(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetApp28MobList002(parm);
            default:
                List<AppMob005tDto> object = null;
                return object;
        }
    }

    /** app03-04 codenum **/
    public List<CommonDto> code754get06List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.code754get06List();
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.code754get06List();
            case "ELV_GAON":
                return  app10ElvMobMapperG.code754get06List();
            case "nmyang":
                return  app10ElvMobMapperN.code754get06List();
            case "hanyangs":
                return  app10ElvMobMapperH.code754get06List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }

    public List<CommonDto> code754get08List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.code754get08List();
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.code754get08List();
            case "ELV_GAON":
                return  app10ElvMobMapperG.code754get08List();
            case "nmyang":
                return  app10ElvMobMapperN.code754get08List();
            case "hanyangs":
                return  app10ElvMobMapperH.code754get08List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }

    /**박광열, 현장별고장부위(모바일), view page**/
    public List<App16ElvlrtDto> GetAppMobList_002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobList_002(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobList_002(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobList_002(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobList_002(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobList_002(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app10ElvMobMapper.GetAppMobList_002(parm);}

    /** 박광열, 직원정보조회(모바일)**/
    public List<App14ElvlrtDto> GetAppMobList_003(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobList_003(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobList_003(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobList_003(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobList_003(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobList_003(parm);
            default:
                List<App14ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app10ElvMobMapper.GetAppMobList_003(parm);}

    /**박광열, 보수현장조회(모바일)*/
    public List<App26ElvlrtDto> GetAppMobListr_004(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobListr_004(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobListr_004(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobListr_004(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobListr_004(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobListr_004(parm);
            default:
                List<App26ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app10ElvMobMapper.GetAppMobListr_004(parm);}


    /**박광열 고장이력(모바일)*/
    public List<App16ElvlrtDto> GetAppMobListr_005(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobListr_005(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobListr_005(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobListr_005(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobListr_005(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobListr_005(parm);
            default:
                List<App16ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app10ElvMobMapper.GetAppMobListr_005(parm);}

    public List<App04ElvlrtDto> GetAppMobList_004(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobList_004(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobList_004(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobList_004(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobList_004(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobList_004(parm);
            default:
                List<App04ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app10ElvMobMapper.GetAppMobList_004(parm);}

    public List<App04ElvlrtDto> GetAppMobList_e(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobList_e(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobList_e(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobList_e(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobList_e(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobList_e(parm);
            default:
                List<App04ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app10ElvMobMapper.GetAppMobList_e(parm);}

    public List<App04ElvlrtDto> GetAppMobList_d(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobList_d(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobList_d(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobList_d(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobList_d(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobList_d(parm);
            default:
                List<App04ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app10ElvMobMapper.GetAppMobList_d(parm);}

    public List<AttachDTO> GetMobThumbList_001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetMobThumbList_001(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetMobThumbList_001(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetMobThumbList_001(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetMobThumbList_001(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetMobThumbList_001(parm);
            default:
                List<AttachDTO> object = null;
                return object;
        }
    }
//    {return app10ElvMobMapper.GetMobThumbList_001(parm);}


    /**고장처리 등록**/

    public boolean Insert10Manu(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.Insert10Manul(parm);
                if(queryResult < 1){  //값 확인
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }


    @Transactional
    public boolean Update10Manu(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }


    /**점검계획*/
    public List<AppMobPlanDto> GetplanList(AppMobPlanDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetplanList(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetplanList(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetplanList(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetplanList(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetplanList(parm);
            default:
                List<AppMobPlanDto> object = null;
                return object;
        }
    }

    /**점검계획 등록*/
    public boolean Insertplan(AppMobPlanDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.Insertplan(parm);
                if(queryResult < 1){  //값 확인
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.Insertplan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.Insertplan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.Insertplan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.Insertplan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }



    /**사업자 조회*/
    public List<AppMobPlanDto> GetcltnmList(AppMobPlanDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetcltnmList(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetcltnmList(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetcltnmList(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetcltnmList(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetcltnmList(parm);
            default:
                List<AppMobPlanDto> object = null;
                return object;
        }
    }


    /**점검계획 삭제*/
    public boolean DeletePlan(AppMobPlanDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.DeletePlan(parm);
                if(queryResult < 1){  //값 확인
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.DeletePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.DeletePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.DeletePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.DeletePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }



    @Transactional
    public boolean UpdatePlan(AppMobPlanDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.UpdatePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.UpdatePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.UpdatePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.UpdatePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.UpdatePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

}
