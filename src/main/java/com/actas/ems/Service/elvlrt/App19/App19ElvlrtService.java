package com.actas.ems.Service.elvlrt.App19;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App19ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service("App19ElvlrtService")
public class App19ElvlrtService {

    @Autowired
    App19ElvlrtMapper app19ElvlrtMapper;

    /**기간별*/
    public List<App16ElvlrtDto> GetApp19List001(PopupDto parm){return app19ElvlrtMapper.GetApp19List001(parm);}

    /** 현장별 고장내용, 막대그래프*/
    public List<App16ElvlrtDto> GetApp19List002(PopupDto parm){return app19ElvlrtMapper.GetApp19List002(parm);}
}
