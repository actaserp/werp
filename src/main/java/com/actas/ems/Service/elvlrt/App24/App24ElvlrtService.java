package com.actas.ems.Service.elvlrt.App24;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App24ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App24ElvlrtService")
public class App24ElvlrtService {


    @Autowired
    App24ElvlrtMapper app24ElvlrtMapper;

    public List<App16ElvlrtDto> GetApp24List001(PopupDto parm){return app24ElvlrtMapper.GetApp24List001(parm);}

    public List<App16ElvlrtDto> GetApp24List002(PopupDto parm){return app24ElvlrtMapper.GetApp24List002(parm);}
}
