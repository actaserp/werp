package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface AppPopElvlrtMapper {

    public List<PopupDto>  GetActnmList(PopupDto parm);
    public List<PopupDto>  GetContnmList(PopupDto parm);
    public List<PopupDto>  GetRemonmList(PopupDto parm);
    public List<PopupDto>  GetResunmList(PopupDto parm);
    public List<PopupDto>  GetGreginmList(PopupDto parm);

    public List<PopupDto>  GetReginmList(PopupDto parm);
    public List<PopupDto>  GetResultnmList(PopupDto parm);

    public List<PopupDto> GetPernm3List(PopupDto parm);

    public List<PopupDto> GetPernm2List(PopupDto parm);
    public List<PopupDto>  GetFacnmList(PopupDto parm);
    public List<PopupDto>  GetDivinmList(PopupDto parm);
    public List<PopupDto>  GetPernmList(PopupDto parm);


}
