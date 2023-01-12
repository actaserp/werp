package com.actas.ems.Service.elvlrt.App27;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App27ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("App27ElvlrtServicd")
@RequiredArgsConstructor
public class App27ElvlrtService {


    @Autowired
    App27ElvlrtMapper app27ElvlrtMapper;

    public List<App16ElvlrtDto> GetApp27List001(PopupDto parm){return app27ElvlrtMapper.GetApp27List001(parm);}
    public List<App16ElvlrtDto> GetApp27List002(PopupDto parm){return app27ElvlrtMapper.GetApp27List002(parm);}

    public List<App16ElvlrtDto> GetApp27List003(PopupDto parm) {return app27ElvlrtMapper.GetApp27List003(parm);}

    public List<App16ElvlrtDto> GetApp27List004(PopupDto parm) {return app27ElvlrtMapper.GetApp27List004(parm);}

    public List<App16ElvlrtDto> GetApp27popuplist(App16ElvlrtDto parm) {return app27ElvlrtMapper.GetpopupList(parm);}

}
