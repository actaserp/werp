package com.actas.ems.controller.app01;

import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/app01")
@Controller
@RequiredArgsConstructor
public class App01Controller {
    private final AuthService authService;
    private final App01ElvlrtService app01ElvlrtService;
    UserFormDto userformDto = new UserFormDto();
    App01ElvlrtDto app01ElvlrtDto = new App01ElvlrtDto();

    // kt call dashboard
    @GetMapping(value="/ktcall")
    public String App01Form(@RequestParam("actuseridz") String userid
                           , @RequestParam("actusernamez") String username
                           , @RequestParam("actcltcdz") String cltcd
                           , @RequestParam("actdbnmz") String dbnm
                           , @RequestParam("actflagz") String flag
                           , @RequestParam("actcalluseridz") String calluserid
                           , @RequestParam("actcalluserpwz") String calluserpw
                           , Model model){
        userformDto.setUserid(userid);
        userformDto.setUsername(username);
        userformDto.setCltcd(cltcd);
        userformDto.setDbnm(dbnm);
        userformDto.setFlag(flag);
        userformDto.setCalluserid(calluserid);
        userformDto.setCalluserpw(calluserpw);

        model.addAttribute("userFormDto", userformDto);
        return "app01/KtcallMain";
    }



}