package com.actas.ems.Service.elvlrt.App_mbmanualService;

import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import com.actas.ems.Mapper.Elvlrt.App_mbmanual.App_mbmanualMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public interface App_mbUploadService {
    @Autowired
    App_mbmanualMapper APP_MBMANUAL_MAPPER = null;

    public boolean registerMManu(App08_mbmanual params, MultipartFile[] files);

}


