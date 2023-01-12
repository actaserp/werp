package com.actas.ems.controller.app27;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App27.App27ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app27", method = RequestMethod.POST)
public class App27RetrieveController {


    private final App27ElvlrtService service;

    PopupDto popParmDto = new PopupDto();

    App16ElvlrtDto app16ElvlrtDto = new App16ElvlrtDto();

    List<App16ElvlrtDto> app16DtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log = LogFactory.getLog(this.getClass());


    @GetMapping(value = "/p001tab01")
    public Object App2701TabForm(@RequestParam("frdate") String frdate,
                                 @RequestParam("todate") String todate,
                                 @RequestParam("actequpcdz") String equpcd,
                                 @RequestParam("actgregicdz") String gregicd,
                                 Model model, HttpServletRequest request)throws Exception{
        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate = ls_yeare + ls_mm + ls_dd;

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        model.addAttribute("userformDto", userformDto);

        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(userformDto.getActcd());
        popParmDto.setEqupcd(equpcd);
        popParmDto.setGregicd(gregicd);
        try {


            log.info(popParmDto.getActcd() + "check");
            app16DtoList = service.GetApp27List001(popParmDto);
            model.addAttribute("app16DtoList",app16DtoList);
            log.info(popParmDto.getEqupcd() + "fibnal");

            log.info(userformDto.getActcd() + "3333123215123313123132121dadcdsassd");


        }catch (DataAccessException e) {
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app16DtoList;
    }

    @GetMapping(value = "/p001tab02")
    public Object App2702TabForm(@RequestParam("frdate") String frdate,
                                 @RequestParam("todate") String todate,
                                 @RequestParam("actequpcdz") String equpcd,
                                 @RequestParam("actcontcdz") String contcd,
                                 Model model, HttpServletRequest request)throws Exception{
        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate = ls_yeare + ls_mm + ls_dd;

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        model.addAttribute("userformDto", userformDto);

        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(userformDto.getActcd());
        popParmDto.setEqupcd(equpcd);
        popParmDto.setContcd(contcd);
        try {


            log.info(popParmDto.getActcd() + "check");
            app16DtoList = service.GetApp27List002(popParmDto);
            model.addAttribute("app16DtoList",app16DtoList);
            log.info(popParmDto.getEqupcd() + "fibnal");

            log.info(userformDto.getActcd() + "3333123215123313123132121dadcdsassd");


        }catch (DataAccessException e) {
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app16DtoList;
    }

    @GetMapping(value = "/p001tab03")
    public Object App2703TabForm(@RequestParam("frdate") String frdate,
                                 @RequestParam("todate") String todate,
                                 @RequestParam("actequpcdz") String equpcd,
                                 @RequestParam("actremocdz") String remocd,
                                 Model model, HttpServletRequest request)throws Exception{
        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate = ls_yeare + ls_mm + ls_dd;

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        model.addAttribute("userformDto", userformDto);

        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(userformDto.getActcd());
        popParmDto.setEqupcd(equpcd);
        popParmDto.setRemocd(remocd);
        try {


            log.info(popParmDto.getActcd() + "check");
            app16DtoList = service.GetApp27List003(popParmDto);
            model.addAttribute("app16DtoList",app16DtoList);
            log.info(popParmDto.getEqupcd() + "fibnal");

            log.info(userformDto.getActcd() + "3333123215123313123132121dadcdsassd");


        }catch (DataAccessException e) {
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app16DtoList;
    }
    @GetMapping(value = "/p001tab04")
    public Object App2704TabForm(@RequestParam("frdate") String frdate,
                                 @RequestParam("todate") String todate,
                                 @RequestParam("actequpcdz") String equpcd,
                                 @RequestParam("actresucdz") String resucd,
                                 Model model, HttpServletRequest request)throws Exception{
        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate = ls_yeare + ls_mm + ls_dd;

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        model.addAttribute("userformDto", userformDto);

        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(userformDto.getActcd());
        popParmDto.setEqupcd(equpcd);
        popParmDto.setResucd(resucd);
        try {


            log.info(popParmDto.getActcd() + "check");
            app16DtoList = service.GetApp27List004(popParmDto);
            model.addAttribute("app16DtoList",app16DtoList);
            log.info(popParmDto.getEqupcd() + "fibnal");

            log.info(userformDto.getActcd() + "3333123215123313123132121dadcdsassd");


        }catch (DataAccessException e) {
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app16DtoList;
    }

    @GetMapping(value = "/p001popup")
    public Object App27popForm(@RequestParam("compyear") String compyear,
                               @RequestParam("actequpcdz") String equpcd,
                                 @RequestParam("actgregicd") String gregicd,
                                 @RequestParam("actreginm") String reginm,
                                 @RequestParam("actcontcd") String contcd,
                                 @RequestParam("actcontremark") String contremark,
                                 @RequestParam("actremonm") String remonm,
                                 @RequestParam("actresunmz") String resunm,
                                 Model model, HttpServletRequest request)throws Exception{


        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        model.addAttribute("userformDto", userformDto);

        app16ElvlrtDto.setActcd(userformDto.getActcd());
        app16ElvlrtDto.setCompyear(compyear);
        app16ElvlrtDto.setEqupcd(equpcd);
        app16ElvlrtDto.setGregicd(gregicd);
        app16ElvlrtDto.setReginm(reginm);
        app16ElvlrtDto.setContcd(contcd);
        app16ElvlrtDto.setContremark(contremark);
        app16ElvlrtDto.setRemonm(remonm);
        app16ElvlrtDto.setResunm(resunm);

        try {


            log.info(app16ElvlrtDto.getActcd() + "check");
            app16DtoList = service.GetApp27popuplist(app16ElvlrtDto);
            model.addAttribute("app16DtoList",app16DtoList);
            log.info(app16ElvlrtDto.getEqupcd() + "fibnal");

            log.info(userformDto.getActcd() + "3333123215123313123132121dadcdsassd");


        }catch (DataAccessException e) {
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app16DtoList;
    }

}
