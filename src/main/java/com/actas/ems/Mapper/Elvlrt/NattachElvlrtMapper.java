package com.actas.ems.Mapper.Elvlrt;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App28ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NattachElvlrtMapper {

    public int InsertAttach(List<AttachDTO> attachList);


    public int deleteAttach(App05ElvlrtDto perm);
    public int deleteAttachDetail(AttachDTO perm);
    public AttachDTO selectAttachDeteil(AttachDTO perm);

    public List<AttachDTO> selectAttachList(App05ElvlrtDto perm);

    public int selectAttachTotalCount(String boardIdx);

}
