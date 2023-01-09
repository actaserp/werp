package com.actas.ems.controller.APP28;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App28ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App28ElvlrtService;
import com.actas.ems.controller.SessionManager;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/app28")
@Controller
@RequiredArgsConstructor
public class App28Controller {

    UserFormDto userformDto = new UserFormDto();
    private final App28ElvlrtService service;
    private final SessionManager sessionManager;
    List<App28ElvlrtDto> App28ListDto;
    List<CommonDto> com750Dto;
    App28ElvlrtDto App28Dto = new App28ElvlrtDto();


    protected Log log =  LogFactory.getLog(this.getClass());

    // 도면자료실 index
    @GetMapping(value="/index01")
    public String App28Form(Model model, HttpServletRequest request) throws  Exception{
//        userformDto.setUserid(userid);
//        userformDto.setUsername(username);
//        userformDto.setCltcd(cltcd);
//        userformDto.setDbnm(dbnm);
//        userformDto.setFlag(flag);
//        userformDto.setCalluserid(calluserid);
//        userformDto.setCalluserpw(calluserpw);
//        userformDto.setCustcd(custcd);
//        userformDto.setSpjangcd(spjangcd);

        Date nowData = new Date();
        SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
        String indate = endDate.format(nowData).toString();
        App28Dto.setYyyymm(indate.substring(0,6));
        App28Dto.setNinputdate(indate);
//        if(bflag == "0"){
//            App28Dto.setMsubject(search);
//        }else{
//            App28Dto.setMemo(search);
//        }
        try {
            App28ListDto = service.GetMNoticeList(App28Dto);
//            log.debug("Exception =====>" + App28ListDto );
            model.addAttribute("App28Dto",App28ListDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }
        try {

            com750Dto = service.GetComm751List();
            model.addAttribute("com750Dto",com750Dto);

        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }

//        log.debug("App28tDto =====>" + App28Dto.toString() );
        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }




        return "app28/app28list";
    }




}
