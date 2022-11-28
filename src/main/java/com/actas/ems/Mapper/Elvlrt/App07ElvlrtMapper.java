package com.actas.ems.Mapper.Elvlrt;

import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface App07ElvlrtMapper {

    public List<App07ElvlrtDto> GetNoticeList();

    public void uploadBoard(App07ElvlrtDto perm);

    public App07ElvlrtDto GetnoticeView(String fSeq);

    public void deleteBoard(String fseq);

    public void updateBoard(App07ElvlrtDto dto);


}
