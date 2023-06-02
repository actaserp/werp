package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App04ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App04GaonMapper;
import com.actas.ems.Mapper.kyoung.App04KyoungMapper;
import com.actas.ems.Mapper.Elvlrt.MattachElvlrtMapper;
import com.actas.ems.Mapper.gaon.MattachGaonMapper;
import com.actas.ems.Mapper.kyoung.MattachKyoungMapper;
import com.actas.ems.Mapper.nm.App04NmyangMapper;
import com.actas.ems.Mapper.nm.MattachNmyangMapper;
import com.actas.ems.Mapper.samjung.MattachSamMapper;
import com.actas.ems.Mapper.sjilsan.MattachSjilsanMapper;
import com.actas.ems.util.FilsUtils;
import com.actas.ems.util.UIUtils;
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
    private App04NmyangMapper app04MapperN;

    @Autowired
    private MattachElvlrtMapper attachMapper;
    @Autowired
    private MattachGaonMapper attachMapperG;
    @Autowired
    private MattachKyoungMapper attachMapperK;
    @Autowired
    private MattachNmyangMapper attachMapperN;
    @Autowired
    private MattachSamMapper attachMapperS;
    @Autowired
    private MattachSjilsanMapper attachMapperSj;

    @Autowired
    private FilsUtils fileUtils;

    public boolean registerMManu(App04ElvlrtDto params,  List<AttachDTO> attachDto){
        int queryResult = 1;
//        List<AttachDTO> fileList = fileUtils.uploadFiles(files, params.getMseq());
        if (CollectionUtils.isEmpty(attachDto) == false) {
            String ls_dbnm = UIUtils.getElvDataSourceNm();
            switch (ls_dbnm){
                case "ELV_LRT":
                    queryResult = attachMapper.InsertAttach(attachDto);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                case "ELV_KYOUNG":
                    queryResult = attachMapperK.InsertAttach(attachDto);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                case "ELV_GAON":
                    queryResult = attachMapperG.InsertAttach(attachDto);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                case "samjung":
                    queryResult = attachMapperS.InsertAttach(attachDto);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                case "samjungilsan":
                    queryResult = attachMapperSj.InsertAttach(attachDto);
                    if(queryResult < 1){
                        queryResult = 0;
                    }
                default:
                    break;
            }
        }
        return (queryResult > 0);
    }


    public boolean registerMManuDel(App04ElvlrtDto perm){
        int queryResult = 1;

        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = attachMapper.deleteAttach(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "ELV_KYOUNG":
                queryResult = attachMapperK.deleteAttach(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "ELV_GAON":
                queryResult = attachMapperG.deleteAttach(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "samjung":
                queryResult = attachMapperS.deleteAttach(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "samjungilsan":
                queryResult = attachMapperSj.deleteAttach(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            default:
                break;
        }
        return (queryResult > 0);
    }

    public boolean registerDManuDel(App04ElvlrtDto perm){
        int queryResult = 1;

        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = attachMapper.deleteAttach(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "ELV_KYOUNG":
                queryResult = attachMapperK.deleteAttach(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "ELV_GAON":
                queryResult = attachMapperG.deleteAttach(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "samjung":
                queryResult = attachMapperS.deleteAttach(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "samjungilsan":
                queryResult = attachMapperSj.deleteAttach(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            default:
                break;
        }
        return (queryResult > 0);
    }


    public boolean MManuFileDel(AttachDTO perm){
        int queryResult = 1;

        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = attachMapper.deleteAttachDetail(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "ELV_KYOUNG":
                queryResult = attachMapperK.deleteAttachDetail(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "ELV_GAON":
                queryResult = attachMapperG.deleteAttachDetail(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "samjung":
                queryResult = attachMapperS.deleteAttachDetail(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            case "samjungilsan":
                queryResult = attachMapperSj.deleteAttachDetail(perm);
                if(queryResult < 1){
                    queryResult = 0;
                }
            default:
                break;
        }
        return (queryResult > 0);
    }

    public List<AttachDTO> MManuFilelist(App04ElvlrtDto perm){
        List<AttachDTO> attachDto = null  ;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                attachDto = attachMapper.selectAttachList(perm);
            case "ELV_KYOUNG":
                attachDto = attachMapperK.selectAttachList(perm);
            case "ELV_GAON":
                attachDto = attachMapperG.selectAttachList(perm);
            case "samjung":
                attachDto = attachMapperS.selectAttachList(perm);
            case "samjungilsan":
                attachDto = attachMapperSj.selectAttachList(perm);
            default:
                break;
        }
        return attachDto;
    }

    public AttachDTO selectAttachDeteil(AttachDTO perm){
        AttachDTO attachDto = null  ;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                attachDto = attachMapper.selectAttachDeteil(perm);
            case "ELV_KYOUNG":
                attachDto = attachMapperK.selectAttachDeteil(perm);
            case "ELV_GAON":
                attachDto = attachMapperG.selectAttachDeteil(perm);
            case "samjung":
                attachDto = attachMapperS.selectAttachDeteil(perm);
            case "samjungilsan":
                attachDto = attachMapperSj.selectAttachDeteil(perm);
            default:
                break;
        }
        return attachDto;
    }

    @Override
    public boolean registerMManu(App04ElvlrtDto params, MultipartFile[] files) {
        return false;
    }
}
