package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.CommonDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App04ElvlrtMapper {

    public List<App04ElvlrtDto>  GetMManulList(App04ElvlrtDto perm);
    public List<App04ElvlrtDto> GetMManulBlankList();

    public List<CommonDto> GetComm750List();
    public List<CommonDto> GetComm750BlankList();

    public App04ElvlrtDto GetMManulView(String mSeq);
    public Integer InsertMManul(App04ElvlrtDto perm);
    public Integer UpdateMManul(App04ElvlrtDto perm);
    public Integer DeleteMManul(App04ElvlrtDto perm);
    public String getMManualMaxSeq(String perm);
}
