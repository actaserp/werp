package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App12ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App12ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App12ElvlrtService")
public class App12ElvlrtService {

    @Autowired
    App12ElvlrtMapper  app12ElvMapper;

    /** 고장내용별현황 / 기간별 고장내용 */
    public List<App12ElvlrtDto> GetApp12List001(PopupDto parm){return app12ElvMapper.GetApp12List001(parm);}
    /** 고장내용별현황 / 현장별 고장내용 */
    public List<App12ElvlrtDto> GetApp12List002(PopupDto parm){return app12ElvMapper.GetApp12List002(parm);}
    /** 고장내용별현황 / 호기별 고장내용 */
    public List<App12ElvlrtDto> GetApp12List003(PopupDto parm){return app12ElvMapper.GetApp12List003(parm);}



}
