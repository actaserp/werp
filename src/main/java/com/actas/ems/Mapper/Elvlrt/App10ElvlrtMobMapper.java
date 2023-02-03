package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Elvlrt.AppMob001tDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App10ElvlrtMobMapper {

    public List<AppMob001tDto> GetAppMobList001(App10ElvlrtDto parm) ;



}
