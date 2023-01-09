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

    //  고장원인조회
    @RequestMapping(value="/wfacnm")
    public Object AppfacnmList(@RequestParam("facnmz") String facnm
            , Model model){
        if(facnm.length() == 0){
            facnm = "%";
        }
        try {
            popParmDto.setFacnm(facnm);
            poplistDto = appPopElvlrtService.GetFacnmList(popParmDto);
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

    //  고장부위상세
    @RequestMapping(value="/wreginm")
    public Object AppreginmList(@RequestParam("reginmz") String reginm
            , Model model){
        if(reginm.length() == 0){
            reginm = "%";
        }
        try {
            popParmDto.setReginm(reginm);
            poplistDto = appPopElvlrtService.GetReginmList(popParmDto);
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

    @RequestMapping(value="/wdivinm")
    public Object AppdivinmList(@RequestParam("actdivinmz") String divinm
            , Model model){
        if(divinm.length() == 0){
            divinm = "%";
        }
        try {
            popParmDto.setDivinm(divinm);
            poplistDto = appPopElvlrtService.GetDivinmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

    @RequestMapping(value="/wpernm")
    public Object ApppernmList(@RequestParam("actpernmz") String pernm
            , Model model){
        if(pernm.length() == 0){
            pernm = "%";
        }
        try {
            popParmDto.setPernm(pernm);
            poplistDto = appPopElvlrtService.GetPernmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

    //처리자
    @RequestMapping(value="/wpernm2")
    public Object Apppernm2List(@RequestParam("pernmz") String pernm
            , Model model){
        if(pernm.length() == 0){
            pernm = "%";
        }
        try {
            popParmDto.setPernm(pernm);
            poplistDto = appPopElvlrtService.GetPernm3List(popParmDto);
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
            /*log.info(poplistDto);
            log.info(userformDto.getActcd() + "1212");*/


        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }

    //담당자
    @RequestMapping(value="/wactpernm")
    public Object AppactpernmList(@RequestParam("actpernmz") String actpernm
            , Model model){
        if(actpernm.length() == 0){
            actpernm = "%";
        }
        try {
            popParmDto.setActpernm(actpernm);
            poplistDto = appPopElvlrtService.GetPernm2List(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }





}
