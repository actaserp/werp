package com.actas.ems.controller.app09;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App09ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App09ElvlrtService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/app09", method = RequestMethod.POST)
@Controller
@RequiredArgsConstructor
public class App09Controller {

    UserFormDto userformDto = new UserFormDto();
    private final App09ElvlrtService service;

    private final SessionManager sessionManager;
    List<App09ElvlrtDto> app09DtoList = new ArrayList<>();
    List<CommonDto> com750Dto;

    App09ElvlrtDto app09Dto = new App09ElvlrtDto();

    protected Log log = LogFactory.getLog(this.getClass());


    //게시판 리스트 조회
    @GetMapping(value = "/index01")
    public String App09Form(Model model, HttpServletRequest request) throws  Exception{
        Date nowData = new Date();
        SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
        String indate = endDate.format(nowData).toString();
        app09Dto.setYyyymm(indate.substring(0, 6));
        app09Dto.setFinputdate(indate);

        try{
            app09DtoList = service.GetFQManulList(app09Dto);
            model.addAttribute("app09Dto", app09DtoList);
        }catch (Exception ex){
            log.debug("Exception =====>" + ex.toString() );
        }

        return "app09/app09list";
    }

    @GetMapping(value = "/index02")
    public String App09Form2(Model model, HttpServletRequest request) throws  Exception{
        Date nowData = new Date();
        SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
        String indate = endDate.format(nowData).toString();
        app09Dto.setYyyymm(indate.substring(0, 6));
        app09Dto.setFinputdate(indate);

        try{
            app09DtoList = service.GetFQManulList(app09Dto);
            model.addAttribute("app09Dto", app09DtoList);
        }catch (Exception ex){
            log.debug("Exception =====>" + ex.toString() );
        }

        return "app09/app09list2";
    }


}
