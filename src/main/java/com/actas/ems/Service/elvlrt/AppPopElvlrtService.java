package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App03ElvlrtMapper;
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
    /** 고장요인 조회 */
    public List<PopupDto> GetRemonmList(PopupDto parm){return appPopElvMapper.GetRemonmList(parm);}
    /** 처리내용 조회 */
    public List<PopupDto> GetResunmList(PopupDto parm){return appPopElvMapper.GetResunmList(parm);}
    /** 고장부위 조회 */
    public List<PopupDto> GetGreginmList(PopupDto parm){return appPopElvMapper.GetGreginmList(parm);}
    /** 처리방법 조회 */
    public List<PopupDto> GetResultnmList(PopupDto parm){return appPopElvMapper.GetResultnmList(parm);}



}
