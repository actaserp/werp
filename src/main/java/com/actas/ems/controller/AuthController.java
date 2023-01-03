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
    UserFormDto userformDto = new UserFormDto();

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
    public String memberEmmsBoardForm( Model model
                                    , HttpServletRequest request){

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

        String ls_flag = userformDto.getFlag();


        model.addAttribute("userFormDto", userformDto);
        if (ls_flag.equals("AA")){
            return "mainframe";
        }else{
            return "mainframcustom";
        }
    }

}
