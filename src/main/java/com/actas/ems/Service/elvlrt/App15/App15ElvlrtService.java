package com.actas.ems.Service.elvlrt.App15;


import com.actas.ems.DTO.Elvlrt.App15ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App15ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App15ElvlrtService")
public class App15ElvlrtService {


    @Autowired
    App15ElvlrtMapper app15ElvlrtMapper;

    //호기별고장통계
    public List<App15ElvlrtDto> GetApp15List001(PopupDto parm){return app15ElvlrtMapper.GetApp00List001(parm);}

    //메인화면 당월점검현황
    public List<App15ElvlrtDto> GetApp15List002(App15ElvlrtDto parm){return app15ElvlrtMapper.GetApp00List002(parm);}

    //메인화면 계약만료현장
    public List<App15ElvlrtDto> GetApp15List003(App15ElvlrtDto parm){return app15ElvlrtMapper.GetApp00List003(parm);}

    //메인화면 30일뒤 계약만료현장
    public List<App15ElvlrtDto> GetApp15List004(App15ElvlrtDto parm){return app15ElvlrtMapper.GetApp00List004(parm);}

    //메인화면 당월 고장다발현장
    public List<App15ElvlrtDto> GetApp15List005(App15ElvlrtDto parm){return app15ElvlrtMapper.GetApp00List005(parm);}

    //고객사용자 메인화면 당월 고장다발현장
    public List<App15ElvlrtDto> GetApp15List006(PopupDto parm){return app15ElvlrtMapper.GetApp00List006(parm);}


    //고객사용자 메인화면 당월 고장다발현장 그래프
    public List<App15ElvlrtDto> GetApp15List007(PopupDto parm){return app15ElvlrtMapper.GetApp00List007(parm);}



    //고객사용자 메인화면 당일 직원 근태현황
    public List<App15ElvlrtDto> GetApp00List014(App15ElvlrtDto parm){return app15ElvlrtMapper.GetApp00List014(parm);}



}
