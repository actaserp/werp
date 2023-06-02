package com.actas.ems.Mapper.sjilsan;


import com.actas.ems.DTO.Elvlrt.App12ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App12SjilsanMapper {

    public List<App12ElvlrtDto> GetApp12List001(PopupDto parm) ;
    public List<App12ElvlrtDto> GetApp12List002(PopupDto parm) ;
    public List<App12ElvlrtDto> GetApp12List003(PopupDto parm) ;

}
