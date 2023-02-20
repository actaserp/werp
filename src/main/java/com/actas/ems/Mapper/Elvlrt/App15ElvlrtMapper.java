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
    public List<App15ElvlrtDto> GetApp00List002(App15ElvlrtDto parm);

    public List<App15ElvlrtDto> GetApp00List003(App15ElvlrtDto parm);

    public List<App15ElvlrtDto> GetApp00List004(App15ElvlrtDto parm);


    public List<App15ElvlrtDto> GetApp00List005(App15ElvlrtDto parm);

    public List<App15ElvlrtDto> GetApp00List006(PopupDto parm);

    public List<App15ElvlrtDto> GetApp00List007(PopupDto parm);

    public List<App15ElvlrtDto> GetApp00List014(App15ElvlrtDto parm);




}
