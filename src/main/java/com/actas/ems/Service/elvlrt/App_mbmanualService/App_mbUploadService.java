package com.actas.ems.Service.elvlrt.App_mbmanualService;

import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import com.actas.ems.Mapper.Elvlrt.App_mbmanual.App_mbmanualMapper;
import com.actas.ems.Mapper.gaon.App_mbmanual.App_mbmanualGaonMapper;
import com.actas.ems.Mapper.kyoung.App_mbmanual.App_mbmanualKyoungMapper;
import com.actas.ems.Mapper.nm.App_mbmanual.App_mbmanualNmyangMapper;
import com.actas.ems.Mapper.samjung.App_mbmanual.App_mbmanualSamMapper;
import com.actas.ems.Mapper.sjilsan.App_mbmanual.App_mbmanualSjilsanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public interface App_mbUploadService {
    @Autowired
    App_mbmanualMapper APP_MBMANUAL_MAPPER = null;
    @Autowired
    App_mbmanualGaonMapper APP_MBMANUAL_Gaon_MAPPER = null;
    @Autowired
    App_mbmanualKyoungMapper app27Elvlrt_Kyoung_MapperK= null;
    @Autowired
    App_mbmanualNmyangMapper app27Elvlrt_Nmyang_MapperK= null;
    @Autowired
    App_mbmanualSamMapper app27Elvlrt_Sam_MapperK= null;
    @Autowired
    App_mbmanualSjilsanMapper app27Elvlrt_Sjilsan_MapperK= null;

    public boolean registerMManu(App08_mbmanual params, MultipartFile[] files);

}


