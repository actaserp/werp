package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App10ElvlrtService")
public class App10ElvlrtService {

    @Autowired
    App10ElvlrtMapper  app10ElvMapper;

    /** 고장내용별현황 / 기간별 고장내용 */
    public List<App03ElvlrtDto> GetApp03List001(PopupDto parm){return app10ElvMapper.GetApp10List001(parm);}
    /** 고장내용별현황 / 현장별 고장내용 */
    public List<App03ElvlrtDto> GetApp03List002(PopupDto parm){return app10ElvMapper.GetApp10List002(parm);}
    /** 고장내용별현황 / 호기별 고장내용 */
    public List<App03ElvlrtDto> GetApp03List003(PopupDto parm){return app10ElvMapper.GetApp10List003(parm);}



}