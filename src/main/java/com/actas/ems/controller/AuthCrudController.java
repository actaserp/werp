package com.actas.ems.controller;

import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.TBXuserMenuDTO;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/authcrud", method = RequestMethod.POST)
public class AuthCrudController {
    private final AuthService authService;
    private final App01ElvlrtService app01ElvlrtService;
    UserFormDto userformDto = new UserFormDto();
    TBXuserMenuDTO xusermenuDto = new TBXuserMenuDTO();
    List<TBXuserMenuDTO> xusermenuListDto = new ArrayList<>();

    App01ElvlrtDto app01ElvlrtDto = new App01ElvlrtDto();

    EncryptionController enc = new EncryptionController();



    protected Log log =  LogFactory.getLog(this.getClass());



    @RequestMapping(value="/save")
    public String memberSave(@RequestParam("saupnum") String saupnum
            , @RequestParam("userid") String userid
            , @RequestParam("username") String username
            , @RequestParam("flag") String flag
            , @RequestParam("passwd1") String passwd1
            , @RequestParam("passwd2") String passwd2
            , @RequestParam("phone") String phone
            , @RequestParam("actcd") String actcd
            , Model model,   HttpServletRequest request){

        try {
            userformDto.setCustcd("actas");
            userformDto.setSpjangcd("ZZ");
            userformDto.setUseyn("Y");
            userformDto.setRnum("0");
            userformDto.setFlag(flag);
            userformDto.setSaupnum(saupnum);
            userformDto.setUsername(username);
            userformDto.setUserid(userid);
            userformDto.setPasswd1(passwd1);
            userformDto.setPasswd2(passwd2);
            userformDto.setPhone(phone);


            SecretKey key = enc.getKey();
            IvParameterSpec ivParameterSpec = enc.getIv();
            String specName = "AES/CBC/PKCS5Padding";

            String ecdepw = enc.encrypt(specName, key, ivParameterSpec, userformDto.getPasswd1());

            userformDto.setEncodepw(ecdepw);

            String ls_cltnmInfo = authService.GetClientInfo(userformDto);
            userformDto.setCltcd(ls_cltnmInfo);
            userformDto.setActcd(actcd);
            /*userformDto.setActcd(ls_cltnmInfo);
            */
            String ls_cltnmInfoName = authService.TB_XCLIENT_ACTCD_SELECT(userformDto);
            userformDto.setActnm(ls_cltnmInfoName);

            switch (ls_cltnmInfo){
                case "100534":      //한국엘레텍
                    userformDto.setDbnm("ELV_LRT");
                    break;
                case "100542":      //한양엘리베이터
                    userformDto.setDbnm("hanyangs");
                    break;
                default:
                    break;
            }
            authService.authInsert(userformDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "success";
    }


    @RequestMapping(value="/update")
    public void memberUpdate(
            @RequestParam("passwd1") String passwd1,
             @RequestParam("passwd2") String passwd2,
             @RequestParam("phone") String phone,
             @RequestParam("userid") String userid,
             @RequestParam("username") String username,

             Model model,   HttpServletRequest request){

        HttpSession session = request.getSession();
        UserFormDto userformDtoS = (UserFormDto) session.getAttribute("userformDto");

        userformDto.setPasswd1(passwd1);
        userformDto.setPasswd2(passwd2);
        userformDto.setPhone(phone);
        userformDto.setUsername(username);
        userformDto.setUserid(userid);
        userformDto.setCustcd(userformDtoS.getCustcd());
        userformDto.setFlag(userformDtoS.getFlag());

         authService.TB_XUSER_UPDATE(userformDto);

        model.addAttribute("userformDto", userformDto);



    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object memberLoginForm(@RequestParam("loginid") String loginid
            , @RequestParam("logpass") String logpass
            , @RequestParam("flag") String select
            , Model model
            , HttpServletRequest request) throws Exception{
        userformDto.setUserid(loginid);
        userformDto.setPasswd1(logpass);
        userformDto.setFlag(select);
        UserFormDto userReturnDto = authService.GetUserInfo(userformDto);

        if(userReturnDto.getWrongnum().equals("3")){
            return userReturnDto;
        }

        authService.TB_XUSERS_LOGSUCC(userReturnDto);

        String ls_dbnm = userReturnDto.getDbnm();
        model.addAttribute("UserInfo", userReturnDto );
        userformDto.setUserid(loginid);
        userformDto.setFlag(select);
        userformDto =  authService.GetUserInfoDto(userformDto);

        HttpSession session = request.getSession();
        session.setAttribute("userformDto",userformDto);

        App01ElvlrtDto app01data =  app01ElvlrtService.GetCallXenv(app01ElvlrtDto);
//        System.out.println(app01data.getCallflag());
//        System.out.println(app01data.getCalluserid());
//        System.out.println(app01data.getCalluserpw());
        if(app01data.getCallflag() != null){
            userformDto.setCallflag(app01data.getCallflag());
            userformDto.setCalluserid(app01data.getCalluserid());
            userformDto.setCalluserpw(app01data.getCalluserpw());
        }

        String dbnm = userformDto.getDbnm();
        String ls_custcd = "";
        String ls_spjangcd = "";

        switch (dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                break;
            case "ELV_KYOUNG":
                ls_custcd = "KYOUNG";
                break;
            case "ELV_GAON":
                ls_custcd = "GAON";
                break;
            case "nmyang":
                ls_custcd = "nmyang";
                break;
            case "hanyangs":
                ls_custcd = "hanyangs";
                break;
            default:
                break;

        }
        ls_spjangcd = "ZZ";
        if(userformDto.getCustcd().length() == 0 || userformDto.getCustcd().equals("")){
            userformDto.setCustcd(ls_custcd);
        }
        userformDto.setSpjangcd(ls_spjangcd);

//        model.addAttribute("custReturnDto", custReturnDto);

        if(select.equals(userformDto.getFlag()) == false){
            userReturnDto = null;
            return userReturnDto;
        }else {


            return userReturnDto;
        }
    }

    @RequestMapping(value = "/adminchk", method = RequestMethod.POST)
    public Object memberLoginAdminForm(@RequestParam("loginid") String loginid
            , @RequestParam("logpass") String logpass
            , @RequestParam("flag") String select
            , Model model
            , HttpServletRequest request) throws Exception{
        userformDto.setUserid(loginid);
        userformDto.setPasswd1(logpass);
        userformDto.setFlag("ZZ");
        userformDto.setCustcd(select);
        UserFormDto userReturnDto = authService.GetAdminInfo(userformDto);
//        UserFormDto custReturnDto = authService.GetCustInfo(userformDto);

        if(userReturnDto.getWrongnum().equals("3")){
            return userReturnDto;
        }

        authService.TB_XUSERS_LOGSUCC(userReturnDto);
        model.addAttribute("UserInfo", userReturnDto );

        HttpSession session = request.getSession();
        session.setAttribute("userformDto",userReturnDto);
        if(!userformDto.getFlag().equals("ZZ")){
            userReturnDto = null;
            return userReturnDto;
        }else {


            return userReturnDto;
        }
    }

    @RequestMapping(value = "/useriddupchk", method = RequestMethod.POST)
    public Object AppW016_index(@RequestParam("userid") String userid
            ,Model model, HttpServletRequest request) throws Exception{

        userformDto.setUserid(userid);

        authService.TB_XUSER_DUPCHK(userformDto);
        String ls_userid = authService.TB_XUSER_DUPCHK(userformDto);
        if(ls_userid == null || ls_userid.equals("")){

            return ls_userid;
        }else{
            ls_userid = "error";
            return ls_userid;
        }
    }

    @RequestMapping(value = "/userphdupchk", method = RequestMethod.POST)
    public Object AppW014_index(@RequestParam("phone") String phone, Model model, HttpServletRequest request) throws Exception{

        userformDto.setPhone(phone);

        authService.TB_XUSER_PHDUPCHK(userformDto);
        String ls_userphone = authService.TB_XUSER_PHDUPCHK(userformDto);
        if(ls_userphone == null || ls_userphone.equals("")){
            return ls_userphone;
        }else{
            ls_userphone = "error";
            return ls_userphone;
        }
    }

    @RequestMapping(value = "/searchnum", method = RequestMethod.POST)
    public Object AppW015_index(@RequestParam("saupnum") String saupnum,
                                Model model, HttpServletRequest request)throws  Exception{
            userformDto.setSaupnum(saupnum);

            authService.TB_XCLIENT_SELECT(userformDto);
            String ls_cltnm = authService.TB_XCLIENT_SELECT(userformDto);
            if(ls_cltnm == null || ls_cltnm.equals("")){
                ls_cltnm = "error";
            }
            return ls_cltnm;
    }

    @RequestMapping(value = "/loginlog", method = RequestMethod.POST)
    public void Login_Log(@RequestParam("loginid") String loginid
            , @RequestParam("logpass") String logpass
            , @RequestParam("ipaddr") String ipaddr
            , HttpServletRequest request     )throws Exception {
            System.out.printf("--loginlog 진입");

            UserFormDto user = new UserFormDto();
            HttpSession session = request.getSession();
            UserFormDto userformDtoS = (UserFormDto) session.getAttribute("userformDto");

            user.setUserid(userformDtoS.getUserid());
            user.setPasswd1(userformDtoS.getPasswd1());
            user.setIpaddr(ipaddr);
            user.setCustnm(userformDtoS.getCustnm());
            user.setUsername(userformDtoS.getUsername());

            authService.TB_XLOGIN_INSERT(user);

    }


    @RequestMapping(value = "/logoutlog", method = RequestMethod.POST)
    public void Logout_Log(@RequestParam("loginid") String loginid
            , HttpServletRequest request )throws Exception {


        UserFormDto user = new UserFormDto();

        HttpSession session = request.getSession();
        UserFormDto userformDtoS = (UserFormDto) session.getAttribute("userformDto");

        user.setUserid(userformDtoS.getUserid());
        user.setPasswd1(userformDtoS.getPasswd1());
        user.setUsername(userformDtoS.getUsername());
        user.setCustnm(userformDtoS.getCustnm());
        user.setIpaddr("");

        authService.TB_XLOGOUT_INSERT(user);

    }

    @RequestMapping(value = "/wrongpasswd", method = RequestMethod.POST)
    public Object Login_fail(@RequestParam("loginid") String loginid
                             , @RequestParam("logpass") String logpass, Model model)throws Exception {
            System.out.printf("--loginfail 진입");

            UserFormDto user = new UserFormDto();

            user.setUserid(loginid);
            user.setPasswd1(logpass);


            user = authService.GetUserInfoDto(user);
            if(user == null){
                return "null";
            }
            if(user.getWrongnum().equals("3")){

            } else{
                authService.TB_XUSERS_LOGFAIL(user);
                user = authService.GetUserInfo(user);
            }



            return user;

    }


    @RequestMapping(value = "/menulist", method = RequestMethod.POST)
    public Object Login_fail(@RequestParam("searchtext") String userid
            , Model model
            , HttpServletRequest request )throws Exception {

        HttpSession session = request.getSession();
        UserFormDto userformDtoS = (UserFormDto) session.getAttribute("userformDto");

        xusermenuDto.setCustcd(userformDtoS.getCustcd());
        xusermenuDto.setUserid(userid);
        xusermenuListDto = authService.GetXusersMenuList(xusermenuDto);


        return xusermenuListDto;

    }


    @RequestMapping(value = "/searchnum_actcd", method = RequestMethod.POST)
    public Object TB_XCLIENT_ACTCD_SELECT(@RequestParam("actcd") String actcd, @RequestParam("dbnm") String dbnm,
                                          Model model, HttpServletRequest request)throws Exception{
        userformDto.setActcd(actcd);
        userformDto.setDbnm(dbnm);




        authService.TB_XCLIENT_ACTCD_SELECT(userformDto);




        String ls_actcd_nm = authService.TB_XCLIENT_ACTCD_SELECT(userformDto);

        if(ls_actcd_nm == null || ls_actcd_nm.equals("")){
            ls_actcd_nm = "error";
            log.info("에로사항발생");
        }
        log.info("success");
        return ls_actcd_nm;
    }

    @RequestMapping(value = "/dbnm", method = RequestMethod.POST)
    public Object AppW018_index(@RequestParam("saupnum") String saupnum, Model model, HttpServletRequest request){

        userformDto.setSaupnum(saupnum);

        authService.TB_XUSER_DBNM(userformDto);
        String ls_dbnm = authService.TB_XUSER_DBNM(userformDto);
        if(ls_dbnm == null || ls_dbnm.equals("")){
            ls_dbnm = "error";
        }
        return ls_dbnm;
    }
}
