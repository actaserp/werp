package com.actas.ems.controller.app12;

import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.controller.SessionManager;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


@RequestMapping(value = "/app12", method = RequestMethod.POST)
@Controller
@RequiredArgsConstructor
public class App12Controller {
    UserFormDto userformDto = new UserFormDto();
    private final SessionManager sessionManager;

    protected Log log =  LogFactory.getLog(this.getClass());

    // 고장내용별현황 index
    @GetMapping(value="/index01")
    public String App03IndexForm(Model model, HttpServletRequest request, HttpServletResponse response) throws  Exception{
        try {
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
            if(userformDto.getFlag().equals("CC")){
                userformDto.setPagetree01("고객지원센터");
            }else{
                userformDto.setPagetree01("통계관리");
            }
            userformDto.setPagenm("고장별수리현황");
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }

        return "app12/app12list";
    }




}
