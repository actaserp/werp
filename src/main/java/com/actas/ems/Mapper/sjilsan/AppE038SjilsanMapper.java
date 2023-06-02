package com.actas.ems.Mapper.sjilsan;

import com.actas.ems.DTO.Elvlrt.AppE038ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AppE038SjilsanMapper {

    public List<AppE038ElvlrtDto> GetE038List(PopupDto parm);

    public List<AppE038ElvlrtDto> GetActList(PopupDto parm);

    public List<AppE038ElvlrtDto> GetEqupList(PopupDto parm);

    public List<AppE038ElvlrtDto> GetCarList(PopupDto parm);

    public boolean InsertE038(PopupDto parm);

    public boolean UpdateE038(PopupDto parm);

    public boolean DeleteE038(PopupDto parm);

    public String getE038MaxSeq(String yyyymm);
}
