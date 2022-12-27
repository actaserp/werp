package com.actas.ems.controller.app01;

import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.elvlrt.App03ElvlrtService;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/app01")
@Controller
@RequiredArgsConstructor
public class App01Controller {
    private final App01ElvlrtService app01ElvlrtService;
    UserFormDto userformDto = new UserFormDto();
    PopupDto popParmDto = new PopupDto();
    List<App03ElvlrtDto> app03DtoList = new ArrayList<>();
    private final App01ElvlrtService service;
    protected Log log =  LogFactory.getLog(this.getClass());

    // kt call dashboard
    @GetMapping(value="/ktcall")
    public String App01Form(  Model model , HttpServletRequest request){
        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
//        userformDto.setUserid(userid);
//        userformDto.setUsername(username);
//        userformDto.setCltcd(cltcd);
//        userformDto.setDbnm(dbnm);
//        userformDto.setFlag(flag);
//        userformDto.setCalluserid(calluserid);
//        userformDto.setCalluserpw(calluserpw);

        model.addAttribute("userFormDto", userformDto);
        return "app01/KtcallMAIN";
    }

    // kt call dashboard
    @GetMapping(value="/ktcalltemp")
    public String App01TempForm(  Model model
            , HttpServletRequest request){
        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
//        userformDto.setUserid(userid);
//        userformDto.setUsername(username);
//        userformDto.setCltcd(cltcd);
//        userformDto.setDbnm(dbnm);
//        userformDto.setFlag(flag);
//        userformDto.setCalluserid(calluserid);
//        userformDto.setCalluserpw(calluserpw);

        model.addAttribute("userFormDto", userformDto);
        return "app01/KtcallNew";
    }

    // 관제 dashboard
    @GetMapping(value="/emcontrol")
    public String App01ControlForm(  Model model
            , HttpServletRequest request){
        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        String todate = getToDate();
//        String ls_yeare = todate.substring(0,4);
//        String ls_mm = todate.substring(4,6);
//        String ls_mm = todate.substring(4,6);
        String frdate =  getToDate();
        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd("%");
        try {
            app03DtoList = service.GetApp01List001(popParmDto);
            model.addAttribute("app03DtoList",app03DtoList);
        }catch (DataAccessException e) {
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }

        model.addAttribute("userFormDto", userformDto);
        return "app01/emcontrol";
    }
    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
