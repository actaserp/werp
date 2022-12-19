package com.actas.ems.Mapper.Elvlrt;

import com.actas.ems.DTO.UserFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ElvactcdMapper {

    public String TB_XCLIENT_ACTCD_SELECT(UserFormDto PARM);
}
