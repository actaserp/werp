package com.actas.ems.controller;

import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.reflect.Field;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/authcrud", method = RequestMethod.POST)
public class AuthCrudController {
    private final AuthService authService;
    UserFormDto userformDto = new UserFormDto();




    @RequestMapping(value="/save")
    public String memberSave(@RequestParam("saupnum") String saupnum
            , @RequestParam("userid") String userid
            , @RequestParam("username") String username
            , @RequestParam("flag") String flag
            , @RequestParam("passwd1") String passwd1
            , @RequestParam("passwd2") String passwd2
            , @RequestParam("phone") String phone
            , @RequestParam("actcd") String actcd
            , @RequestParam("actnm") String actnm
            , Model model,   HttpServletRequest request){

        try {
            userformDto.setCustcd("actas");
            userformDto.setSpjangcd("ZZ");
            userformDto.setUseyn("1");
            userformDto.setRnum("0");
            userformDto.setFlag(flag);
            userformDto.setSaupnum(saupnum);
            userformDto.setUsername(username);
            userformDto.setUserid(userid);
            userformDto.setPasswd1(passwd1);
            userformDto.setPasswd2(passwd2);
            userformDto.setPhone(phone);

            String ls_cltnmInfo = authService.GetClientInfo(userformDto);
            userformDto.setCltcd(ls_cltnmInfo);
            userformDto.setActcd(ls_cltnmInfo);
            String ls_cltnmInfoName = authService.GetClientInfoName(userformDto);
            userformDto.setActnm(ls_cltnmInfoName);

            switch (ls_cltnmInfo){
                case "100534":      //한국엘레텍
                    userformDto.setDbnm("ELV_LRT");
                    break;
                case "100542":      //한국엘레텍
                    userformDto.setDbnm("hanyangs");
                    break;
                default:
                    break;
            }
            authService.authInsert(userformDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }
        return "success";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object memberLoginForm(@RequestParam("loginid") String loginid
            , @RequestParam("logpass") String logpass
            , Model model
            , HttpServletRequest request) throws Exception{
        userformDto.setUserid(loginid);
        userformDto.setPasswd1(logpass);

        UserFormDto userReturnDto = authService.GetUserInfo(userformDto);

        String ls_dbnm = userReturnDto.getDbnm();
        model.addAttribute("UserInfo", userReturnDto );
        switch (ls_dbnm){
            case "ELV_LRT":      //한국엘레텍
                break;
            default:
                break;
        }
        return userReturnDto;
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

}
