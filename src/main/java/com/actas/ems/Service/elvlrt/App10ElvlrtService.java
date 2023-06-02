package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App10GaonMapper;
import com.actas.ems.Mapper.kyoung.App10KyoungMapper;
import com.actas.ems.Mapper.nm.App10NmyangMapper;
import com.actas.ems.Mapper.samjung.App09SamMapper;
import com.actas.ems.Mapper.samjung.App10SamMapper;
import com.actas.ems.Mapper.sjilsan.App09SjilsanMapper;
import com.actas.ems.Mapper.sjilsan.App10SjilsanMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service("App10ElvlrtService")
public class App10ElvlrtService {

    @Autowired
    App10ElvlrtMapper app10ElvMapper;
    @Autowired
    App10GaonMapper app10ElvMapperG;
    @Autowired
    App10KyoungMapper app10ElvMapperK;
    @Autowired
    App10NmyangMapper app10ElvMapperN;
    @Autowired
    App10ElvlrtMapper app10ElvMapperH;
    @Autowired
    App10SamMapper app10ElvMapperS;
    @Autowired
    App10SjilsanMapper app10ElvMapperSj;
    int queryResult = 1;

    /** pin page **/
    public List<App10ElvlrtDto> GetApp10List002(App10ElvlrtDto parm){
    String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm)
        {
            case "ELV_LRT":
                return app10ElvMapper.GetApp10List002(parm);
            case "ELV_KYOUNG":
                return app10ElvMapperK.GetApp10List002(parm);
            case "nmyang":
                return app10ElvMapperN.GetApp10List002(parm);
            case "ELV_GAON":
                return app10ElvMapperG.GetApp10List002(parm);
            case "hanyangs":
                return app10ElvMapperH.GetApp10List002(parm);
            case "samjung":
                return  app10ElvMapperS.GetApp10List002(parm);
            case "samjungilsan":
                return  app10ElvMapperSj.GetApp10List002(parm);
            default:
                List<App10ElvlrtDto> Object = null;
                return Object;
        }
    }

    /** view page **/
    public List<App10ElvlrtDto> GetApp10List001(App10ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm)
        {
            case "ELV_LRT":
                return app10ElvMapper.GetApp10List001(parm);
            case "ELV_KYOUNG":
                return app10ElvMapperK.GetApp10List001(parm);
            case "nmyang":
                return app10ElvMapperN.GetApp10List001(parm);
            case "ELV_GAON":
                return app10ElvMapperG.GetApp10List001(parm);
            case "hanyangs":
                return app10ElvMapperH.GetApp10List001(parm);
            case "samjung":
                return  app10ElvMapperS.GetApp10List001(parm);
            case "samjungilsan":
                return  app10ElvMapperSj.GetApp10List001(parm);
            default:
                List<App10ElvlrtDto> Object = null;
                return Object;
        }
    }

    /** view page2 **/
    public List<App10ElvlrtDto> GetApptab10List001(App10ElvlrtDto parm){return app10ElvMapper.GetApptab10List001(parm);}


    /** 글 등록 */
    public boolean Insert10Manu(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMapper.Insert10Manul(parm);
                if(queryResult < 1){  //값 확인
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMapperG.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMapperK.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMapperN.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMapperH.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMapperS.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMapperSj.Insert10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    //처리등록 compnum
    public String get10ManualMaxSeq(String parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app10ElvMapper.get10ManualMaxSeq(parm);
            case "ELV_KYOUNG":
                return  app10ElvMapperK.get10ManualMaxSeq(parm);
            case "ELV_GAON":
                return  app10ElvMapperG.get10ManualMaxSeq(parm);
            case "nmyang":
                return  app10ElvMapperN.get10ManualMaxSeq(parm);
            case "hanyangs":
                return  app10ElvMapperH.get10ManualMaxSeq(parm);
            case "samjung":
                return  app10ElvMapperS.get10ManualMaxSeq(parm);
            case "samjungilsan":
                return  app10ElvMapperSj.get10ManualMaxSeq(parm);
            default:
                return "";
        }
    }
//    {return app10ElvMapper.get10ManualMaxSeq(parm);}


    //글수정
    @Transactional
    public boolean Update10Manu(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMapper.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMapperG.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMapperK.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMapperN.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMapperH.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMapperS.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMapperSj.Update10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    //resultck 변경

    @Transactional
    public boolean Updateresult1(App10ElvlrtDto parm){

        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMapper.Updateresult11(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMapperG.Updateresult11(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMapperK.Updateresult11(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMapperN.Updateresult11(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMapperH.Updateresult11(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMapperS.Updateresult11(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMapperSj.Updateresult11(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            default:
                break;
        }
        return true;
    }
    @Transactional
    public boolean Updateresult0(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMapper.Updateresult10(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMapperG.Updateresult10(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMapperK.Updateresult10(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMapperN.Updateresult10(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMapperH.Updateresult10(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMapperS.Updateresult10(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMapperSj.Updateresult10(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            default:
                break;
        }
        return true;
    }
    @Transactional
    public boolean Updateresult00(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMapper.Updateresult100(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMapperG.Updateresult100(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMapperK.Updateresult100(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMapperN.Updateresult100(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMapperH.Updateresult100(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMapperS.Updateresult100(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMapperSj.Updateresult100(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            default:
                break;
        }
        return true;
    }

    //글삭제
    public boolean Delete10Manu(App10ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = app10ElvMapper.Delete10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = app10ElvMapperG.Delete10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = app10ElvMapperK.Delete10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = app10ElvMapperN.Delete10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = app10ElvMapperH.Delete10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjung":
                queryResult = app10ElvMapperS.Delete10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = app10ElvMapperSj.Delete10Manul(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            default:
                break;
        }
        return true;
    }
}
