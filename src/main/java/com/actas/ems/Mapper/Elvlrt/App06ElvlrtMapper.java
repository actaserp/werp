package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App06ElvlrtMapper {

//    public List<App05ElvlrtDto> GetNoticeList(String searchType, String Keyword);
//    public App05ElvlrtDto GetNoticeView(String nSeq);
//    public void InsertNotice(App05ElvlrtDto perm);
//    public void UpdateNotice(App05ElvlrtDto perm);
//    public void DeleteNotice(String nSeq);
//    public String getDate();
//    public void ResetSeq();
//    public String getMaxSeq();
//    public String SeqNext();

    public List<App06ElvlrtDto>  GetMHManualList(App06ElvlrtDto perm);
    public List<App06ElvlrtDto> GetMHManualBlankList();

    public List<CommonDto> GetComm751List();
    public List<CommonDto> GetComm751BlankList();

    public App06ElvlrtDto GetMHManualView(String mSeq);
    public int InsertMHManual(App06ElvlrtDto perm);
    public int UpdateMHManual(App06ElvlrtDto perm);
    public int DeleteMHManual(App06ElvlrtDto perm);
    public String getMHManualMaxSeq(String perm);

}
