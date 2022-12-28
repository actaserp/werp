package com.actas.ems.controller.app00;

import com.actas.ems.DTO.Elvlrt.App00ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App00ElvlrtService;
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
@RequestMapping(value = "/app00", method = RequestMethod.POST)
public class App00RetrieveController {

    private final App00ElvlrtService service;

    PopupDto popParmDto = new PopupDto();

    List<App00ElvlrtDto> app00DtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    @GetMapping(value = "/p001tab01")
    public Object App00001TabForm(@RequestParam("frdate")String frdate
                                    , @RequestParam("todate") String todate
                                    , @RequestParam("actnm") String actnm
                                    , Model model)throws Exception{

        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate = ls_yeare + ls_mm + ls_dd;

        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActnm(actnm);
        try{
            app00DtoList = service.GetApp00List001(popParmDto);
            model.addAttribute("app00DtoList", app00DtoList);
            log.info(app00DtoList);
        }catch (DataAccessException e){
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
        }catch (Exception ex){
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());

        }
        return app00DtoList;
    }

    private String getTodate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }





}
