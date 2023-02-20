package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App07ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service("App07ElvlrtService")
public class App07ElvlrtService {

    @Autowired
    App07ElvlrtMapper app07ElvMapper;
    int queryResult = 1;
    public Object GetMManulList(App07ElvlrtDto perm){return app07ElvMapper.GetMManulList(perm);}

    public List<App07ElvlrtDto> GetMManuBlankList(App07ElvlrtDto perm){return app07ElvMapper.GetMManulList(perm);}


    //상세조회
    public App07ElvlrtDto GetMManuView(@RequestParam("fseq") String fSeq){return app07ElvMapper.GetMManulView(fSeq);}

    //글쓰기
    public boolean InsertMManu(App07ElvlrtDto perm){
        queryResult = app07ElvMapper.InsertMManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    //글수정
    @Transactional
    public boolean UpdateMManu(App07ElvlrtDto perm){
        queryResult = app07ElvMapper.UpdateMManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    //글삭제
    public boolean DeleteMManu(App07ElvlrtDto perm){
        queryResult = app07ElvMapper.DeleteMManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }




    public String getMManualMaxSeq(String parm){return app07ElvMapper.getMManualMaxSeq(parm);}

    public List<CommonDto> GetComm750List(){ return app07ElvMapper.GetComm750List();}

    public List<CommonDto> GetComm750BlankList() {return app07ElvMapper.GetComm750List();}
}
