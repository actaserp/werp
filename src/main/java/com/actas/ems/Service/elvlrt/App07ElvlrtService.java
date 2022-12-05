package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.Pagination;
import com.actas.ems.DTO.Elvlrt.PagingResponse;
import com.actas.ems.DTO.Elvlrt.SearchDto;
import com.actas.ems.Mapper.Elvlrt.App07ElvlrtMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service("App07ElvlrtService")
public class App07ElvlrtService {

    @Autowired
    App07ElvlrtMapper appMapper;
    public List<App07ElvlrtDto> GetNoticeList(final SearchDto params){

        return appMapper.GetNoticeList(params);
    }

    //글쓰기
    public void uploadBoard(App07ElvlrtDto perm){appMapper.uploadBoard(perm);}

    //상세조회
    public App07ElvlrtDto GetNoticeView(@RequestParam("fseq") String fSeq){return appMapper.GetnoticeView(fSeq);}


    //글삭제
    @Transactional //오류시에 자동롤백
    public void deleteBoard(@RequestParam("fseq") String fseq) {appMapper.deleteBoard(fseq);}
    //글수정
    @Transactional
    public void updateBoard(App07ElvlrtDto dto){appMapper.updateBoard(dto);}


}
