package com.actas.ems.controller.app16;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App16.App16ElvlrtService;
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
@RequestMapping(value = "/app16", method = RequestMethod.POST)
public class App16RetrieveController {

    private final App16ElvlrtService service;

    PopupDto popParmDto = new PopupDto();

    List<App16ElvlrtDto> app16DtoList = new ArrayList<>();
    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    @GetMapping(value = "/p001tab01")
    public Object App1601TabForm(@RequestParam("frdate")  String frdate,
                                 @RequestParam("todate") String todate,
                                 @RequestParam(value = "actcdz", required = false) String actcd,
                                 Model model, HttpServletRequest request)throws Exception{
        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate = ls_yeare + ls_mm + ls_dd;

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        model.addAttribute("userformDto", userformDto);
        log.info(userformDto.getActcd());

        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        if(userformDto.getFlag().equals("AA")){
            popParmDto.setActcd(actcd);
        }else{
            if(userformDto.getActcd().equals("") || userformDto.getActcd() == null){
                popParmDto.setActcd(actcd);
                log.info("이 사용자는 보수업체용이다.");
            }else{
                popParmDto.setActcd(userformDto.getActcd());
                log.info("이 사용자는 고객용계정이다.");
            }
        }

        try{
            app16DtoList = service.GetApp16List(popParmDto);
            model.addAttribute("app16DtoList", app16DtoList);

        }catch (DataAccessException e){
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
        }catch (Exception ex){
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());

        }
        return app16DtoList;

    }
    /*
    private String getTodate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
*/
}
