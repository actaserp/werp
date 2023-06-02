package com.actas.ems.Mapper.sjilsan;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface App19SjilsanMapper {


    public List<App16ElvlrtDto> GetApp19List001(PopupDto parm);
    public List<App16ElvlrtDto> GetApp19List002(PopupDto parm);
}
