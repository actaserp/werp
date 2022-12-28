package com.actas.ems.Service.elvlrt.App_mbmanualService;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import com.actas.ems.Mapper.Elvlrt.App_mbmanual.App_mbmanualMapper;
import com.actas.ems.Mapper.Elvlrt.App_mbmanual.Attach_02ElvlrtMapper;
import com.actas.ems.util.FilsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class App_mbUploadServiceImpl implements App_mbUploadService{

    @Autowired
    private App_mbmanualMapper app_mbmanualMapper;

    @Autowired
    private Attach_02ElvlrtMapper attach_02ElvlrtMapper;

    @Autowired
    private FilsUtils fileUtils;

    public boolean registerMManu(App08_mbmanual params, List<AttachDTO> attachDto){
        int queryResult = 1;

        if(CollectionUtils.isEmpty(attachDto) == false){
            queryResult = attach_02ElvlrtMapper.InsertAttach(attachDto);
            if(queryResult < 1){
                queryResult = 0;
            }

        }
        return (queryResult > 0);

    }

    public boolean registerMManuDel(App08_mbmanual perm){
        int queryResult = 1;
        queryResult = attach_02ElvlrtMapper.deleteAttach(perm);
        if(queryResult < 1){
            queryResult = 1;
        }
        return (queryResult > 0);
    }

    public boolean MManuFileDel(AttachDTO perm){
        int queryResult = 1;
        queryResult = attach_02ElvlrtMapper.deleteAttachDetail(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    public List<AttachDTO> MManuFilelist(App08_mbmanual perm){
        List<AttachDTO> attachDto = attach_02ElvlrtMapper.selectAttachList(perm);
        return attachDto;
    }

    public AttachDTO selectAttachDeteil(AttachDTO perm){
        AttachDTO attachDto = attach_02ElvlrtMapper.selectAttachDeteil(perm);
        return attachDto;
    }

    @Override
    public boolean registerMManu(App08_mbmanual params, MultipartFile[] files){return false;}

}

