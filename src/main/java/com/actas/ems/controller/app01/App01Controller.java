package com.actas.ems.controller.app01;

import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppCallElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.elvlrt.AppPopElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/app01", method = RequestMethod.POST)
@Controller
@RequiredArgsConstructor
public class App01Controller {
    private final App01ElvlrtService app01ElvlrtService;
    UserFormDto userformDto = new UserFormDto();
    PopupDto popParmDto = new PopupDto();
    List<PopupDto> poplistDto = new ArrayList<>();
    PopupDto popsmsinfoDto = new PopupDto();

    List<App03ElvlrtDto> app03DtoList01 = new ArrayList<>();
    List<App03ElvlrtDto> app03DtoList02 = new ArrayList<>();
    List<App03ElvlrtDto> app03DtoList03 = new ArrayList<>();
    List<App03ElvlrtDto> app03DtoList04 = new ArrayList<>();
    List<App03ElvlrtDto> app03DtoList05 = new ArrayList<>();

    private final App01ElvlrtService service;
    private final AppPopElvlrtService appPopElvlrtService;
    protected Log log =  LogFactory.getLog(this.getClass());

    // kt call dashboard
    @GetMapping(value="/ktcall")
    public String App01Form(Model model , HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        if(!request.isRequestedSessionIdValid()){
            try {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter w = response.getWriter();
                w.write("<script>alert('로그인세션이 만료됐습니다.');</script>");
                w.flush();
                w.close();
                throw new Exception(); //강제 에러 출력
            } catch(Exception e) {
                e.printStackTrace();
                return "loginForm";
            }
        }
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
//        userformDto.setUserid(userid);
//        userformDto.setUsername(username);
//        userformDto.setCltcd(cltcd);
//        userformDto.setDbnm(dbnm);
//        userformDto.setFlag(flag);
//        userformDto.setCalluserid(calluserid);
//        userformDto.setCalluserpw(calluserpw);
        model.addAttribute("userformDto", userformDto);
        model.addAttribute("callid", userformDto.getCalluserid());
        model.addAttribute("callpw", userformDto.getCalluserpw());

        return "app01/KtcallMAIN";
    }

    // kt call dashboard
    @GetMapping(value="/ktcalltemp")
    public String App01TempForm(  Model model
            , HttpServletRequest request){
        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        userformDto.setPagetree01("종합유지관리서비스");
        userformDto.setPagenm("고객상담센터");
        model.addAttribute("userformDto",userformDto);



        String todate = getToDate();
        String frdate =  getToDate();
        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd("%");
        popParmDto.setPernm("%");

        try {
            app03DtoList01 = service.GetApp01List001(popParmDto);
            model.addAttribute("app03DtoList01",app03DtoList01);
            app03DtoList02 = service.GetApp01List002(popParmDto);
            model.addAttribute("app03DtoList02",app03DtoList02);
            app03DtoList03 = service.GetApp01List003(popParmDto);
            model.addAttribute("app03DtoList03",app03DtoList03);
            app03DtoList04 = service.GetApp01List001(popParmDto);
            model.addAttribute("app03DtoList",app03DtoList04);
            poplistDto = appPopElvlrtService.GetPernmList(popParmDto);
            model.addAttribute("wperidDto", poplistDto);
            popsmsinfoDto = appPopElvlrtService.GetSmsInfoList(popParmDto);
            model.addAttribute("popsmsinfoDto", popsmsinfoDto);
            popParmDto.setYyyymm(frdate.substring(0,4));
            popParmDto.setPernm("%");
            app03DtoList05 = service.GetApp01List006(popParmDto);
            model.addAttribute("appSMSDtoList",app03DtoList05);

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
        return "app01/appkt";
    }

    // 관제 dashboard
    @GetMapping(value="/emcontrol")
    public String App01ControlForm(  Model model
            , HttpServletRequest request){
        String todate = getToDate();
//        String ls_yeare = todate.substring(0,4);
//        String ls_mm = todate.substring(4,6);
//        String ls_mm = todate.substring(4,6);
        String frdate =  getToDate();
        popParmDto.setFrdate(frdate);
        popParmDto.setTodate(todate);
        popParmDto.setActcd("%");
        try {
            app03DtoList01 = service.GetApp01List001(popParmDto);
            model.addAttribute("app03DtoList",app03DtoList01);
            app03DtoList02 = service.GetApp01List002(popParmDto);
            model.addAttribute("app03DtoList02",app03DtoList02);
            app03DtoList03 = service.GetApp01List003(popParmDto);
            model.addAttribute("app03DtoList03",app03DtoList03);

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

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        userformDto.setPagetree01("고객상담센터");
        userformDto.setPagenm("고장접수관제센터");
        model.addAttribute("userformDto",userformDto);
        return "app01/emcontrol";
    }


    // 관제현황 > 접수조회
    @GetMapping(value="/emconlist")
    public Object App01001EmconlistForm( @RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate
            , @RequestParam("actnmz") String actnmz
            , @RequestParam("page")   String page
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
        popParmDto.setActcd(actnmz);
        try {
            app03DtoList01 = service.GetApp01List001(popParmDto);
            model.addAttribute("app03DtoList",app03DtoList01);
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
        if (page.equals("encon")) {
            return "app01/emcontrollist01";
        }else if (page.equals("appkt")) {
            return "app01/appktlist01";
        } else {
            return "app01/emcontrollist01";
        }
    }


    // 관제현황 > 접수조회
    @GetMapping(value="/emtellist")
    public Object App01001EmtellistForm( @RequestParam("frdate") String frdate
            , @RequestParam("callnm") String callnm
            , Model model) throws  Exception{

        String ls_yeare = frdate.substring(0,4);
        String ls_mm = frdate.substring(5,7);
        String ls_dd = frdate.substring(8,10);
        frdate =  ls_yeare + ls_mm + ls_dd;
        popParmDto.setFrdate(frdate);
        popParmDto.setActcd(callnm);
        try {
            app03DtoList01 = service.GetApp01List005(popParmDto);
            model.addAttribute("app03TelList",app03DtoList01);
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
        return "app01/apptellist01";

    }



    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
