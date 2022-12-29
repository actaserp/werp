package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App10ElvlrtMapper {

    public List<App10ElvlrtDto> GetApp03List001(PopupDto parm) ;
    public List<App10ElvlrtDto> GetApp03List002(PopupDto parm) ;
    public List<App10ElvlrtDto> GetApp03List003(PopupDto parm) ;

}
