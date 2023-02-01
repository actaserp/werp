package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.DTO.CommonDto;
import com.actas.ems.Mapper.Elvlrt.App05ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service("App05ElvlrtService")
public class App05ElvlrtService {


    @Autowired
    App05ElvlrtMapper app05ElvMapper;
    int queryResult = 1;
    /** 글 목록 */
    public Object GetMNoticeList(App05ElvlrtDto perm){return app05ElvMapper.GetMNoticeList(perm);}
    public List<App05ElvlrtDto> GetMNoticeBlankList(App05ElvlrtDto perm){return app05ElvMapper.GetMNoticeList(perm);}

    /** 글 조회 */
    public App05ElvlrtDto GetMNoticeView(@RequestParam("nseq") String mSeq){return app05ElvMapper.GetMNoticeView(mSeq);}
    /** 글 등록 */
    public boolean InsertMNotice(App05ElvlrtDto perm){
        queryResult = app05ElvMapper.InsertMNotice(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 수정 */
    public boolean UpdateMNotice(App05ElvlrtDto perm){
        queryResult = app05ElvMapper.UpdateMNotice(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
    /** 글 삭제 */
    public boolean DeleteMNotice(App05ElvlrtDto perm){
        queryResult = app05ElvMapper.DeleteMNotice(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public String getMNoticeMaxSeq(String parm){ return app05ElvMapper.getMNoticeMaxSeq(parm);}



    public List<CommonDto> GetComm751List(){return app05ElvMapper.GetComm751List();}
    public List<CommonDto>  GetComm751BlankList(){return app05ElvMapper.GetComm751List();}
}
