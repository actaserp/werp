package com.actas.ems.Mapper.samjung;



import com.actas.ems.DTO.Elvlrt.*;
import com.actas.ems.DTO.Popup.PopupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App01SamMapper {

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
    public int InsertE601CALL(AppCall601ElvlrtDto parm) ;
    public int InsertE601CALL01(AppCall601ElvlrtDto parm) ;

    public int UpdateE601CALL(AppCall601ElvlrtDto parm) ;
    public int UpdateE601CALL01(AppCall601ElvlrtDto parm);
    public int DeleteE601CALL(AppCall601ElvlrtDto parm) ;
    public int DeleteE601CALL01(AppCall601ElvlrtDto parm) ;

    public int UpdateCallInfo(App01ElvlrtDto parm) ;



    public int InsertE401Sms(AppCallElvlrtDto datainfo);

    public String getSmsMaxSeq(String parm);

    public List<App03ElvlrtDto> GetApp01List006(PopupDto parm) ;

    public String getE601CallNM(String parm);


    public String gete601CallMaxSeq(String parm);

    public List<AppCallElvlrtDto> GetCallBackList(AppCallElvlrtDto datainfo) ;
    public List<AppCall601ElvlrtDto> GetPhonebookList(AppCall601ElvlrtDto datainfo) ;


}
