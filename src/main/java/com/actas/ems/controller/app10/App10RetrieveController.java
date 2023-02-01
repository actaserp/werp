package com.actas.ems.controller.app10;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App10ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app10", method = RequestMethod.POST)
public class App10RetrieveController {
    private final App10ElvlrtService service;
    PopupDto popParmDto = new PopupDto();
    App10ElvlrtDto app10tDto = new App10ElvlrtDto();
    List<App10ElvlrtDto> app10DtoList = new ArrayList<>();
    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());


    // veiw page tb_401
    @GetMapping(value="/p001tab01")
    public Object App01001Tab01Form( @RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate
            , @RequestParam("changeop") String changeop
            , Model model
            , HttpServletRequest request) throws  Exception{

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        String ls_custcd = userformDto.getCustcd();
        String ls_spjangcd = userformDto.getSpjangcd();
        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate =  ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate =  ls_yeare + ls_mm + ls_dd;
        app10tDto.setFrdate(frdate);
        app10tDto.setTodate(todate);
        app10tDto.setChangeop(changeop);
        app10tDto.setCustcd(ls_custcd);
        app10tDto.setSpjangcd(ls_spjangcd);

        try {
            app10DtoList = service.GetApp10List001(app10tDto);
            model.addAttribute("app10DtoList",app10DtoList);

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
        return app10DtoList;
    }


    // veiw page tb_401,601
    @GetMapping(value="/p001tab02")
    public Object App03001Tab02Form( @RequestParam("stdate") String stdate
            , @RequestParam("enddate") String enddate
            , @RequestParam("comp") String comp
            , Model model
            , HttpServletRequest request) throws  Exception{

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        String ls_custcd = userformDto.getCustcd();
        String ls_spjangcd = userformDto.getSpjangcd();
        String ls_yeare = stdate.substring(0,4);
        String ls_mm = stdate.substring(5,7);
        String ls_dd = stdate.substring(8,10);
        stdate =  ls_yeare + ls_mm + ls_dd;
        ls_yeare = enddate.substring(0,4);
        ls_mm = enddate.substring(5,7);
        ls_dd = enddate.substring(8,10);
        enddate =  ls_yeare + ls_mm + ls_dd;
        app10tDto.setStdate(stdate);
        app10tDto.setEnddate(enddate);
        app10tDto.setComp(comp);
        app10tDto.setCustcd(ls_custcd);
        app10tDto.setSpjangcd(ls_spjangcd);

        try {
            app10DtoList = service.GetApptab10List001(app10tDto);
            model.addAttribute("app10DtoList",app10DtoList);
        }catch (DataAccessException e) {
            log.info("App10001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App10001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app10DtoList;
    }


    //save
    @RequestMapping(value = "/save")
    public String memberSave(@RequestPart(value = "key") Map<String, Object> param
            , Model model
            , HttpServletRequest request){

        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();


            param.forEach((key, values) -> {
                switch (key) {
                    case "recedatez":
                        app10tDto.setRecedate(values.toString());
                        break;
                    case "recetimez":
                        app10tDto.setRecetime(values.toString());
                        break;
                    case "recenumz":
                        app10tDto.setRecenum(values.toString());
                        break;
                    case "actcdz":
                        app10tDto.setActcd(values.toString());
                        break;
                    case "actnmz":
                        app10tDto.setActnm(values.toString());
                        break;
                    case "equpcdz":
                        app10tDto.setEqupcd(values.toString());
                        break;
                    case "equpnmz":
                        app10tDto.setEqupnm(values.toString());
                        break;
                    case "actcontcdz":
                        app10tDto.setContcd(values.toString());
                        break;
                    case "contnmz":
                        app10tDto.setContnm(values.toString());
                        break;
                    case "contentsz":
                        app10tDto.setContents(values.toString());
                        break;
                    case "peridz":
                        app10tDto.setPerid(values.toString());
                        break;
                    case "actperidz":
                        app10tDto.setActperid(values.toString());
                        break;
                    case "inperidz":
                        app10tDto.setInperid(values.toString());
                        break;
                    case "indatez":
                        app10tDto.setIndate(values.toString());
                        break;
                    case "actcompdatez":
                        app10tDto.setCompdate(values.toString());
                        break;
                    case "actcomptimez":
                        app10tDto.setComptime(values.toString());
                        break;
                    case "resutimez":
                        app10tDto.setResutime(values.toString());
                        break;
                    case "resultcdz":
                        app10tDto.setResultcd(values.toString());
                        break;
                    case "arrivdatez":
                        app10tDto.setArrivdate(values.toString());
                        break;
                    case "actarrivtimez":
                        app10tDto.setArrivtime(values.toString());
                        break;
                    case "gregicdz":
                        app10tDto.setGregicd(values.toString());
                        break;
                    case "regicdz":
                        app10tDto.setRegicd(values.toString());
                        break;
                    case "divicdz":
                        app10tDto.setDivicd(values.toString());
                        break;
                    case "faccdz":
                        app10tDto.setFaccd(values.toString());
                        break;
                    case "remocdz":
                        app10tDto.setRemocd(values.toString());
                        break;
                    case "resucdz":
                        app10tDto.setResucd(values.toString());
                        break;
                    case "remoremarkz":
                        app10tDto.setRemoremark(values.toString());
                        break;
                    case "resuremarkz":
                        app10tDto.setResuremark(values.toString());
                        break;
                    case "greginmz":
                        app10tDto.setGreginm(values.toString());
                        break;
                    case "reginmz":
                        app10tDto.setReginm(values.toString());
                        break;
                    case "remonmz":
                        app10tDto.setRemonm(values.toString());
                        break;
                    case "facnmz":
                        app10tDto.setFacnm(values.toString());
                        break;
                    case "resultnmz":
                        app10tDto.setResultnm(values.toString());
                        break;
                    case "resunmz":
                        app10tDto.setResunm(values.toString());
                        break;
                    case "remarkz":
                        app10tDto.setRemark(values.toString());
                        break;
                    default:
                        break;
                }
            });

            log.info(app10tDto);
            app10tDto.setCustcd(ls_custcd);
            app10tDto.setSpjangcd(ls_spjangcd);
            app10tDto.setInputdate(getToDate());
            String compnum = app10tDto.getCompnum();
            String compdate = app10tDto.getCompdate();
            boolean result = false;

            if (compnum == null || compnum.equals("")) {
                app10tDto.setCompnum(CountSeq(compdate));
                result = service.Insert10Manu(app10tDto);
                if (!result) {
                    return "error";
                }
            } else {
                app10tDto.setCompnum(compnum);
                result = service.Update10Manu(app10tDto);
            }
            result = service.Updateresult1(app10tDto);

            model.addAttribute("userformDto",userformDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        String ls_compnum = app10tDto.getCompnum();
        return ls_compnum;
    }
    @RequestMapping("/del")
    public String mmnualDelete(@RequestParam("compnum") String compnum,
                               @RequestParam("compdate") String compdate,
                               @RequestParam("recenum") String recenum,
                               @RequestParam("recedate") String recedate
                                , Model model
                                , HttpServletRequest request){
        boolean result = false;

        try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            app10tDto.setCompdate(compdate);
            app10tDto.setCompnum(compnum);
            app10tDto.setRecenum(recenum);
            app10tDto.setRecedate(recedate);
            app10tDto.setCustcd(ls_custcd);
            app10tDto.setSpjangcd(ls_spjangcd);

            result = service.Delete10Manu(app10tDto);
            if(!result){
                return "error";
            }
            result = service.Updateresult0(app10tDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return "success";
    }


    public String CountSeq(String compdate){
        String ls_compnum = service.get10ManualMaxSeq(compdate);

        int ll_compnum = 0;
        if(ls_compnum == null){
            ls_compnum = "001";
        }else{
            ll_compnum = Integer.parseInt(ls_compnum);
            log.info(ll_compnum);
            if(ll_compnum > 8) {
                ls_compnum = "0" + Integer.toString(ll_compnum + 01);
            }else{
                ls_compnum = "00" + Integer.toString(ll_compnum + 01);
            }
        }
        return ls_compnum;
    }

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
