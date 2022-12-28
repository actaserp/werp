package com.actas.ems.Mapper.Elvlrt;

import com.actas.ems.DTO.Elvlrt.App15ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App15ElvlrtMapper {
    public List<App15ElvlrtDto> GetApp00List001(PopupDto parm);
}
