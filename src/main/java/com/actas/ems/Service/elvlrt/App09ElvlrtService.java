package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App09ElvlrtDto;
import com.actas.ems.Mapper.Elvlrt.App09ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Service("App09ElvlrtService")
public class App09ElvlrtService {

    @Autowired
    App09ElvlrtMapper app09ElvMapper;
    int queryResult = 1;
    public List<App09ElvlrtDto> GetFQManulList(App09ElvlrtDto perm){return app09ElvMapper.GetFQManulList(perm);}

    //글쓰기
    public boolean InsertFQManu(App09ElvlrtDto perm){
        queryResult = app09ElvMapper.InsertFQManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    //글수정
    @Transactional
    public boolean UpdateFQManu(App09ElvlrtDto perm){
        queryResult = app09ElvMapper.UpdateFQManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    //글삭제
    public boolean DeleteFQManu(App09ElvlrtDto perm){
        queryResult = app09ElvMapper.DeleteFQManul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }


    public String getFQManualMaxSeq(String parm){return app09ElvMapper.getFQManualMaxSeq(parm);}

    public List<CommonDto> GetComm750List(){ return app09ElvMapper.GetComm750List();}
    public List<CommonDto> GetComm750BlankList() {return app09ElvMapper.GetComm750List();}
}
