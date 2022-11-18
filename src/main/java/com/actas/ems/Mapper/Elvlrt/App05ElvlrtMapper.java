package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App05ElvlrtMapper {

    public List<App05ElvlrtDto> GetNoticeList();
    public App05ElvlrtDto GetNoticeView(String nSeq);
    public void InsertNotice(App05ElvlrtDto perm);
    public void UpdateNotice(App05ElvlrtDto perm);
    public void DeleteNotice(String nSeq);

}
