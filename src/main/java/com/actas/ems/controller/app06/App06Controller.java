package com.actas.ems.controller.app06;

import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App06ElvlrtService;
import com.actas.ems.controller.SessionManager;
import com.actas.ems.DTO.CommonDto;

import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/app06")
@Controller
@RequiredArgsConstructor
public class App06Controller {

    UserFormDto userformDto = new UserFormDto();
    private final App06ElvlrtService service;
    private final SessionManager sessionManager;
    List<App06ElvlrtDto> App06ListDto;
    List<CommonDto> com750Dto;
    App06ElvlrtDto App06Dto = new App06ElvlrtDto();


    protected Log log =  LogFactory.getLog(this.getClass());

    // 도면자료실 index
    @GetMapping(value="/index01")
    public String App06Form(Model model, HttpServletRequest request) throws  Exception{
//        userformDto.setUserid(userid);
//        userformDto.setUsername(username);
//        userformDto.setCltcd(cltcd);
//        userformDto.setDbnm(dbnm);
//        userformDto.setFlag(flag);
//        userformDto.setCalluserid(calluserid);
//        userformDto.setCalluserpw(calluserpw);
//        userformDto.setCustcd(custcd);
//        userformDto.setSpjangcd(spjangcd);

        Date nowData = new Date();
        SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
        String indate = endDate.format(nowData).toString();
        App06Dto.setYyyymm(indate.substring(0,6));
        App06Dto.setHinputdate(indate);
//        if(bflag == "0"){
//            App05Dto.setMsubject(search);
//        }else{
//            App05Dto.setMemo(search);
//        }
        try {
            App06ListDto = service.GetMHManualList(App06Dto);
//            log.debug("Exception =====>" + App05ListDto );
            model.addAttribute("App06Dto",App06ListDto);

            for(int i=0; i<App06ListDto.size(); i++) {
                System.out.println(App06ListDto.get(i).getHsubject());
            }
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }
        try {

            com750Dto = service.GetComm751List();
            model.addAttribute("com750Dto",com750Dto);

        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }

//        log.debug("App05tDto =====>" + App05Dto.toString() );
        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            userformDto.setPagetree01("기술자료실");
            userformDto.setPagenm("수리노하우");
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }




        return "app06/app06list";
    }




}
