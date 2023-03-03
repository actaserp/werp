package com.actas.ems.controller.appadmin;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.TBXLoginDTO;
import com.actas.ems.DTO.TBXa012VO;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.elvlrt.App04ElvlrtService;
import com.actas.ems.Service.elvlrt.AppPopElvlrtService;
import com.actas.ems.Service.master.AuthService;
import com.actas.ems.controller.SessionManager;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RequestMapping(value = "/admin", method = RequestMethod.POST)
@Controller
@RequiredArgsConstructor
public class AppIndexController {
    private final AuthService service;
    private final AppPopElvlrtService servicePop;
    private final App01ElvlrtService app01ElvlrtService;
    App01ElvlrtDto app01ElvlrtDto = new App01ElvlrtDto();
    List<UserFormDto> appUserFormListDto ;
    List<TBXLoginDTO> appUserLoginListDto ;
    UserFormDto appUserFormDto  = new UserFormDto();
    TBXa012VO appXa012Dto  = new TBXa012VO();
    PopupDto  appPopDto  = new PopupDto();


    protected Log log =  LogFactory.getLog(this.getClass());

    // 사용자관리 index
    @GetMapping(value="/index01")
    public String AppIndex01Form(Model model, HttpServletRequest request) throws  Exception{

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        appUserFormDto.setFlag("AA");
        appUserFormDto.setUsername("%");
        appUserFormDto.setCustcd(userformDto.getCustcd());
        appUserFormDto.setUsername("%");
        appUserFormListDto = service.GetUserListDto(appUserFormDto);
        userformDto.setPagetree01("관리자모드");
        userformDto.setPagenm("사용자현황");
        model.addAttribute("userformDto",userformDto);
        try {
            model.addAttribute("appUserListDto",appUserFormListDto);
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }
        return "appadmin/appindex01";
    }


    // 사용자관리 index
    @GetMapping(value="/index02")
    public String AppIndex02Form(Model model, HttpServletRequest request) throws  Exception{

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        appUserFormDto.setFlag("CC");
        appUserFormDto.setUsername("%");
        appUserFormDto.setCustcd(userformDto.getCustcd());
        appUserFormDto.setUserid("%");
        appUserFormListDto = service.GetUserListDto(appUserFormDto);
        userformDto.setPagetree01("관리자모드");
        userformDto.setPagenm("보수현장현황");
        model.addAttribute("userformDto",userformDto);
        try {
            model.addAttribute("appUserListDto",appUserFormListDto);
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }
        return "appadmin/appindex02";
    }


    // 사용자로그 index
    @GetMapping(value="/index03")
    public String AppIndex03Form(Model model, HttpServletRequest request) throws  Exception{

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        appUserFormDto.setUserid("%");
        appUserFormDto.setCustnm(userformDto.getCustnm());
        appUserLoginListDto = service.GetLogListDto(appUserFormDto);
        userformDto.setPagetree01("관리자모드");
        userformDto.setPagenm("사용자로그");
        model.addAttribute("userformDto",userformDto);
        try {
            model.addAttribute("appUserListDto",appUserLoginListDto);
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }
        return "appadmin/appindex03";
    }



    // 사업장정보 index
    @GetMapping(value="/index04")
    public String AppIndex04Form(Model model, HttpServletRequest request) throws  Exception{

        appXa012Dto = servicePop.GetXa012Info(appPopDto);

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        appUserFormDto.setUserid("%");
        userformDto.setPagetree01("관리자모드");
        userformDto.setPagenm("사업장정보");
        try {
            model.addAttribute("appXa012Dto",appXa012Dto);
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }
        return "appadmin/appindex04";
    }


    // 콜 api 정보 index
    @GetMapping(value="/index05")
    public String AppIndex05Form(Model model, HttpServletRequest request) throws  Exception{

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        userformDto.setPagetree01("관리자모드");
        userformDto.setPagenm("통신사 API 정보");
        App01ElvlrtDto app01data =  app01ElvlrtService.GetCallXenv(app01ElvlrtDto);
        try {
            model.addAttribute("userformDto",userformDto);
            model.addAttribute("app01data",app01data);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }
        return "appadmin/appindex05";
    }

}
