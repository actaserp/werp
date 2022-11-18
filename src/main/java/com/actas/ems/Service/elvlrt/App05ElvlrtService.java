package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
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
    App05ElvlrtMapper appMapper;

    /** 글 목록 */
    public List<App05ElvlrtDto> GetNoticeList(){return appMapper.GetNoticeList();}
    /** 글 조회 */
    public App05ElvlrtDto GetNoticeView(@RequestParam("nseq") String nSeq){return appMapper.GetNoticeView(nSeq);}
    /** 글 등록 */
    public void InsertNotice(App05ElvlrtDto perm){appMapper.InsertNotice(perm);}
    /** 글 수정 */
    public void UpdateNotice(App05ElvlrtDto perm){appMapper.UpdateNotice(perm);}
    /** 글 삭제 */
    public void DeleteNotice(@RequestParam("nseq") String nSeq){appMapper.DeleteNotice(nSeq);}

}
