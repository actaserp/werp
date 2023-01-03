package com.actas.ems.controller.app12;


import com.actas.ems.DTO.Elvlrt.App12ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App12ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app12", method = RequestMethod.POST)
public class App12RetrieveController {
    private final App12ElvlrtService service;

    PopupDto popParmDto = new PopupDto();
    List<App12ElvlrtDto> app12DtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    // 고장내용별현황 > 기간별 고장내용
    @GetMapping(value="/p001tab01")
    public Object App03001Tab01Form( @RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate
            , @RequestParam("actcdz") String actcd
            , @RequestParam("actcontcdz") String contcd
            , @RequestParam("actresucdz") String resucd
            , @RequestParam("actremocdz") String remocd
            , @RequestParam("actgregicdz") String gregicd
            , @RequestParam("actresultcdz") String resultcdz
            , Model model) throws  Exception{
        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate =  ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate =  ls_yeare + ls_mm + ls_dd;
        System.out.println(frdate);
        System.out.println(todate);
        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(actcd);
        popParmDto.setContcd(contcd);
        popParmDto.setResucd(resucd);
        popParmDto.setRemocd(remocd);
        popParmDto.setGregicd(gregicd);
        popParmDto.setResultcd(resultcdz);
        try {
            app12DtoList = service.GetApp12List001(popParmDto);
            model.addAttribute("app12DtoList",app12DtoList);
        }catch (DataAccessException e) {
            log.info("App12001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App12001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app12DtoList;
    }

    // 고장내용별현황 > 현장별 고장내용
    @GetMapping(value="/p001tab02")
    public Object App03001Tab02Form( @RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate
            , @RequestParam("actcdz") String actcd
            , @RequestParam("actcontcdz") String contcd
            , Model model) throws  Exception{

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
        try {
            app12DtoList = service.GetApp12List002(popParmDto);
            model.addAttribute("app03DtoList",app12DtoList);
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
        return app12DtoList;
    }
    // 고장내용별현황 > 호기별 고장내용
    @GetMapping(value="/p001tab03")
    public Object App03001Tab03Form( @RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate
            , @RequestParam("actcdz") String actcd
            , @RequestParam("actcontcdz") String contcd
            , Model model) throws  Exception{

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
        try {
            app12DtoList = service.GetApp12List003(popParmDto);
            model.addAttribute("app03DtoList",app12DtoList);
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
        return app12DtoList;
    }
    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }

}
