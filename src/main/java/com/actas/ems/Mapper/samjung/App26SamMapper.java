package com.actas.ems.Mapper.samjung;


import com.actas.ems.DTO.Elvlrt.App26ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App26SamMapper {

    public List<App26ElvlrtDto> GetApp26List001(PopupDto parm) ;

    public List<App26ElvlrtDto> GetApp26List002(PopupDto parm);

    public List<App26ElvlrtDto> GetApp26List003(PopupDto parm);
    public List<App26ElvlrtDto> GetApp26List004(PopupDto parm);
}
