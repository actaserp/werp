package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App04ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App04GaonMapper;
import com.actas.ems.Mapper.kyoung.App04KyoungMapper;
import com.actas.ems.Mapper.Elvlrt.MattachElvlrtMapper;
import com.actas.ems.Mapper.gaon.MattachGaonMapper;
import com.actas.ems.Mapper.kyoung.MattachKyoungMapper;
import com.actas.ems.util.FilsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class App04UploadServiceImpl implements  App04UploadService {

    @Autowired
    private App04ElvlrtMapper app04Mapper;
    @Autowired
    private App04GaonMapper app04MapperG;
    @Autowired
    private App04KyoungMapper app04MapperK;

    @Autowired
    private MattachElvlrtMapper attachMapper;
    @Autowired
    private MattachGaonMapper attachMapperG;
    @Autowired
    private MattachKyoungMapper attachMapperK;

    @Autowired
    private FilsUtils fileUtils;

    public boolean registerMManu(App04ElvlrtDto params,  List<AttachDTO> attachDto){
        int queryResult = 1;
//        List<AttachDTO> fileList = fileUtils.uploadFiles(files, params.getMseq());
        if (CollectionUtils.isEmpty(attachDto) == false) {
            queryResult = attachMapper.InsertAttach(attachDto);
            if(queryResult < 1){
                queryResult = 0;
            }
        }
        return (queryResult > 0);
    }


    public boolean registerMManuDel(App04ElvlrtDto perm){
        int queryResult = 1;
        queryResult = attachMapper.deleteAttach(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public boolean registerDManuDel(App04ElvlrtDto perm){
        int queryResult = 1;
        queryResult = attachMapper.deleteAttach(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }


    public boolean MManuFileDel(AttachDTO perm){
        int queryResult = 1;
        queryResult = attachMapper.deleteAttachDetail(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public List<AttachDTO> MManuFilelist(App04ElvlrtDto perm){
        List<AttachDTO> attachDto = attachMapper.selectAttachList(perm);
        return attachDto;
    }

    public AttachDTO selectAttachDeteil(AttachDTO perm){
        AttachDTO attachDto = attachMapper.selectAttachDeteil(perm);
        return attachDto;
    }

    @Override
    public boolean registerMManu(App04ElvlrtDto params, MultipartFile[] files) {
        return false;
    }
}
