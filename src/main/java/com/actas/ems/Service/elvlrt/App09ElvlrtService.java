package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App09ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App09ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App09GaonMapper;
import com.actas.ems.Mapper.kyoung.App09KyoungMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service("App09ElvlrtService")
public class App09ElvlrtService {

    @Autowired
    App09GaonMapper app09ElvMapper;
    @Autowired
    App09GaonMapper app09ElvMapperG;
    @Autowired
    App09GaonMapper app09ElvMapperK;
    @Autowired
    App09GaonMapper app09ElvMapperN;
    @Autowired
    App09GaonMapper app09ElvMapperH;
    int queryResult = 1;
    public List<App09ElvlrtDto> GetFQManulList(App09ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app09ElvMapper.GetFQManulList(parm);
            case "ELV_KYOUNG":
                return  app09ElvMapperK.GetFQManulList(parm);
            case "ELV_GAON":
                return  app09ElvMapperG.GetFQManulList(parm);
            case "nmyang":
                return  app09ElvMapperN.GetFQManulList(parm);
            case "hanyangs":
                return  app09ElvMapperH.GetFQManulList(parm);
            default:
                List<App09ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app09ElvMapper.GetFQManulList(parm);}

    //글쓰기
    public boolean InsertFQManu(App09ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app09ElvMapper.InsertFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app09ElvMapperG.InsertFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app09ElvMapperK.InsertFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app09ElvMapperN.InsertFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app09ElvMapperH.InsertFQManul(parm);
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
    public boolean UpdateFQManu(App09ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app09ElvMapper.UpdateFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app09ElvMapperG.UpdateFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app09ElvMapperK.UpdateFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app09ElvMapperN.UpdateFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app09ElvMapperH.UpdateFQManul(parm);
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
    public boolean DeleteFQManu(App09ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app09ElvMapper.DeleteFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app09ElvMapperG.DeleteFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app09ElvMapperK.DeleteFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app09ElvMapperN.DeleteFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app09ElvMapperH.DeleteFQManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }


    public String getFQManualMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app09ElvMapper.getFQManualMaxSeq(parm);
            case "ELV_KYOUNG":
                return  app09ElvMapperK.getFQManualMaxSeq(parm);
            case "ELV_GAON":
                return  app09ElvMapperG.getFQManualMaxSeq(parm);
            case "nmyang":
                return  app09ElvMapperN.getFQManualMaxSeq(parm);
            case "hanyangs":
                return  app09ElvMapperH.getFQManualMaxSeq(parm);
            default:
                return "";
        }
    }
//    {return app09ElvMapper.getFQManualMaxSeq(parm);}

    public List<CommonDto> GetComm750List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app09ElvMapper.GetComm750List();
            case "ELV_KYOUNG":
                return  app09ElvMapperK.GetComm750List();
            case "ELV_GAON":
                return  app09ElvMapperG.GetComm750List();
            case "nmyang":
                return  app09ElvMapperN.GetComm750List();
            case "hanyangs":
                return  app09ElvMapperH.GetComm750List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }
//    { return app09ElvMapper.GetComm750List();}
    public List<CommonDto> GetComm750BlankList(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app09ElvMapper.GetComm750List();
            case "ELV_KYOUNG":
                return  app09ElvMapperK.GetComm750List();
            case "ELV_GAON":
                return  app09ElvMapperG.GetComm750List();
            case "nmyang":
                return  app09ElvMapperN.GetComm750List();
            case "hanyangs":
                return  app09ElvMapperH.GetComm750List();
            default:
                List<CommonDto> object = null;
                return object;
        }
    }
//    {return app09ElvMapper.GetComm750List();}
}
