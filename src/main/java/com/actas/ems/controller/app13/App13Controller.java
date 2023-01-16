package com.actas.ems.controller.app13;


import com.actas.ems.DTO.UserFormDto;
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

@Controller
@RequestMapping(value = "/app13", method = RequestMethod.POST)
@RequiredArgsConstructor
public class App13Controller {

    UserFormDto userFormDto = new UserFormDto();
    private final SessionManager sessionManager;

    protected Log log = LogFactory.getLog(this.getClass());


    //현장별수리현황
    @GetMapping(value = "/index01")
    public String App13IndexForm(Model model, HttpServletRequest request) throws Exception{
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            userformDto.setPagetree01("통계관리");
            userformDto.setPagenm("현장별수리현황");

            model.addAttribute("userformDto", userformDto);

        } catch (Exception ex){
            log.debug("Exception ====>" + ex.toString());
        }
        return "app13/app13p001";
    }
}
