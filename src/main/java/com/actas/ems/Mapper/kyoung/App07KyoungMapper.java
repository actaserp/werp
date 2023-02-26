package com.actas.ems.Mapper.kyoung;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface App07KyoungMapper {

    public List<App07ElvlrtDto> GetMManulList(App07ElvlrtDto perm);

    public List<App07ElvlrtDto> GetMManulBlankList();

    public List<CommonDto> GetComm750List();

    public List<CommonDto> GetComm750BlankList();

    public int InsertMManul(App07ElvlrtDto perm);

    public App07ElvlrtDto GetMManulView(String fSeq);

    public int DeleteMManul(App07ElvlrtDto perm);

    public int UpdateMManul(App07ElvlrtDto perm);

    public String getMManualMaxSeq(String perm);




}
