package com.actas.ems.controller.app05;

import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App05ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/app05")
@Controller
@RequiredArgsConstructor
public class App05Controller {
    private final App05ElvlrtService service;
    UserFormDto userformDto = new UserFormDto();

    @GetMapping(value="/mnotice")
    public String noticeList(/** @RequestParam("actuseridz") String userid
                           , */@RequestParam(value = "actusernamez", required = false) String username
                           , /**@RequestParam("actcltcdz") String cltcd
                           , */@RequestParam(value = "actdbnmz", required = false) String dbnm
                           , /**@RequestParam("actflagz") String flag
                           , @RequestParam("actcalluseridz") String calluserid
                           , @RequestParam("actcalluserpwz") String calluserpw
                                  */
                            @RequestParam(value = "searchType", required = false) String searchType
                            ,@RequestParam(value = "Keyword", required = false) String Keyword
                            ,Model model ){
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
        try{
            List<App05ElvlrtDto> noticeList = service.GetNoticeList(searchType, Keyword);

            model.addAttribute("list", noticeList);
            model.addAttribute("username", username);
            model.addAttribute("dbnm", dbnm);

        }catch(Exception e){
            System.out.println(e);
        }finally{
            return "noticelist";
        }

    }

    @GetMapping(value="/mnoticeWrite")
    public String noticeWrite(@RequestParam(value = "username", required = false) String username
                             ,@RequestParam(value = "dbnm", required = false) String dbnm
                             ,Model model){
        try{
            model.addAttribute("username", username);
            model.addAttribute("dbnm", dbnm);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            return "noticewrite";
        }

    }

    @GetMapping(value="/mnoticeView")
    public String noticeView(@RequestParam(value = "dbnm", required = false) String dbnm
                             ,@RequestParam(value = "username", required = false) String username
                             ,@RequestParam(value = "nseq") String nseq
                             ,Model model){
        try {
            App05ElvlrtDto dto = service.GetNoticeView(nseq);

            model.addAttribute("view", dto);
            model.addAttribute("username", username);
            model.addAttribute("dbnm", dbnm);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            return "noticeview";
        }
    }

    @RequestMapping(value="/mnoticeRegist", method = RequestMethod.POST)
    public String noticeRegist(@RequestParam("username") String custcd,
                             @RequestParam("dbnm") String spjangcd,
                             @RequestParam("nsubject") String subject,
                             @RequestParam("nmemo") String memo,
                               Model model){
        try {
            String max = service.getMaxSeq();
            String today = service.getDate();

            App05ElvlrtDto dto = new App05ElvlrtDto();

            dto.setCustcd(custcd);
            dto.setSpjangcd(spjangcd);
            dto.setNsubject(subject);
            dto.setNmemo(memo);
            dto.setDate(today);

            if(max.equals(today)){
                String seq = service.SeqNext();
                if(Integer.parseInt(seq)<10){
                    seq = 0 + seq;
                }
                dto.setNseq(max+seq);
            }else{
                service.ResetSeq();

                String seq = service.SeqNext();
                if(Integer.parseInt(seq)<10){
                    seq = 0 + seq;
                }
                dto.setNseq(today+seq);
            }

            service.InsertNotice(dto);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            return noticeList(null, null, null, null, model);
        }
    }

    @GetMapping(value="/mnoticeUpdate")
    public String noticeUpdate(@RequestParam("nseq") String nseq
                               , Model model){
        try {
            App05ElvlrtDto dto = service.GetNoticeView(nseq);

            model.addAttribute("view", dto);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            return "/noticeupdate";
        }
    }

    @RequestMapping(value="/mnoticeUpdateRegist", method = RequestMethod.POST)
    public String noticeUpdateRegist(@RequestParam(value = "username", required = false) String username,
                                     @RequestParam(value = "dbnm", required = false) String dbnm,
                                     @RequestParam("nseq") String nseq,
                                     @RequestParam("custcd") String custcd,
                                     @RequestParam("spjangcd") String spjangcd,
                                     @RequestParam("nsubject") String subject,
                                     @RequestParam("nmemo") String memo,
                                     Model model){

        App05ElvlrtDto dto = new App05ElvlrtDto();

        try {
            dto.setNseq(nseq);
            dto.setCustcd(custcd);
            dto.setSpjangcd(spjangcd);
            dto.setNsubject(subject);
            dto.setNmemo(memo);

            service.UpdateNotice(dto);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            return noticeView(username, dbnm, nseq, model);
        }
    }

    @GetMapping(value="/mnoticeDelete")
    public String noticeDelete(@RequestParam("nseq") String nseq,
                               Model model){
        try {
            service.DeleteNotice(nseq);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            return noticeList(null, null, null, null, model);
        }
    }

    public String getDate(){
        return service.getDate();
    }






}
