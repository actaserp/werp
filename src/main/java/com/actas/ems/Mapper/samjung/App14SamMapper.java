package com.actas.ems.Mapper.samjung;


import com.actas.ems.DTO.Elvlrt.App14ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App14SamMapper {

    public List<App14ElvlrtDto> GetApp14List001(PopupDto parm) ;


}
