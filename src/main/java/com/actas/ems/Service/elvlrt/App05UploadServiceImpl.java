package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App05ElvlrtMapper;
import com.actas.ems.Mapper.Elvlrt.NattachElvlrtMapper;
import com.actas.ems.util.FilsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class App05UploadServiceImpl implements  App05UploadService {

    @Autowired
    private App05ElvlrtMapper App05Mapper;

    @Autowired
    private NattachElvlrtMapper attachMapper;

    @Autowired
    private FilsUtils fileUtils;

    public boolean registerMNotice(App05ElvlrtDto params,  List<AttachDTO> attachDto){
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

    public boolean registerMNoticeDel(App05ElvlrtDto perm){
        int queryResult = 1;
        queryResult = attachMapper.deleteAttach(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }


    public boolean MNoticeFileDel(AttachDTO perm){
        int queryResult = 1;
        queryResult = attachMapper.deleteAttachDetail(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public List<AttachDTO> MNoticeFilelist(App05ElvlrtDto perm){
        List<AttachDTO> attachDto = attachMapper.selectAttachList(perm);
        return attachDto;
    }

    public AttachDTO selectAttachDeteil(AttachDTO perm){
        AttachDTO attachDto = attachMapper.selectAttachDeteil(perm);
        return attachDto;
    }

    @Override
    public boolean registerMNotice(App05ElvlrtDto params, MultipartFile[] files) {
        return false;
    }
}
