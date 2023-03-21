package com.actas.ems.Service.master;

import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.TBXLoginDTO;
import com.actas.ems.DTO.TBXuserMenuDTO;
import com.actas.ems.Mapper.Elvlrt.ElvactcdMapper;
import com.actas.ems.Mapper.gaon.ElvactcdGaonMapper;
import com.actas.ems.Mapper.kyoung.ElvactcdKyoungMapper;
import com.actas.ems.Mapper.Hanyangs.hanyangsMapper;
import com.actas.ems.Mapper.master.AuthDBMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.actas.ems.DTO.UserFormDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service("AuthService")
public class AuthService {
    @Autowired
    AuthDBMapper authMapper;

    @Autowired
    ElvactcdMapper elvactcdMapper;
    @Autowired
    ElvactcdGaonMapper elvactcdMapperG;
    @Autowired
    ElvactcdKyoungMapper elvactcdMapperK;
    @Autowired
    ElvactcdMapper elvactcdMapperN;
    @Autowired
    ElvactcdMapper elvactcdMapperH;

    @Autowired
    hanyangsMapper hanyangsMapper;

    int queryResult = 1;

    public void authInsert(UserFormDto parm){authMapper.TBXUSERS_Insert(parm);}
    public UserFormDto GetUserInfo(UserFormDto parm){return authMapper.GetUserInfo(parm);}
    public UserFormDto GetCustInfo(UserFormDto parm){return authMapper.GetUserInfo(parm);}
    public UserFormDto GetAdminInfo(UserFormDto parm){return authMapper.GetAdminInfo(parm);}
    public List<UserFormDto> GetUserListDto(UserFormDto parm){return authMapper.GetUserListDto(parm);}
    public List<TBXLoginDTO> GetLogListDto(UserFormDto parm){return authMapper.GetLogListDto(parm);}
    public List<TBXuserMenuDTO> GetXusersMenuList(TBXuserMenuDTO parm){return authMapper.GetXusersMenuList(parm);}
    public List<TBXuserMenuDTO> GetXMenuList(TBXuserMenuDTO parm){return authMapper.GetXMenuList(parm);}


    public UserFormDto GetUserInfoDto(UserFormDto parm){return authMapper.GetUserInfoDto(parm);}
    public UserFormDto GetUserInfoDto2(UserFormDto parm){return authMapper.GetUserInfoDto2(parm);}

    public String GetClientInfo(UserFormDto parm){return authMapper.GetClientInfo(parm);}
    public String GetClientInfoName(UserFormDto parm){return authMapper.GetClientInfoName(parm);}

    public void UpdateDbInfo(UserFormDto parm){authMapper.UpdateDbInfo(parm);}

    public String TB_XUSER_DUPCHK(UserFormDto parm){
        return authMapper.TB_XUSER_DUPCHK(parm);
    }

    public String TB_XUSER_PHDUPCHK(UserFormDto parm){
        return authMapper.TB_XUSER_PHDUPCHK(parm);
    }
    public String TB_XCLIENT_SELECT(UserFormDto parm){
        return authMapper.TB_XCLIENT_SELECT(parm);
    }

    public void TB_XLOGIN_INSERT(UserFormDto parm) { authMapper.TB_XLOGIN_INSERT(parm);}
    public void TB_XLOGOUT_INSERT(UserFormDto parm) { authMapper.TB_XLOGOUT_INSERT(parm);}

    public void TB_XUSERS_LOGFAIL(UserFormDto parm) { authMapper.TB_XUSERS_LOGFAIL(parm);}

    public void TB_XUSERS_LOGSUCC(UserFormDto parm) { authMapper.TB_XUSERS_LOGSUCC(parm);}

    public String TB_XCLIENT_ACTCD_SELECT(UserFormDto parm) {

        String dbnm = parm.getDbnm();
        switch (dbnm){
            case "ELV_LRT":
                return elvactcdMapper.TB_XCLIENT_ACTCD_SELECT(parm);

            case "ELV_GAON":
                return elvactcdMapperG.TB_XCLIENT_ACTCD_SELECT(parm);

            case "nmyang":
                return elvactcdMapperN.TB_XCLIENT_ACTCD_SELECT(parm);

            case "ELV_KYOUNG":
                return elvactcdMapperK.TB_XCLIENT_ACTCD_SELECT(parm);
            case "hanyangs":
                return elvactcdMapperH.TB_XCLIENT_ACTCD_SELECT(parm);
            //return hanyangsMapper.TB_XCLIENT_ACTCD_SELECT(parm);
            default:
                return "";

        }
        //return hanyangsMapper.TB_XCLIENT_ACTCD_SELECT(parm);
    }

    public String TB_XUSER_DBNM(UserFormDto parm) {return authMapper.TB_XUSER_DBNM(parm);}

    public void TB_XUSER_UPDATE(UserFormDto dto) {authMapper.TB_XUSER_UPDATE(dto);}



    //사용자사용여부
    @Transactional
    public boolean UpdateUserInfo(UserFormDto parm){
        int queryResult = 1;
        queryResult = authMapper.UpdateUserInfo(parm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

    //사용자 메뉴사용여부
    @Transactional
    public boolean UpdateUserMenuInfo(TBXuserMenuDTO parm){
        int queryResult = 1;
        queryResult = authMapper.UpdateUserMenuInfo(parm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }

//    pushid
    @Transactional
    public boolean Updatepushid(UserFormDto parm){
        int queryResult = 1;
        queryResult = authMapper.Updatepushid(parm);
        if(queryResult < 1){
            queryResult = 0;
        }
        return (queryResult > 0);
    }



}
