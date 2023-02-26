package com.actas.ems.Service.elvlrt.App_mbmanualService;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import com.actas.ems.Mapper.Elvlrt.App_mbmanual.App_mbmanualMapper;
import com.actas.ems.Mapper.gaon.App_mbmanual.App_mbmanualGaonMapper;
import com.actas.ems.Mapper.kyoung.App_mbmanual.App_mbmanualKyoungMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service("App_mbmanualService")
public class App_mbmanualService {

    @Autowired
    App_mbmanualMapper app_mbmanualMapper;
    @Autowired
    App_mbmanualGaonMapper app_mbmanualMapperG;
    @Autowired
    App_mbmanualKyoungMapper app_mbmanualMapperK;
    @Autowired
    App_mbmanualMapper app_mbmanualMapperN;
    @Autowired
    App_mbmanualMapper app_mbmanualMapperH;

    int queryResult = 1;

    public Object GetMManulList(App08_mbmanual perm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app_mbmanualMapper.GetMManulList(perm);
            case "ELV_KYOUNG":
                return  app_mbmanualMapperK.GetMManulList(perm);
            case "ELV_GAON":
                return  app_mbmanualMapperG.GetMManulList(perm);
            case "nmyang":
                return  app_mbmanualMapperN.GetMManulList(perm);
            case "hanyangs":
                return  app_mbmanualMapperH.GetMManulList(perm);
            default:
                return null;
        }
    }
//    {return app_mbmanualMapper.GetMManulList(perm);}

    public List<App08_mbmanual> GetMManuBlankList(App08_mbmanual perm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app_mbmanualMapper.GetMManulList(perm);
            case "ELV_KYOUNG":
                return  app_mbmanualMapperK.GetMManulList(perm);
            case "ELV_GAON":
                return  app_mbmanualMapperG.GetMManulList(perm);
            case "nmyang":
                return  app_mbmanualMapperN.GetMManulList(perm);
            case "hanyangs":
                return  app_mbmanualMapperH.GetMManulList(perm);
            default:
                List<App08_mbmanual> object = null;
                return object;
        }
    }
//    {return app_mbmanualMapper.GetMManulList(perm);}


    //상세조회
    public App08_mbmanual GetMManuView(@RequestParam("bseq") String bSeq){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app_mbmanualMapper.GetMManulView(bSeq);
            case "ELV_KYOUNG":
                return  app_mbmanualMapperK.GetMManulView(bSeq);
            case "ELV_GAON":
                return  app_mbmanualMapperG.GetMManulView(bSeq);
            case "nmyang":
                return  app_mbmanualMapperN.GetMManulView(bSeq);
            case "hanyangs":
                return  app_mbmanualMapperH.GetMManulView(bSeq);
            default:
                return null;
        }
    }
//    {return app_mbmanualMapper.GetMManulView(bSeq);}

    public String getMManualMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app_mbmanualMapper.getMManualMaxSeq(parm);
            case "ELV_KYOUNG":
                return  app_mbmanualMapperK.getMManualMaxSeq(parm);
            case "ELV_GAON":
                return  app_mbmanualMapperG.getMManualMaxSeq(parm);
            case "nmyang":
                return  app_mbmanualMapperN.getMManualMaxSeq(parm);
            case "hanyangs":
                return  app_mbmanualMapperH.getMManualMaxSeq(parm);
            default:
                return null;
        }
    }
//    {return app_mbmanualMapper.getMManualMaxSeq(parm);}

    public List<CommonDto> GetComm750List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app_mbmanualMapper.GetComm750List();
            case "ELV_KYOUNG":
                return  app_mbmanualMapperK.GetComm750List();
            case "ELV_GAON":
                return  app_mbmanualMapperG.GetComm750List();
            case "nmyang":
                return  app_mbmanualMapperN.GetComm750List();
            case "hanyangs":
                return  app_mbmanualMapperH.GetComm750List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }
//    { return app_mbmanualMapper.GetComm750List();}

    public List<CommonDto> GetComm750BlankList() {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app_mbmanualMapper.GetComm750List();
            case "ELV_KYOUNG":
                return  app_mbmanualMapperK.GetComm750List();
            case "ELV_GAON":
                return  app_mbmanualMapperG.GetComm750List();
            case "nmyang":
                return  app_mbmanualMapperN.GetComm750List();
            case "hanyangs":
                return  app_mbmanualMapperH.GetComm750List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }
//    {return app_mbmanualMapper.GetComm750List();}
    //글쓰기
    public boolean InsertMManu(App08_mbmanual parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app_mbmanualMapper.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app_mbmanualMapperG.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app_mbmanualMapperK.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app_mbmanualMapperN.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app_mbmanualMapperH.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    //글수정
    @Transactional
    public boolean UpdateMManu(App08_mbmanual parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app_mbmanualMapper.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app_mbmanualMapperG.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app_mbmanualMapperK.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app_mbmanualMapperN.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app_mbmanualMapperH.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    //글삭제
    public boolean DeleteMManu(App08_mbmanual parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app_mbmanualMapper.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app_mbmanualMapperG.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app_mbmanualMapperK.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app_mbmanualMapperN.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app_mbmanualMapperH.DeleteMManul(parm);
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
