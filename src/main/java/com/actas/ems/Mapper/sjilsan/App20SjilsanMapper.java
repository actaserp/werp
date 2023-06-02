package com.actas.ems.Mapper.sjilsan;


import com.actas.ems.DTO.Elvlrt.App20ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App20SjilsanMapper {

    public List<App20ElvlrtDto> GetApp20List001(PopupDto parm) ;


}
