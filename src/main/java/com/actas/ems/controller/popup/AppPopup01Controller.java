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

    //  고장요인조회
    @RequestMapping(value="/wremonm")
    public Object AppremonmList(@RequestParam("remonmz") String remonm
            , Model model){
        if(remonm.length() == 0){
            remonm = "%";
        }
        try {
            popParmDto.setRemonm(remonm);
            poplistDto = appPopElvlrtService.GetRemonmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

    //  처리내용조회
    @RequestMapping(value="/wresunm")
    public Object AppresunmList(@RequestParam("resunmz") String resunm
            , Model model){
        if(resunm.length() == 0){
            resunm = "%";
        }
        try {
            popParmDto.setResunm(resunm);
            poplistDto = appPopElvlrtService.GetResunmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

    //  고장부위조회
    @RequestMapping(value="/wgreginm")
    public Object AppgreginmList(@RequestParam("greginmz") String greginm
            , Model model){
        if(greginm.length() == 0){
            greginm = "%";
        }
        try {
            popParmDto.setGreginm(greginm);
            poplistDto = appPopElvlrtService.GetGreginmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

    //  처리방법조회
    @RequestMapping(value="/wresultnm")
    public Object AppresultnmList(@RequestParam("resultnmz") String resultnm
            , Model model){
        if(resultnm.length() == 0){
            resultnm = "%";
        }
        try {
            popParmDto.setResultnm(resultnm);
            poplistDto = appPopElvlrtService.GetResultnmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

}
