package com.actas.ems.controller.app13;


import com.actas.ems.DTO.Elvlrt.App13ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App13ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app13", method = RequestMethod.POST)
public class App13RetrieveController {


    private final App13ElvlrtService service;

    PopupDto popParmDto = new PopupDto();
    List<App13ElvlrtDto> app13DtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log = LogFactory.getLog(this.getClass());

    //기간별
    @GetMapping(value = "/p001tab01")
    public Object App13001Tab01Form(@RequestParam("frdate") String frdate,
                                    @RequestParam("todate") String todate,
                                    @RequestParam("actcdz") String actcd,
                                    @RequestParam("actresucdz") String resucd,
                                    @RequestParam("actremocd") String remocd,
                                    @RequestParam("actgregicd") String gregicd,
                                    @RequestParam("actresultcd") String resultcd,
                                    Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
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
        popParmDto.setResucd(resucd);
        popParmDto.setRemocd(remocd);
        popParmDto.setGregicd(gregicd);
        popParmDto.setResultcd(resultcd);
        try {
            app13DtoList = service.GetApp13List001(popParmDto);
            model.addAttribute("app13DtoList", app13DtoList);

        } catch (DataAccessException e){
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app13DtoList;
    }


}
