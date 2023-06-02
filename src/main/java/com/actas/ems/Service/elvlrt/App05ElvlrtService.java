package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import com.actas.ems.DTO.CommonDto;
import com.actas.ems.Mapper.Elvlrt.App04ElvlrtMapper;
import com.actas.ems.Mapper.Elvlrt.App05ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App05GaonMapper;
import com.actas.ems.Mapper.kyoung.App05KyoungMapper;
import com.actas.ems.Mapper.nm.App05NmyangMapper;
import com.actas.ems.Mapper.samjung.App05SamMapper;
import com.actas.ems.Mapper.samjung.MattachSamMapper;
import com.actas.ems.Mapper.sjilsan.App05SjilsanMapper;
import com.actas.ems.Mapper.sjilsan.MattachSjilsanMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service("App05ElvlrtService")
public class App05ElvlrtService {


    @Autowired
    App05ElvlrtMapper app05ElvMapper;
    @Autowired
    App05GaonMapper app05ElvMapperG;
    @Autowired
    App05KyoungMapper app05ElvMapperK;
    @Autowired
    App05NmyangMapper app05ElvMapperN;
    @Autowired
    App05ElvlrtMapper app05ElvMapperH;
    @Autowired
    App05SamMapper app05ElvMapperS;
    @Autowired
    App05SjilsanMapper app05ElvMapperSj;

    int queryResult = 1;


    /** 글 목록 */
    public Object GetMNoticeList(App05ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app05ElvMapper.GetMNoticeList(parm);
            case "ELV_KYOUNG":
                return  app05ElvMapperK.GetMNoticeList(parm);
            case "ELV_GAON":
                return  app05ElvMapperG.GetMNoticeList(parm);
            case "nmyang":
                return  app05ElvMapperN.GetMNoticeList(parm);
            case "hanyangs":
                return  app05ElvMapperH.GetMNoticeList(parm);
            case "samjung":
                return  app05ElvMapperS.GetMNoticeList(parm);
            case "samjungilsan":
                return  app05ElvMapperSj.GetMNoticeList(parm);
            default:
                break;
        }
        List<App05ElvlrtDto> Object = null;
        return Object;
    }
//    {return app05ElvMapper.GetMNoticeList(parm);}
    public List<App05ElvlrtDto> GetMNoticeBlankList(App05ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app05ElvMapper.GetMNoticeList(parm);
            case "ELV_KYOUNG":
                return  app05ElvMapperK.GetMNoticeList(parm);
            case "ELV_GAON":
                return  app05ElvMapperG.GetMNoticeList(parm);
            case "nmyang":
                return  app05ElvMapperN.GetMNoticeList(parm);
            case "hanyangs":
                return  app05ElvMapperH.GetMNoticeList(parm);
            case "samjung":
                return  app05ElvMapperS.GetMNoticeList(parm);
            case "samjungilsan":
                return  app05ElvMapperSj.GetMNoticeList(parm);
            default:
                break;
        }
        List<App05ElvlrtDto> Object = null;
        return Object;
    }
//    {return app05ElvMapper.GetMNoticeList(parm);}

    /** 글 조회 */
    public App05ElvlrtDto GetMNoticeView(@RequestParam("nseq") String mSeq){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app05ElvMapper.GetMNoticeView(mSeq);
            case "ELV_KYOUNG":
                return  app05ElvMapperK.GetMNoticeView(mSeq);
            case "ELV_GAON":
                return  app05ElvMapperG.GetMNoticeView(mSeq);
            case "nmyang":
                return  app05ElvMapperN.GetMNoticeView(mSeq);
            case "hanyangs":
                return  app05ElvMapperH.GetMNoticeView(mSeq);
            case "samjung":
                return  app05ElvMapperS.GetMNoticeView(mSeq);
            case "samjungilsan":
                return  app05ElvMapperSj.GetMNoticeView(mSeq);
            default:
                break;
        }
        App05ElvlrtDto Object = null;
        return Object;
    }
//    {return app05ElvMapper.GetMNoticeView(mSeq);}
    /** 글 등록 */
    public boolean InsertMNotice(App05ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app05ElvMapper.InsertMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app05ElvMapperG.InsertMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app05ElvMapperK.InsertMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app05ElvMapperN.InsertMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app05ElvMapperH.InsertMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app05ElvMapperS.InsertMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app05ElvMapperSj.InsertMNotice(parm);
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
    public boolean UpdateMNotice(App05ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app05ElvMapper.UpdateMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app05ElvMapperG.UpdateMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app05ElvMapperK.UpdateMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app05ElvMapperN.UpdateMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app05ElvMapperH.UpdateMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app05ElvMapperS.UpdateMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app05ElvMapperSj.UpdateMNotice(parm);
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
    public boolean DeleteMNotice(App05ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app05ElvMapper.DeleteMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app05ElvMapperG.DeleteMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app05ElvMapperK.DeleteMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app05ElvMapperN.DeleteMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app05ElvMapperH.DeleteMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app05ElvMapperS.DeleteMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app05ElvMapperSj.DeleteMNotice(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    public String getMNoticeMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app05ElvMapper.getMNoticeMaxSeq(parm);
            case "ELV_KYOUNG":
                return  app05ElvMapperK.getMNoticeMaxSeq(parm);
            case "ELV_GAON":
                return  app05ElvMapperG.getMNoticeMaxSeq(parm);
            case "nmyang":
                return  app05ElvMapperN.getMNoticeMaxSeq(parm);
            case "hanyangs":
                return  app05ElvMapperH.getMNoticeMaxSeq(parm);
            case "samjung":
                return  app05ElvMapperS.getMNoticeMaxSeq(parm);
            case "samjungilsan":
                return  app05ElvMapperSj.getMNoticeMaxSeq(parm);
            default:
                break;
        }
        return "";
    }
//    { return app05ElvMapper.getMNoticeMaxSeq(parm);}
    public List<CommonDto> GetComm751List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app05ElvMapper.GetComm751List();
            case "ELV_KYOUNG":
                return  app05ElvMapperK.GetComm751List();
            case "ELV_GAON":
                return  app05ElvMapperG.GetComm751List();
            case "nmyang":
                return  app05ElvMapperN.GetComm751List();
            case "hanyangs":
                return  app05ElvMapperH.GetComm751List();
            case "samjung":
                return  app05ElvMapperS.GetComm751List();
            case "samjungilsan":
                return  app05ElvMapperSj.GetComm751List();
            default:
                break;
        }
        List<CommonDto> Object = null;
        return Object;
    }
//    {return app05ElvMapper.GetComm751List();}
    public List<CommonDto>  GetComm751BlankList(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app05ElvMapper.GetComm751List();
            case "ELV_KYOUNG":
                return  app05ElvMapperK.GetComm751List();
            case "ELV_GAON":
                return  app05ElvMapperG.GetComm751List();
            case "nmyang":
                return  app05ElvMapperN.GetComm751List();
            case "hanyangs":
                return  app05ElvMapperH.GetComm751List();
            case "samjung":
                return  app05ElvMapperS.GetComm751List();
            case "samjungilsan":
                return  app05ElvMapperSj.GetComm751List();
            default:
                break;
        }
        List<CommonDto> Object = null;
        return Object;
    }
//    {return app05ElvMapper.GetComm751List();}
}
