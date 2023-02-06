package com.actas.ems.Mapper.kyoung;



import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App01KyoungMapper {

    public App01ElvlrtDto GetCallXenv(App01ElvlrtDto datainfo);
    public List<App03ElvlrtDto> GetApp01List001(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp01List002(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp01List003(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp01List004(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp01List005(PopupDto parm) ;


}
