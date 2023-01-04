package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App21ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App21ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App21ElvlrtService")
public class App21ElvlrtService {

    @Autowired
    App21ElvlrtMapper  app21ElvMapper;

    public List<App21ElvlrtDto> GetApp21List001(PopupDto parm){return app21ElvMapper.GetApp21List001(parm);}



}
