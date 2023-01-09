package com.actas.ems.controller.app10;


import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App10ElvlrtService;
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
@RequestMapping(value = "/app10", method = RequestMethod.POST)
public class App10RetrieveController {
    private final App10ElvlrtService service;

    PopupDto popParmDto = new PopupDto();
    App10ElvlrtDto app10tDto = new App10ElvlrtDto();
    List<App10ElvlrtDto> app10DtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    // 고장내용별현황 > 기간별 고장내용
    @GetMapping(value="/p001tab01")
    public Object App01001Tab01Form( @RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate
            , @RequestParam("actcdz") String actcd
            , @RequestParam("opchange") String resultck
            , Model model) throws  Exception{

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
        app10tDto.setActcd(actcd);
        app10tDto.setResultck(resultck);
        try {
            app10DtoList = service.GetApp10List001(app10tDto);
                for(int i=0; i< app10DtoList.size(); i++){
                if(app10DtoList.get(i).getResultck().equals("0")){
                    app10DtoList.get(i).setResultck("0");
                }else{
                    app10DtoList.get(i).setResultck("1");
                }
            }
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
//
//// 고장내용별현황 > 현장별 고장내용
//@GetMapping(value = "/p001tab02")
//public Object App10001Tab02Form(@RequestParam("frdate") String frdate
//        , @RequestParam("todate") String todate
//        , @RequestParam("actcdz") String actcd
//        , @RequestParam("actcontcdz") String contcd
//        , Model model) throws Exception {
//
//    String ls_yeare = frdate.substring(0, 4);
//    String ls_mm = frdate.substring(5, 7);
//    String ls_dd = frdate.substring(8, 10);
//    frdate = ls_yeare + ls_mm + ls_dd;
//    ls_yeare = todate.substring(0, 4);
//    ls_mm = todate.substring(5, 7);
//    ls_dd = todate.substring(8, 10);
//    todate = ls_yeare + ls_mm + ls_dd;
//    app10tDto.setFrdate(frdate);
//    app10tDto.setTodate(todate);
//    app10tDto.setActcd(actcd);
//    app10tDto.setContcd(contcd);
//    try {
//        app10DtoList = service.GetApp03List002(app10tDto);
//        model.addAttribute("app10DtoList", app10DtoList);
//    } catch (DataAccessException e) {
//        log.info("App03001Tab01Form DataAccessException ================================================================");
//        log.info(e.toString());
//        throw new AttachFileException(" DataAccessException to save");
//        //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
//    } catch (Exception ex) {
//    //            dispatchException = ex;
//        log.info("App03001Tab01Form Exception ================================================================");
//        log.info("Exception =====>" + ex);
//        log.debug("Exception =====>" + ex);
//    }
//    return app10DtoList;
//}


    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
