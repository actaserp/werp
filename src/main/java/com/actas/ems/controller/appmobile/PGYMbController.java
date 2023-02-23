package com.actas.ems.controller.appmobile;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.*;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.*;
import com.actas.ems.Service.elvlrt.App27.App27ElvlrtService;

import com.actas.ems.controller.EncryptionController;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/apppgymobile", method = RequestMethod.POST)
public class PGYMbController {
    private final App10ElvlrtMobService service;
    private final App07ElvlrtService service2;
    private final App06ElvlrtMobService service06;
    private final AppPopElvlrtService appPopElvlrtService;
    UserFormDto userformDto = new UserFormDto();

    AttachDTO attachDTO = new AttachDTO();
    private final App07ElvlrtService appService;
    private final App07UploadServiceImpl appservice2;

    private  final App05UploadServiceImpl app05UploadService;

    private final App10ElvlrtService app10ElvlrtServiceservice;


    private final App10ElvlrtMobService app10ElvlrtMobService;

    private final App05ElvlrtService app05Service;
    App05ElvlrtDto app05Dto = new App05ElvlrtDto();
    App07ElvlrtDto app07Dto = new App07ElvlrtDto();

    App10ElvlrtDto app10tDto = new App10ElvlrtDto();

    App08_mbmanual app08_mbmanual = new App08_mbmanual();
    PopupDto popParmDto = new PopupDto();
    List<AppMob001tDto> appMobDtoList = new ArrayList<>();

    List<App16ElvlrtDto> app16DtoList = new ArrayList<>();



    List<PopupDto> poplistDto = new ArrayList<>();
    protected Log log =  LogFactory.getLog(this.getClass());
    String ls_custcd = "";
    String ls_spjangcd = "";




    /**박광열 승강기번호조회 리스트 **/
    @RequestMapping(value = "/getelvinfo_1", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object JA001ListForm(@RequestParam Map<String, String> param,
                                Model model, HttpServletRequest request) throws Exception{


        String elvnum = (String) param.get("elvnum");

        Object returnDto = "";
        try {
            String apikey = "ECeTFAnF2DoeYFYBFygeY%2BFt3GLMMzD9OsgSaEF2h0Qvw3KAhuNWCfczIDQgC4ucmlS6BbLWojlyYuhFRXgXcQ%3D%3D";
            String text = URLEncoder.encode(elvnum, "UTF-8");
            String apiURL = "http://openapi.elevator.go.kr/openapi/service/BuldElevatorService/getBuldElvtrList";
            String postParams = "serviceKey=" + apikey;
            postParams = postParams + "&elevator_no=" + text;
            apiURL = apiURL.trim().toString() + "?" + postParams.trim().toString();
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            //http 요청에 필요한 타입 정의 실시
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("GET");
//            con.setRequestProperty("Authorization", "serviceKey " + apikey);
//            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);


            con.setDoOutput(true);
            // DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            // wr.writeBytes(postParams);
            // wr.flush();
            // wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
//            System.out.println(response.toString());
            returnDto = response.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return returnDto;
    }




    /**박광열 점검조치사항 수정 **/
    @RequestMapping(value = "/update", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String UpdateListForm(@RequestParam Map<String, String> param,
                                 Model model, HttpServletRequest request) throws Exception{


        /*업로드 파일 정보를 담을 리스트*/
        List<AttachDTO> attachList = new ArrayList<>();

        param.forEach((key, values) -> {
            switch (key){
                case "fnsubject":
                    app07Dto.setFnsubject(values.toString());
                    break;
                case "fmemo":
                    app07Dto.setFmemo(values.toString());
                    break;
                case "fseq":
                    app07Dto.setFseq(values.toString());
                    break;
                case "fgourpcd":
                    app07Dto.setFgourpcd(values.toString());
                    break;
                case "fflag":
                    app07Dto.setFflag(values.toString());

                default:
                    break;
            }
        });



        try {

            boolean result = appService.UpdateMManu(app07Dto);


        } catch (Exception e) {
            System.out.println(e);
        }
        return "success";
    }


    /**파일 첨부*/
    //app06 to 03 첨부파일리스트
    @RequestMapping(value = "/attachMB", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object mhListAttach(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request) throws Exception{
        String ls_dbnm = "";
        String ls_fseq = "";
        String ls_fflag = "";
        List<AttachDTO>  attach =new ArrayList<>();
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "fflag":
                    app07Dto.setFflag(values.toString());
                    break;
                case "fseq":
                    app07Dto.setFseq(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                try {

                    attach = appservice2.MManuFilelist(app07Dto);
                    model.addAttribute("attachDto",attach);

                }catch (DataAccessException e) {
                    log.info("App06MobForm DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
                    //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
                }catch (Exception ex) {
//                dispatchException = ex;
                    log.info("App01001Tab01Form Exception ================================================================");
                    log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
                }
                break;
            case "ELV_KYOUNG":
                ls_custcd = "KYOUNG";
                break;
            case "hanyangs":
                ls_custcd = "hanyangs";
                break;
            default:
                break;

        }

        return attach;
    }




    /**박광열 공지사항 **/
    @RequestMapping(value = "/mnoticelist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object MNOTICEListForm(@RequestParam Map<String, String> param,
                                  Model model, HttpServletRequest request) throws Exception{

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "nsubject":
                    app05Dto.setNsubject(values.toString());
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();
        Object app05  = app05Service.GetMNoticeList(app05Dto);
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{
                    model.addAttribute("app05Dto", app05Service.GetMNoticeList(app05Dto));

                }catch (DataAccessException e){
                    log.info("App01001Tab01Form DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
                }catch (Exception ex) {
//                dispatchException = ex;
                    log.info("App01001Tab01Form Exception ================================================================");
                    log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
                }
                break;
            case "ELV_KYOUNG":
                ls_custcd = "KYOUNG";
                break;
            case "hanyangs":
                ls_custcd = "hanyangs";
                break;
            default:
                break;
        }
        return app05;
    }






    /**파일 첨부(공지사항)*/
    //app06 to 03 첨부파일리스트
    @RequestMapping(value = "/attachNOTICE", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object NOTICEListAttach(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request) throws Exception{
        String ls_dbnm = "";
        String ls_fseq = "";
        String ls_fflag = "";
        List<AttachDTO>  attach =new ArrayList<>();
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "nflag":
                    app05Dto.setNflag(values.toString());
                    break;
                case "nseq":
                    app05Dto.setNseq(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();
        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                try {

                    attach = app05UploadService.MNoticeFilelist(app05Dto);
                    model.addAttribute("attachDto",attach);

                }catch (DataAccessException e) {
                    log.info("App06MobForm DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException(" DataAccessException to save");
                    //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
                }catch (Exception ex) {
//                dispatchException = ex;
                    log.info("App01001Tab01Form Exception ================================================================");
                    log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
                }
                break;
            case "ELV_KYOUNG":
                ls_custcd = "KYOUNG";
                break;
            case "hanyangs":
                ls_custcd = "hanyangs";
                break;
            default:
                break;

        }

        return attach;
    }




    /**박광열 공지사항 수정 **/
    @RequestMapping(value = "/mnoticeupdate", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String NoticeUpdateListForm(@RequestParam Map<String, String> param,
                                       Model model, HttpServletRequest request) throws Exception{


        /*업로드 파일 정보를 담을 리스트*/
        List<AttachDTO> attachList = new ArrayList<>();

        param.forEach((key, values) -> {
            switch (key){
                case "nsubject":
                    app05Dto.setNsubject(values.toString());
                    break;
                case "nmemo":
                    app05Dto.setNmemo(values.toString());
                    break;
                case "nseq":
                    app05Dto.setNseq(values.toString());
                    break;
                case "ngourpcd":
                    app05Dto.setNgourpcd(values.toString());
                    break;
                case "nflag":
                    app05Dto.setNflag(values.toString());

                default:
                    break;
            }
        });



        try {

            boolean result = app05Service.UpdateMNotice(app05Dto);


        } catch (Exception e) {
            System.out.println(e);
        }
        return "success";
    }




    /**박광열 고장처리마스터 저장 **/
    @RequestMapping(value = "/save", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String e_411listSaveForm(@RequestParam Map<String, String> param,
                                    Model model, HttpServletRequest request) throws Exception{

        String ls_dbnm = "";
        String ls_gregicd = "";
        String ls_regicd = "";
        String ls_resucd = "";
        String ls_resultcd = "";
        String ls_resuremark = "";
        String ls_comptime = "";
        String ls_compdate = "";

        param.forEach((key, values) -> {
            switch (key) {

                case "compdate":
                    app10tDto.setCompdate(values.replaceAll("-",""));
                    break;
                case "recedate":
                    String vla = values.substring(0,4) + values.substring(5,7) + values.substring(8,10);
                    app10tDto.setRecedate(vla);
                    break;
                case "recenum":
                    if(values == null){
                        values = "";
                    }
                    app10tDto.setRecenum(values.toString());
                    break;
                case "actnm":
                    app10tDto.setActnm(values.toString());
                    break;
                case "resultcd":
                    app10tDto.setResultcd(values.toString());
                    break;
                case "gregicd":
                    app10tDto.setGregicd(values.toString());
                    break;
                case "regicd":
                    app10tDto.setRegicd(values.toString());
                    break;
                case "resucd":
                    app10tDto.setResucd(values.toString());
                    break;
                case "resuremark":
                    if(values == null){
                        values = "";
                    }
                    app10tDto.setResuremark(values.toString());
                    break;

                case "resultck":
                    app10tDto.setResultck(values.toString());
                    break;
                case "perid":
                    app10tDto.setPerid(values.toString());
                    break;
                case "contcd":
                    app10tDto.setContcd(values.toString());
                    break;
                case "actcd":
                    app10tDto.setActcd(values.toString());
                    break;
                case "equpcd":
                    app10tDto.setEqupcd(values.toString());
                    break;
                case "equpnm":
                    app10tDto.setEqupnm(values.toString());
                case "recetime":
                    String via = values.replaceAll(":","");
                    app10tDto.setRecetime(via);
                default:
                    break;
            }
        });


        ls_gregicd = app10tDto.getGregicd();
        ls_regicd = app10tDto.getRegicd();
        ls_resucd = app10tDto.getResucd();
        ls_resultcd = app10tDto.getResultcd();

        int stCnt = ls_gregicd.indexOf('[') + 1 ;
        int etCnt = ls_gregicd.indexOf(']');
        ls_gregicd = ls_gregicd.substring(stCnt, etCnt);

        stCnt = 0; etCnt = 0;
        stCnt = ls_regicd.indexOf('[') + 1 ;
        etCnt = ls_regicd.indexOf(']');
        ls_regicd = ls_regicd.substring(stCnt, etCnt);

        stCnt = 0; etCnt = 0;
        stCnt = ls_resucd.indexOf('[') + 1 ;
        etCnt = ls_resucd.indexOf(']');
        ls_resucd = ls_resucd.substring(stCnt, etCnt);

        stCnt = 0; etCnt = 0;
        stCnt = ls_resultcd.indexOf('[') + 1 ;
        etCnt = ls_resultcd.indexOf(']');
        ls_resultcd = ls_resultcd.substring(stCnt, etCnt);

        app10tDto.setGregicd(ls_gregicd);
        app10tDto.setRegicd(ls_regicd);
        app10tDto.setResucd(ls_resucd);
        app10tDto.setResultcd(ls_resultcd);


        try {

            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();

            app10tDto.setCustcd("ELVLRT");
            app10tDto.setSpjangcd("ZZ");

            String compnum = app10tDto.getCompnum();
            String compdate = app10tDto.getCompdate();
//            boolean result = false;

            log.info(app10tDto.getPerid());
            log.info(app10tDto.getContcd());
            log.info(app10tDto.getActcd());
            log.info(app10tDto.getEqupcd());
            log.info(app10tDto.getEqupnm());
            log.info(app10tDto.getRecetime());




            if (compnum == null || compnum.equals("")) {
                app10tDto.setCompnum(CountSeq(compdate));
                boolean result = app10ElvlrtMobService.Insert10Manu(app10tDto);
                if (!result) {
                    return "error";
                }
            } else {
                app10tDto.setCompnum(compnum);
                boolean  result = app10ElvlrtMobService.Update10Manu(app10tDto);
                if (!result) {
                    return "error";
                }
            }
            boolean result = app10ElvlrtServiceservice.Updateresult1(app10tDto);
            if (!result) {
                return "error";
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return "success";
    }





    public String CountSeq(String compdate){
        String ls_compnum = app10ElvlrtServiceservice.get10ManualMaxSeq(compdate);
        int ll_compnum = 0;
        if(ls_compnum == null){
            ls_compnum = "001";
        }else{
            ll_compnum = Integer.parseInt(ls_compnum);
            log.info(ll_compnum);
            if(ll_compnum > 8) {
                ls_compnum = "0" + Integer.toString(ll_compnum + 01);
            }else{
                ls_compnum = "00" + Integer.toString(ll_compnum + 01);
            }
        }
        return ls_compnum;
    }

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }

}
