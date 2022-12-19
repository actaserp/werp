package com.actas.ems.Mapper.Hanyangs;

import com.actas.ems.DTO.UserFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface hanyangsMapper {
    public String TB_XCLIENT_ACTCD_SELECT(UserFormDto userFormDto);
}
