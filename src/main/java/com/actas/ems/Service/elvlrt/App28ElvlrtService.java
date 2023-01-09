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
    public List<App28ElvlrtDto> GetMNoticeList(App28ElvlrtDto perm){return app28ElvMapper.GetMNoticeList(perm);}
    public List<App28ElvlrtDto> GetMNoticeBlankList(App28ElvlrtDto perm){return app28ElvMapper.GetMNoticeList(perm);}

    /** 글 조회 */
    public App28ElvlrtDto GetMNoticeView(@RequestParam("nseq") String mSeq){return app28ElvMapper.GetMNoticeView(mSeq);}
    /** 글 등록 */
    public boolean InsertMNotice(App28ElvlrtDto perm){
        queryResult = app28ElvMapper.InsertMNotice(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 수정 */
    public boolean UpdateMNotice(App28ElvlrtDto perm){
        queryResult = app28ElvMapper.UpdateMNotice(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 삭제 */
    public boolean DeleteMNotice(App28ElvlrtDto perm){
        queryResult = app28ElvMapper.DeleteMNotice(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public String getMNoticeMaxSeq(String parm){ return app28ElvMapper.getMNoticeMaxSeq(parm);}



    public List<CommonDto> GetComm751List(){return app28ElvMapper.GetComm751List();}
    public List<CommonDto>  GetComm751BlankList(){return app28ElvMapper.GetComm751List();}
}
