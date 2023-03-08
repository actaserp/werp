package com.actas.ems.Mapper.nm;


import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.TBXa012VO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface AppPopNmyangMapper {
    public List<PopupDto>  GetActnmList(PopupDto parm);
    public List<PopupDto>  GetContnmList(PopupDto parm);
    public List<PopupDto>  GetRemonmList(PopupDto parm);
    public List<PopupDto>  GetResunmList(PopupDto parm);
    public List<PopupDto>  GetGreginmList(PopupDto parm);
    public List<PopupDto>  GetResultnmList(PopupDto parm);
    public List<PopupDto>  GetDivinmList(PopupDto parm);
    public List<PopupDto>  GetPernmList(PopupDto parm);
    public List<PopupDto>  GetPernmList2(PopupDto parm);
    public List<PopupDto> GetEqupList(PopupDto parm);

    public List<PopupDto> GetGreGicdList(PopupDto parm);

    public List<PopupDto> GetremoList(PopupDto parm);

    public List<PopupDto> GetresunmList2(PopupDto parm);

    public List<PopupDto>  GetReginmList(PopupDto parm);

    public List<PopupDto>  GetPernm3List(PopupDto parm);

    public List<PopupDto> GetPernm2List(PopupDto parm);
    public List<PopupDto> GetFacnmList(PopupDto parm);

    public List<PopupDto> GetWkactList(PopupDto parm);
    public PopupDto GetSmsInfoList(PopupDto parm);
    public TBXa012VO GetXa012Info(PopupDto parm);
    public int UpdateXa012(TBXa012VO parm) ;
    public int UpdateXa011(TBXa012VO parm) ;


}
