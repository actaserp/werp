package com.actas.ems.Mapper.samjung.App_mbmanual;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Attach_02SamMapper {

    public int InsertAttach(List<AttachDTO> attachList);

    public int deleteAttach(App08_mbmanual perm);

    public int deleteAttachDetail(AttachDTO perm);

    public AttachDTO selectAttachDeteil(AttachDTO perm);

    public List<AttachDTO> selectAttachList(App08_mbmanual perm);

    public int selectAttachTotalCount(String boardIdx);
}
