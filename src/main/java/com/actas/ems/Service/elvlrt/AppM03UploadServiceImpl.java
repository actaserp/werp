package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMobMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppM03UploadServiceImpl {



    @Autowired
    private App10ElvlrtMobMapper attachMapper;

    public List<AttachDTO> select06to03AttachList(AttachDTO parm){
        List<AttachDTO> attachDto = attachMapper.select06AttachList(parm);
        return attachDto;
    }

}
