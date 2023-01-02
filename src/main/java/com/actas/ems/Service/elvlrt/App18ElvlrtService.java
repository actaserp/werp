package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App18ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App18ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App18ElvlrtService")
public class App18ElvlrtService {

    @Autowired
    App18ElvlrtMapper  app18ElvMapper;

    public List<App18ElvlrtDto> GetApp18List001(PopupDto parm){return app18ElvMapper.GetApp18List001(parm);}



}
