package com.actas.ems.Service.elvlrt.App_mbmanualService;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App_mbmanual.App_mbmanualMapper;
import com.actas.ems.Mapper.gaon.App_mbmanual.App_mbmanualGaonMapper;
import com.actas.ems.Mapper.kyoung.App_mbmanual.App_mbmanualKyoungMapper;
import com.actas.ems.Mapper.Elvlrt.App_mbmanual.Attach_02ElvlrtMapper;
import com.actas.ems.Mapper.kyoung.App_mbmanual.Attach_02KyoungMapper;
import com.actas.ems.Mapper.gaon.App_mbmanual.Attach_02GaonMapper;
import com.actas.ems.Mapper.nm.App_mbmanual.App_mbmanualNmyangMapper;
import com.actas.ems.Mapper.nm.App_mbmanual.Attach_02NmyangMapper;
import com.actas.ems.util.FilsUtils;
import com.actas.ems.util.UIUtils;
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
    private App_mbmanualGaonMapper APP_MBMANUAL_GaonMAPPER ;
    @Autowired
    private App_mbmanualKyoungMapper app27Elvlrt_KyoungMapperK ;
    @Autowired
    private App_mbmanualNmyangMapper app27Elvlrt_NmyangMapperN ;

    @Autowired
    private Attach_02ElvlrtMapper attach_02ElvlrtMapper;
    @Autowired
    private Attach_02GaonMapper attach_02GaonMapper;
    @Autowired
    private Attach_02KyoungMapper attach_02KyoungMapper;
    @Autowired
    private Attach_02NmyangMapper attach_02NmyangMapper;

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

    public boolean registerMManuDel(App08_mbmanual parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = attach_02ElvlrtMapper.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 1;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = attach_02GaonMapper.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = attach_02KyoungMapper.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = attach_02ElvlrtMapper.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = attach_02ElvlrtMapper.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    public boolean MManuFileDel(AttachDTO parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = attach_02ElvlrtMapper.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 1;
                }
                return (queryResult > 0);
            case "ELV_GAON":
                queryResult = attach_02GaonMapper.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "ELV_KYOUNG":
                queryResult = attach_02KyoungMapper.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "nmyang":
                queryResult = attach_02ElvlrtMapper.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "hanyangs":
                queryResult = attach_02ElvlrtMapper.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    public List<AttachDTO> MManuFilelist(App08_mbmanual perm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                List<AttachDTO> attachDto = attach_02ElvlrtMapper.selectAttachList(perm);
                return attachDto;
            case "ELV_KYOUNG":
                List<AttachDTO> attachDtoK = attach_02KyoungMapper.selectAttachList(perm);
                return attachDtoK;
            case "ELV_GAON":
                List<AttachDTO> attachDtoG = attach_02GaonMapper.selectAttachList(perm);
                return attachDtoG;
            case "nmyang":
                List<AttachDTO> attachDtoN = attach_02ElvlrtMapper.selectAttachList(perm);
                return attachDtoN;
            case "hanyangs":
                List<AttachDTO> attachDtoH = attach_02ElvlrtMapper.selectAttachList(perm);
                return attachDtoH;
            default:
                List<AttachDTO> object = null;
                return object;
        }
    }

    public AttachDTO selectAttachDeteil(AttachDTO perm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                AttachDTO attachDto = attach_02ElvlrtMapper.selectAttachDeteil(perm);
                return attachDto;
            case "ELV_KYOUNG":
                AttachDTO attachDtoK = attach_02KyoungMapper.selectAttachDeteil(perm);
                return attachDtoK;
            case "ELV_GAON":
                AttachDTO attachDtoG = attach_02GaonMapper.selectAttachDeteil(perm);
                return attachDtoG;
            case "nmyang":
                AttachDTO attachDtoN = attach_02ElvlrtMapper.selectAttachDeteil(perm);
                return attachDtoN;
            case "hanyangs":
                AttachDTO attachDtoH = attach_02ElvlrtMapper.selectAttachDeteil(perm);
                return attachDtoH;
            default:
                AttachDTO object = null;
                return object;
        }
    }

    @Override
    public boolean registerMManu(App08_mbmanual params, MultipartFile[] files){return false;}

}

