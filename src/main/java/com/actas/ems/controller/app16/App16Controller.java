package com.actas.ems.controller.app16;


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
@RequestMapping(value = "/app16", method = RequestMethod.POST)
public class App16Controller {

    UserFormDto userFormDto = new UserFormDto();
    private final SessionManager sessionManager;

    protected Log log = LogFactory.getLog(this.getClass());

    @GetMapping(value = "/index01")
    public String App16IndexForm(Model model, HttpServletRequest request) throws Exception{
        try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            userformDto.setPagetree01("고객지원센터");
            userformDto.setPagenm("월별고장률현황");
            boolean result = true;
             if(userformDto.getFlag().equals("CC")){

                 result = false;
             }

            model.addAttribute("userformDto", userformDto);
            model.addAttribute("result", result);

            log.info(userformDto.getFlag());
            log.info(result);
        }catch (Exception ex){
            log.debug("Exception12 ==========>" + ex.toString());
        }

        return "app16/app16p001";
    }

}
