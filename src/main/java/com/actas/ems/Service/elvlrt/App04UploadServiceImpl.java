package com.actas.ems.Service.elvlrt;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App04ElvlrtMapper;
import com.actas.ems.Mapper.master.MattachMapper;
import com.actas.ems.util.FilsUtils;
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
    private MattachMapper attachMapper;

    @Autowired
    private FilsUtils fileUtils;

//    @Override
    public boolean registerMManu(App04ElvlrtDto params){
        String ls_minputdate = params.getMinputdate();
        String ls_yeare = ls_minputdate.substring(0,4);
        String ls_mm = ls_minputdate.substring(5,7);
        String ls_dd = ls_minputdate.substring(8,10);
        ls_minputdate =  ls_yeare + ls_mm + ls_dd;

        int queryResult = 0;
        if(params.getMseq() == null){
            params.setMseq(CountSeq(ls_yeare + ls_mm));
            queryResult = app04Mapper.InsertMManul(params);
        }else{
            queryResult = app04Mapper.UpdateMManul(params);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public boolean registerMManu(App04ElvlrtDto params, MultipartFile[] files){
        int queryResult = 1;

        if(registerMManu(params) == false){
            return false;
        }

        List<AttachDTO> fileList = fileUtils.uploadFiles(files, params.getMseq());
        if (CollectionUtils.isEmpty(fileList) == false) {
            queryResult = attachMapper.insertAttach(fileList);
            if(queryResult < 1){
                queryResult = 0;
            }
        }
        return (queryResult > 0);
    }

    public String CountSeq(String yyyymm){
        String ls_mseq = getMManualMaxSeq(yyyymm);
        int ll_mseq = 0;
        if(ls_mseq == null ){
            ls_mseq = yyyymm + "001";
        }else{
            ll_mseq = Integer.parseInt(ls_mseq);
            ls_mseq = Integer.toString(ll_mseq + 1 );
        }
        return ls_mseq;
    }

}
