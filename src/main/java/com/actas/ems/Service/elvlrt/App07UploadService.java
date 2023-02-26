package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App07ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App07GaonMapper;
import com.actas.ems.Mapper.kyoung.App07KyoungMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public interface App07UploadService {

    @Autowired
    App07GaonMapper app07ElvMapper = null;
    public boolean registerMManu(App07ElvlrtDto params, MultipartFile[] files);

}
