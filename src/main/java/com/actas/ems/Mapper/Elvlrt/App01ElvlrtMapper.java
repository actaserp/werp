package com.actas.ems.Mapper.Elvlrt;



import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface App01ElvlrtMapper {

    public App01ElvlrtDto GetCallXenv(App01ElvlrtDto datainfo);


}
