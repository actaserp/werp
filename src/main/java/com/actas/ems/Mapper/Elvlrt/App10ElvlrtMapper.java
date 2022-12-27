package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App10ElvlrtMapper {

    public List<App03ElvlrtDto> GetApp10List001(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp10List002(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp10List003(PopupDto parm) ;

}
