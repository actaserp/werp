package com.actas.ems.Service.elvlrt.App_mbmanualService;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import com.actas.ems.Mapper.Elvlrt.App_mbmanual.App_mbmanualMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service("App_mbmanualService")
public class App_mbmanualService {

    @Autowired
    App_mbmanualMapper app_mbmanualMapper;

    int queryResult = 1;

    public Object GetMManulList(App08_mbmanual perm){return app_mbmanualMapper.GetMManulList(perm);}

    public List<App08_mbmanual> GetMManuBlankList(App08_mbmanual perm){return app_mbmanualMapper.GetMManulList(perm);}


    //상세조회
    public App08_mbmanual GetMManuView(@RequestParam("bseq") String bSeq){return app_mbmanualMapper.GetMManulView(bSeq);}

    //글쓰기
    public boolean InsertMManu(App08_mbmanual perm){
        queryResult = app_mbmanualMapper.InsertMManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    //글수정
    @Transactional
    public boolean UpdateMManu(App08_mbmanual perm){
        queryResult = app_mbmanualMapper.UpdateMManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    //글삭제
    public boolean DeleteMManu(App08_mbmanual perm){
        queryResult = app_mbmanualMapper.DeleteMManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }




    public String getMManualMaxSeq(String parm){return app_mbmanualMapper.getMManualMaxSeq(parm);}

    public List<CommonDto> GetComm750List(){ return app_mbmanualMapper.GetComm750List();}

    public List<CommonDto> GetComm750BlankList() {return app_mbmanualMapper.GetComm750List();}

}
