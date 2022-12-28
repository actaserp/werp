package com.actas.ems.controller.app13;


import com.actas.ems.DTO.Elvlrt.App13ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App13ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app13", method = RequestMethod.POST)
public class App13RetrieveController {


    private final App13ElvlrtService service;

    PopupDto popParmDto = new PopupDto();
    List<App13ElvlrtDto> app13DtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log = LogFactory.getLog(this.getClass());

    //기간별
    @GetMapping(value = "/p001tab01")
    public Object App13001Tab01Form(@RequestParam("frdate") String frdate,
                                    @RequestParam("todate") String todate,
                                    @RequestParam("actcdz") String actcd,
                                    @RequestParam("actcontcdz") String contcd,
                                    Model model) throws Exception {
        String ls_yeare = frdate.substring(0, 4);
        String ls_mm = frdate.substring(5, 7);
        String ls_dd = frdate.substring(8, 10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0, 4);
        ls_mm = todate.substring(5, 7);
        ls_dd = todate.substring(8, 10);
        todate = ls_yeare + ls_mm + ls_dd;
        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(actcd);
        popParmDto.setContcd(contcd);
        try {
            app13DtoList = service.GetApp13List001(popParmDto);
            model.addAttribute("app13DtoList", app13DtoList);

        } catch (DataAccessException e){
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app13DtoList;
    }

    @GetMapping(value = "/p001tab02")
    public Object App13001Tab02Form(@RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate
            , @RequestParam("actcdz") String actcd
            , @RequestParam("actcontcdz") String contcd
            , Model model) throws Exception{

        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate =  ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate =  ls_yeare + ls_mm + ls_dd;
        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(actcd);
        popParmDto.setContcd(contcd);

        try{
            app13DtoList = service.GetApp13List002(popParmDto);
            model.addAttribute("app03DtoList", app13DtoList);
        }catch (DataAccessException e){
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app13DtoList;
    }
    //호기별 고장내용
    @GetMapping(value = "/p001tab03")
    public Object App03001Tab03Form(@RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate
            , @RequestParam("actcdz") String actcd
            , @RequestParam("actcontcdz") String contcd
            , Model model) throws Exception{
        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate =  ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate =  ls_yeare + ls_mm + ls_dd;
        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(actcd);
        popParmDto.setContcd(contcd);

        try{
            app13DtoList = service.GetApp13List003(popParmDto);
            model.addAttribute("app03DtoList", app13DtoList);
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
        return app13DtoList;
    }

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
