package com.actas.ems.controller.app05;

import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.elvlrt.App05ElvlrtService;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/app05")
@Controller
@RequiredArgsConstructor
public class App05Controller {
    private final App05ElvlrtService service;
    UserFormDto userformDto = new UserFormDto();

    @GetMapping(value="/mnotice")
    public String noticeList(/** @RequestParam("actuseridz") String userid
                           , @RequestParam("actusernamez") String username
                           , @RequestParam("actcltcdz") String cltcd
                           , @RequestParam("actdbnmz") String dbnm
                           , @RequestParam("actflagz") String flag
                           , @RequestParam("actcalluseridz") String calluserid
                           , @RequestParam("actcalluserpwz") String calluserpw
                                  */ Model model ){
        /**
        userformDto.setUserid(userid);
        userformDto.setUsername(username);
        userformDto.setCltcd(cltcd);
        userformDto.setDbnm(dbnm);
        userformDto.setFlag(flag);
        userformDto.setCalluserid(calluserid);
        userformDto.setCalluserpw(calluserpw);

        model.addAttribute("userFormDto", userformDto);
        */

        List<App05ElvlrtDto> noticeList = service.GetNoticeList();

        model.addAttribute("list", noticeList);

        return "noticelist";
    }

    @GetMapping(value="/mnoticeWrite")
    public String noticeWrite(){
        return "noticewrite";
    }

    @GetMapping(value="/mnoticeView")
    public String noticeView(@RequestParam(value = "nseq") String nseq
                             ,Model model){
        App05ElvlrtDto dto = service.GetNoticeView(nseq);

        model.addAttribute("subject", dto.getNsubject());
        model.addAttribute("memo", dto.getNmemo());
        model.addAttribute("nseq", dto.getNseq());

        return "noticeview";
    }

    @RequestMapping(value="/mnoticeRegist", method = RequestMethod.POST)
    public String noticeRegist(@RequestParam("custcd") String custcd,
                             @RequestParam("spjangcd") String spjangcd,
                             @RequestParam("nsubject") String subject,
                             @RequestParam("nmemo") String memo,
                               Model model){
        App05ElvlrtDto dto = new App05ElvlrtDto();

        dto.setCustcd(custcd);
        dto.setSpjangcd(spjangcd);
        dto.setNsubject(subject);
        dto.setNmemo(memo);

        service.InsertNotice(dto);

        return noticeList(model);
    }

    @GetMapping(value="/mnoticeUpdate")
    public String noticeUpdate(@RequestParam("nseq") String nseq
                               , Model model){
        App05ElvlrtDto dto = service.GetNoticeView(nseq);

        model.addAttribute("nseq", nseq);
        model.addAttribute("subject", dto.getNsubject());
        model.addAttribute("memo", dto.getNmemo());

        return "/noticeupdate";
    }

    @RequestMapping(value="/mnoticeUpdateRegist", method = RequestMethod.POST)
    public String noticeUpdateRegist(@RequestParam("nseq") String nseq,
                                     @RequestParam("custcd") String custcd,
                                     @RequestParam("spjangcd") String spjangcd,
                                     @RequestParam("nsubject") String subject,
                                     @RequestParam("nmemo") String memo,
                                     Model model){
        App05ElvlrtDto dto = new App05ElvlrtDto();

        dto.setNseq(nseq);
        dto.setCustcd(custcd);
        dto.setSpjangcd(spjangcd);
        dto.setNsubject(subject);
        dto.setNmemo(memo);

        service.UpdateNotice(dto);

        return noticeView(nseq, model);
    }

    @GetMapping(value="/mnoticeDelete")
    public String noticeDelete(@RequestParam("nseq") String nseq,
                               Model model){

        service.DeleteNotice(nseq);

        return noticeList(model);
    }






}
