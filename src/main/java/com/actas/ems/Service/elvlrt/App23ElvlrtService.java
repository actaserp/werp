package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App23ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App23ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App23ElvlrtService")
public class App23ElvlrtService {

    @Autowired
    App23ElvlrtMapper  app23ElvMapper;

    public List<App23ElvlrtDto> GetApp23List001(PopupDto parm){return app23ElvMapper.GetApp23List001(parm);}

    public List<App23ElvlrtDto> GetApp23List002(PopupDto parm){return app23ElvMapper.GetApp23List002(parm);}



}
