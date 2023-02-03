package com.actas.ems.controller.app10;

import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Mapper.Elvlrt.App04ElvlrtMapper;
import com.actas.ems.Service.elvlrt.App10ElvlrtService;
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


@RequestMapping(value = "/app10", method = RequestMethod.POST)
@Controller
@RequiredArgsConstructor
public class App10Controller {
    UserFormDto userformDto = new UserFormDto();
    private final SessionManager sessionManager;

    protected Log log =  LogFactory.getLog(this.getClass());
    private final App10ElvlrtService service;
    App10ElvlrtDto app10tDto = new App10ElvlrtDto();

    // 고장내용별현황 index
    @GetMapping(value="/index01")
    public String App10IndexForm(Model model, HttpServletRequest request) throws  Exception{
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            model.addAttribute("userformDto",userformDto);
            String ls_spjangcd = userformDto.getSpjangcd();
            app10tDto.setFrdate(getToDate());
            app10tDto.setTodate(getToDate());
            app10tDto.setSpjangcd(ls_spjangcd);
            model.addAttribute("app04Dto",service.GetApp10List002(app10tDto));

        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }

        return "app10/app10p001";
    }

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }

}
