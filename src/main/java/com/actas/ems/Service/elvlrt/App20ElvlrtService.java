package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App20ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App20ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App20ElvlrtService")
public class App20ElvlrtService {

    @Autowired
    App20ElvlrtMapper  app20ElvMapper;

    public List<App20ElvlrtDto> GetApp20List001(PopupDto parm){return app20ElvMapper.GetApp20List001(parm);}



}
