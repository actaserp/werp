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
public class App04ElvlrtService {

    @Autowired
    App04ElvlrtMapper app04ElvMapper;

    /** 글 목록 */
    public Object GetMManulList(App04ElvlrtDto perm){return app04ElvMapper.GetMManulList(perm);}
    public List<App04ElvlrtDto> GetMManuBlankList(App04ElvlrtDto perm){return app04ElvMapper.GetMManulList(perm);}

    /** 글 조회 */
    public App04ElvlrtDto GetMManuView(@RequestParam("mseq") String mSeq){return app04ElvMapper.GetMManulView(mSeq);}
    /** 글 등록 */
    public void InsertMManu(App04ElvlrtDto perm){app04ElvMapper.InsertMManul(perm);}
    /** 글 수정 */
    public void UpdateMManu(App04ElvlrtDto perm){app04ElvMapper.UpdateMManul(perm);}
    /** 글 삭제 */
    public void DeleteMManu(App04ElvlrtDto perm){app04ElvMapper.DeleteMManul(perm);}

    public String getMManualMaxSeq(String parm){ return app04ElvMapper.getMManualMaxSeq(parm);}

    public List<CommonDto> GetComm750List(){return app04ElvMapper.GetComm750List();}
    public List<CommonDto>  GetComm750BlankList(){return app04ElvMapper.GetComm750List();}

}
