package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.DTO.CommonDto;
import com.actas.ems.Mapper.Elvlrt.App01ElvlrtMapper;
import com.actas.ems.Mapper.Elvlrt.App06ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App01GaonMapper;
import com.actas.ems.Mapper.kyoung.App01KyoungMapper;
import com.actas.ems.Mapper.kyoung.App06KyoungMapper;
import com.actas.ems.Mapper.nm.App01NmMapper;
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
//    @Autowired
//    App06GaonMapper appMapperG;
    @Autowired
    App06KyoungMapper appMapperK;
//    @Autowired
//    App06NmMapper appMapperN;
    int queryResult = 1;
    /** 글 목록 */
    public List<App06ElvlrtDto> GetMHManualList(App06ElvlrtDto perm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                System.out.println("ELV_LRT !!!!");
                return  App06ElvMapper.GetMHManualList(perm);
            case "ELV_KYOUNG":
                System.out.println("ELV_KYOUNG !!!!");
                return  appMapperK.GetMHManualList(perm);
            default:
                List<App06ElvlrtDto> Object = null;
                return Object;
        }
    }
    public List<App06ElvlrtDto> GetMHManualBlankList(App06ElvlrtDto perm){return App06ElvMapper.GetMHManualList(perm);}

    /** 글 조회 */
    public App06ElvlrtDto GetMHManualView(@RequestParam("hseq") String mSeq){return App06ElvMapper.GetMHManualView(mSeq);}
    /** 글 등록 */
    public boolean InsertMHManual(App06ElvlrtDto perm){
        queryResult = App06ElvMapper.InsertMHManual(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 수정 */
    public boolean UpdateMHManual(App06ElvlrtDto perm){
        queryResult = App06ElvMapper.UpdateMHManual(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 삭제 */
    public boolean DeleteMHManual(App06ElvlrtDto perm){
        queryResult = App06ElvMapper.DeleteMHManual(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public String getMHManualMaxSeq(String parm){ return App06ElvMapper.getMHManualMaxSeq(parm);}



    public List<CommonDto> GetComm751List(){return App06ElvMapper.GetComm751List();}
    public List<CommonDto>  GetComm751BlankList(){return App06ElvMapper.GetComm751List();}
}
