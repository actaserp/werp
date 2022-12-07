package com.actas.ems.Mapper.master;

import com.actas.ems.DTO.AttachDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MattachMapper {

    public int insertAttach(List<AttachDTO> attachList);

    public AttachDTO selectAttachDetail(Long idx);

    public int deleteAttach(Long boardIdx);

    public List<AttachDTO> selectAttachList(Long boardIdx);

    public int selectAttachTotalCount(Long boardIdx);

}
