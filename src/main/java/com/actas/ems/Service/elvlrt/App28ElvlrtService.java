package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App28ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App28ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App28GaonMapper;
import com.actas.ems.Mapper.kyoung.App28KyoungMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service("App28ElvlrtService")
public class App28ElvlrtService {


    @Autowired
    App28GaonMapper app28ElvMapper;
    @Autowired
    App28GaonMapper app28ElvMapperG;
    @Autowired
    App28GaonMapper app28ElvMapperK;
    @Autowired
    App28GaonMapper app28ElvMapperN;
    @Autowired
    App28GaonMapper app28ElvMapperH;
    int queryResult = 1;
    /** 글 목록 */
    public List<App28ElvlrtDto> GetMSManualList(App28ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app28ElvMapper.GetMSManualList(parm);
            case "ELV_KYOUNG":
                return  app28ElvMapperK.GetMSManualList(parm);
            case "ELV_GAON":
                return  app28ElvMapperG.GetMSManualList(parm);
            case "nmyang":
                return  app28ElvMapperN.GetMSManualList(parm);
            case "hanyangs":
                return  app28ElvMapperH.GetMSManualList(parm);
            default:
                List<App28ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app28ElvMapper.GetMSManualList(parm);}
    public List<App28ElvlrtDto> GetMSManualBlankList(App28ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app28ElvMapper.GetMSManualList(parm);
            case "ELV_KYOUNG":
                return  app28ElvMapperK.GetMSManualList(parm);
            case "ELV_GAON":
                return  app28ElvMapperG.GetMSManualList(parm);
            case "nmyang":
                return  app28ElvMapperN.GetMSManualList(parm);
            case "hanyangs":
                return  app28ElvMapperH.GetMSManualList(parm);
            default:
                List<App28ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app28ElvMapper.GetMSManualList(parm);}

    /** 글 조회 */
    public App28ElvlrtDto GetMSManualView(@RequestParam("nseq") String mSeq){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app28ElvMapper.GetMSManualView(mSeq);
            case "ELV_KYOUNG":
                return  app28ElvMapperK.GetMSManualView(mSeq);
            case "ELV_GAON":
                return  app28ElvMapperG.GetMSManualView(mSeq);
            case "nmyang":
                return  app28ElvMapperN.GetMSManualView(mSeq);
            case "hanyangs":
                return  app28ElvMapperH.GetMSManualView(mSeq);
            default:
                App28ElvlrtDto object = null;
                return object;
        }
    }
//    {return app28ElvMapper.GetMSManualView(mSeq);}



    public String getMSManualMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app28ElvMapper.getMSManualMaxSeq(parm);
            case "ELV_KYOUNG":
                return  app28ElvMapperK.getMSManualMaxSeq(parm);
            case "ELV_GAON":
                return  app28ElvMapperG.getMSManualMaxSeq(parm);
            case "nmyang":
                return  app28ElvMapperN.getMSManualMaxSeq(parm);
            case "hanyangs":
                return  app28ElvMapperH.getMSManualMaxSeq(parm);
            default:
                return "";
        }
    }
//    { return app28ElvMapper.getMSManualMaxSeq(parm);}



    public List<CommonDto> GetComm751List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app28ElvMapper.GetComm751List();
            case "ELV_KYOUNG":
                return  app28ElvMapperK.GetComm751List();
            case "ELV_GAON":
                return  app28ElvMapperG.GetComm751List();
            case "nmyang":
                return  app28ElvMapperN.GetComm751List();
            case "hanyangs":
                return  app28ElvMapperH.GetComm751List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }
//    {return app28ElvMapper.GetComm751List();}
    public List<CommonDto>  GetComm751BlankList(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app28ElvMapper.GetComm751List();
            case "ELV_KYOUNG":
                return  app28ElvMapperK.GetComm751List();
            case "ELV_GAON":
                return  app28ElvMapperG.GetComm751List();
            case "nmyang":
                return  app28ElvMapperN.GetComm751List();
            case "hanyangs":
                return  app28ElvMapperH.GetComm751List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }
//    {return app28ElvMapper.GetComm751List();}

    public List<App28ElvlrtDto> getMSCommentList(App28ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app28ElvMapper.getMSCommentList(parm);
            case "ELV_KYOUNG":
                return  app28ElvMapperK.getMSCommentList(parm);
            case "ELV_GAON":
                return  app28ElvMapperG.getMSCommentList(parm);
            case "nmyang":
                return  app28ElvMapperN.getMSCommentList(parm);
            case "hanyangs":
                return  app28ElvMapperH.getMSCommentList(parm);
            default:
                List<App28ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app28ElvMapper.getMSCommentList(parm);}

    public String GetMSCommentCount(String sseq){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app28ElvMapper.GetMSCommentCount(sseq);
            case "ELV_KYOUNG":
                return  app28ElvMapperK.GetMSCommentCount(sseq);
            case "ELV_GAON":
                return  app28ElvMapperG.GetMSCommentCount(sseq);
            case "nmyang":
                return  app28ElvMapperN.GetMSCommentCount(sseq);
            case "hanyangs":
                return  app28ElvMapperH.GetMSCommentCount(sseq);
            default:
                return "";
        }
    }
//    {return app28ElvMapper.GetMSCommentCount(sseq);}


    /** 글 등록 */
    public boolean InsertMSManual(App28ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app28ElvMapper.InsertMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app28ElvMapperG.InsertMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app28ElvMapperK.InsertMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app28ElvMapperN.InsertMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app28ElvMapperH.InsertMSManual(parm);
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
    public boolean UpdateMSManual(App28ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app28ElvMapper.UpdateMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app28ElvMapperG.UpdateMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app28ElvMapperK.UpdateMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app28ElvMapperN.UpdateMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app28ElvMapperH.UpdateMSManual(parm);
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
    public boolean DeleteMSManual(App28ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app28ElvMapper.DeleteMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app28ElvMapperG.DeleteMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app28ElvMapperK.DeleteMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app28ElvMapperN.DeleteMSManual(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app28ElvMapperH.DeleteMSManual(parm);
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
