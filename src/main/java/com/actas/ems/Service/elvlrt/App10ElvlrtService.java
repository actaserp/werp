package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App09ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service("App10ElvlrtService")
public class App10ElvlrtService {

    @Autowired
    App10ElvlrtMapper  app10ElvMapper;
    int queryResult = 1;


    /** view page **/
    public List<App10ElvlrtDto> GetApp10List001(App10ElvlrtDto parm){return app10ElvMapper.GetApp10List001(parm);}

    /** view page2 **/
    public List<App10ElvlrtDto> GetApptab10List001(App10ElvlrtDto parm){return app10ElvMapper.GetApptab10List001(parm);}


    /** 글 등록 */
    public boolean Insert10Manu(App10ElvlrtDto perm){
        queryResult = app10ElvMapper.Insert10Manul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }


    public String get10ManualMaxSeq(String parm){return app10ElvMapper.get10ManualMaxSeq(parm);}

    //글수정
    @Transactional
    public boolean Update10Manu(App10ElvlrtDto perm){
        queryResult = app10ElvMapper.Update10Manul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    //글삭제
    public boolean Delete10Manu(App10ElvlrtDto perm){
        int queryResult = 1;
        queryResult = app10ElvMapper.Delete10Manul(perm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }
}
