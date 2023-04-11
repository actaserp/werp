package com.actas.ems.Mapper.gaon;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Attach02GaonMapper {

    public int InsertAttach(List<AttachDTO> attachList);

    public int deleteAttach(App07ElvlrtDto perm);

    public int deleteAttachDetail(AttachDTO perm);

    public AttachDTO selectAttachDeteil(AttachDTO perm);

    public List<AttachDTO> selectAttachList(App07ElvlrtDto perm);

    public int selectAttachTotalCount(String boardIdx);

    public List<AttachDTO> selectinsertdate(App07ElvlrtDto perm);
}

