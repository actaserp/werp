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
    /** 고장요인 조회 */
    public List<PopupDto> GetRemonmList(PopupDto parm){return appPopElvMapper.GetRemonmList(parm);}
    /** 처리내용 조회 */
    public List<PopupDto> GetResunmList(PopupDto parm){return appPopElvMapper.GetResunmList(parm);}
    /** 고장부위 조회 */
    public List<PopupDto> GetGreginmList(PopupDto parm){return appPopElvMapper.GetGreginmList(parm);}
    /** 처리방법 조회 */
    public List<PopupDto> GetResultnmList(PopupDto parm){return appPopElvMapper.GetResultnmList(parm);}
    /** 담당부서 조회 */
    public List<PopupDto> GetDivinmList(PopupDto parm){return appPopElvMapper.GetDivinmList(parm);}
    /** 담당자 조회 */
    public List<PopupDto> GetPernmList(PopupDto parm){return appPopElvMapper.GetPernmList(parm);}

    public List<PopupDto> GetPernmList2(PopupDto parm){return appPopElvMapper.GetPernmList2(parm);}


    /** 고장원인 조회 */
    public List<PopupDto> GetFacnmList(PopupDto parm){return appPopElvMapper.GetFacnmList(parm);}

    public List<PopupDto> GetEqupList(PopupDto parm){return appPopElvMapper.GetEqupList(parm);}

    /** 고장부위 조회 */
    public List<PopupDto> GetGreGicdList(PopupDto parm){return appPopElvMapper.GetGreGicdList(parm);}

    /**고장원인*/
    public List<PopupDto> GetremoList(PopupDto parm){return appPopElvMapper.GetremoList(parm);}

    /**처리내용*/
    public List<PopupDto> GetresunmList(PopupDto parm){return appPopElvMapper.GetresunmList2(parm);}
    /** 고장부위 상세조회 */
    public List<PopupDto> GetReginmList(PopupDto parm){return appPopElvMapper.GetReginmList(parm);}

    public List<PopupDto> GetPernm3List(PopupDto parm){return appPopElvMapper.GetPernm3List(parm);}
    /** 담당자2 조회 */
    public List<PopupDto> GetPernm2List(PopupDto parm){return appPopElvMapper.GetPernm2List(parm);}

    public List<PopupDto> GetWkactList(PopupDto parm) {return appPopElvMapper.GetWkactList(parm);}
//   sms 정보조회 */
    public PopupDto GetSmsInfoList(PopupDto parm) {return appPopElvMapper.GetSmsInfoList(parm);}



}
