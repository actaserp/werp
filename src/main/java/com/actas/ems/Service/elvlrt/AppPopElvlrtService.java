package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.AppPopElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /** 호기명 조회 (고객센타)*/
    public List<PopupDto> GetEqupList(PopupDto parm){return appPopElvMapper.GetEqupList(parm);}

    /** 고장부위 조회 */
    public List<PopupDto> GetGreGicdList(PopupDto parm){return appPopElvMapper.GetGreGicdList(parm);}

    /**고장원인*/
    public List<PopupDto> GetremoList(PopupDto parm){return appPopElvMapper.GetremoList(parm);}

    /**처리내용*/
    public List<PopupDto> GetresunmList(PopupDto parm){return appPopElvMapper.GetresunmList(parm);}


}
