package com.actas.ems.controller.appmobile;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.*;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.*;
import com.actas.ems.Service.elvlrt.App27.App27ElvlrtService;
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

    private final AppM03UploadServiceImpl appServiceImpl03;
    private final App10ElvlrtMobService service;
    private final App07ElvlrtService service2;
    private final AppPopElvlrtService appPopElvlrtService;
    UserFormDto userformDto = new UserFormDto();
    App10ElvlrtDto app10tDto = new App10ElvlrtDto();
    App28ElvlrtDto app28Dto = new App28ElvlrtDto();
    AttachDTO attachDTO = new AttachDTO();
    App16ElvlrtDto app16tDto = new App16ElvlrtDto();


    List<App14ElvlrtDto> app14DtoList = new ArrayList<>();
    List<App26ElvlrtDto> app26DtoList = new ArrayList<>();
    List<App07ElvlrtDto> app07DtoList = new ArrayList<>();
    App07ElvlrtDto app07Dto = new App07ElvlrtDto();

    App06ElvlrtDto app06Dto = new App06ElvlrtDto();
    App08_mbmanual app08_mbmanual = new App08_mbmanual();
    PopupDto popParmDto = new PopupDto();
    List<AppMob001tDto> appMobDtoList = new ArrayList<>();

    List<App16ElvlrtDto> app16DtoList = new ArrayList<>();

    List<App04ElvlrtDto> app04DtoList = new ArrayList<>();


    List<AppMob003tDto> appMob003tDtoList = new ArrayList<>();
    List<AppMob004tDto> appMob004tDtoList = new ArrayList<>();

    List<AppMob005tDto> appMob005tDtoList = new ArrayList<>();

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
                case "actnm":
                    app10tDto.setActnm(values.toString());
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

    //현장별고장부위별현황 ,박광열
    @RequestMapping(value = "/e411list", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object E411ListForm(@RequestParam Map<String, String> param,
                               Model model, HttpServletRequest request) throws Exception{

        //현재날짜기준 월초(1일) 구하기
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());
        String time = formatter.format(date);


        String minusYear = AddDate(time, -2, 0, 0);


        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "actnm":

                    popParmDto.setActnm(values.toString());
                    break;
                case "contnm":

                    popParmDto.setContnm(values.toString());
                    popParmDto.setGreginm("%");
                    popParmDto.setRemonm("%");
                    break;
                case "greginm":

                    popParmDto.setGreginm(values.toString());
                    popParmDto.setContnm("%");
                    popParmDto.setRemonm("%");
                    break;
                case "remonm":

                    popParmDto.setRemonm(values.toString());
                    popParmDto.setContnm("%");
                    popParmDto.setGreginm("%");
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();
        String frdate = minusYear;
        String todate = time;





        ls_spjangcd = "ZZ";

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                popParmDto.setFrdate(frdate);    //2년전날짜
                popParmDto.setTodate(todate);    //현재날짜
                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT




                try{
                    app16DtoList = service.GetAppMobList_002(popParmDto);
                    model.addAttribute("app16DtoList", app16DtoList);

                }catch (DataAccessException e){
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
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
        return app16DtoList;
    }


    /**박광열 직원정보 리스트 **/
    @RequestMapping(value = "/ja001list", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object JA001ListForm(@RequestParam Map<String, String> param,
                                Model model, HttpServletRequest request) throws Exception{

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "pernm":

                    popParmDto.setPernm(values.toString());
                    break;
                case "divinm":
                    popParmDto.setDivinm(values.toString());
                    break;
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{
                    app14DtoList = service.GetAppMobList_003(popParmDto);
                    model.addAttribute("app14DtoList", app14DtoList);

                }catch (DataAccessException e){
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
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
        return app14DtoList;
    }

    /**박광열 현장정보 리스트 **/
    @RequestMapping(value = "/tbe601list", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object TBE601ListForm(@RequestParam Map<String, String> param,
                                Model model, HttpServletRequest request) throws Exception{

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "actnm":

                    popParmDto.setActnm(values.toString());
                    break;
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{
                    app26DtoList = service.GetAppMobListr_004(popParmDto);
                    model.addAttribute("app26DtoList", app26DtoList);

                }catch (DataAccessException e){
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
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
        return app26DtoList;
    }
    /**박광열 고장이력 **/
    @RequestMapping(value = "/tbe401list", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object TBE401ListForm(@RequestParam Map<String, String> param,
                                 Model model, HttpServletRequest request) throws Exception{

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "actnm":

                    popParmDto.setActnm(values.toString());
                    break;

                case "equpnm":

                    popParmDto.setEqupnm(values.toString());
                    break;
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{
                    app16DtoList = service.GetAppMobListr_005(popParmDto);
                    model.addAttribute("app16DtoList", app16DtoList);

                }catch (DataAccessException e){
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
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
        return app16DtoList;
    }

    /**박광열 점검조치사항 **/
    @RequestMapping(value = "/mfixlist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object MFIXListForm(@RequestParam Map<String, String> param,
                                 Model model, HttpServletRequest request) throws Exception{

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "fnsubject":
                    app07Dto.setFnsubject(values.toString());
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();
        Object app07  = service2.GetMManulList(app07Dto);
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{
                    model.addAttribute("app07Dto", service2.GetMManulList(app07Dto));
                    model.addAttribute("app16DtoList", app16DtoList);

                }catch (DataAccessException e){
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
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
        return app07;
    }



    @RequestMapping(value = "/mhlist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object mhListForm(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request) throws Exception{
        String ls_dbnm = "";
        String ls_hseq = "";
        HttpSession session = request.getSession();
        userformDto.setDbnm(ls_dbnm);
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
        session.setAttribute("userformDto",userformDto);
        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                app06Dto.setCustcd(ls_custcd);
                app06Dto.setSpjangcd(ls_spjangcd);


                try {
                    appMob003tDtoList = service.GetApp06MobList001(app06Dto);
                    model.addAttribute("appMob003tDtoList",appMob003tDtoList);

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
        return appMob003tDtoList;
    }

    //app06 to 03 첨부파일리스트
    @RequestMapping(value = "/attachMH", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object mhListAttach(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request) throws Exception{
        String ls_dbnm = "";
        String ls_hseq = "";
        String ls_hflag = "";
        List<AttachDTO>  attach =new ArrayList<>();
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "flag":
                    attachDTO.setFlag(values.toString());
                    break;
                case "boardIdx":
                    attachDTO.setBoardIdx(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        ls_hseq = attachDTO.getBoardIdx();
        ls_hflag = attachDTO.getFlag();
        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                try {
                    attachDTO.setBoardIdx(ls_hseq);
                    attachDTO.setFlag(ls_hflag);
                    attach = appServiceImpl03.select06to03AttachList(attachDTO);
                    model.addAttribute("attachDto",attach);

                }catch (DataAccessException e) {
                    log.info("App06MobForm DataAccessException ================================================================");
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

        return attach;
    }

    //app06 to 03 첨부파일리스트
    @RequestMapping(value = "/attachMB", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object mbListAttach(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request) throws Exception{
        String ls_dbnm = "";
        String ls_hseq = "";
        String ls_hflag = "";
        List<AttachDTO>  attach =new ArrayList<>();
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "flag":
                    attachDTO.setFlag(values.toString());
                    break;
                case "boardIdx":
                    attachDTO.setBoardIdx(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        ls_hseq = attachDTO.getBoardIdx();
        ls_hflag = attachDTO.getFlag();
        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                try {
                    attachDTO.setBoardIdx(ls_hseq);
                    attachDTO.setFlag(ls_hflag);
                    attach = appServiceImpl03.select08tombAttachList(attachDTO);
                    model.addAttribute("attachDto",attach);

                }catch (DataAccessException e) {
                    log.info("App06MobForm DataAccessException ================================================================");
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

        return attach;
    }

    @RequestMapping(value = "/Blist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object bListForm(@RequestParam Map<String, String> param
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
        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                app08_mbmanual.setCustcd(ls_custcd);
                app08_mbmanual.setSpjangcd(ls_spjangcd);

                try {
                    appMob004tDtoList = service.GetApp0bMobList001(app08_mbmanual);
                    model.addAttribute("appMob004tDtoList",appMob004tDtoList);

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

        return appMob004tDtoList;
    }

    //FnQ
    @RequestMapping(value = "/SSlist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object sListForm(@RequestParam Map<String, String> param
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
        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                app28Dto.setCustcd(ls_custcd);
                app28Dto.setSpjangcd(ls_spjangcd);

                try {
                    appMob005tDtoList = service.GetApp28MobList001(app28Dto);
                    model.addAttribute("appMob005tDtoList",appMob005tDtoList);

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

        return appMob005tDtoList;
    }

    //  고장내용조회
    @RequestMapping(value = "/comslist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object MobcomList(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request){
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
        ls_spjangcd = "ZZ";
        ls_custcd = "ELVLRT";

        try {
            app28Dto.setCustcd(ls_custcd);
            app28Dto.setSpjangcd(ls_spjangcd);
            appMob005tDtoList = service.GetApp28MobList002(app28Dto);
            model.addAttribute("appMob005tDtoList", appMob005tDtoList);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return appMob005tDtoList;
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

    private static String AddDate(String strDate, int year, int month, int day) throws Exception {

        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");

        Calendar cal = Calendar.getInstance();

        Date dt = dtFormat.parse(strDate);

        cal.setTime(dt);

        cal.add(Calendar.YEAR,  year);
        cal.add(Calendar.MONTH, month);
        cal.add(Calendar.DATE,  day);

        return dtFormat.format(cal.getTime());
    }

    @RequestMapping(value = "/mlist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object MListForm(@RequestParam Map<String, String> param,
                               Model model, HttpServletRequest request) throws Exception{

        //현재날짜기준 월초(1일) 구하기
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());
        String time = formatter.format(date);


        String minusYear = AddDate(time, -2, 0, 0);


        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "subject":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setSubject(values.toString());
                    break;
                case "memo":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setMemo(values.toString());
                    break;
                case "groupcd":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setGroupcd(values.toString());
                    break;
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();
        String frdate = minusYear;
        String todate = time;





        ls_spjangcd = "ZZ";

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                popParmDto.setFrdate(frdate);    //2년전날짜
                popParmDto.setTodate(todate);    //현재날짜
                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT




                try{
                    app04DtoList = service.GetAppMobList_004(popParmDto);
                    model.addAttribute("app04DtoList", app04DtoList);

                }catch (DataAccessException e){
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
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
        return app04DtoList;
    }

    @RequestMapping(value = "/elist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object EListForm(@RequestParam Map<String, String> param,
                            Model model, HttpServletRequest request) throws Exception{

        //현재날짜기준 월초(1일) 구하기
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());
        String time = formatter.format(date);


        String minusYear = AddDate(time, -2, 0, 0);


        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "subject":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setSubject(values.toString());
                    break;
                case "memo":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setMemo(values.toString());
                    break;
                case "groupcd":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setGroupcd(values.toString());
                    break;
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();
        String frdate = minusYear;
        String todate = time;





        ls_spjangcd = "ZZ";

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                popParmDto.setFrdate(frdate);    //2년전날짜
                popParmDto.setTodate(todate);    //현재날짜
                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT




                try{
                    app04DtoList = service.GetAppMobList_e(popParmDto);
                    model.addAttribute("app04DtoList", app04DtoList);

                }catch (DataAccessException e){
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
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
        return app04DtoList;
    }

    @RequestMapping(value = "/dlist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object DListForm(@RequestParam Map<String, String> param,
                            Model model, HttpServletRequest request) throws Exception{

        //현재날짜기준 월초(1일) 구하기
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());
        String time = formatter.format(date);


        String minusYear = AddDate(time, -2, 0, 0);


        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "subject":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setSubject(values.toString());
                    break;
                case "memo":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setMemo(values.toString());
                    break;
                case "groupcd":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setGroupcd(values.toString());
                    break;
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();
        String frdate = minusYear;
        String todate = time;





        ls_spjangcd = "ZZ";

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                popParmDto.setFrdate(frdate);    //2년전날짜
                popParmDto.setTodate(todate);    //현재날짜
                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT




                try{
                    app04DtoList = service.GetAppMobList_d(popParmDto);
                    model.addAttribute("app04DtoList", app04DtoList);

                }catch (DataAccessException e){
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
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
        return app04DtoList;
    }

    @RequestMapping(value = "/fileThumblist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object thumbListForm(@RequestParam Map<String, String> param,
                            Model model, HttpServletRequest request) throws Exception{

        List<AttachDTO> attachDTOList = new ArrayList<>();

        //현재날짜기준 월초(1일) 구하기
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());
        String time = formatter.format(date);


        String minusYear = AddDate(time, -2, 0, 0);


        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    popParmDto.setDbnm(values.toString());
                    break;
                case "flag":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setFlag(values.toString());
                    break;
                case "boardIdx":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setSeq(values.toString());
                    break;
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();
        String frdate = minusYear;
        String todate = time;





        ls_spjangcd = "ZZ";

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                popParmDto.setFrdate(frdate);    //2년전날짜
                popParmDto.setTodate(todate);    //현재날짜
                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT




                try{
                    attachDTOList = service.GetMobThumbList_001(popParmDto);
                    model.addAttribute("attachDTOList", attachDTOList);

                }catch (DataAccessException e){
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
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
        return attachDTOList;
    }




    //  고장요인
    @RequestMapping(value = "/wremonm", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object AppRemonmList(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request){
        String ls_dbnm = "";
        String ls_remonm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "remonm":
                    popParmDto.setRemonm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        if(ls_remonm.length() == 0){
            ls_remonm = "%";
        }
        try {
            popParmDto.setRemonm(ls_remonm);
            poplistDto = appPopElvlrtService.GetRemonmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }


    //  담당자
    @RequestMapping(value = "/wpernm", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object AppPernmList(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request){
        String ls_dbnm = "";
        String ls_pernm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "wpernm":
                    popParmDto.setWpernm(values.toString());
                    popParmDto.setPernm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        if(ls_pernm.length() == 0){
            ls_pernm = "%";
        }
        try {
            popParmDto.setWpernm(ls_pernm);
            poplistDto = appPopElvlrtService.GetPernmList(popParmDto);
            model.addAttribute("poplistDto", poplistDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return poplistDto;
    }



}
