package com.actas.ems.controller.app19;


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

@RequestMapping(value = "/app19", method = RequestMethod.POST)
@Controller
@RequiredArgsConstructor
public class App19Controller {

    UserFormDto userformDto = new UserFormDto();
    private final SessionManager sessionManager;

    protected Log log =  LogFactory.getLog(this.getClass());

    @GetMapping(value = "/index01")
    public String App19IndexForm(Model model, HttpServletRequest request) throws Exception {
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            model.addAttribute("userformDto", userformDto);
            log.info(userformDto.getActcd());
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString());
        }
        return "app19/app19p001";
    }
}
