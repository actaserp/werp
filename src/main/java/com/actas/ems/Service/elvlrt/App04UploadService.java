package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import com.actas.ems.Mapper.Elvlrt.App04ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App04GaonMapper;
import com.actas.ems.Mapper.kyoung.App04KyoungMapper;

public interface App04UploadService {

    @Autowired
    App04ElvlrtMapper app04ElvMapper = null;
    public boolean registerMManu(App04ElvlrtDto params, MultipartFile[] files);

}
