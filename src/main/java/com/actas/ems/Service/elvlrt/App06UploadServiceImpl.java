package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App06ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App06GaonMapper;
import com.actas.ems.Mapper.kyoung.App06KyoungMapper;
import com.actas.ems.Mapper.Elvlrt.Attach06ElvlrtMapper;
import com.actas.ems.Mapper.gaon.Attach06GaonMapper;
import com.actas.ems.Mapper.kyoung.Attach06KyoungMapper;
import com.actas.ems.Mapper.nm.App06NmyangMapper;
import com.actas.ems.Mapper.nm.Attach06NmyangMapper;
import com.actas.ems.util.FilsUtils;
import com.actas.ems.util.UIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class App06UploadServiceImpl implements  App06UploadService {

    @Autowired
    private App06ElvlrtMapper app06Mapper;
    private App06GaonMapper app06MapperG;
    private App06KyoungMapper app06MapperK;
    private App06NmyangMapper app06MapperN;
    private App06ElvlrtMapper app06MapperH;

    @Autowired
    private Attach06ElvlrtMapper attachMapper;
    private Attach06GaonMapper attachMapperG;
    private Attach06KyoungMapper attachMapperK;
    private Attach06NmyangMapper attachMapperN;
    private Attach06ElvlrtMapper attachMapperH;

    @Autowired
    private FilsUtils fileUtils;

    public boolean registerMHManual(App06ElvlrtDto params,  List<AttachDTO> attachDto){
        int queryResult = 1;

//        List<AttachDTO> fileList = fileUtils.uploadFiles(files, params.getMseq());
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                if (CollectionUtils.isEmpty(attachDto) == false) {
                    queryResult = attachMapper.InsertAttach(attachDto);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = attachMapperG.InsertAttach(attachDto);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = attachMapperK.InsertAttach(attachDto);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = attachMapperN.InsertAttach(attachDto);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = attachMapperH.InsertAttach(attachDto);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    public boolean registerMHManualDel(App06ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = attachMapper.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = attachMapperG.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = attachMapperK.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = attachMapperN.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = attachMapperH.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }


    public boolean MHManualFileDel(AttachDTO parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = attachMapper.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = attachMapperG.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = attachMapperK.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = attachMapperN.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = attachMapperH.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    public List<AttachDTO> MHManualFilelist(App06ElvlrtDto perm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                List<AttachDTO> attachDto = attachMapper.selectAttachList(perm);
                return attachDto;
            case "ELV_KYOUNG":
                List<AttachDTO> attachDtoK = attachMapperK.selectAttachList(perm);
                return attachDtoK;
            case "ELV_GAON":
                List<AttachDTO> attachDtoG = attachMapperG.selectAttachList(perm);
                return attachDtoG;
            case "nmyang":
                List<AttachDTO> attachDtoN = attachMapperN.selectAttachList(perm);
                return attachDtoN;
            case "hanyangs":
                List<AttachDTO> attachDtoH = attachMapperH.selectAttachList(perm);
                return attachDtoH;
            default:
                List<AttachDTO> object = null;
                return object;
        }
    }

    public AttachDTO selectAttachDeteil(AttachDTO parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                AttachDTO attachDto = attachMapper.selectAttachDeteil(parm);
                return attachDto;
            case "ELV_KYOUNG":
                AttachDTO attachDtoK = attachMapperK.selectAttachDeteil(parm);
                return attachDtoK;
            case "ELV_GAON":
                AttachDTO attachDtoG = attachMapperG.selectAttachDeteil(parm);
                return attachDtoG;
            case "nmyang":
                AttachDTO attachDtoN = attachMapperN.selectAttachDeteil(parm);
                return attachDtoN;
            case "hanyangs":
                AttachDTO attachDtoH = attachMapperH.selectAttachDeteil(parm);
                return attachDtoH;
            default:
                AttachDTO object = null;
                return object;
        }
    }

    @Override
    public boolean registerMHManual(App06ElvlrtDto params, MultipartFile[] files) {
        return false;
    }
}
