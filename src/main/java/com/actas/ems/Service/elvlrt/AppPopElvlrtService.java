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
    /** 고장원인 조회 */
    public List<PopupDto> GetFacnmList(PopupDto parm){return appPopElvMapper.GetFacnmList(parm);}
    /** 처리내용 조회 */
    public List<PopupDto> GetResunmList(PopupDto parm){return appPopElvMapper.GetResunmList(parm);}
    /** 고장부위 조회 */
    public List<PopupDto> GetGreginmList(PopupDto parm){return appPopElvMapper.GetGreginmList(parm);}

    /** 고장부위 상세조회 */
    public List<PopupDto> GetReginmList(PopupDto parm){return appPopElvMapper.GetReginmList(parm);}

    /** 처리방법 조회 */
    public List<PopupDto> GetResultnmList(PopupDto parm){return appPopElvMapper.GetResultnmList(parm);}
    /** 담당부서 조회 */
    public List<PopupDto> GetDivinmList(PopupDto parm){return appPopElvMapper.GetDivinmList(parm);}
    /** 담당자 조회 */
    public List<PopupDto> GetPernmList(PopupDto parm){return appPopElvMapper.GetPernmList(parm);}
    /** 처리자 조회 */
    public List<PopupDto> GetPernm3List(PopupDto parm){return appPopElvMapper.GetPernm3List(parm);}
    /** 담당자2 조회 */
    public List<PopupDto> GetPernm2List(PopupDto parm){return appPopElvMapper.GetPernm2List(parm);}



}
