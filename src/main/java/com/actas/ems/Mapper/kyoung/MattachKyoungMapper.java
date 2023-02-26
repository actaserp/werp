package com.actas.ems.Mapper.kyoung;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MattachKyoungMapper {

    public int InsertAttach(List<AttachDTO> attachList);

    public int deleteAttach(App04ElvlrtDto perm);
    public int deleteAttachDetail(AttachDTO perm);
    public AttachDTO selectAttachDeteil(AttachDTO perm);

    public List<AttachDTO> selectAttachList(App04ElvlrtDto perm);

    public int selectAttachTotalCount(String boardIdx);

}
