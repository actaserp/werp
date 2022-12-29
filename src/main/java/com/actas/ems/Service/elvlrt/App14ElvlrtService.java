package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App14ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App14ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App14ElvlrtService")
public class App14ElvlrtService {

    @Autowired
    App14ElvlrtMapper  app14ElvMapper;

    /** 사원 목록 출력 */
    public List<App14ElvlrtDto> GetApp14List001(PopupDto parm){return app14ElvMapper.GetApp14List001(parm);}


}
