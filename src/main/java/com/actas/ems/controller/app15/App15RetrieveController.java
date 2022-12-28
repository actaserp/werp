package com.actas.ems.controller.app15;


import com.actas.ems.DTO.Elvlrt.App15ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App15.App15ElvlrtService;
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
@RequestMapping(value = "/app15", method = RequestMethod.POST)
public class App15RetrieveController {

    private final App15ElvlrtService service;

    PopupDto popParmDto = new PopupDto();

    List<App15ElvlrtDto> app15DtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log = LogFactory.getLog(this.getClass());

    //기간별
    @GetMapping(value = "/p001tab01")
    public Object App15001Tab01Form(@RequestParam("frdate") String frdate,
                                    @RequestParam("todate") String todate,
                                    @RequestParam("actcdz") String actcd,
                                    Model model
                                    ) throws Exception {
        String ls_yeare = frdate.substring(0, 4);
        String ls_mm = frdate.substring(5, 7);
        String ls_dd = frdate.substring(8, 10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0, 4);
        ls_mm = todate.substring(5, 7);
        ls_dd = todate.substring(8, 10);
        todate = ls_yeare + ls_mm + ls_dd;
        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(actcd);
        try {
            app15DtoList = service.GetApp15List001(popParmDto);
            model.addAttribute("app15DtoList", app15DtoList);

        }catch (DataAccessException e){
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app15DtoList;
    }
    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }

}
