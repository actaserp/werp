package com.actas.ems.controller.popup;

import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.AppPopElvlrtService;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    protected Log log = LogFactory.getLog(this.getClass());
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

    @RequestMapping(value = "/wequpnm")
    public Object AppEqupnmList(Model model, HttpServletRequest request, @RequestParam("equpnmz") String equpnm){
            if(equpnm.length() == 0){
                equpnm = "%";
            }
        try{

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            model.addAttribute("userformDto", userformDto);

            popParmDto.setActcd(userformDto.getActcd());
            popParmDto.setEqupnm(equpnm);
            poplistDto = appPopElvlrtService.GetEqupList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
            log.info(poplistDto);
            log.info(userformDto.getActcd() + "1212");


        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }



    //  고장내용조회
    @RequestMapping(value="/wgreginm")
    public Object AppgreginmList(@RequestParam("greginmz") String greginm
            , Model model){
        if(greginm.length() == 0){
            greginm = "%";
        }
        try {
            popParmDto.setGreginm(greginm);
            poplistDto = appPopElvlrtService.GetGreGicdList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

    //  고장원인조회
    @RequestMapping(value="/wremonm")
    public Object AppremonmList(@RequestParam("remonmz") String remonm
            , Model model){
        if(remonm.length() == 0){
            remonm = "%";
        }
        try {
            popParmDto.setRemonm(remonm);
            poplistDto = appPopElvlrtService.GetremoList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

    @RequestMapping(value="/wresunm")
    public Object AppresunmList(@RequestParam("resunmz") String resunm
            , Model model){
        if(resunm.length() == 0){
            resunm = "%";
        }
        try {
            popParmDto.setResunm(resunm);
            poplistDto = appPopElvlrtService.GetresunmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

}
