package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App07ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App07GaonMapper;
import com.actas.ems.Mapper.kyoung.App07KyoungMapper;
import com.actas.ems.Mapper.nm.App07NmyangMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service("App07ElvlrtService")
public class App07ElvlrtService {
 
    @Autowired
    App07ElvlrtMapper app07ElvMapper;
    @Autowired
    App07GaonMapper app07ElvMapperG;
    @Autowired
    App07KyoungMapper app07ElvMapperK;
    @Autowired
    App07NmyangMapper app07ElvMapperN;
    @Autowired
    App07ElvlrtMapper app07ElvMapperH;
    int queryResult = 1;
    
    public Object GetMManulList(App07ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app07ElvMapper.GetMManulList(parm);
            case "ELV_KYOUNG":
                return  app07ElvMapperK.GetMManulList(parm);
            case "ELV_GAON":
                return  app07ElvMapperG.GetMManulList(parm);
            case "nmyang":
                return  app07ElvMapperN.GetMManulList(parm);
            case "hanyangs":
                return  app07ElvMapperH.GetMManulList(parm);
            default:
                return null;
        }
    }
//    {return app07ElvMapper.GetMManulList(parm);}

    public List<App07ElvlrtDto> GetMManuBlankList(App07ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app07ElvMapper.GetMManulList(parm);
            case "ELV_KYOUNG":
                return  app07ElvMapperK.GetMManulList(parm);
            case "ELV_GAON":
                return  app07ElvMapperG.GetMManulList(parm);
            case "nmyang":
                return  app07ElvMapperN.GetMManulList(parm);
            case "hanyangs":
                return  app07ElvMapperH.GetMManulList(parm);
            default:
                return null;
        }
    }
//    {return app07ElvMapper.GetMManulList(parm);}


    //상세조회
    public App07ElvlrtDto GetMManuView(@RequestParam("fseq") String fSeq){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app07ElvMapper.GetMManulView(fSeq);
            case "ELV_KYOUNG":
                return  app07ElvMapperK.GetMManulView(fSeq);
            case "ELV_GAON":
                return  app07ElvMapperG.GetMManulView(fSeq);
            case "nmyang":
                return  app07ElvMapperN.GetMManulView(fSeq);
            case "hanyangs":
                return  app07ElvMapperH.GetMManulView(fSeq);
            default:
                return null;
        }
    }
//    {return app07ElvMapper.GetMManulView(fSeq);}

    //글쓰기
    public boolean InsertMManu(App07ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app07ElvMapper.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app07ElvMapperG.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app07ElvMapperK.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app07ElvMapperN.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app07ElvMapperH.InsertMManul(parm);
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
    public boolean UpdateMManu(App07ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app07ElvMapper.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app07ElvMapperG.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app07ElvMapperK.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app07ElvMapperN.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app07ElvMapperH.UpdateMManul(parm);
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
    public boolean DeleteMManu(App07ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app07ElvMapper.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app07ElvMapperG.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app07ElvMapperK.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app07ElvMapperN.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app07ElvMapperH.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }




    public String getMManualMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app07ElvMapper.getMManualMaxSeq(parm);
            case "ELV_KYOUNG":
                return  app07ElvMapperK.getMManualMaxSeq(parm);
            case "ELV_GAON":
                return  app07ElvMapperG.getMManualMaxSeq(parm);
            case "nmyang":
                return  app07ElvMapperN.getMManualMaxSeq(parm);
            case "hanyangs":
                return  app07ElvMapperH.getMManualMaxSeq(parm);
            default:
                return null;
        }
    }
//    {return app07ElvMapper.getMManualMaxSeq(parm);}

    public List<CommonDto> GetComm750List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
            switch (ls_dbnm){
            case "ELV_LRT":
                return  app07ElvMapper.GetComm750List();
            case "ELV_KYOUNG":
                return  app07ElvMapperK.GetComm750List();
            case "ELV_GAON":
                return  app07ElvMapperG.GetComm750List();
            case "nmyang":
                return  app07ElvMapperN.GetComm750List();
            case "hanyangs":
                return  app07ElvMapperH.GetComm750List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }
//    { return app07ElvMapper.GetComm750List();}

    public List<CommonDto> GetComm750BlankList(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app07ElvMapper.GetComm750List();
            case "ELV_KYOUNG":
                return  app07ElvMapperK.GetComm750List();
            case "ELV_GAON":
                return  app07ElvMapperG.GetComm750List();
            case "nmyang":
                return  app07ElvMapperN.GetComm750List();
            case "hanyangs":
                return  app07ElvMapperH.GetComm750List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }
//    {return app07ElvMapper.GetComm750List();}
}
