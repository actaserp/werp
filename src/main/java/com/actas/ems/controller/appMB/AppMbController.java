package com.actas.ems.controller.appMB;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App_mbmanualService.App_mbmanualService;
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
import java.util.List;

@RequestMapping(value = "/app08", method = RequestMethod.POST)
@Controller
@RequiredArgsConstructor
public class AppMbController {

    private final App_mbmanualService service;
    UserFormDto userFormDto = new UserFormDto();
    private final SessionManager sessionManager;
    List<App08_mbmanual> app08_mbmanual;
    List<CommonDto> com750Dto;

    App08_mbmanual app08Dto = new App08_mbmanual();

    protected Log log = LogFactory.getLog(this.getClass());

    //게시판 리스트 조회
    @GetMapping(value = "/index01")
    public String App08Form(Model model, HttpServletRequest request) throws Exception{
        Date nowData = new Date();
        SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
        String indate = endDate.format(nowData).toString();
        app08Dto.setYyyymm(indate.substring(0, 6));
        app08Dto.setBinputdate(indate);
        Object check = service.GetMManulList(app08Dto);
        try{
            model.addAttribute("app08Dto", check);

            log.info(check);

        }catch (Exception ex){
            log.debug("Exception =====>" + ex.toString() );
        }try{
            com750Dto = service.GetComm750List();
            model.addAttribute("com750Dto", com750Dto);

        }catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            model.addAttribute("userformDto",userformDto);

        }catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }

        return "app08/app08list";
    }


}
