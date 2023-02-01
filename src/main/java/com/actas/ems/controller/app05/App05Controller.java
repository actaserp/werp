package com.actas.ems.controller.app05;

import com.actas.ems.DTO.Elvlrt.App05ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App05ElvlrtService;
import com.actas.ems.controller.EncryptionController;
import com.actas.ems.controller.SessionManager;
import com.actas.ems.DTO.CommonDto;

import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/app05")
@Controller
@RequiredArgsConstructor
public class App05Controller {

    UserFormDto userformDto = new UserFormDto();
    private final App05ElvlrtService service;
    private final SessionManager sessionManager;
    List<App05ElvlrtDto> App05ListDto;
    List<CommonDto> com750Dto;
    App05ElvlrtDto App05Dto = new App05ElvlrtDto();


    protected Log log =  LogFactory.getLog(this.getClass());

    // 도면자료실 index
    @GetMapping(value="/index01")
    public String App05Form(Model model, HttpServletRequest request) throws  Exception{


        Date nowData = new Date();
        SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
        String indate = endDate.format(nowData).toString();
        App05Dto.setYyyymm(indate.substring(0,6));
        App05Dto.setNinputdate(indate);

        try {

//            log.debug("Exception =====>" + App05ListDto );
            model.addAttribute("App05Dto",service.GetMNoticeList(App05Dto));
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

//        log.debug("App05tDto =====>" + App05Dto.toString() );
        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }




        return "app05/noticelist";
    }




}
