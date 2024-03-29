package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.DTO.CommonDto;
import com.actas.ems.Mapper.Elvlrt.App06ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App06GaonMapper;
import com.actas.ems.Mapper.kyoung.App06KyoungMapper;
import com.actas.ems.Mapper.nm.App06NmyangMapper;
import com.actas.ems.Mapper.samjung.App06SamMapper;
import com.actas.ems.Mapper.sjilsan.App06SjilsanMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service("App06ElvlrtService")
public class App06ElvlrtService {


    @Autowired
    App06ElvlrtMapper App06ElvMapper;
    @Autowired
    App06GaonMapper App06ElvMapperG;
    @Autowired
    App06KyoungMapper App06ElvMapperK;
    @Autowired
    App06NmyangMapper App06ElvMapperN;
    @Autowired
    App06ElvlrtMapper App06ElvMapperH;
    @Autowired
    App06SamMapper App06ElvMapperS;
    @Autowired
    App06SjilsanMapper App06ElvMapperSj;
    /** 글 목록 */
    public List<App06ElvlrtDto> GetMHManualList(App06ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  App06ElvMapper.GetMHManualList(parm);
            case "ELV_KYOUNG":
                return  App06ElvMapperK.GetMHManualList(parm);
            case "ELV_GAON":
                return  App06ElvMapperG.GetMHManualList(parm);
            case "nmyang":
                return  App06ElvMapperN.GetMHManualList(parm);
            case "hanyangs":
                return  App06ElvMapperH.GetMHManualList(parm);
            case "samjung":
                return  App06ElvMapperS.GetMHManualList(parm);
            case "samjungilsan":
                return  App06ElvMapperSj.GetMHManualList(parm);
            default:
                break;
        }
        List<App06ElvlrtDto> Object = null;
        return Object;
    }
    public List<App06ElvlrtDto> GetMHManualBlankList(App06ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  App06ElvMapper.GetMHManualList(parm);
            case "ELV_KYOUNG":
                return  App06ElvMapperK.GetMHManualList(parm);
            case "ELV_GAON":
                return  App06ElvMapperG.GetMHManualList(parm);
            case "nmyang":
                return  App06ElvMapperN.GetMHManualList(parm);
            case "hanyangs":
                return  App06ElvMapperH.GetMHManualList(parm);
            case "samjung":
                return  App06ElvMapperS.GetMHManualList(parm);
            case "samjungilsan":
                return  App06ElvMapperSj.GetMHManualList(parm);
            default:
                break;
        }
        List<App06ElvlrtDto> Object = null;
        return Object;
    }
//    {return App06ElvMapper.GetMHManualList(parm);}

    /** 글 조회 */
    public App06ElvlrtDto GetMHManualView(@RequestParam("hseq") String mSeq){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  App06ElvMapper.GetMHManualView(mSeq);
            case "ELV_KYOUNG":
                return  App06ElvMapperK.GetMHManualView(mSeq);
            case "ELV_GAON":
                return  App06ElvMapperG.GetMHManualView(mSeq);
            case "nmyang":
                return  App06ElvMapperN.GetMHManualView(mSeq);
            case "hanyangs":
                return  App06ElvMapperH.GetMHManualView(mSeq);
            case "samjung":
                return  App06ElvMapperS.GetMHManualView(mSeq);
            case "samjungilsan":
                return  App06ElvMapperSj.GetMHManualView(mSeq);
            default:
                break;
        }
        App06ElvlrtDto Object = null;
        return Object;
    }
//    {return App06ElvMapper.GetMHManualView(mSeq);}
    /** 글 등록 */
    public boolean InsertMHManual(App06ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
//        if(parm.getHflag().equals("1")){
//            queryResult = App06ElvMapper.InsertMHManual(parm);
//            parm.setCustcd("KYOUNG");
//            queryResult = App06ElvMapperG.InsertMHManual(parm);
//            parm.setCustcd("GAON");
//            queryResult = App06ElvMapperK.InsertMHManual(parm);
//            parm.setCustcd("nmyang");
//            queryResult = App06ElvMapperN.InsertMHManual(parm);
//        }else{
            switch (ls_dbnm){
                case "ELV_LRT":
                    queryResult = App06ElvMapper.InsertMHManual(parm);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                    return (queryResult > 0);
                case "ELV_GAON":
                    queryResult = App06ElvMapperG.InsertMHManual(parm);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                    return (queryResult > 0);
                case "ELV_KYOUNG":
                    queryResult = App06ElvMapperK.InsertMHManual(parm);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                    return (queryResult > 0);
                case "nmyang":
                    queryResult = App06ElvMapperN.InsertMHManual(parm);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                    return (queryResult > 0);
                case "hanyangs":
                    queryResult = App06ElvMapperH.InsertMHManual(parm);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                    return (queryResult > 0);
                case "samjung":
                    queryResult = App06ElvMapperS.InsertMHManual(parm);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                    return (queryResult > 0);
                case "samjungilsan":
                    queryResult = App06ElvMapperSj.InsertMHManual(parm);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                    return (queryResult > 0);
                default:
                    break;
            }

//        }
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = App06ElvMapper.InsertMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = App06ElvMapperG.InsertMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = App06ElvMapperK.InsertMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = App06ElvMapperN.InsertMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = App06ElvMapperH.InsertMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = App06ElvMapperS.InsertMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = App06ElvMapperSj.InsertMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }
    /** 글 수정 */
    public boolean UpdateMHManual(App06ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = App06ElvMapper.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = App06ElvMapperG.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = App06ElvMapperK.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = App06ElvMapperN.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = App06ElvMapperH.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = App06ElvMapperS.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = App06ElvMapperSj.UpdateMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }
    /** 글 삭제 */
    public boolean DeleteMHManual(App06ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = App06ElvMapper.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = App06ElvMapperG.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = App06ElvMapperK.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = App06ElvMapperN.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = App06ElvMapperH.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = App06ElvMapperS.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = App06ElvMapperSj.DeleteMHManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    public String getMHManualMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  App06ElvMapper.getMHManualMaxSeq(parm);
            case "ELV_KYOUNG":
                return  App06ElvMapperK.getMHManualMaxSeq(parm);
            case "ELV_GAON":
                return  App06ElvMapperG.getMHManualMaxSeq(parm);
            case "nmyang":
                return  App06ElvMapperN.getMHManualMaxSeq(parm);
            case "hanyangs":
                return  App06ElvMapperH.getMHManualMaxSeq(parm);
            case "samjung":
                return  App06ElvMapperS.getMHManualMaxSeq(parm);
            case "samjungilsan":
                return  App06ElvMapperSj.getMHManualMaxSeq(parm);
            default:
                break;
        }
        return "";
    }
//    { return App06ElvMapper.getMHManualMaxSeq(parm);}



    public List<CommonDto> GetComm751List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  App06ElvMapper.GetComm751List();
            case "ELV_KYOUNG":
                return  App06ElvMapperK.GetComm751List();
            case "ELV_GAON":
                return  App06ElvMapperG.GetComm751List();
            case "nmyang":
                return  App06ElvMapperN.GetComm751List();
            case "hanyangs":
                return  App06ElvMapperH.GetComm751List();
            case "samjung":
                return  App06ElvMapperS.GetComm751List();
            case "samjungilsan":
                return  App06ElvMapperSj.GetComm751List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }
//    {return App06ElvMapper.GetComm751List();}
    public List<CommonDto>  GetComm751BlankList(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  App06ElvMapper.GetComm751List();
            case "ELV_KYOUNG":
                return  App06ElvMapperK.GetComm751List();
            case "ELV_GAON":
                return  App06ElvMapperG.GetComm751List();
            case "nmyang":
                return  App06ElvMapperN.GetComm751List();
            case "hanyangs":
                return  App06ElvMapperH.GetComm751List();
            case "samjung":
                return  App06ElvMapperS.GetComm751List();
            case "samjungilsan":
                return  App06ElvMapperSj.GetComm751List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }
//    {return App06ElvMapper.GetComm751List();}
}
