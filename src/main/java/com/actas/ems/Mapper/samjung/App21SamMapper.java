package com.actas.ems.Mapper.samjung;


import com.actas.ems.DTO.Elvlrt.App21ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App21SamMapper {

    public List<App21ElvlrtDto> GetApp21List001(PopupDto parm) ;


}
