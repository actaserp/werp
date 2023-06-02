package com.actas.ems.Mapper.sjilsan;


import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App03SjilsanMapper {

    public List<App03ElvlrtDto> GetApp03List001(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp03List002(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp03List003(PopupDto parm) ;

}
