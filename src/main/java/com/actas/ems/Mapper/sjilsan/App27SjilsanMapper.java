package com.actas.ems.Mapper.sjilsan;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface App27SjilsanMapper {

    public List<App16ElvlrtDto> GetApp27List001(PopupDto parm);

    public List<App16ElvlrtDto> GetApp27List002(PopupDto parm);

    public List<App16ElvlrtDto> GetApp27List003(PopupDto parm);

    public List<App16ElvlrtDto> GetApp27List004(PopupDto parm);

    //클릭시 팝업
    public List<App16ElvlrtDto> GetpopupList(App16ElvlrtDto parm);



}
