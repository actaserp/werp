package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.AppE038ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.AppE038ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("AppE038ElvlrtService")
public class AppE038ElvlrtService {

    @Autowired
    AppE038ElvlrtMapper appMapper;
    public List<AppE038ElvlrtDto> GetE038List(PopupDto parm) {
        return appMapper.GetE038List(parm);
    }

    public List<AppE038ElvlrtDto> GetActList(PopupDto parm) {
        return appMapper.GetActList(parm);
    }

    public List<AppE038ElvlrtDto> GetEqupList(PopupDto parm) {
        return appMapper.GetEqupList(parm);
    }
    public List<AppE038ElvlrtDto> GetCarList(PopupDto parm) {
        return appMapper.GetCarList(parm);
    }

    public boolean InsertE038(PopupDto parm) {
        return appMapper.InsertE038(parm);
    }

    public boolean UpdateE038(PopupDto parm) {
        return appMapper.UpdateE038(parm);
    }

    public boolean DeleteE038(PopupDto parm) {
        return appMapper.DeleteE038(parm);
    }
}
