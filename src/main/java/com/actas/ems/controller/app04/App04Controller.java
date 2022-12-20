package com.actas.ems.controller.app04;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Entity.User;
import com.actas.ems.Service.elvlrt.App04ElvlrtService;
import com.actas.ems.controller.SessionManager;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RequestMapping(value = "/app04", method = RequestMethod.POST)
@Controller
@RequiredArgsConstructor
public class App04Controller {
    UserFormDto userformDto = new UserFormDto();
    private final App04ElvlrtService service;
    private final SessionManager sessionManager;
    List<App04ElvlrtDto> app04ListDto ;
    List<CommonDto> com750Dto ;
    App04ElvlrtDto app04Dto = new App04ElvlrtDto();


    protected Log log =  LogFactory.getLog(this.getClass());

    // 도면자료실 index
    @GetMapping(value="/index01")
    public String App04Form(Model model, HttpServletRequest request) throws  Exception{
//여기부터 화면 구성
        Date nowData = new Date();
        SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
        String indate = endDate.format(nowData).toString();
        app04Dto.setYyyymm(indate.substring(0,6));
        app04Dto.setMinputdate(indate);
//        if(bflag == "0"){
//            app04Dto.setMsubject(search);
//        }else{
//            app04Dto.setMemo(search);
//        }
        try {
//            app04ListDto = service.GetMManulList(app04Dto);
//            log.debug("Exception =====>" + app04ListDto );
            model.addAttribute("app04Dto",service.GetMManulList(app04Dto));
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }
        try {
            com750Dto = service.GetComm750List();
            model.addAttribute("com750Dto",com750Dto);

        } catch (Exception ex) {
            log.debug("Exception =====>" + ex.toString() );
        }

        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }

        return "app04/app04list";
    }
    @GetMapping(value="/index02")
    public String App04Form2(Model model, HttpServletRequest request) throws  Exception{

        Date nowData = new Date();
        SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
        String indate = endDate.format(nowData).toString();
        app04Dto.setYyyymm(indate.substring(0,6));
        app04Dto.setMinputdate(indate);
//        if(bflag == "0"){
//            app04Dto.setMsubject(search);
//        }else{
//            app04Dto.setMemo(search);
//        }
        try {
//            app04ListDto = service.GetMManulList(app04Dto);
//            log.debug("Exception =====>" + app04ListDto );
            model.addAttribute("app04Dto",service.GetDManulList(app04Dto));
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }
        try {
            com750Dto = service.GetComm750List();
            model.addAttribute("com750Dto",com750Dto);

        } catch (Exception ex) {
            log.debug("Exception =====>" + ex.toString() );
        }

        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }

        return "app04/app04list_index02";
    }

    @GetMapping(value="/index03")
    public String App04Form3(Model model, HttpServletRequest request) throws  Exception{

        Date nowData = new Date();
        SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
        String indate = endDate.format(nowData).toString();
        app04Dto.setYyyymm(indate.substring(0,6));
        app04Dto.setMinputdate(indate);
//        if(bflag == "0"){
//            app04Dto.setMsubject(search);
//        }else{
//            app04Dto.setMemo(search);
//        }
        try {
//            app04ListDto = service.GetMManulList(app04Dto);
//            log.debug("Exception =====>" + app04ListDto );
            model.addAttribute("app04Dto",service.GetMManulList(app04Dto));
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }
        try {
            com750Dto = service.GetComm750List();
            model.addAttribute("com750Dto",com750Dto);

        } catch (Exception ex) {
            log.debug("Exception =====>" + ex.toString() );
        }

        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }

        return "app04/app04list_index03";
    }

}
