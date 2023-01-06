package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App26ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App26ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App26ElvlrtService")
public class App26ElvlrtService {

    @Autowired
    App26ElvlrtMapper  app26ElvMapper;

    public List<App26ElvlrtDto> GetApp26List001(PopupDto parm){return app26ElvMapper.GetApp26List001(parm);}



}
