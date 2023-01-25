package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App01ElvlrtMapper;
import com.actas.ems.Mapper.Elvlrt.App03ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("App01ElvlrtService")
public class App01ElvlrtService {

    @Autowired
    App01ElvlrtMapper appMapper;

    public App01ElvlrtDto GetCallXenv(App01ElvlrtDto parm){return appMapper.GetCallXenv(parm);}
    /** 관제현황 / 접수현황 리스트 */
    public List<App03ElvlrtDto> GetApp01List001(PopupDto parm){return appMapper.GetApp01List001(parm);}
    /** 관제현황 / 수리기사 리스트 */
    public List<App03ElvlrtDto> GetApp01List002(PopupDto parm){return appMapper.GetApp01List002(parm);}
    /** 관제현황 / 상단통계 리스트 */
    public List<App03ElvlrtDto> GetApp01List003(PopupDto parm){return appMapper.GetApp01List003(parm);}
    /** 관제현황 / 기사 이동라인 리스트 */
    public List<App03ElvlrtDto> GetApp01List004(PopupDto parm){return appMapper.GetApp01List004(parm);}
    /** 고객상담센터 / 전화메모 리스트 */
    public List<App03ElvlrtDto> GetApp01List005(PopupDto parm){return appMapper.GetApp01List005(parm);}



}
