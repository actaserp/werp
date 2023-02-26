package com.actas.ems.Mapper.gaon;


import com.actas.ems.DTO.Elvlrt.App13ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface App13GaonMapper {

    public List<App13ElvlrtDto> GetApp13List001(PopupDto parm);
    public List<App13ElvlrtDto> GetApp13List002(PopupDto parm);
    public List<App13ElvlrtDto> GetApp13List003(PopupDto parm);

}
