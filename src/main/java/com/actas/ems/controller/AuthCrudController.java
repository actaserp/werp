package com.actas.ems.controller;

import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
            userformDto.setActcd(actcd);
            userformDto.setActnm(actnm);

            authService.authInsert(userformDto);

            String ls_cltnmInfo = authService.GetClientInfo(userformDto);

            switch (ls_cltnmInfo){
                case "100534":      //한국엘레텍
                    userformDto.setDbnm("ELV_LRT");
                    userformDto.setCltcd(ls_cltnmInfo);
                    authService.UpdateDbInfo(userformDto);
                    break;
                default:
                    break;
            }
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

}
