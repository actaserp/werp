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
            , @RequestParam("todate") String todate
            , @RequestParam("actcdz") String actcd
            , @RequestParam("actgregicdz") String gregicd
            , @RequestParam("actremocdz") String remocd
            , @RequestParam("actresucdz") String resucd
            , @RequestParam("actresultcdz") String resultcd
            , @RequestParam("actqtyz") int qtyz
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
        popParmDto.setGregicd(gregicd);
        popParmDto.setRemocd(remocd);
        popParmDto.setResucd(resucd);
        popParmDto.setResultcd(resultcd);
        popParmDto.setQty(qtyz);
        try {
            app26DtoList = service.GetApp26List001(popParmDto);
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
