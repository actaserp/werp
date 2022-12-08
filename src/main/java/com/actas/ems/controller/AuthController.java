package com.actas.ems.controller;

import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/auth")
@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final App01ElvlrtService app01ElvlrtService;
    UserFormDto userformDto = new UserFormDto();
    App01ElvlrtDto app01ElvlrtDto = new App01ElvlrtDto();

    // 보수업체 유지보수 회원가입
    @GetMapping(value="/cltcdnew")
    public String memberForm(Model model){
        userformDto.setFlag("AA");
        model.addAttribute("userFormDto", userformDto);
        return "register";
    }

    // 고객 유지보수 회원가입
    @GetMapping(value="/actcdnew")
    public String memberActcdForm(Model model){
        userformDto.setFlag("CC");
        model.addAttribute("userFormDto", userformDto);
        return "registeractcd";
    }


    // 보수업체 대시보드
    @GetMapping(value="/emmsdashboard")
    public String memberEmmsBoardForm(@RequestParam("userid") String userid
                                    , Model model
                                    , HttpServletRequest request){
        userformDto.setUserid(userid);
        userformDto =  authService.GetUserInfoDto(userformDto);

        String ls_flag = userformDto.getFlag();
        String dbnm = userformDto.getDbnm();
        String ls_custcd = "";
        String ls_spjangcd = "";
        App01ElvlrtDto app01data =  app01ElvlrtService.GetCallXenv(app01ElvlrtDto);
        userformDto.setCallflag(app01data.getCallflag());
        userformDto.setCalluserid(app01data.getCalluserid());
        userformDto.setCalluserpw(app01data.getCalluserpw());

        switch (dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                break;
            case "ELV_KYOUNG":
                ls_custcd = "KYOUNG";
                break;
            case "hanyangs":
                ls_custcd = "hanyangs";
                break;
            default:
                break;

        }
        ls_spjangcd = "ZZ";
        userformDto.setCustcd(ls_custcd);
        userformDto.setSpjangcd(ls_spjangcd);
        HttpSession session = request.getSession();
        session.setAttribute("userformDto",userformDto);

        model.addAttribute("userFormDto", userformDto);
        if (ls_flag.equals("AA")){
            return "mainframe";
        }else{
            return "mainframcustom";
        }
    }

}
