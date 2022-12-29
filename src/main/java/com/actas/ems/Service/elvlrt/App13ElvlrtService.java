package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App13ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App13ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App13ElvlrtService")
public class App13ElvlrtService {

    @Autowired
    App13ElvlrtMapper app13ElvlrtMapper;

    /** 고장내용별현황/ 기간별 고장내용 */
    public List<App13ElvlrtDto> GetApp13List001(PopupDto parm){ return app13ElvlrtMapper.GetApp13List001(parm);}

    /** 고정내용별현황 / 현장별 고장내용 */

    public List<App13ElvlrtDto> GetApp13List002(PopupDto parm){ return app13ElvlrtMapper.GetApp13List002(parm);}

    public List<App13ElvlrtDto> GetApp13List003(PopupDto parm){ return app13ElvlrtMapper.GetApp13List003(parm);}

}
