package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import com.actas.ems.Mapper.Elvlrt.App05ElvlrtMapper;

public interface App05UploadService {

    @Autowired
    App05ElvlrtMapper app05ElvMapper = null;
    public boolean registerMNotice(App05ElvlrtDto params, MultipartFile[] files);

}
