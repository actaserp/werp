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
                    System.out.println("date : "+ popParmDto.getRptdate());
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
                    System.out.println(appE038DtoList);
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
}
