package com.actas.ems.Mapper.kyoung;


import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.CommonDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App04KyoungMapper {

    public List<App04ElvlrtDto>  GetMManulList(App04ElvlrtDto perm);
    public List<App04ElvlrtDto> GetMManulBlankList();

    public List<App04ElvlrtDto>  GetDManulList(App04ElvlrtDto perm);
    public List<App04ElvlrtDto> GetDManulBlankList();
    public List<App04ElvlrtDto>  GetEManulList(App04ElvlrtDto perm);
    public List<App04ElvlrtDto> GetEManulBlankList();
    public List<CommonDto> GetComm750List();
    public List<CommonDto> GetComm750BlankList();

//    공통코드 구분 부품메뉴얼

    public List<CommonDto> GetComm752List();
    public List<CommonDto> GetComm752BlankList();

    public List<CommonDto> GetComm753List();

    public List<CommonDto> GetComm753BlankList();



    public App04ElvlrtDto GetMManulView(String mSeq);
    public int InsertMManul(App04ElvlrtDto perm);
    public int UpdateMManul(App04ElvlrtDto perm);
    public int DeleteMManul(App04ElvlrtDto perm);
    public String getMManualMaxSeq(String perm);

    public App04ElvlrtDto GetDManulView(String dSeq);
    public int InsertDManul(App04ElvlrtDto perm);
    public int UpdateDManul(App04ElvlrtDto perm);
    public int DeleteDManul(App04ElvlrtDto perm);
    public String getDManualMaxSeq(String perm);

    public App04ElvlrtDto GetEManulView(String eSeq);
    public int InsertEManul(App04ElvlrtDto perm);
    public int UpdateEManul(App04ElvlrtDto perm);
    public int DeleteEManul(App04ElvlrtDto perm);
    public String getEManualMaxSeq(String perm);


}
