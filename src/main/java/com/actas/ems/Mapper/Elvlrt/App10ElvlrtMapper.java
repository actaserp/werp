package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App10ElvlrtMapper {

    public List<App10ElvlrtDto> GetApp10List001(App10ElvlrtDto parm) ;
    public int Insert10Manul(App10ElvlrtDto perm);


}
