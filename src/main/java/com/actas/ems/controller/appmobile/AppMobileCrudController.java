package com.actas.ems.controller.appmobile;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppMob001tDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.elvlrt.App10ElvlrtMobService;
import com.actas.ems.Service.elvlrt.App10ElvlrtService;
import com.actas.ems.Service.elvlrt.AppPopElvlrtService;
import com.actas.ems.Service.elvlrt.App_mbmanualService.App_mbUploadService;
import com.actas.ems.Service.elvlrt.App_mbmanualService.App_mbUploadServiceImpl;
import com.actas.ems.Service.elvlrt.App_mbmanualService.App_mbmanualService;
import com.actas.ems.Service.master.AuthService;
import com.actas.ems.controller.EncryptionController;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/appmobile", method = RequestMethod.POST)
public class AppMobileCrudController {
    private final App10ElvlrtMobService service;
    private final AppPopElvlrtService appPopElvlrtService;
    UserFormDto userformDto = new UserFormDto();
    App10ElvlrtDto app10tDto = new App10ElvlrtDto();
    PopupDto popParmDto = new PopupDto();
    List<AppMob001tDto> appMobDtoList = new ArrayList<>();
    List<PopupDto> poplistDto = new ArrayList<>();
    protected Log log =  LogFactory.getLog(this.getClass());
    String ls_custcd = "";
    String ls_spjangcd = "";

    @RequestMapping(value = "/e401list", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object E401ListForm(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request) throws Exception{
        String ls_dbnm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        String frdate = getToDate();
        String todate = getToDate();


        String ls_yymm = frdate.substring(0,6);
        String ls_dd = "01";
        frdate =  ls_yymm + ls_dd;

        String changeop = "0";    //처리구분
        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";

                app10tDto.setFrdate(frdate);
                app10tDto.setTodate(todate);
                app10tDto.setChangeop(changeop);
                app10tDto.setCustcd(ls_custcd);
                app10tDto.setSpjangcd(ls_spjangcd);

                try {
                    appMobDtoList = service.GetAppMobList001(app10tDto);
                    model.addAttribute("appMobDtoList",appMobDtoList);

                }catch (DataAccessException e) {
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
                    //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
                }catch (Exception ex) {
//                dispatchException = ex;
                    log.info("App01001Tab01Form Exception ================================================================");
                    log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
                }
                break;
            case "ELV_KYOUNG":
                ls_custcd = "KYOUNG";
                break;
            case "hanyangs":
                ls_custcd = "hanyangs";
                break;
            default:
                break;

        }

        return appMobDtoList;
    }

    //  고장내용조회
    @RequestMapping(value = "/wcontnm", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object AppContnmList(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request){
        String ls_dbnm = "";
        String ls_contnm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "contnm":
                    popParmDto.setContnm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        if(ls_contnm.length() == 0){
            ls_contnm = "%";
        }
        try {
            popParmDto.setContnm(ls_contnm);
            poplistDto = appPopElvlrtService.GetContnmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }


    //  고장부위조회
    @RequestMapping(value = "/wgreginm", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object AppGreginmList(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request){
        String ls_dbnm = "";
        String ls_greginm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "greginm":
                    popParmDto.setContnm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        if(ls_greginm.length() == 0){
            ls_greginm = "%";
        }
        try {
            popParmDto.setGreginm(ls_greginm);
            poplistDto = appPopElvlrtService.GetGreginmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }



    //  고장부위상세조회
    @RequestMapping(value = "/wreginm", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object AppReginmList(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request){
        String ls_dbnm = "";
        String ls_gregicd = "";
        String ls_reginm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "gregicd":
                    popParmDto.setGregicd(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        if(ls_reginm.length() == 0){
            ls_reginm = "%";
        }
        try {
            ls_gregicd = popParmDto.getGregicd();
            int stCnt = ls_gregicd.indexOf('[') + 1 ;
            int etCnt = ls_gregicd.indexOf(']');

            ls_gregicd = ls_gregicd.substring(stCnt, etCnt);
            popParmDto.setGregicd(ls_gregicd);
            popParmDto.setReginm(ls_reginm);
            poplistDto = appPopElvlrtService.GetReginmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }



    //  처리내용조회
    @RequestMapping(value = "/wresunm", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object AppResunmList(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request){
        String ls_dbnm = "";
        String ls_resunm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "resunm":
                    popParmDto.setContnm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        if(ls_resunm.length() == 0){
            ls_resunm = "%";
        }
        try {
            popParmDto.setResunm(ls_resunm);
            poplistDto = appPopElvlrtService.GetResunmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }


    //  처리결과조회
    @RequestMapping(value = "/wresultnm", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object AppResultnmList(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request){
        String ls_dbnm = "";
        String ls_resultnm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "resultnm":
                    popParmDto.setContnm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        if(ls_resultnm.length() == 0){
            ls_resultnm = "%";
        }
        try {
            popParmDto.setResultnm(ls_resultnm);
            poplistDto = appPopElvlrtService.GetResultnmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }



    //  고장부위조회
    @RequestMapping(value = "/savee411", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object AppE411SaveList(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request){
        String ls_dbnm = "";
        String ls_gregicd = "";
        String ls_regicd = "";
        String ls_resucd = "";
        String ls_resultcd = "";
        String ls_resuremark = "";
        String ls_comptime = "";
        String ls_compdate = "";
        App10ElvlrtDto app10tDto = new App10ElvlrtDto();
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "recedate":
                    app10tDto.setRecedate(values.toString());
                case "recenum":
                    app10tDto.setRecenum(values.toString());
                case "compdate":
                    app10tDto.setCompdate(values.toString());
                case "comptime":
                    app10tDto.setComptime(values.toString());
                case "gregicd":
                    app10tDto.setGregicd(values.toString());
                case "regicd":
                    app10tDto.setRegicd(values.toString());
                case "resucd":
                    app10tDto.setResucd(values.toString());
                case "resultcd":
                    app10tDto.setResultcd(values.toString());
                case "resuremark":
                    app10tDto.setResuremark(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        ls_gregicd = app10tDto.getGregicd();
        ls_regicd = app10tDto.getRegicd();
        ls_resucd = app10tDto.getResucd();
        ls_resultcd = app10tDto.getResultcd();
        ls_resuremark = app10tDto.getResuremark();
        ls_compdate = app10tDto.getCompdate();
        ls_comptime = app10tDto.getComptime();
        int stCnt = ls_gregicd.indexOf('[') + 1 ;
        int etCnt = ls_gregicd.indexOf(']');
        ls_gregicd = ls_gregicd.substring(stCnt, etCnt);
        stCnt = 0; etCnt = 0;
        stCnt = ls_regicd.indexOf('[') + 1 ;
        etCnt = ls_regicd.indexOf(']');
        ls_regicd = ls_regicd.substring(stCnt, etCnt);
        stCnt = 0; etCnt = 0;
        stCnt = ls_resucd.indexOf('[') + 1 ;
        etCnt = ls_resucd.indexOf(']');
        ls_resucd = ls_resucd.substring(stCnt, etCnt);
        stCnt = 0; etCnt = 0;
        stCnt = ls_resultcd.indexOf('[') + 1 ;
        etCnt = ls_resultcd.indexOf(']');
        ls_resultcd = ls_resultcd.substring(stCnt, etCnt);
        app10tDto.setGregicd(ls_gregicd);
        app10tDto.setRegicd(ls_regicd);
        app10tDto.setResucd(ls_resucd);
        app10tDto.setResultcd(ls_resultcd);

        try {
            //poplistDto = appPopElvlrtService.GetGreginmList(popParmDto);
            //model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }



    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }



}
