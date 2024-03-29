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
import com.actas.ems.Mapper.nm.App10NmyangMobMapper;
import com.actas.ems.Mapper.samjung.App09SamMapper;
import com.actas.ems.Mapper.samjung.App10SamMapper;
import com.actas.ems.Mapper.samjung.App10SamMobMapper;
import com.actas.ems.Mapper.sjilsan.App09SjilsanMapper;
import com.actas.ems.Mapper.sjilsan.App10SjilsanMapper;
import com.actas.ems.Mapper.sjilsan.App10SjilsanMobMapper;
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
    App10NmyangMobMapper app10ElvMobMapperN;
    @Autowired
    App10ElvlrtMobMapper app10ElvMobMapperH;
    @Autowired
    App10SamMobMapper app10ElvMobMapperS;
    @Autowired
    App10SjilsanMobMapper app10ElvMobMapperSj;
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
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobList001(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobList001(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetApp06MobList001(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetApp06MobList001(parm);
            default:
                List<AppMob003tDto> object = null;
                return object;
        }
    }
    public List<AppMob003tDto> GetApp06MobList002(App06ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetApp06MobList002(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetApp06MobList002(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetApp06MobList002(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetApp06MobList002(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetApp06MobList002(parm);
            case "samjung":
                return  app10ElvMobMapperS.GetApp06MobList002(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetApp06MobList002(parm);
            default:
                List<AppMob003tDto> object = null;
                return object;
        }
    }
    /** 자료실 글 식제 */

    public boolean DeleteMManul(App08_mbmanual parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMobMapperS.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }
    public boolean DeleteMHManual(App06ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMobMapperS.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
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
                    case "samjung":
                        return  app10ElvMobMapperS.getMHManualMaxSeq(parm);
                    case "samjungilsan":
                        return  app10ElvMobMapperSj.getMHManualMaxSeq(parm);
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
                        case "samjung":
                            return  app10ElvMobMapperS.getMBManualMaxSeq(parm);
                        case "samjungilsan":
                            return  app10ElvMobMapperSj.getMBManualMaxSeq(parm);
                        default:
                            break;
                    }
                    return "";
                }
                    public String getMSManualMaxSeq(String parm){
                        String ls_dbnm = UIUtils.getElvDataSourceNm();
                        switch (ls_dbnm){
                            case "ELV_LRT":
                                return  app10ElvMobMapper.getMSManualMaxSeq(parm);
                            case "ELV_KYOUNG":
                                return  app10ElvMobMapperK.getMSManualMaxSeq(parm);
                            case "ELV_GAON":
                                return  app10ElvMobMapperG.getMSManualMaxSeq(parm);
                            case "nmyang":
                                return  app10ElvMobMapperN.getMSManualMaxSeq(parm);
                            case "hanyangs":
                                return  app10ElvMobMapperH.getMSManualMaxSeq(parm);
                            case "samjung":
                                return  app10ElvMobMapperS.getMSManualMaxSeq(parm);
                            case "samjungilsan":
                                return  app10ElvMobMapperSj.getMSManualMaxSeq(parm);
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
                    case "samjung":
                        queryResult = app10ElvMobMapperS.InsertMHManual(parm);
                        if(queryResult < 1){
                            queryResult = 0;
                        }
                        return (queryResult > 0);
                    case "samjungilsan":
                        queryResult = app10ElvMobMapperSj.InsertMHManual(parm);
                        if(queryResult < 1){
                            queryResult = 0;
                        }
                        return (queryResult > 0);
                    default:
                        break;
                }
                return true;
            }
    public boolean UpdateMHManual(App06ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMobMapperS.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.UpdateMHManual(parm);
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
                        case "samjung":
                            queryResult = app10ElvMobMapperS.InsertMBManual(parm);
                            if(queryResult < 1){
                                queryResult = 0;
                            }
                            return (queryResult > 0);
                        case "samjungilsan":
                            queryResult = app10ElvMobMapperSj.InsertMBManual(parm);
                            if(queryResult < 1){
                                queryResult = 0;
                            }
                            return (queryResult > 0);
                        default:
                            break;
                    }
                    return true;
                }
    public boolean UpdateMBManual(App08_mbmanual parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.UpdateMBManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.UpdateMBManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.UpdateMBManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.UpdateMBManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.UpdateMBManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMobMapperS.UpdateMBManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.UpdateMBManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }
                    public boolean InsertMSManual(App28ElvlrtDto parm){
                        int queryResult = 1;
                        String ls_dbnm = UIUtils.getElvDataSourceNm();
                        switch (ls_dbnm){
                            case "ELV_LRT":
                                queryResult = app10ElvMobMapper.InsertMSManual(parm);
                                if(queryResult < 1){
                                    queryResult = 0;
                                }
                                return (queryResult > 0);
                            case "ELV_GAON":
                                queryResult = app10ElvMobMapperK.InsertMSManual(parm);
                                if(queryResult < 1){
                                    queryResult = 0;
                                }
                                return (queryResult > 0);
                            case "ELV_KYOUNG":
                                queryResult = app10ElvMobMapperG.InsertMSManual(parm);
                                if(queryResult < 1){
                                    queryResult = 0;
                                }
                                return (queryResult > 0);
                            case "nmyang":
                                queryResult = app10ElvMobMapperN.InsertMSManual(parm);
                                if(queryResult < 1){
                                    queryResult = 0;
                                }
                                return (queryResult > 0);
                            case "hanyangs":
                                queryResult = app10ElvMobMapperH.InsertMSManual(parm);
                                if(queryResult < 1){
                                    queryResult = 0;
                                }
                                return (queryResult > 0);
                            case "samjung":
                                queryResult = app10ElvMobMapperS.InsertMSManual(parm);
                                if(queryResult < 1){
                                    queryResult = 0;
                                }
                                return (queryResult > 0);
                            case "samjungilsan":
                                queryResult = app10ElvMobMapperSj.InsertMSManual(parm);
                                if(queryResult < 1){
                                    queryResult = 0;
                                }
                                return (queryResult > 0);
                            default:
                                break;
                        }
                        return true;
                    }
    public boolean UpdateMSManual(App28ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.UpdateMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.UpdateMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.UpdateMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.UpdateMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.UpdateMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMobMapperS.UpdateMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.UpdateMSManual(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetApp0bMobList001(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetApp0bMobList001(parm);
            default:
                List<AppMob004tDto> object = null;
                return object;
        }
    }
    public List<AppMob004tDto> GetApp0bMobList002(App08_mbmanual parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetApp0bMobList002(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetApp0bMobList002(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetApp0bMobList002(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetApp0bMobList002(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetApp0bMobList002(parm);
            case "samjung":
                return  app10ElvMobMapperS.GetApp0bMobList002(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetApp0bMobList002(parm);
            default:
                List<AppMob004tDto> object = null;
                return object;
        }
    }
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
            case "samjung":
                return  app10ElvMobMapperS.GetApp28MobList001(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetApp28MobList001(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetApp28MobList002(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetApp28MobList002(parm);
            default:
                List<AppMob005tDto> object = null;
                return object;
        }
    }
    public List<AppMob005tDto> GetApp28MobList003(App28ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetApp28MobList003(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetApp28MobList003(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetApp28MobList003(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetApp28MobList003(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetApp28MobList003(parm);
            case "samjung":
                return  app10ElvMobMapperS.GetApp28MobList003(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetApp28MobList003(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.code754get06List();
            case "samjungilsan":
                return  app10ElvMobMapperSj.code754get06List();
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
            case "samjung":
                return  app10ElvMobMapperS.code754get08List();
            case "samjungilsan":
                return  app10ElvMobMapperSj.code754get08List();
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
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobList_002(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobList_002(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobList_003(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobList_003(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobListr_004(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobListr_004(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobListr_005(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobListr_005(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobList_004(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobList_004(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobList_e(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobList_e(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobList_d(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobList_d(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetMobThumbList_001(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetMobThumbList_001(parm);
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
            case "samjung":
                queryResult = app10ElvMobMapperS.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.Insert10Manul(parm);
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
            case "samjung":
                queryResult = app10ElvMobMapperS.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.Update10Manul(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetplanList(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetplanList(parm);
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
            case "samjung":
                queryResult = app10ElvMobMapperS.Insertplan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.Insertplan(parm);
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
            case "samjung":
                return  app10ElvMobMapperS.GetcltnmList(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetcltnmList(parm);
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
//                queryResult = app10ElvMobMapperN.DeletePlan(parm);
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
            case "samjung":
                queryResult = app10ElvMobMapperS.DeletePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.DeletePlan(parm);
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
//                queryResult = app10ElvMobMapperN.UpdatePlan(parm);
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
            case "samjung":
                queryResult = app10ElvMobMapperS.UpdatePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.UpdatePlan(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    /**현장조회 (점검계획용)*/
    public List<App26ElvlrtDto> GetAppMobListr_004_plan(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobListr_004_plan(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobListr_004_plan(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobListr_004_plan(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobListr_004_plan(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobListr_004_plan(parm);
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobListr_004_plan(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobListr_004_plan(parm);
            default:
                List<App26ElvlrtDto> object = null;
                return object;
        }
    }


    public List<App03ElvlrtDto> GetApp01List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetApp01List001(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetApp01List001(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetApp01List001(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetApp01List001(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetApp01List001(parm);
            case "samjung":
                return  app10ElvMobMapperS.GetApp01List001(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetApp01List001(parm);
            default:
                List<App03ElvlrtDto> object = null;
                return object;
        }
    }

    public String getMaxPlandate(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.getMaxPlandate(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.getMaxPlandate(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.getMaxPlandate(parm);
            case "nmyang":
                return  app10ElvMobMapperN.getMaxPlandate(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.getMaxPlandate(parm);
            case "samjung":
                return  app10ElvMobMapperS.getMaxPlandate(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.getMaxPlandate(parm);
            default:
                break;
        }
        return "";
    }


    /**현장조회 (고장접수용)*/
    public List<App26ElvlrtDto> GetAppMobListr_004_e601(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobListr_004_e601(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobListr_004_e601(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobListr_004_e601(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobListr_004_e601(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobListr_004_e601(parm);
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobListr_004_e601(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobListr_004_e601(parm);
            default:
                List<App26ElvlrtDto> object = null;
                return object;
        }
    }


    /**고장접수 수정*/
    public int UpdateE401(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = app10ElvMobMapperK.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperG.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = app10ElvMobMapperN.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = app10ElvMobMapperH.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "samjung":
                queryResult = app10ElvMobMapperS.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.UpdateE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }


    /**접수 등록**/
    public int InsertE401(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = app10ElvMobMapperK.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperG.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = app10ElvMobMapperN.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = app10ElvMobMapperH.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "samjung":
                queryResult = app10ElvMobMapperS.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.InsertE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }

    /**접수 삭제**/
    public int DeleteE401(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = app10ElvMobMapperN.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = app10ElvMobMapperH.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "samjung":
                queryResult = app10ElvMobMapperS.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.DeleteE401(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }


    /** view page **/
    public List<App10ElvlrtDto> GetAppMobList002(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMobMapper.GetAppMobList002(parm);
            case "ELV_KYOUNG":
                return  app10ElvMobMapperK.GetAppMobList002(parm);
            case "ELV_GAON":
                return  app10ElvMobMapperG.GetAppMobList002(parm);
            case "nmyang":
                return  app10ElvMobMapperN.GetAppMobList002(parm);
            case "hanyangs":
                return  app10ElvMobMapperH.GetAppMobList002(parm);
            case "samjung":
                return  app10ElvMobMapperS.GetAppMobList002(parm);
            case "samjungilsan":
                return  app10ElvMobMapperSj.GetAppMobList002(parm);
            default:
                List<App10ElvlrtDto> object = null;
                return object;
        }
    }




    /** 처리접수 식제 */

    public boolean DeleteList002(PopupDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.DeleteList002(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.DeleteList002(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.DeleteList002(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.DeleteList002(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.DeleteList002(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMobMapperS.DeleteList002(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.DeleteList002(parm);
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
    public boolean UpdateList002_rollback(PopupDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.UpdateList002_rollback(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.UpdateList002_rollback(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.UpdateList002_rollback(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.UpdateList002_rollback(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.UpdateList002_rollback(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMobMapperS.UpdateList002_rollback(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.UpdateList002_rollback(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }


    /**고장처리 수정**/
    @Transactional
    public boolean Update10Manull(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMobMapper.Update10Manull(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMobMapperG.Update10Manull(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMobMapperK.Update10Manull(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMobMapperN.Update10Manull(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMobMapperH.Update10Manull(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMobMapperS.Update10Manull(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMobMapperSj.Update10Manull(parm);
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
