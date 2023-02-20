package com.actas.ems.Mapper.SmsMcs;



import com.actas.ems.DTO.Elvlrt.AppCallElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface AppSmsMcsMapper {

    public int InsertShortSms(AppCallElvlrtDto datainfo);
    public int InsertLongSms(AppCallElvlrtDto datainfo);


}
