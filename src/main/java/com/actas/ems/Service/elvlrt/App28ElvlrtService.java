package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App28ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App28ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service("App28ElvlrtService")
public class App28ElvlrtService {


    @Autowired
    App28ElvlrtMapper app28ElvMapper;
    int queryResult = 1;
    /** 글 목록 */
    public List<App28ElvlrtDto> GetMSManualList(App28ElvlrtDto perm){return app28ElvMapper.GetMSManualList(perm);}
    public List<App28ElvlrtDto> GetMSManualBlankList(App28ElvlrtDto perm){return app28ElvMapper.GetMSManualList(perm);}

    /** 글 조회 */
    public App28ElvlrtDto GetMSManualView(@RequestParam("nseq") String mSeq){return app28ElvMapper.GetMSManualView(mSeq);}
    /** 글 등록 */
    public boolean InsertMSManual(App28ElvlrtDto perm){
        queryResult = app28ElvMapper.InsertMSManual(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 수정 */
    public boolean UpdateMSManual(App28ElvlrtDto perm){
        queryResult = app28ElvMapper.UpdateMSManual(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 삭제 */
    public boolean DeleteMSManual(App28ElvlrtDto perm){
        queryResult = app28ElvMapper.DeleteMSManual(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public String getMSManualMaxSeq(String parm){ return app28ElvMapper.getMSManualMaxSeq(parm);}



    public List<CommonDto> GetComm751List(){return app28ElvMapper.GetComm751List();}
    public List<CommonDto>  GetComm751BlankList(){return app28ElvMapper.GetComm751List();}

    public List<App28ElvlrtDto> getMSCommentList(App28ElvlrtDto perm) {return app28ElvMapper.getMSCommentList(perm);}

    public String GetMSCommentCount(String sseq) {return app28ElvMapper.GetMSCommentCount(sseq);}
}
