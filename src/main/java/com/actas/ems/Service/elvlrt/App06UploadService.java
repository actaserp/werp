package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import com.actas.ems.Mapper.Elvlrt.App06ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App06GaonMapper;
import com.actas.ems.Mapper.kyoung.App06KyoungMapper;

public interface App06UploadService {

    @Autowired
    App06GaonMapper app06ElvMapper = null;
    public boolean registerMHManual(App06ElvlrtDto params, MultipartFile[] files);

}
