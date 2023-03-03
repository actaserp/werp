package com.actas.ems.Mapper.nm;


import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App28ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App28NmyangMapper {

//    public List<App28ElvlrtDto> GetNoticeList(String searchType, String Keyword);
//    public App28ElvlrtDto GetNoticeView(String nSeq);
//    public void InsertNotice(App28ElvlrtDto perm);
//    public void UpdateNotice(App28ElvlrtDto perm);
//    public void DeleteNotice(String nSeq);
//    public String getDate();
//    public void ResetSeq();
//    public String getMaxSeq();
//    public String SeqNext();

    public List<App28ElvlrtDto>  GetMSManualList(App28ElvlrtDto perm);
    public List<App28ElvlrtDto> GetMSManualBlankList();

    public List<CommonDto> GetComm751List();
    public List<CommonDto> GetComm751BlankList();

    public App28ElvlrtDto GetMSManualView(String mSeq);
    public int InsertMSManual(App28ElvlrtDto perm);
    public int UpdateMSManual(App28ElvlrtDto perm);
    public int DeleteMSManual(App28ElvlrtDto perm);
    public String getMSManualMaxSeq(String perm);

    public List<App28ElvlrtDto> getMSCommentList(App28ElvlrtDto perm);

    public String GetMSCommentCount(String sseq);
}
