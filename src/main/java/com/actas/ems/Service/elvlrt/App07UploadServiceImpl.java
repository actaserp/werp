package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;


import com.actas.ems.Mapper.Elvlrt.App05ElvlrtMapper;
import com.actas.ems.Mapper.Elvlrt.App07ElvlrtMapper;
import com.actas.ems.Mapper.Elvlrt.NattachElvlrtMapper;
import com.actas.ems.Mapper.gaon.App05GaonMapper;
import com.actas.ems.Mapper.gaon.App07GaonMapper;
import com.actas.ems.Mapper.gaon.NattachGaonMapper;
import com.actas.ems.Mapper.kyoung.App05KyoungMapper;
import com.actas.ems.Mapper.kyoung.App07KyoungMapper;
import com.actas.ems.Mapper.Elvlrt.Attach02ElvlrtMapper;
import com.actas.ems.Mapper.gaon.Attach02GaonMapper;
import com.actas.ems.Mapper.kyoung.Attach02KyoungMapper;

import com.actas.ems.Mapper.kyoung.NattachKyoungMapper;
import com.actas.ems.Mapper.nm.App07NmyangMapper;
import com.actas.ems.Mapper.nm.Attach02NmyangMapper;
import com.actas.ems.Mapper.samjung.Attach02SamMapper;
import com.actas.ems.Mapper.samjung.Attach06SamMapper;
import com.actas.ems.Mapper.sjilsan.Attach02SjilsanMapper;
import com.actas.ems.Mapper.sjilsan.Attach06SjilsanMapper;
import com.actas.ems.util.FilsUtils;
import com.actas.ems.util.UIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class App07UploadServiceImpl implements App07UploadService{

    @Autowired
    private App07ElvlrtMapper App07Mapper;
    private App07GaonMapper App07MapperG;
    private App07KyoungMapper App07MapperK;
    private App07NmyangMapper App07MapperN;
    private App07GaonMapper App07MapperH;

    @Autowired
    private Attach02ElvlrtMapper attachMapper;
    private Attach02GaonMapper attachMapperG;
    private Attach02KyoungMapper attachMapperK;
    private Attach02NmyangMapper  attachMapperN;
    private Attach02ElvlrtMapper attachMapperH;
    private Attach02SamMapper attachMapperS;
    private Attach02SjilsanMapper attachMapperSj;

    @Autowired
    private FilsUtils fileUtils;

    public boolean registerMManu(App07ElvlrtDto params, List<AttachDTO> attachDto){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                if(CollectionUtils.isEmpty(attachDto) == false){
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
            case "samjung":
                queryResult = attachMapperS.InsertAttach(attachDto);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = attachMapperSj.InsertAttach(attachDto);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;


    }

    public boolean registerMManuDel(App07ElvlrtDto parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = attachMapper.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 1;
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
            case "samjung":
                queryResult = attachMapperS.deleteAttach(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = attachMapperSj.deleteAttach(parm);
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
            case "samjung":
                queryResult = attachMapperS.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            case "samjungilsan":
                queryResult = attachMapperSj.deleteAttachDetail(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return (queryResult > 0);
            default:
                break;
        }
        return true;
    }

    public List<AttachDTO> MManuFilelist(App07ElvlrtDto perm){
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
            case "samjung":
                List<AttachDTO> attachDtoS = attachMapperS.selectAttachList(perm);
                return attachDtoS;
            case "samjungilsan":
                List<AttachDTO> attachDtoSj = attachMapperSj.selectAttachList(perm);
                return attachDtoSj;
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
            case "samjung":
                AttachDTO attachDtoS = attachMapperS.selectAttachDeteil(parm);
                return attachDtoS;
            case "samjungilsan":
                AttachDTO attachDtoSj = attachMapperSj.selectAttachDeteil(parm);
                return attachDtoSj;
            default:
                AttachDTO object = null;
                return object;
        }
    }

    @Override
    public boolean registerMManu(App07ElvlrtDto params, MultipartFile[] files){return false;}

    public List<AttachDTO> selectinsertdate(App07ElvlrtDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                List<AttachDTO> attachDto = attachMapper.selectinsertdate(parm);
                return attachDto;
            case "ELV_KYOUNG":
                List<AttachDTO> attachDtoK = attachMapperK.selectinsertdate(parm);
                return attachDtoK;
            case "ELV_GAON":
                List<AttachDTO> attachDtoG = attachMapperG.selectinsertdate(parm);
                return attachDtoG;
            case "nmyang":
                List<AttachDTO> attachDtoN = attachMapperN.selectinsertdate(parm);
                return attachDtoN;
            case "hanyangs":
                List<AttachDTO> attachDtoH = attachMapperH.selectinsertdate(parm);
                return attachDtoH;
            default:
                List<AttachDTO> object = null;
                return object;
        }
    }

}
