package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App10ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App10ElvlrtService")
public class App10ElvlrtService {

    @Autowired
    App10ElvlrtMapper  app10ElvMapper;
    int queryResult = 1;


    /** 고장내용별현황 / 기간별 고장내용 */
    public List<App10ElvlrtDto> GetApp10List001(App10ElvlrtDto parm){return app10ElvMapper.GetApp10List001(parm);}

//
//    /** 글 등록 */
//    public boolean Insert10Manu(App10ElvlrtDto perm){
//        queryResult = app10ElvMapper.Insert10Manul(perm);
//        if(queryResult < 1){
//            queryResult = 0;
//        }
//        return (queryResult > 0);
//    }

}
