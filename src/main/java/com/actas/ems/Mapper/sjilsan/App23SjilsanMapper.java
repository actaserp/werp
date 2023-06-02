package com.actas.ems.Mapper.sjilsan;


import com.actas.ems.DTO.Elvlrt.App23ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App23SjilsanMapper {

    public List<App23ElvlrtDto> GetApp23List001(PopupDto parm) ;

    public List<App23ElvlrtDto> GetApp23List002(PopupDto parm) ;


}
