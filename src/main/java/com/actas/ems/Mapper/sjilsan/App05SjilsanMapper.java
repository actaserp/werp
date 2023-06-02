package com.actas.ems.Mapper.sjilsan;


import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App05SjilsanMapper {

//    public List<App05ElvlrtDto> GetNoticeList(String searchType, String Keyword);
//    public App05ElvlrtDto GetNoticeView(String nSeq);
//    public void InsertNotice(App05ElvlrtDto perm);
//    public void UpdateNotice(App05ElvlrtDto perm);
//    public void DeleteNotice(String nSeq);
//    public String getDate();
//    public void ResetSeq();
//    public String getMaxSeq();
//    public String SeqNext();

    public List<App05ElvlrtDto>  GetMNoticeList(App05ElvlrtDto perm);
    public List<App05ElvlrtDto> GetMNoticeBlankList();

    public List<CommonDto> GetComm751List();
    public List<CommonDto> GetComm751BlankList();

    public App05ElvlrtDto GetMNoticeView(String mSeq);
    public int InsertMNotice(App05ElvlrtDto perm);
    public int UpdateMNotice(App05ElvlrtDto perm);
    public int DeleteMNotice(App05ElvlrtDto perm);
    public String getMNoticeMaxSeq(String perm);

}
