package com.actas.ems.controller;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App15ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.elvlrt.App05ElvlrtService;
import com.actas.ems.Service.elvlrt.App15.App15ElvlrtService;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/auth")
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final App05ElvlrtService service;
    List<App05ElvlrtDto> App05ListDto;

    private final App15ElvlrtService service2;
    App15ElvlrtDto App15Dto = new App15ElvlrtDto();

    List<CommonDto> com750Dto;

    List<App15ElvlrtDto> app15DtoList = new ArrayList<>();
    List<App15ElvlrtDto> app15DtoList2 = new ArrayList<>();
    App05ElvlrtDto App05Dto = new App05ElvlrtDto();

    protected Log log =  LogFactory.getLog(this.getClass());


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

            Date nowData = new Date();
            SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
            String indate = endDate.format(nowData).toString();
            App05Dto.setYyyymm(indate.substring(0,6));
            App05Dto.setNinputdate(indate);

            //공지사항
            /*App05ListDto =*/

            com750Dto = service.GetComm751List();
            model.addAttribute("com750Dto",com750Dto);


//            log.debug("Exception =====>" + App05ListDto );
            model.addAttribute("App05Dto",service.GetMNoticeList(App05Dto));

            //당월점검현황
            app15DtoList = service2.GetApp15List002(App15Dto);
            model.addAttribute("app15DtoList", app15DtoList);

            //당일계약만료현장
            app15DtoList2 = service2.GetApp15List003(App15Dto);
            model.addAttribute("app15DtoList2", app15DtoList2);

            //30일후 계약만료현장
            app15DtoList2 = service2.GetApp15List004(App15Dto);
            model.addAttribute("app15DtoList3", app15DtoList2);

            //
            app15DtoList2 = service2.GetApp15List005(App15Dto);
            model.addAttribute("app15DtoList4", app15DtoList2);

            return "mainframe";
        } else if (userformDto == null) {
            model.addAttribute("msg", "로그인실패");
            return "/";
        } else{
            return "mainframcustom";
        }

    }

}
