package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App04ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App04GaonMapper;
import com.actas.ems.Mapper.kyoung.App04KyoungMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequiredArgsConstructor
@Service("App04ElvlrtService")
public class  App04ElvlrtService {

    @Autowired
    App04ElvlrtMapper app04ElvMapper;
    @Autowired
    App04GaonMapper app04ElvMapperG;
    @Autowired
    App04KyoungMapper app04ElvMapperK;
    @Autowired
    App04GaonMapper app04ElvMapperN;
    @Autowired
    App04GaonMapper app04ElvMapperH;

    /** 글 목록 */
    public Object GetMManulList(App04ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetMManulList(parm);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetMManulList(parm);
            case "ELV_GAON":
                return  app04ElvMapperG.GetMManulList(parm);
            case "nmyang":
                return  app04ElvMapperN.GetMManulList(parm);
            case "hanyangs":
                return  app04ElvMapperH.GetMManulList(parm);
            default:
                break;
        }
        List<App03ElvlrtDto> Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetMManulList(parm);}
    public List<App04ElvlrtDto> GetMManuBlankList(App04ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetMManulList(parm);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetMManulList(parm);
            case "ELV_GAON":
                return  app04ElvMapperG.GetMManulList(parm);
            case "nmyang":
                return  app04ElvMapperN.GetMManulList(parm);
            case "hanyangs":
                return  app04ElvMapperH.GetMManulList(parm);
            default:
                break;
        }
        List<App04ElvlrtDto> Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetMManulList(parm);}

    /** 글 조회 */
    public App04ElvlrtDto GetMManuView(@RequestParam("mseq") String mSeq){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetMManulView(mSeq);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetMManulView(mSeq);
            case "ELV_GAON":
                return  app04ElvMapperG.GetMManulView(mSeq);
            case "nmyang":
                return  app04ElvMapperN.GetMManulView(mSeq);
            case "hanyangs":
                return  app04ElvMapperH.GetMManulView(mSeq);
            default:
                break;
        }
        App04ElvlrtDto Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetMManulView(mSeq);}
    /** 글 등록 */
    public boolean InsertMManu(App04ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app04ElvMapper.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app04ElvMapperG.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app04ElvMapperK.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app04ElvMapperN.InsertMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app04ElvMapperH.InsertMManul(parm);
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
    public boolean UpdateMManu(App04ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app04ElvMapper.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app04ElvMapperG.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app04ElvMapperK.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app04ElvMapperN.UpdateMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app04ElvMapperH.UpdateMManul(parm);
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
    public boolean DeleteMManu(App04ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app04ElvMapper.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app04ElvMapperG.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app04ElvMapperK.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app04ElvMapperN.DeleteMManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app04ElvMapperH.DeleteMManul(parm);
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
                return  app04ElvMapper.getMManualMaxSeq(parm);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.getMManualMaxSeq(parm);
            case "ELV_GAON":
                return  app04ElvMapperG.getMManualMaxSeq(parm);
            case "nmyang":
                return  app04ElvMapperN.getMManualMaxSeq(parm);
            case "hanyangs":
                return  app04ElvMapperH.getMManualMaxSeq(parm);
            default:
                break;
        } 
        return "";
    }
//    { return app04ElvMapper.getMManualMaxSeq(parm);}
    public Object GetDManulList(App04ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetDManulList(parm);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetDManulList(parm);
            case "ELV_GAON":
                return  app04ElvMapperG.GetDManulList(parm);
            case "nmyang":
                return  app04ElvMapperN.GetDManulList(parm);
            case "hanyangs":
                return  app04ElvMapperH.GetDManulList(parm);
            default:
                break;
        }
        return "";
    }
//    {return app04ElvMapper.GetDManulList(parm);}
    public List<App04ElvlrtDto> GetDManuBlankList(App04ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetDManulList(parm);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetDManulList(parm);
            case "ELV_GAON":
                return  app04ElvMapperG.GetDManulList(parm);
            case "nmyang":
                return  app04ElvMapperN.GetDManulList(parm);
            case "hanyangs":
                return  app04ElvMapperH.GetDManulList(parm);
            default:
                break;
        }
        List<App04ElvlrtDto> Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetDManulList(parm);}

    /** 글 조회 */
    public App04ElvlrtDto GetDManuView(@RequestParam("dseq") String dSeq){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetDManulView(dSeq);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetDManulView(dSeq);
            case "ELV_GAON":
                return  app04ElvMapperG.GetDManulView(dSeq);
            case "nmyang":
                return  app04ElvMapperN.GetDManulView(dSeq);
            case "hanyangs":
                return  app04ElvMapperH.GetDManulView(dSeq);
            default:
                break;
        }
        App04ElvlrtDto Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetDManulView(dSeq);}
    /** 글 등록 */
    public boolean InsertDManu(App04ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app04ElvMapper.InsertDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app04ElvMapperG.InsertDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app04ElvMapperK.InsertDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app04ElvMapperN.InsertDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app04ElvMapperH.InsertDManul(parm);
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
    public boolean UpdateDManu(App04ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app04ElvMapper.UpdateDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app04ElvMapperG.UpdateDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app04ElvMapperK.UpdateDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app04ElvMapperN.UpdateDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app04ElvMapperH.UpdateDManul(parm);
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
    public boolean DeleteDManu(App04ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app04ElvMapper.DeleteDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app04ElvMapperG.DeleteDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app04ElvMapperK.DeleteDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app04ElvMapperN.DeleteDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app04ElvMapperH.DeleteDManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    public String getDManualMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.getDManualMaxSeq(parm);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.getDManualMaxSeq(parm);
            case "ELV_GAON":
                return  app04ElvMapperG.getDManualMaxSeq(parm);
            case "nmyang":
                return  app04ElvMapperN.getDManualMaxSeq(parm);
            case "hanyangs":
                return  app04ElvMapperH.getDManualMaxSeq(parm);
            default:
                break;
        } 
        return "";
    }
//    { return app04ElvMapper.getDManualMaxSeq(parm);}
    public Object GetEManulList(App04ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetEManulList(parm);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetEManulList(parm);
            case "ELV_GAON":
                return  app04ElvMapperG.GetEManulList(parm);
            case "nmyang":
                return  app04ElvMapperN.GetEManulList(parm);
            case "hanyangs":
                return  app04ElvMapperH.GetEManulList(parm);
            default:
                break;
        }
        App04ElvlrtDto Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetEManulList(parm);}
    public List<App04ElvlrtDto> GetEManuBlankList(App04ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetEManulList(parm);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetEManulList(parm);
            case "ELV_GAON":
                return  app04ElvMapperG.GetEManulList(parm);
            case "nmyang":
                return  app04ElvMapperN.GetEManulList(parm);
            case "hanyangs":
                return  app04ElvMapperH.GetEManulList(parm);
            default:
                break;
        }
        List<App04ElvlrtDto> Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetEManulList(parm);}
    /** 글 조회 */
    public App04ElvlrtDto GetEManuView(@RequestParam("eseq") String eSeq){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetEManulView(eSeq);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetEManulView(eSeq);
            case "ELV_GAON":
                return  app04ElvMapperG.GetEManulView(eSeq);
            case "nmyang":
                return  app04ElvMapperN.GetEManulView(eSeq);
            case "hanyangs":
                return  app04ElvMapperH.GetEManulView(eSeq);
            default:
                break;
        }
        App04ElvlrtDto Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetEManulView(eSeq);}
    /** 글 등록 */
    public boolean InsertEManu(App04ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app04ElvMapper.InsertEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app04ElvMapperG.InsertEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app04ElvMapperK.InsertEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app04ElvMapperN.InsertEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app04ElvMapperH.InsertEManul(parm);
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
    public boolean UpdateEManu(App04ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app04ElvMapper.UpdateEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app04ElvMapperG.UpdateEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app04ElvMapperK.UpdateEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app04ElvMapperN.UpdateEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app04ElvMapperH.UpdateEManul(parm);
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
    public boolean DeleteEManu(App04ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app04ElvMapper.DeleteEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app04ElvMapperG.DeleteEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app04ElvMapperK.DeleteEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app04ElvMapperN.DeleteEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app04ElvMapperH.DeleteEManul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    public String getEManualMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.getEManualMaxSeq(parm);
            case "ELV_KYOUNG":
                return  app04ElvMapperK.getEManualMaxSeq(parm);
            case "ELV_GAON":
                return  app04ElvMapperG.getEManualMaxSeq(parm);
            case "nmyang":
                return  app04ElvMapperN.getEManualMaxSeq(parm);
            case "hanyangs":
                return  app04ElvMapperH.getEManualMaxSeq(parm);
            default:
                break;
        }
        return "";
    }
//    { return app04ElvMapper.getEManualMaxSeq(parm);}
    public List<CommonDto> GetComm750List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetComm750List();
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetComm750List();
            case "ELV_GAON":
                return  app04ElvMapperG.GetComm750List();
            case "nmyang":
                return  app04ElvMapperN.GetComm750List();
            case "hanyangs":
                return  app04ElvMapperH.GetComm750List();
            default:
                break;
        }
        List<CommonDto> Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetComm750List();}
    public List<CommonDto>  GetComm750BlankList(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetComm750List();
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetComm750List();
            case "ELV_GAON":
                return  app04ElvMapperG.GetComm750List();
            case "nmyang":
                return  app04ElvMapperN.GetComm750List();
            case "hanyangs":
                return  app04ElvMapperH.GetComm750List();
            default:
                break;
        }
        List<CommonDto> Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetComm750List();}
    public List<CommonDto> GetComm752List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetComm752List();
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetComm752List();
            case "ELV_GAON":
                return  app04ElvMapperG.GetComm752List();
            case "nmyang":
                return  app04ElvMapperN.GetComm752List();
            case "hanyangs":
                return  app04ElvMapperH.GetComm752List();
            default:
                break;
        }
        List<CommonDto> Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetComm752List();}
    public List<CommonDto>  GetComm752BlankList(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetComm752List();
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetComm752List();
            case "ELV_GAON":
                return  app04ElvMapperG.GetComm752List();
            case "nmyang":
                return  app04ElvMapperN.GetComm752List();
            case "hanyangs":
                return  app04ElvMapperH.GetComm752List();
            default:
                break;
        }
        List<CommonDto> Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetComm752List();}
    public List<CommonDto> GetComm753List(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetComm753List();
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetComm753List();
            case "ELV_GAON":
                return  app04ElvMapperG.GetComm753List();
            case "nmyang":
                return  app04ElvMapperN.GetComm753List();
            case "hanyangs":
                return  app04ElvMapperH.GetComm753List();
            default:
                break;
        }
        List<CommonDto> Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetComm753List();}
    
    public List<CommonDto>  GetComm753BlankList(){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app04ElvMapper.GetComm753List();
            case "ELV_KYOUNG":
                return  app04ElvMapperK.GetComm753List();
            case "ELV_GAON":
                return  app04ElvMapperG.GetComm753List();
            case "nmyang":
                return  app04ElvMapperN.GetComm753List();
            case "hanyangs":
                return  app04ElvMapperH.GetComm753List();
            default:
                break;
        }
        List<CommonDto> Object = null;
        return Object;
    }
//    {return app04ElvMapper.GetComm753List();}





}
