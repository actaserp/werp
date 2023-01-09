package com.actas.ems.controller.app22;


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
@RequiredArgsConstructor
@RequestMapping(value = "/app22", method = RequestMethod.POST)
public class App22Controller {

    UserFormDto userFormDto = new UserFormDto();

    private final SessionManager sessionManager;

    protected Log log = LogFactory.getLog(this.getClass());

    @GetMapping(value = "/index01")
    public String App22IndexForm(Model model, HttpServletRequest request) throws Exception{
        try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            model.addAttribute("userformDto", userformDto);
        }catch (Exception ex){
            log.debug("Exception12 ==========>" + ex.toString());
        }
        return "app22/app22p001";
    }
}
