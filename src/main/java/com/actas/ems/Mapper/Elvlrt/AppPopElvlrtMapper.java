package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface AppPopElvlrtMapper {

    public List<PopupDto>  GetActnmList(PopupDto parm);
    public List<PopupDto>  GetContnmList(PopupDto parm);

    public List<PopupDto> GetEqupList(PopupDto parm);

    public List<PopupDto> GetGreGicdList(PopupDto parm);

    public List<PopupDto> GetremoList(PopupDto parm);

    public List<PopupDto> GetresunmList(PopupDto parm);

}
