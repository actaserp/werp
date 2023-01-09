package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App28ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App28ElvlrtMapper {

//    public List<App28ElvlrtDto> GetNoticeList(String searchType, String Keyword);
//    public App28ElvlrtDto GetNoticeView(String nSeq);
//    public void InsertNotice(App28ElvlrtDto perm);
//    public void UpdateNotice(App28ElvlrtDto perm);
//    public void DeleteNotice(String nSeq);
//    public String getDate();
//    public void ResetSeq();
//    public String getMaxSeq();
//    public String SeqNext();

    public List<App28ElvlrtDto>  GetMNoticeList(App28ElvlrtDto perm);
    public List<App28ElvlrtDto> GetMNoticeBlankList();

    public List<CommonDto> GetComm751List();
    public List<CommonDto> GetComm751BlankList();

    public App28ElvlrtDto GetMNoticeView(String mSeq);
    public int InsertMNotice(App28ElvlrtDto perm);
    public int UpdateMNotice(App28ElvlrtDto perm);
    public int DeleteMNotice(App28ElvlrtDto perm);
    public String getMNoticeMaxSeq(String perm);

}
