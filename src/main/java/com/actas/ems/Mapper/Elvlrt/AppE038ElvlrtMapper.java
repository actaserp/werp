package com.actas.ems.Mapper.Elvlrt;

import com.actas.ems.DTO.Elvlrt.AppE038ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AppE038ElvlrtMapper {

    public List<AppE038ElvlrtDto> GetE038List(PopupDto parm);
}
