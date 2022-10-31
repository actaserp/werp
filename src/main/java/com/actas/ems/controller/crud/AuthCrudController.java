package com.actas.ems.controller.crud;

import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/authcrud", method = RequestMethod.POST)
public class AuthCrudController {
    private final AuthService authService;
    UserFormDto userformDto = new UserFormDto();


    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String memberSave(@RequestParam("saupnum") String saupnum
            , @RequestParam("userid") String userid
            , @RequestParam("username") String username
            , @RequestParam("flag") String flag
            , @RequestParam("passwd1") String passwd1
            , @RequestParam("passwd2") String passwd2
            , @RequestParam("phone") String phone
            , Model model, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "register";
        }
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

            authService.authInsert(userformDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }
        return "success";
    }
}
