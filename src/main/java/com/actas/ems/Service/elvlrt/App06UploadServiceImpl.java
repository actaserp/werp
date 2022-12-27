package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App06ElvlrtMapper;
import com.actas.ems.Mapper.Elvlrt.Attach06ElvlrtMapper;
import com.actas.ems.util.FilsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class App06UploadServiceImpl implements  App06UploadService {

    @Autowired
    private App06ElvlrtMapper app06Mapper;

    @Autowired
    private Attach06ElvlrtMapper attachMapper;

    @Autowired
    private FilsUtils fileUtils;

    public boolean registerMHManual(App06ElvlrtDto params,  List<AttachDTO> attachDto){
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

    public boolean registerMHManualDel(App06ElvlrtDto perm){
        int queryResult = 1;
        queryResult = attachMapper.deleteAttach(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }


    public boolean MHManualFileDel(AttachDTO perm){
        int queryResult = 1;
        queryResult = attachMapper.deleteAttachDetail(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public List<AttachDTO> MHManualFilelist(App06ElvlrtDto perm){
        List<AttachDTO> attachDto = attachMapper.selectAttachList(perm);
        return attachDto;
    }

    public AttachDTO selectAttachDeteil(AttachDTO perm){
        AttachDTO attachDto = attachMapper.selectAttachDeteil(perm);
        return attachDto;
    }

    @Override
    public boolean registerMHManual(App06ElvlrtDto params, MultipartFile[] files) {
        return false;
    }
}
