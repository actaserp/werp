package com.actas.ems.Mapper.sjilsan.App_mbmanual;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface App_mbmanualSjilsanMapper {

    public List<App08_mbmanual> GetMManulList(App08_mbmanual perm);

    public List<App08_mbmanual> GetMManulBlankList();

    public List<CommonDto> GetComm750List();

    public List<CommonDto> GetComm750BlankList();

    public int InsertMManul(App08_mbmanual perm);

    public App08_mbmanual GetMManulView(String bSeq);

    public int DeleteMManul(App08_mbmanual perm);

    public int UpdateMManul(App08_mbmanual perm);

    public String getMManualMaxSeq(String perm);
}
