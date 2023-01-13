package com.actas.ems.controller.app26;

import com.actas.ems.DTO.Elvlrt.App26ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App26ElvlrtService;
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
@RequestMapping(value = "/app26", method = RequestMethod.POST)
public class App26RetrieveController {
    private final App26ElvlrtService service;

    PopupDto popParmDto = new PopupDto();
    List<App26ElvlrtDto> app26DtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    // 고장내용별현황 > 기간별 고장내용
    @GetMapping(value="/p001tab01")
    public Object App26001Tab01Form( @RequestParam("frdate") String frdate
            ,@RequestParam("actcdz") String actcd
            ,@RequestParam("actwkactcdz") String wkactcd
            ,@RequestParam("actdivicdz") String divicd
            ,@RequestParam("actcontgubunz") String contgubun
            ,@RequestParam("actgubunz") String gubun
            ,Model model) throws  Exception{

        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate =  ls_yeare + ls_mm + ls_dd;

        popParmDto.setFrdate(frdate);
        popParmDto.setActcd(actcd);
        popParmDto.setWkactcd(wkactcd);
        popParmDto.setDivicd(divicd);
        popParmDto.setContgubun(contgubun);
        popParmDto.setGubun(gubun);
        try {
            app26DtoList = service.GetApp26List001(popParmDto);
            for(int i=0; i<app26DtoList.size(); i++){
                if(app26DtoList.get(i).getContg().equals("01")){
                    app26DtoList.get(i).setContg("신규");
                }else if(app26DtoList.get(i).getContg().equals("02")){
                    app26DtoList.get(i).setContg("계약연장");
                }else if(app26DtoList.get(i).getContg().equals("04")){
                    app26DtoList.get(i).setContg("만료");
                }else{
                    app26DtoList.get(i).setContg("재계약");
                }
            }
            model.addAttribute("app26DtoList",app26DtoList);
        }catch (DataAccessException e) {
            log.info("App26001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App26001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app26DtoList;
    }

    @GetMapping(value="/p001tab02")
    public Object App26001Tab02Form( @RequestParam("frdate") String frdate
            ,@RequestParam("actcdz") String actcd
            ,@RequestParam("actwkactcdz") String wkactcd
            ,@RequestParam("actdivicdz") String divicd
            ,@RequestParam("actcontgubunz") String contgubun
            ,@RequestParam("actgubunz") String gubun
            ,Model model) throws  Exception{

        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate =  ls_yeare + ls_mm + ls_dd;

        popParmDto.setFrdate(frdate);
        popParmDto.setActcd(actcd);
        popParmDto.setWkactcd(wkactcd);
        popParmDto.setDivicd(divicd);
        popParmDto.setContgubun(contgubun);
        popParmDto.setGubun(gubun);
        try {
            app26DtoList = service.GetApp26List002(popParmDto);
            model.addAttribute("app26DtoList",app26DtoList);
        }catch (DataAccessException e) {
            log.info("App26001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App26001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app26DtoList;
    }

    @GetMapping(value="/p001tab03")
    public Object App26001Tab03Form( @RequestParam("frdate") String frdate
            ,@RequestParam("actcdz") String actcd
            ,@RequestParam("actwkactcdz") String wkactcd
            ,@RequestParam("actdivicdz") String divicd
            ,@RequestParam("actcontgubunz") String contgubun
            ,@RequestParam("actgubunz") String gubun
            ,Model model) throws  Exception{

        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate =  ls_yeare + ls_mm + ls_dd;

        popParmDto.setFrdate(frdate);
        popParmDto.setActcd(actcd);
        popParmDto.setWkactcd(wkactcd);
        popParmDto.setDivicd(divicd);
        popParmDto.setContgubun(contgubun);
        popParmDto.setGubun(gubun);
        try {
            app26DtoList = service.GetApp26List003(popParmDto);
            for(int i=0; i<app26DtoList.size(); i++){
                if(app26DtoList.get(i).getContg().equals("01")){
                    app26DtoList.get(i).setContg("신규");
                }else if(app26DtoList.get(i).getContg().equals("02")){
                    app26DtoList.get(i).setContg("계약연장");
                }else if(app26DtoList.get(i).getContg().equals("04")){
                    app26DtoList.get(i).setContg("만료");
                }else{
                    app26DtoList.get(i).setContg("재계약");
                }
            }
            model.addAttribute("app26DtoList",app26DtoList);
        }catch (DataAccessException e) {
            log.info("App26001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App26001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app26DtoList;
    }

    @GetMapping(value="/p001tab04")
    public Object App26001Tab04Form( @RequestParam("frdate") String frdate
            ,@RequestParam("actcdz") String actcd
            ,@RequestParam("actwkactcdz") String wkactcd
            ,@RequestParam("actdivicdz") String divicd
            ,@RequestParam("actcontgubunz") String contgubun
            ,@RequestParam("actgubunz") String gubun
            ,Model model) throws  Exception{

        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate =  ls_yeare + ls_mm + ls_dd;



        popParmDto.setFrdate(frdate);
        popParmDto.setActcd(actcd);
        popParmDto.setWkactcd(wkactcd);
        popParmDto.setDivicd(divicd);
        popParmDto.setContgubun(contgubun);
        popParmDto.setGubun(gubun);
        try {
            app26DtoList = service.GetApp26List004(popParmDto);
            for(int i=0; i<app26DtoList.size(); i++){
                if(app26DtoList.get(i).getContg().equals("01")){
                    app26DtoList.get(i).setContg("신규");
                }else if(app26DtoList.get(i).getContg().equals("02")){
                    app26DtoList.get(i).setContg("계약연장");
                }else if(app26DtoList.get(i).getContg().equals("04")){
                    app26DtoList.get(i).setContg("만료");
                }else{
                    app26DtoList.get(i).setContg("재계약");
                }
            }
            model.addAttribute("app26DtoList",app26DtoList);
        }catch (DataAccessException e) {
            log.info("App26001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App26001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app26DtoList;
    }

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
