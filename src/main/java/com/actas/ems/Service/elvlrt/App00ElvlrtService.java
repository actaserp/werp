package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App00ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App00ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App00ElvlrtService")
public class App00ElvlrtService {


    @Autowired
    App00ElvlrtMapper app00ElvMapper;

    /** 현장별월별통계, 기간별*/
    public List<App00ElvlrtDto> GetApp00List001(PopupDto parm){ return app00ElvMapper.GetApp00List001(parm);}

}
