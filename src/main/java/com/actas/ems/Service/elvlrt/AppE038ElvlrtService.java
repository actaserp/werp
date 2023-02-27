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
}
