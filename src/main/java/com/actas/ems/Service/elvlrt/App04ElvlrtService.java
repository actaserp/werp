package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App04ElvlrtMapper;
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
    int queryResult = 1;
    /** 글 목록 */
    public Object GetMManulList(App04ElvlrtDto perm){return app04ElvMapper.GetMManulList(perm);}
    public List<App04ElvlrtDto> GetMManuBlankList(App04ElvlrtDto perm){return app04ElvMapper.GetMManulList(perm);}

    /** 글 조회 */
    public App04ElvlrtDto GetMManuView(@RequestParam("mseq") String mSeq){return app04ElvMapper.GetMManulView(mSeq);}
    /** 글 등록 */
    public boolean InsertMManu(App04ElvlrtDto perm){
        queryResult = app04ElvMapper.InsertMManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 수정 */
    public boolean UpdateMManu(App04ElvlrtDto perm){
        queryResult = app04ElvMapper.UpdateMManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 삭제 */
    public boolean DeleteMManu(App04ElvlrtDto perm){
        queryResult = app04ElvMapper.DeleteMManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public String getMManualMaxSeq(String parm){ return app04ElvMapper.getMManualMaxSeq(parm);}


// D Dto

    public Object GetDManulList(App04ElvlrtDto perm){return app04ElvMapper.GetDManulList(perm);}
    public List<App04ElvlrtDto> GetDManuBlankList(App04ElvlrtDto perm){return app04ElvMapper.GetDManulList(perm);}

    /** 글 조회 */
    public App04ElvlrtDto GetDManuView(@RequestParam("dseq") String dSeq){return app04ElvMapper.GetDManulView(dSeq);}
    /** 글 등록 */
    public boolean InsertDManu(App04ElvlrtDto perm){
        queryResult = app04ElvMapper.InsertDManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 수정 */
    public boolean UpdateDManu(App04ElvlrtDto perm){
        queryResult = app04ElvMapper.UpdateDManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 삭제 */
    public boolean DeleteDManu(App04ElvlrtDto perm){
        queryResult = app04ElvMapper.DeleteDManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public String getDManualMaxSeq(String parm){ return app04ElvMapper.getDManualMaxSeq(parm);}



    public List<CommonDto> GetComm750List(){return app04ElvMapper.GetComm750List();}
    public List<CommonDto>  GetComm750BlankList(){return app04ElvMapper.GetComm750List();}



}
