package com.actas.ems.Mapper.kyoung;


import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App10KyoungMapper {
    public List<App10ElvlrtDto> GetApp10List002(App10ElvlrtDto parm) ;

    public List<App10ElvlrtDto> GetApp10List001(App10ElvlrtDto parm) ;

    public List<App10ElvlrtDto> GetApptab10List001(App10ElvlrtDto parm);
    public int Insert10Manul(App10ElvlrtDto perm);

    public int Update10Manul(App10ElvlrtDto perm);

    public int Delete10Manul(App10ElvlrtDto perm);

    public int Updateresult11(App10ElvlrtDto perm);
    public int Updateresult10(App10ElvlrtDto perm);
    public int Updateresult100(App10ElvlrtDto perm);



    public String get10ManualMaxSeq(String perm);


}
