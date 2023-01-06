package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Elvlrt.App26ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App26ElvlrtMapper {

    public List<App26ElvlrtDto> GetApp26List001(PopupDto parm) ;


}
