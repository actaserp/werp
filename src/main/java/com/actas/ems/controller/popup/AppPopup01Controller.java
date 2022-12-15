package com.actas.ems.controller.popup;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.elvlrt.AppPopElvlrtService;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pop01", method = RequestMethod.POST)
public class AppPopup01Controller {
    private final AuthService authService;
    private final AppPopElvlrtService appPopElvlrtService;
    UserFormDto userformDto = new UserFormDto();
    PopupDto popParmDto = new PopupDto();

    List<PopupDto> poplistDto = new ArrayList<>();
    //  현장조회
    @RequestMapping(value="/wactnm")
    public Object AppActnmList(@RequestParam("actnmz") String actnm
                           , @RequestParam("conflag") String conflag
                           , Model model){
        if(actnm.length() == 0){
            actnm = "%";
        }
        try {
            popParmDto.setActnm(actnm);
            popParmDto.setCltnm("%");
            popParmDto.setContflag(conflag);
            poplistDto = appPopElvlrtService.GetActnmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

    //  고장내용조회
    @RequestMapping(value="/wcontnm")
    public Object AppContnmList(@RequestParam("contnmz") String contnm
            , Model model){
        if(contnm.length() == 0){
            contnm = "%";
        }
        try {
            popParmDto.setContnm(contnm);
            poplistDto = appPopElvlrtService.GetContnmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

}
