package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMobMapper;
import com.actas.ems.Mapper.gaon.App10GaonMobMapper;
import com.actas.ems.Mapper.kyoung.App10KyoungMobMapper;

import com.actas.ems.Mapper.nm.App10NmyangMobMapper;
import com.actas.ems.util.UIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppM03UploadServiceImpl {



    @Autowired
    private App10ElvlrtMobMapper attachMapper;
    @Autowired
    private App10GaonMobMapper attachMapperG;
    @Autowired
    private App10KyoungMobMapper attachMapperK;
    @Autowired
    private App10NmyangMobMapper attachMapperN;
    @Autowired
    private App10ElvlrtMobMapper attachMapperH;

    public List<AttachDTO> select06to03AttachList(AttachDTO parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                List<AttachDTO> attachDto = attachMapper.select06AttachList(parm);
                return attachDto;
            case "ELV_KYOUNG":
                List<AttachDTO> attachDtoK = attachMapperK.select06AttachList(parm);
                return attachDtoK;
            case "ELV_GAON":
                List<AttachDTO> attachDtoG = attachMapperG.select06AttachList(parm);
                return attachDtoG;
            case "nmyang":
                List<AttachDTO> attachDtoN = attachMapperN.select06AttachList(parm);
                return attachDtoN;
            case "hanyangs":
                List<AttachDTO> attachDtoH = attachMapperH.select06AttachList(parm);
                return attachDtoH;
            default:
                List<AttachDTO> object = null;
                return object;
        }
    }

    public List<AttachDTO> select08tombAttachList(AttachDTO parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                List<AttachDTO> attachDto = attachMapper.select08AttachList(parm);
                return attachDto;
            case "ELV_KYOUNG":
                List<AttachDTO> attachDtoK = attachMapperK.select08AttachList(parm);
                return attachDtoK;
            case "ELV_GAON":
                List<AttachDTO> attachDtoG = attachMapperG.select08AttachList(parm);
                return attachDtoG;
            case "nmyang":
                List<AttachDTO> attachDtoN = attachMapperN.select08AttachList(parm);
                return attachDtoN;
            case "hanyangs":
                List<AttachDTO> attachDtoH = attachMapperH.select08AttachList(parm);
                return attachDtoH;
            default:
                List<AttachDTO> object = null;
                return object;
        }
    }

}
