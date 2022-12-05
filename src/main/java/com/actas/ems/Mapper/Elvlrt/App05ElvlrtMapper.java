package com.actas.ems.Mapper.Elvlrt;


import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App05ElvlrtMapper {

    public List<App05ElvlrtDto> GetNoticeList(String searchType, String Keyword);
    public App05ElvlrtDto GetNoticeView(String nSeq);
    public void InsertNotice(App05ElvlrtDto perm);
    public void UpdateNotice(App05ElvlrtDto perm);
    public void DeleteNotice(String nSeq);
    public String getDate();
    public void ResetSeq();
    public String getMaxSeq();
    public String SeqNext();

    /**
     * 게시글 리스트 조회
     * @param params - search conditions
     * @return 게시글 리스트
     */
    List<App05ElvlrtDto> findAll(SearchDto params);

    /**
     * 게시글 수 카운팅
     * @param params - search conditions
     * @return 게시글 수
     */
    int count(SearchDto params);
}
