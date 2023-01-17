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


    // 고장내용별현황 > 현장별 고장내용
    @GetMapping(value="/p001tab02")
    public Object App03001Tab02Form( @RequestParam("frdate") String frdate
            , @RequestParam("todate") String todate
            , @RequestParam("actcdz") String actcd
            , @RequestParam("actcontcdz") String contcd
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
        app10tDto.setContcd(contcd);
        try {
            app10DtoList = service.GetApptab10List001(app10tDto);
            model.addAttribute("app10DtoList",app10DtoList);
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
        return app10DtoList;
    }


    //save
    @RequestMapping(value = "/save")
    public String memberSave(@RequestParam("compnumz") String compnum //seq
//                             compdate 고장일자 = 등록일자
            , @RequestParam("actperidz") String actperid //담당자 코드
            , @RequestParam("peridz") String perid //처리자 코드
            , @RequestParam("arrivdatez") String arrivdate //도착일자
            , @RequestParam("actcompdatez") String compdate //고장일자
            , @RequestParam("actarrivtimez") String arrivtime //도착시간
            , @RequestParam("actcomptimez") String comptime //완료시간
            , @RequestParam("remoremarkz") String remoremark //고장상세원인
            , @RequestParam("resuremarkz") String resuremark //처리내용상세
            , @RequestParam("remarkz") String remark //고객 요망사항
            , @RequestParam("resutimez") String resutime //대응시간
            , @RequestParam("resultckz") String resultck
            , Model model, HttpServletRequest request){

        try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            String recedate = getToDate(); //접수일자 recedate
            String ls_yeare = recedate.substring(0,4);
            String ls_mm = recedate.substring(4,6);
            app10tDto.setCustcd(ls_custcd);
            app10tDto.setSpjangcd(ls_spjangcd);
            app10tDto.setInperid(userformDto.getPerid());
            if(compnum == null || compnum.equals("")){
                app10tDto.setCompnum(CountSeq(compdate));
            }else{
                app10tDto.setCompnum(compnum);
            }
            app10tDto.setActperid(actperid);
            app10tDto.setPerid(perid);
            app10tDto.setArrivdate(arrivdate);
            app10tDto.setCompdate(compdate);
            app10tDto.setArrivtime(arrivtime);
            app10tDto.setComptime(comptime);
            app10tDto.setRemoremark(remoremark);
            app10tDto.setResuremark(resuremark);
            app10tDto.setRemark(remark);
            app10tDto.setInputdate(getToDate());
            app10tDto.setIndate(getToDate());
            app10tDto.setResultck(resultck);
            log.info(app10tDto); //consolelog에 app04Dto 호출
            boolean result = false;
            if(compnum == null || compnum.equals("")){
                switch(app10tDto.getChangeop()) {
                    case "0":
                        result = service.Insert10Manu(app10tDto);
                        break;
                    case "1":
                        result = service.Update10Manu(app10tDto);
                        break;
                    default:
                        break;
                }
                if (!result) {
                    return "error";
                }
            }
            model.addAttribute("userformDto",userformDto);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return "app10/p001tab01";
    }
    public String CountSeq(String compdate){
        String ls_compnum = service.get10ManualMaxSeq(compdate);
        int ll_compnum = 0;
        if(ls_compnum == null){
            ls_compnum = "001";
        }else{
            ll_compnum = Integer.parseInt(ls_compnum);
            ls_compnum = Integer.toString(ll_compnum + 001);
        }
        return ls_compnum;
    }

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
