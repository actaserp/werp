package com.actas.ems.Mapper.samjung;


import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppMob003tDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App06SamMobMapper {

    public List<AppMob003tDto> GetApp06MobList001(App06ElvlrtDto parm) ;



}
