package com.actas.ems.controller.app27;


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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/app27", method = RequestMethod.POST)
public class App27Controller {

    UserFormDto userformDto = new UserFormDto();
    private final SessionManager sessionManager;

    protected Log log =  LogFactory.getLog(this.getClass());

    @GetMapping(value = "/index01")
    public String App27IndexForm(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            HttpSession session = request.getSession();
            if(!request.isRequestedSessionIdValid()){
                try {
                    response.setContentType("text/html; charset=utf-8");
                    PrintWriter w = response.getWriter();
                    w.write("<script>alert('로그인세션이 만료됐습니다.');</script>");
                    w.flush();
                    w.close();
                    throw new Exception(); //강제 에러 출력
                } catch(Exception e) {
                    e.printStackTrace();
                    return "loginForm";
                }
            }
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            userformDto.setPagetree01("고객지원센터");
            userformDto.setPagenm("고장구분별현황");
            model.addAttribute("userformDto", userformDto);
            String actnm = userformDto.getActnm();
            model.addAttribute("actnm", actnm);

            log.info(userformDto.getActcd());

        }catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString());
        }
        return "app27/app27p001";
    }
}
