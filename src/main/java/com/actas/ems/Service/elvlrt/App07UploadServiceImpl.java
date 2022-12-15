package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App07ElvlrtMapper;
import com.actas.ems.Mapper.Elvlrt.Attach02ElvlrtMapper;

import com.actas.ems.util.FilsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class App07UploadServiceImpl implements App07UploadService{

    @Autowired
    private App07ElvlrtMapper app07Mapper;

    @Autowired
    private Attach02ElvlrtMapper attachMapper;

    @Autowired
    private FilsUtils fileUtils;

    public boolean registerMManu(App07ElvlrtDto params, List<AttachDTO> attachDto){
        int queryResult = 1;

        if(CollectionUtils.isEmpty(attachDto) == false){
            queryResult = attachMapper.InsertAttach(attachDto);
            if(queryResult < 1){
                queryResult = 0;
            }

        }
        return (queryResult > 0);

    }

    public boolean registerMManuDel(App07ElvlrtDto perm){
        int queryResult = 1;
        queryResult = attachMapper.deleteAttach(perm);
        if(queryResult < 1){
            queryResult = 1;
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

    public List<AttachDTO> MManuFilelist(App07ElvlrtDto perm){
        List<AttachDTO> attachDto = attachMapper.selectAttachList(perm);
        return attachDto;
    }

    public AttachDTO selectAttachDeteil(AttachDTO perm){
        AttachDTO attachDto = attachMapper.selectAttachDeteil(perm);
        return attachDto;
    }

    @Override
    public boolean registerMManu(App07ElvlrtDto params, MultipartFile[] files){return false;}

}
