package com.actas.ems.Service.elvlrt.App15;


import com.actas.ems.DTO.Elvlrt.App15ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App15ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App15ElvlrtService")
public class App15ElvlrtService {


    @Autowired
    App15ElvlrtMapper app15ElvlrtMapper;

    public List<App15ElvlrtDto> GetApp15List001(PopupDto parm){return app15ElvlrtMapper.GetApp00List001(parm);}
}
