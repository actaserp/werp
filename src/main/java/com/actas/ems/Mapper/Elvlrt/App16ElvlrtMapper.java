package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface App16ElvlrtMapper {

    public List<App16ElvlrtDto> GetApp16List001(PopupDto parm);
}
