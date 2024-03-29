package com.actas.ems.controller.app22;


import com.actas.ems.DTO.Elvlrt.App16ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App22.App22ElvlrtService;
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
@RequestMapping(value = "/app22", method = RequestMethod.POST)
public class App22RetrieveController {

    private final App22ElvlrtService service;

    PopupDto popParmDto = new PopupDto();

    List<App16ElvlrtDto> app16DtoList = new ArrayList<>();
    UserFormDto userFormDto = new UserFormDto();
    protected Log log  = LogFactory.getLog(this.getClass());

    @GetMapping(value = "/p001tab01")
    public Object App2201TabForm(@RequestParam("frdate") String frdate,
                                 @RequestParam("todate") String todate,
                                 Model model, HttpServletRequest request)throws Exception{
        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0,4);
        ls_mm = todate.substring(5,7);
        ls_dd = todate.substring(8,10);
        todate = ls_yeare + ls_mm + ls_dd;
       /* dwdwdwdwdwdwdwa (ArrayList 찾기)*/

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(userformDto.getActcd());
        try{
            app16DtoList = service.GetApp22List(popParmDto);
            model.addAttribute("app16DtoList", app16DtoList);
            log.info(app16DtoList);
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

    @GetMapping(value = "/p001tab02")
    public Object App22001Tab02Form( @RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate

            , Model model, HttpServletRequest request) throws  Exception{


        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

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
        popParmDto.setActcd(userformDto.getActcd());
        try {
            app16DtoList = service.GetApp22List002(popParmDto);
            model.addAttribute("app22DtoList",app16DtoList);
        }catch (DataAccessException e) {
            log.info("App03001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App03001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app16DtoList;
    }
}
