package com.actas.ems.controller.appmobile;

import com.actas.ems.DTO.Elvlrt.AppE038ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.AppE038ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/e038mbc", method = RequestMethod.POST)
public class E038MbController {

    private final AppE038ElvlrtService service;

    List<AppE038ElvlrtDto> appE038DtoList = new ArrayList<>();
    UserFormDto userformDto = new UserFormDto();
    PopupDto popParmDto = new PopupDto();

    protected Log log =  LogFactory.getLog(this.getClass());

    String ls_custcd = "";
    String ls_spjangcd = "";


    @RequestMapping(value = "/list", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object e038List(@RequestParam Map<String, String> param,
                                Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        //현재날짜기준 월초(1일) 구하기
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        System.out.println("time : "+time);


        String minusYear = AddDate(time, -2, 0, 0);


        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    popParmDto.setDbnm(values.toString());
                    break;
                case "date":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setRptdate(values.toString());
                    break;
                case "perid":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setPerid(values.toString());
                    break;
                case "actnm":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setActnm(values.toString());
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
                    appE038DtoList = service.GetE038List(popParmDto);
                    model.addAttribute("E038List_model", appE038DtoList);

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
        return appE038DtoList;
    }

    @RequestMapping(value = "/getActInfo", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object getActInfo(@RequestParam Map<String, String> param,
                           Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    popParmDto.setDbnm(values.toString());
                    break;
                case "actnm":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setActnm(values.toString());
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

                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT

                try{
                    appE038DtoList = service.GetActList(popParmDto);
                    model.addAttribute("E038List_model", appE038DtoList);

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
        return appE038DtoList;
    }

    @RequestMapping(value = "/getCarInfo", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object getCarInfo(@RequestParam Map<String, String> param,
                             Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    popParmDto.setDbnm(values.toString());
                    break;
                case "carnum":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setCarnum(values.toString());
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

                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT

                try{
                    appE038DtoList = service.GetCarList(popParmDto);
                    model.addAttribute("E038List_model", appE038DtoList);

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
        return appE038DtoList;
    }

    @RequestMapping(value = "/getEqupInfo", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object getEqupInfo(@RequestParam Map<String, String> param,
                             Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    popParmDto.setDbnm(values.toString());
                    break;
                case "actcd":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setActcd(values.toString());
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

                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT

                try{
                    appE038DtoList = service.GetEqupList(popParmDto);
                    model.addAttribute("E038List_model", appE038DtoList);

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
        return appE038DtoList;
    }

    @RequestMapping(value = "/insertE038", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String insertE038(@RequestParam Map<String, String> param,
                              Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    popParmDto.setDbnm(values.toString());
                    break;
                case "rptdate":
                    popParmDto.setRptdate(values.toString());
                    break;
                case "actcd":
                    popParmDto.setActcd(values.toString());
                    break;
                case "equpcd":
                    popParmDto.setEqupcd(values.toString());
                    break;
                case "carcd":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setCarcd(values.toString());
                    break;
                case "frtime":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setFrtime(values.toString());
                    break;
                case "totime":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setTotime(values.toString());
                    break;
                case "remark":
                    if(values == ""){
                        values = "%";
                    }
                    popParmDto.setRemark(values.toString());
                    break;
                case "perid":
                    popParmDto.setPerid(values.toString());
                    break;
                case "actnm":
                    popParmDto.setActnm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        String rptdate = popParmDto.getRptdate();
        String ls_yeare = rptdate.substring(0,4);
        System.out.println(ls_yeare);
        String ls_mm = rptdate.substring(4,6);
        System.out.println(ls_mm);
        String ls_dd = rptdate.substring(6,8);
        popParmDto.setRptdate(rptdate);
        String rptnum = popParmDto.getRptnum();
        System.out.println("ls_year:"+ls_yeare+",   ls_mm:"+ls_mm+",    ls_dd:"+ls_dd);

//        String hseq = "";
        popParmDto.setYyyymm(ls_yeare + ls_mm + ls_dd);
        popParmDto.setRptnum(CountSeq(ls_yeare + ls_mm + ls_dd));


        ls_spjangcd = "ZZ";

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";

                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT

                try{
                    boolean result = service.InsertE038(popParmDto);
                    popParmDto.setRptnum(null);

                    if(!result){
                        return "error";
                    }

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
        return "success";
    }

    @RequestMapping(value = "/updateE038", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String updateE038(@RequestParam Map<String, String> param,
                             Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    popParmDto.setDbnm(values.toString());
                    break;
                case "rptnum":
                    popParmDto.setRptnum(values.toString());
                    break;
                case "actcd":
                    popParmDto.setActcd(values.toString());
                    break;
                case "actnm":
                    popParmDto.setActnm(values.toString());
                    break;
                case "equpcd":
                    popParmDto.setEqupcd(values.toString());
                    break;
                case "carcd":
                    popParmDto.setCarcd(values.toString());
                    break;
                case "remark":
                    popParmDto.setRemark(values.toString());
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

                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT

                try{
                    boolean result = service.UpdateE038(popParmDto);

                    if(!result){
                        return "error";
                    }

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
        return "success";
    }

    @RequestMapping(value = "/deleteE038", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String deleteE038(@RequestParam Map<String, String> param,
                             Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    popParmDto.setDbnm(values.toString());
                    break;
                case "rptnum":
                    popParmDto.setRptnum(values.toString());
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

                popParmDto.setSpjangcd(ls_spjangcd); // ZZ
                popParmDto.setCustcd(ls_custcd); //ELVLRT

                try{
                    boolean result = service.DeleteE038(popParmDto);

                    if(!result){
                        return "error";
                    }

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
        return "success";
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

    public synchronized String CountSeq(String yyyymm) {
        String ls_rptnum = service.getE038MaxSeq(yyyymm);
        int ll_nseq = 0;
        if (ls_rptnum == null) {
            ls_rptnum = "001";
        } else {
            System.out.println("ls_rptnum1:" + ls_rptnum);
            ll_nseq = Integer.parseInt(ls_rptnum);
            System.out.println("ll_nseq:" + ll_nseq);
            ls_rptnum = String.format("%03d", ll_nseq + 1);
            System.out.println("ls_rptnum2:" + ls_rptnum);
        }
        return ls_rptnum;
    }
}
