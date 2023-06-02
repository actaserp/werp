package com.actas.ems.Mapper.samjung;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface App24SamMapper {

    public List<App16ElvlrtDto> GetApp24List001(PopupDto parm);
    public List<App16ElvlrtDto> GetApp24List002(PopupDto parm);

}
