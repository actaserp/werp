package com.actas.ems.Mapper.nm;

import com.actas.ems.DTO.Elvlrt.App00ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface App00NmyangMapper {
    public List<App00ElvlrtDto> GetApp00List001(PopupDto parm);
}
