package com.actas.ems.controller.app10;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App10ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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


    // veiw page tb_401
    @GetMapping(value="/p001tab01")
    public Object App01001Tab01Form( @RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate
            , @RequestParam("changeop") String changeop
            , Model model
            , HttpServletRequest request) throws  Exception{

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        String ls_custcd = userformDto.getCustcd();
        String ls_spjangcd = userformDto.getSpjangcd();
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
        app10tDto.setChangeop(changeop);
        app10tDto.setCustcd(ls_custcd);
        app10tDto.setSpjangcd(ls_spjangcd);

        try {
            app10DtoList = service.GetApp10List001(app10tDto);
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

    //save , tb_411

    @RequestMapping(value = "/save")
    public String memberSave( @RequestPart(value = "key") Map<String, Object> param
            , Model model
            , HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        String ls_custcd = userformDto.getCustcd();
        String ls_spjangcd = userformDto.getSpjangcd();

        param.forEach((key, values) -> {
            switch (key) {
                case "compnumz":
                    app10tDto.setCompnum(values.toString());
                    break;
                case "actperidz":
                    app10tDto.setActperid(values.toString());
                    break;
                case "peridz":
                    app10tDto.setPerid(values.toString());
                    break;
                case "arrivdatez":
                    app10tDto.setArrivdate(values.toString());
                    break;
                case "actcompdatez":
                    app10tDto.setCompdate(values.toString());
                    break;
                case "actarrivtimez":
                    app10tDto.setArrivtime(values.toString());
                    break;
                case "actcomptimez":
                    app10tDto.setComptime(values.toString());
                    break;
                case "remoremarkz":
                    app10tDto.setRemoremark(values.toString());
                    break;
                case "resuremarkz":
                    app10tDto.setResuremark(values.toString());
                    break;
                case "remarkz":
                    app10tDto.setRemark(values.toString());
                    break;
                case "resutimez":
                    app10tDto.setResutime(values.toString());
                    break;
                case "inputdatez":
                    app10tDto.setInputdate(values.toString());
                    break;
                case "inputperidz":
                    app10tDto.setInperid(values.toString());
                    break;
                default:
                    break;
            }
        });

        String compnum = app10tDto.getCompnum();
        String compdate = app10tDto.getCompdate();
        app10tDto.setCustcd(ls_custcd);
        app10tDto.setSpjangcd(ls_spjangcd);
        app10tDto.setInperid(userformDto.getUsername());
        String inputdate = app10tDto.getInputdate();
        String ls_yeare = inputdate.substring(0, 4);
        String ls_mm = inputdate.substring(5, 7);
        String ls_dd = inputdate.substring(8, 10);
        inputdate = ls_yeare + ls_mm + ls_dd;
        app10tDto.setInputdate(inputdate);
        if (compnum == null || compnum.equals("")) {
            app10tDto.setCompnum(CountSeq(compdate));
        } else {
            app10tDto.setCompnum(compnum);
        }
        app10tDto.setCompdate(ls_yeare + ls_mm);
        log.info(app10tDto); //consolelog에 app04Dto 호출
        if (compnum == null || compnum.equals("")) {
            boolean result = service.Insert10Manu(app10tDto);
            if (!result) {
                return "error";
            }
        } else {
            boolean result = service.Update10Manu(app10tDto);
            if (!result) {
                return "error";
            }
        }
        try {

        model.addAttribute("userformDto", userformDto);
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
        return "/p001tab01";
    }




 //날짜

    public String CountSeq(String compdate){
        String ls_compnum = service.get10ManualMaxSeq(compdate);
        app10tDto.setCompdate(compdate);
        int ll_compnum = 0; //순번이 0번이면~
        if(ls_compnum == null){
            ls_compnum = "001";
        }else{
            ll_compnum = Integer.parseInt(ls_compnum);
            ls_compnum = Integer.toString(ll_compnum + 001);
        }
        return ls_compnum;
    }

//    public String Dd(){
//        String ls_changeop = app10tDto.getChangeop();
//        if(ls_changeop == "0"){
//            ls_changeop = "1";
//        }else(ls_changeop == "1"){
//            ls_changeop = "0";
//        }
//        return ls_changeop;
//    }
    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
