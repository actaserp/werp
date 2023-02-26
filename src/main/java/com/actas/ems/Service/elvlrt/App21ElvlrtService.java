package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App21ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.App21ElvlrtMapper;
import com.actas.ems.Mapper.gaon.App21GaonMapper;
import com.actas.ems.Mapper.kyoung.App21KyoungMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("App21ElvlrtService")
public class App21ElvlrtService {

    @Autowired
    App21GaonMapper app21ElvMapper;
    @Autowired
    App21GaonMapper app21ElvMapperG;
    @Autowired
    App21GaonMapper app21ElvMapperK;
    @Autowired
    App21GaonMapper app21ElvMapperN;
    @Autowired
    App21GaonMapper app21ElvMapperH;

    public List<App21ElvlrtDto> GetApp21List001(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  app21ElvMapper.GetApp21List001(parm);
            case "ELV_KYOUNG":
                return  app21ElvMapperK.GetApp21List001(parm);
            case "ELV_GAON":
                return  app21ElvMapperG.GetApp21List001(parm);
            case "nmyang":
                return  app21ElvMapperN.GetApp21List001(parm);
            case "hanyangs":
                return  app21ElvMapperH.GetApp21List001(parm);
            default:
                List<App21ElvlrtDto> object = null;
                return object;
        }
    }
//    {return app21ElvMapper.GetApp21List001(parm);}



}
