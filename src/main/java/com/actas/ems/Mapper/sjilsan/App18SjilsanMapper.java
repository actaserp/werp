package com.actas.ems.Mapper.sjilsan;


import com.actas.ems.DTO.Elvlrt.App18ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App18SjilsanMapper {

    public List<App18ElvlrtDto> GetApp18List001(PopupDto parm) ;


}
