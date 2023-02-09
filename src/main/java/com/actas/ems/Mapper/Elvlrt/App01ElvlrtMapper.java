package com.actas.ems.Mapper.Elvlrt;



import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppCallElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App01ElvlrtMapper {

    public App01ElvlrtDto GetCallXenv(App01ElvlrtDto datainfo);
    public List<App03ElvlrtDto> GetApp01List001(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp01List002(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp01List003(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp01List004(PopupDto parm) ;
    public List<App03ElvlrtDto> GetApp01List005(PopupDto parm) ;
    public String get10RecenumMaxSeq(String parm) ;
    public String getCllMaxSeq(String parm) ;
    public int InsertE401(App10ElvlrtDto parm) ;
    public int UpdateE401(App10ElvlrtDto parm) ;
    public int DeleteE401(App10ElvlrtDto parm) ;
    public int InsertCall(AppCallElvlrtDto parm) ;
    public int UpdateCall(AppCallElvlrtDto parm) ;
    public int DeleteCall(AppCallElvlrtDto parm) ;



}
