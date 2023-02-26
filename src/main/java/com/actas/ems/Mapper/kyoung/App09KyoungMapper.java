package com.actas.ems.Mapper.kyoung;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App09ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface App09KyoungMapper {

    public List<App09ElvlrtDto> GetFQManulList(App09ElvlrtDto perm);

    public List<App09ElvlrtDto> GetFQManulBlankList();

    public List<CommonDto> GetComm750List();

    public List<CommonDto> GetComm750BlankList();

    public int InsertFQManul(App09ElvlrtDto perm);

    public App09ElvlrtDto GetFQManulView(String fSeq);

    public int DeleteFQManul(App09ElvlrtDto perm);

    public int UpdateFQManul(App09ElvlrtDto perm);

    public String getFQManualMaxSeq(String perm);




}
