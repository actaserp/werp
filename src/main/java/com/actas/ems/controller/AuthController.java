package com.actas.ems.controller;

import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/auth")
@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    UserFormDto userformDto = new UserFormDto();
    @GetMapping(value="/cltcdnew")
    public String memberForm(Model model){
        userformDto.setFlag("AA");
        model.addAttribute("userFormDto", userformDto);
        return "register";
    }

    @GetMapping(value="/actcdnew")
    public String memberActcdForm(Model model){
        userformDto.setFlag("CC");
        model.addAttribute("userFormDto", userformDto);
        return "registeractcd";
    }


    @GetMapping(value="/emmsdashboard")
    public String memberEmmsBoardForm(@RequestParam("userid") String userid
                                    , @RequestParam("username") String username
                                    , @RequestParam("cltcd") String cltcd
                                    , @RequestParam("dbnm") String dbnm
                                    , @RequestParam("flag") String flag
                                    , Model model){
        userformDto.setUserid(userid);
        userformDto.setUsername(username);
        userformDto.setCltcd(cltcd);
        userformDto.setDbnm(dbnm);
        userformDto.setFlag(flag);
        String ls_flag = flag.toString();
        model.addAttribute("userFormDto", userformDto);
        if (ls_flag.equals("AA")){
            return "mainframe";
        }else{
            return "mainframcustom";
        }
    }



}
