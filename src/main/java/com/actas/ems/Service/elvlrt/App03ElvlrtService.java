package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App03ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App03ElvlrtService")
public class App03ElvlrtService {

    @Autowired
    App03ElvlrtMapper  app03ElvMapper;

    /** 고장내용별현황 / 기간별 고장내용 */
    public List<App03ElvlrtDto> GetApp03List001(PopupDto parm){return app03ElvMapper.GetApp03List001(parm);}



}
