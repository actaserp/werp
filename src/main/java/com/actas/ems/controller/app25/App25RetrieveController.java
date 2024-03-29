package com.actas.ems.controller.app25;


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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app25", method = RequestMethod.POST)
public class App25RetrieveController {


    private final App15ElvlrtService service;

    PopupDto popParmDto = new PopupDto();
    List<App15ElvlrtDto> app15DtoList2 = new ArrayList<>();
    private final App15ElvlrtService service2;

    List<App15ElvlrtDto> app15DtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log = LogFactory.getLog(this.getClass());

    @GetMapping(value = "/p001tab01")
    public Object App25001Tab01Form(@RequestParam("frdate") String frdate,
                                    @RequestParam("todate") String todate,
                                    @RequestParam("actcdz") String actcd,
                                    Model model, HttpServletRequest request) throws Exception{

        String ls_yeare = frdate.substring(0, 4);
        String ls_mm = frdate.substring(5, 7);
        String ls_dd = frdate.substring(8, 10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0, 4);
        ls_mm = todate.substring(5, 7);
        ls_dd = todate.substring(8, 10);
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
            }else{
                popParmDto.setActcd(userformDto.getActcd());
            }
        }

        try{
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

    //고객메인화면 당월고장접수현황 조회시
    @GetMapping(value="/p001tab02")
    public Object App1601TabForm(@RequestParam("frdate")  String frdate,
                                 @RequestParam("todate") String todate,
                                 Model model, HttpServletRequest request){

        String ls_yeare = frdate.substring(0, 4);
        String ls_mm = frdate.substring(5, 7);
        String ls_dd = frdate.substring(8, 10);
        frdate = ls_yeare + ls_mm + ls_dd;
        ls_yeare = todate.substring(0, 4);
        ls_mm = todate.substring(5, 7);
        ls_dd = todate.substring(8, 10);
        todate = ls_yeare + ls_mm + ls_dd;

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        model.addAttribute("userformDto", userformDto);

        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd(userformDto.getActcd());

        try{
            app15DtoList2 = service2.GetApp15List006(popParmDto);
            model.addAttribute("app15DtoList2", app15DtoList2);

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
        return app15DtoList2;
    }

    @GetMapping(value="/p001tab03")
    public Object App03001Tab03Form(
             Model model, HttpServletRequest request,@RequestParam("frdate") String frdate,@RequestParam("todate") String todate, String actcd)
            throws  Exception{

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
        popParmDto.setActcd(userformDto.getActcd());
        try {
            app15DtoList2 = service2.GetApp15List007(popParmDto);
            model.addAttribute("app15DtoList2",app15DtoList2);
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
        return app15DtoList2;
    }
}
