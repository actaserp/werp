package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App04ElvlrtMapper;
import com.actas.ems.Mapper.Elvlrt.AppPopElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequiredArgsConstructor
@Service("AppPopElvlrtService")
public class AppPopElvlrtService {

    @Autowired
    AppPopElvlrtMapper appPopElvMapper;

    /** 현장명 조회 */
    public List<PopupDto> GetActnmList(PopupDto parm){return appPopElvMapper.GetActnmList(parm);}
    /** 고장내용 조회 */
    public List<PopupDto> GetContnmList(PopupDto parm){return appPopElvMapper.GetContnmList(parm);}



}
