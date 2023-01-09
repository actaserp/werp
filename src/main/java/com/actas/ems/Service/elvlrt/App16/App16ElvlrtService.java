package com.actas.ems.Service.elvlrt.App16;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App16ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App16ElvlrtService")
public class App16ElvlrtService {

    @Autowired
    App16ElvlrtMapper app16ElvlrtMapper;

    public List<App16ElvlrtDto> GetApp16List(PopupDto parm){return app16ElvlrtMapper.GetApp16List001(parm);}
}
