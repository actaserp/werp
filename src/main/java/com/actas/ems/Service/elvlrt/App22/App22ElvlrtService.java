package com.actas.ems.Service.elvlrt.App22;

import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App22ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App22ElvlrtService")
public class App22ElvlrtService {


        @Autowired
    App22ElvlrtMapper app22ElvlrtMapper;

    public List<App16ElvlrtDto> GetApp22List(PopupDto parm){return app22ElvlrtMapper.GetApp22List001(parm);}

    public List<App16ElvlrtDto> GetApp22List002(PopupDto parm){return app22ElvlrtMapper.GetApp22List002(parm);}


}
