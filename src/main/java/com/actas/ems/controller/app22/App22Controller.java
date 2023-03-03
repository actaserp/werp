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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/app22", method = RequestMethod.POST)
public class App22Controller {

    UserFormDto userFormDto = new UserFormDto();

    private final SessionManager sessionManager;

    protected Log log = LogFactory.getLog(this.getClass());

    @GetMapping(value = "/index01")
    public String App22IndexForm(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
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
            userformDto.setPagenm("승강기고장통계(연도별단위)");

            boolean result = true;
            if(userformDto.getFlag().equals("CC")){
                result = false;
            }

            model.addAttribute("userformDto", userformDto);
            model.addAttribute("result", result);
            String actnm = userformDto.getActnm();
            model.addAttribute("actnm", actnm);

        }catch (Exception ex){
            log.debug("Exception12 ==========>" + ex.toString());
        }
        return "app22/app22p001";
    }
}
