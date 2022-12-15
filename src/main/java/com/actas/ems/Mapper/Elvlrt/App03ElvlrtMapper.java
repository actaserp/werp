package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App03ElvlrtMapper {

    public List<App03ElvlrtDto> GetApp03List001(PopupDto parm) ;

}
