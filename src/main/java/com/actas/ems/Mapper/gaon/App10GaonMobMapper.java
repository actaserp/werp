package com.actas.ems.Mapper.gaon;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.*;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface App10GaonMobMapper {

    public List<AppMob001tDto> GetAppMobList001(App10ElvlrtDto parm) ;
    // app03-05까지 mapper
    public List<AppMob003tDto> GetApp06MobList001(App06ElvlrtDto parm) ;
    public List<AppMob003tDto> GetApp06MobList002(App06ElvlrtDto parm) ;

    public List<AttachDTO> select06AttachList(AttachDTO parm) ;
    public List<AttachDTO> select08AttachList(AttachDTO parm) ;

    public List<AppMob004tDto> GetApp0bMobList001(App08_mbmanual parm) ;
    public List<AppMob004tDto> GetApp0bMobList002(App08_mbmanual parm) ;

    public List<AppMob005tDto> GetApp28MobList001(App28ElvlrtDto parm) ;
    public List<AppMob005tDto> GetApp28MobList002(App28ElvlrtDto parm) ;
    public List<AppMob005tDto> GetApp28MobList003(App28ElvlrtDto parm) ;
    public int DeleteMManul(App08_mbmanual perm);
    public int DeleteMManul(App06ElvlrtDto perm);
    public List<CommonDto> code754get06List() ;
    public List<CommonDto> code754get08List();
    public int InsertMHManual(App06ElvlrtDto perm);
    public int UpdateMHManual(App06ElvlrtDto perm);

    public String getMHManualMaxSeq(String perm);
    public int InsertMBManual(App08_mbmanual perm);
    public int UpdateMBManual(App08_mbmanual perm);
    public String getMBManualMaxSeq(String perm);
    public int InsertMSManual(App28ElvlrtDto perm);
    public int UpdateMSManual(App28ElvlrtDto perm);
    public String getMSManualMaxSeq(String perm);

    //박광열, 모바일 현장별고장부위
    public List<App16ElvlrtDto> GetAppMobList_002(PopupDto parm);

    public List<App04ElvlrtDto> GetAppMobList_004(PopupDto parm);

    public List<App04ElvlrtDto> GetAppMobList_e(PopupDto parm);

    public List<App04ElvlrtDto> GetAppMobList_d(PopupDto parm);


    /**박광열 모바일 직원리스트 */
    public List<App14ElvlrtDto> GetAppMobList_003(PopupDto parm);

    /**박광열 모바일 보수현장리스트*/
    public List<App26ElvlrtDto> GetAppMobListr_004(PopupDto parm);

    /**박광열 모바일 고장이력*/
    public List<App16ElvlrtDto> GetAppMobListr_005(PopupDto parm);


    public List<AttachDTO> GetMobThumbList_001(PopupDto parm);

    /**박광열 고장처리등록*/
    public int Insert10Manul(App10ElvlrtDto perm);

    public int Update10Manul(App10ElvlrtDto perm);

    public List<AppMobPlanDto> GetplanList(AppMobPlanDto parm);

    /**박광열 점검계획 등록*/
    public int Insertplan(AppMobPlanDto perm);

    /**사업자명 조회*/
    public List<AppMobPlanDto> GetcltnmList(AppMobPlanDto parm);

    public int DeletePlan(AppMobPlanDto perm);

    /**점검계획 수정*/
    public int UpdatePlan(AppMobPlanDto perm);

    /**접수 조회*/
    public List<App03ElvlrtDto> GetApp01List001(PopupDto parm) ;



    /**박광열 모바일 보수현장리스트 (점검계획 전용)*/
    public List<App26ElvlrtDto> GetAppMobListr_004_plan(PopupDto parm);


    /**박광열 모바일 호기코드 삽입*/
    public String getMaxPlandate(String perm);


    /**박광열 모바일 보수현장리스트 (고장접수 전용)*/
    public List<App26ElvlrtDto> GetAppMobListr_004_e601(PopupDto parm);

    public int UpdateE401(App10ElvlrtDto parm) ;

    /**접수 삭제*/
    public int DeleteE401(App10ElvlrtDto parm) ;
    /**접수 등록**/
    public int InsertE401(App10ElvlrtDto parm) ;

    /**처리 조회*/
    public List<App10ElvlrtDto> GetAppMobList002(PopupDto parm) ;

    /**처리 삭제 및 롤백**/
    public int UpdateList002_rollback(PopupDto parm);

    public int DeleteList002(PopupDto parm);

    /**고장처리 수정**/
    public int Update10Manull(App10ElvlrtDto parm);

}
