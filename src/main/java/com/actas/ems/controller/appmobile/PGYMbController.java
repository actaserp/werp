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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private final App01ElvlrtService App01service;
    private  final App05UploadServiceImpl app05UploadService;

    private final App10ElvlrtService app10ElvlrtServiceservice;
    List<AttachDTO>  attach =new ArrayList<>();
    AppMobPlanDto appMobPlanDto = new AppMobPlanDto();
    private final App10ElvlrtMobService app10ElvlrtMobService;
    List<App26ElvlrtDto> app26DtoList = new ArrayList<>();
    private final App05ElvlrtService app05Service;
    private final App01ElvlrtService app01ElvlrtServiceservice;
    App05ElvlrtDto app05Dto = new App05ElvlrtDto();
    App07ElvlrtDto app07Dto = new App07ElvlrtDto();
    List<App03ElvlrtDto> app03DtoList01 = new ArrayList<>();
    App10ElvlrtDto app10tDto = new App10ElvlrtDto();
    List<AppMobPlanDto> appMobplanDtoList = new ArrayList<>();

    List<App10ElvlrtDto> app10DtoList = new ArrayList<>();


    App08_mbmanual app08_mbmanual = new App08_mbmanual();
    PopupDto popParmDto = new PopupDto();
    List<AppMob001tDto> appMobDtoList = new ArrayList<>();

    List<App16ElvlrtDto> app16DtoList = new ArrayList<>();

    private final App07UploadServiceImpl appServiceImpl;

    List<PopupDto> poplistDto = new ArrayList<>();
    protected Log log =  LogFactory.getLog(this.getClass());
    String ls_custcd = "";
    String ls_spjangcd = "";

    /**랜덤문자열*/
    private final String getRandomString() { return UUID.randomUUID().toString().replaceAll("-", "");}
    /**파일경로*/
    private final String uploadPath = Paths.get("C:", "develop", "upload","mfix", getToDate()).toString();

    /**박광열 승강기번호조회 리스트 **/
    @RequestMapping(value = "/getelvinfo_1", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object JA001ListForm(@RequestParam Map<String, String> param,
                                Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


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

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


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


        HttpSession session = request.getSession();
        userformDto.setDbnm(ls_dbnm);


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
        session.setAttribute("userformDto",userformDto);
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
                                  Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

        String ls_dbnm = "";




        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "nsubject":
                    app05Dto.setNsubject(values.toString());
                case "ngourpcd":
                    app05Dto.setNgourpcd(values.toString());
                default:
                    break;

            }
        });

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        ls_dbnm = userformDto.getDbnm();
        Object app05  = app05Service.GetMNoticeList(app05Dto);
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{

                    log.info(userformDto.getUserid() + "chkeck!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
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

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

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

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


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
        String ls_resulttime = "";
        String ls_comptime = "";
        Integer ls_comptime2;
        String ls_arrivtime = "";
        Integer ls_arrivtime2;
        String compnum = "";

        String ls_actperid = "";
        String ls_remocd = "";


        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


        param.forEach((key, values) -> {
            switch (key) {

                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;

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
                    break;
                case "recetime":
                    String via = values.replaceAll(":","");
                    app10tDto.setRecetime(via);
                    break;
                case "cltcd":
                    app10tDto.setCltcd(values.toString());
                    break;
                case "divicd":
                    app10tDto.setDivicd(values.toString());
                    break;
                case "remocd":
                    app10tDto.setRemocd(values.toString());
                    break;
                case "actperid":
                    app10tDto.setActperid(values.toString());
                    break;
                case "remoremark":
                    app10tDto.setRemoremark(values.toString());
                    break;
                case "resulttime":
                    app10tDto.setResulttime(values.toString());
                    break;
                case "comptime":

                    app10tDto.setComptime(values.toString());
                    break;
                case "arrivtime":
                    app10tDto.setArrivtime(values.toString());
                    break;
                default:
                    break;
            }
        });

        ls_dbnm = userformDto.getDbnm();
        ls_gregicd = app10tDto.getGregicd();
        ls_regicd = app10tDto.getRegicd();
        ls_resucd = app10tDto.getResucd();
        ls_resultcd = app10tDto.getResultcd();
        ls_actperid = app10tDto.getActperid();
        ls_remocd = app10tDto.getRemocd();
        ls_comptime = app10tDto.getComptime();
        ls_arrivtime = app10tDto.getArrivtime();




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

        stCnt = 0; etCnt = 0;
        stCnt = ls_actperid.indexOf('[') + 1;
        etCnt = ls_actperid.indexOf(']');
        ls_actperid = ls_actperid.substring(stCnt, etCnt);

        stCnt = 0; etCnt = 0;
        stCnt = ls_remocd.indexOf('[') + 1;
        etCnt = ls_remocd.indexOf(']');
        ls_remocd = ls_remocd.substring(stCnt, etCnt);



/*

        if(ls_comptime.contains("PM")){
            if (ls_comptime.substring(0, 2).equals("12")) {
                ls_comptime = ls_comptime.replace(":","");
                ls_comptime = ls_comptime.substring(0,4);
            }else{
                ls_comptime = ls_comptime.replace(":","");
                ls_comptime = ls_comptime.substring(0,4);
                ls_comptime2 = Integer.parseInt(ls_comptime) + 1200;
                ls_comptime = ls_comptime2.toString();
            }
        }else if (ls_comptime.contains("AM")){
            if(ls_comptime.substring(0,2).equals("12")){
                ls_comptime = ls_comptime.replace(":","");
                ls_comptime = "00" + ls_comptime.substring(2,4);
            }else {
                ls_comptime = ls_comptime.replace(":", "");
                ls_comptime = ls_comptime.substring(0, 4);
            }
        }
*/

        /**GPT가 짠 코드**/
        final int PM_HOUR_OFFSET2 = 1200;
        final int MILITARY_TIME_LENGTH2 = 4;
        final String MIDNIGHT2 = "24";

        if(ls_comptime.contains("PM")){
            int hour = Integer.parseInt(ls_comptime.substring(0, 2));
            ls_comptime = ls_comptime.replace(":", "");
            ls_comptime = ls_comptime.substring(0, MILITARY_TIME_LENGTH2);
            if (hour != 12) {
                int militaryTime = Integer.parseInt(ls_comptime) + PM_HOUR_OFFSET2;
                ls_comptime = String.valueOf(militaryTime);
            }
        } else if (ls_comptime.contains("AM")) {
            int hour = Integer.parseInt(ls_comptime.substring(0, 2));
            ls_comptime = ls_comptime.replace(":", "");
            ls_comptime = ls_comptime.substring(0, MILITARY_TIME_LENGTH2);
            if (hour == 12) {
                ls_comptime = MIDNIGHT2 + ls_comptime.substring(2, 4);
            }
        }
        /**내가 짠 쓰레기 코드**/
       /* if(ls_arrivtime.contains("PM")){
            if (ls_arrivtime.substring(0, 2).equals("12")) {
                ls_arrivtime = ls_arrivtime.replace(":","");
                ls_arrivtime = ls_arrivtime.substring(0,4);
            }else{
                ls_arrivtime = ls_arrivtime.replace(":","");
                ls_arrivtime = ls_arrivtime.substring(0,4);
                ls_arrivtime2 = Integer.parseInt(ls_arrivtime) + 1200;
                ls_arrivtime = ls_arrivtime2.toString();
            }
        }else if (ls_arrivtime.contains("AM")){
            if(ls_arrivtime.substring(0,2).equals("12")){
                ls_arrivtime = ls_arrivtime.replace(":","");
                ls_arrivtime = "00" + ls_arrivtime.substring(2,4);
            }else {
                ls_arrivtime = ls_arrivtime.replace(":", "");
                ls_arrivtime = ls_arrivtime.substring(0, 4);
            }
        }*/

        /**GPT가 짠 코드**/
        final int PM_HOUR_OFFSET = 1200;
        final int MILITARY_TIME_LENGTH = 4;
        final String MIDNIGHT = "24";

        if(ls_arrivtime.contains("PM")){
            int hour = Integer.parseInt(ls_arrivtime.substring(0, 2));
            ls_arrivtime = ls_arrivtime.replace(":", "");
            ls_arrivtime = ls_arrivtime.substring(0, MILITARY_TIME_LENGTH);
            if (hour != 12) {
                int militaryTime = Integer.parseInt(ls_arrivtime) + PM_HOUR_OFFSET;
                ls_arrivtime = String.valueOf(militaryTime);
            }
        } else if (ls_arrivtime.contains("AM")) {
            int hour = Integer.parseInt(ls_arrivtime.substring(0, 2));
            ls_arrivtime = ls_arrivtime.replace(":", "");
            ls_arrivtime = ls_arrivtime.substring(0, MILITARY_TIME_LENGTH);
            if (hour == 12) {
                ls_arrivtime = MIDNIGHT + ls_arrivtime.substring(2, 4);
            }
        }



        SimpleDateFormat sdfYMD = new SimpleDateFormat("HH:mm");
        String hour = ls_comptime.substring(0,2) + ":" + ls_comptime.substring(2,4);
        Date date = sdfYMD.parse(hour);
        String hour2 = ls_arrivtime.substring(0,2) + ":" + ls_arrivtime.substring(2,4);
        Date date2 = sdfYMD.parse(hour2);


        long diffMin = (date.getTime() - date2.getTime()) / 60000; //분 차이

        if (diffMin < 0) {
            diffMin += 24 * 60; // 도착 시간이 출발 시간보다 앞에 있으면 24시간을 더함
        }

        ls_resulttime = Long.toString(diffMin);

        app10tDto.setGregicd(ls_gregicd);
        app10tDto.setRegicd(ls_regicd);
        app10tDto.setResucd(ls_resucd);
        app10tDto.setResultcd(ls_resultcd);
        app10tDto.setActperid(ls_actperid);
        app10tDto.setRemocd(ls_remocd);
        app10tDto.setArrivdate(app10tDto.getCompdate());
        app10tDto.setDatetime(app10tDto.getCompdate().substring(0,4) + "-" + app10tDto.getCompdate().substring(4,6) + "-" + app10tDto.getCompdate().substring(6,8) + " 00:00:00.000");
        app10tDto.setDatetime2(app10tDto.getCompdate().substring(0,4) + "-" + app10tDto.getCompdate().substring(4,6) + "-" + app10tDto.getCompdate().substring(6,8) + " 00:00:00.000");
        app10tDto.setComptime(ls_comptime);
        app10tDto.setArrivtime(ls_arrivtime);

        app10tDto.setIndate(getToDate());
        app10tDto.setResulttime(ls_resulttime);


        log.info(app10tDto.getComptime() + " comptime");
        log.info(app10tDto.getArrivtime() + " arrivtime");
        log.info(app10tDto.getResulttime() + " resulttime");

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";

                try {

                    String ls_custcd = userformDto.getCustcd();
                    String ls_spjangcd = userformDto.getSpjangcd();

                    app10tDto.setCustcd("ELVLRT");
                    app10tDto.setSpjangcd("ZZ");

                    compnum = app10tDto.getCompnum();
                    compnum = "";
                    String compdate = app10tDto.getCompdate();


                    log.info(app10tDto.getDivicd() + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    log.info(app10tDto.getCltcd());  //o
                    log.info(app10tDto.getActperid());  //o
                    log.info(app10tDto.getRemocd());    //o
                    log.info(app10tDto.getRemoremark());  //o
                    log.info(app10tDto.getRecenum());     //o
                    log.info(app10tDto.getRecetime());     //
                    log.info(app10tDto.getArrivtime());    //o
                    log.info(app10tDto.getCompdate() + "compdate");
                    log.info(app10tDto.getArrivdate());     //o
                    log.info(app10tDto.getDatetime());     //o
                    log.info(app10tDto.getDatetime2());    //o
                    log.info(app10tDto.getComptime());    //o
                    log.info(app10tDto.getArrivtime());  //o
                    log.info(ls_resulttime+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");  //o
                    log.info(compnum + "compnum");
                    if (compnum == null || compnum.equals("")) {
                        app10tDto.setCompnum(CountSeq(compdate));
                        boolean result = app10ElvlrtMobService.Insert10Manu(app10tDto);
                        log.info(app10tDto.getCompnum());
                        log.info("실행1");
                        if (!result) {
                            return "error";
                        }
                    } else {
                        app10tDto.setCompnum(compnum);
                        boolean  result = app10ElvlrtMobService.Update10Manu(app10tDto);
                        log.info("실행2");
                        if (!result) {
                            return "error";
                        }
                    }
                    boolean result = app10ElvlrtServiceservice.Updateresult1(app10tDto);
                    if (!result) {
                        return "error";
                    }

                } catch (Exception e) {
                    log.info(e);
                    log.info("error");
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

        return "success";
    }

  /**점검계획 조회*/

    @RequestMapping(value = "/planlist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object PLANlistForm(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


        String ls_dbnm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "actnm":
                    appMobPlanDto.setActnm(values.toString());
                    break;
                case "perid":
                    appMobPlanDto.setPerid(values.toString());
                    break;
                case "pernm":
                    appMobPlanDto.setPernm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();

        log.info(appMobPlanDto.getPerid() + " perid");
        log.info(appMobPlanDto.getPernm() + " pernm");


        //현재날짜기준 월초(1일) 구하기
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        String time2 = time.substring(0,6) + "01";

        appMobPlanDto.setFrdate(time2);


        // 현재 날짜 구하기
        LocalDate today = LocalDate.now();

        // 이번 달의 월말 구하기
        LocalDate endOfMonth = today.withDayOfMonth(today.lengthOfMonth());
        String endday = endOfMonth.toString().replaceAll("","");

        appMobPlanDto.setTodate(endday);
        log.info(appMobPlanDto.getPerid() + "perid");

        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                appMobPlanDto.setCustcd(ls_custcd);
                appMobPlanDto.setSpjangcd(ls_spjangcd);

                try {
                    appMobplanDtoList = app10ElvlrtMobService.GetplanList(appMobPlanDto);
                    model.addAttribute("appMobplanDtoList",appMobplanDtoList);

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

        return appMobplanDtoList;
    }


    public String Countequp(String plandate){
        String ls_equpcd = app10ElvlrtMobService.getMaxPlandate(plandate);
        int ll_equpcd = 0;
        if(ls_equpcd == null){
            ls_equpcd = "001";
        }else{
            ll_equpcd = Integer.parseInt(ls_equpcd);
            log.info(ll_equpcd);
            if(ll_equpcd > 8) {
                ls_equpcd = "0" + Integer.toString(ll_equpcd + 01);
            }else{
                ls_equpcd = "00" + Integer.toString(ll_equpcd + 01);
            }
        }
        return ls_equpcd;
    }



    public String CountSeq(String compdate){

        String ls_compnum = "";
        ls_compnum = app10ElvlrtServiceservice.get10ManualMaxSeq(compdate);
        int ll_mseq = 0;
        if(ls_compnum == null ){
            ls_compnum = "001";
        }else{
            ll_mseq = Integer.parseInt(ls_compnum);
            ls_compnum = Integer.toString(ll_mseq + 1 );
            switch (ls_compnum.length()){
                case 1:
                    ls_compnum = "00" + ls_compnum;
                    break;
                case 2:
                    ls_compnum = "0" + ls_compnum;
                    break;
                default:
                    break;
            }

        }
       /* String ls_compnum = app10ElvlrtServiceservice.get10ManualMaxSeq(compdate);
        int ll_compnum = 0;
        if(ls_compnum == null){
            ls_compnum = "001";
        }else{
            *//*ll_compnum = Integer.parseInt(ls_compnum);*//*
            log.info(ls_compnum.length() + "lenaht");
            if(ls_compnum.length() == 2) {
                int ls_compnum2 = Integer.parseInt(ls_compnum) + 1;
                ls_compnum = "0" + Integer.toString(ls_compnum2);
            }else if(ls_compnum.length() == 1){
                int ls_compnum2 = Integer.parseInt(ls_compnum) + 1;
                ls_compnum = "00" + Integer.toString(ls_compnum2);
            } else if (ls_compnum.length() == 3) {
                int ls_compum2 = Integer.parseInt(ls_compnum) + 1;
                ls_compnum = Integer.toString(ls_compum2);
            }
        }
        return ls_compnum;*/
        return ls_compnum;
    }


    public String CountSeq2(String yyyymm){
        String ls_fseq = appService.getMManualMaxSeq(yyyymm);
        int ll_fseq = 0;
        if(ls_fseq == null){
            ls_fseq = yyyymm + "001";
        }else{
            ll_fseq = Integer.parseInt(ls_fseq);
            ls_fseq = Integer.toString(ll_fseq + 1);
        }
        return ls_fseq;
    }

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }



    /**박광열 점검계획 저장 **/
    @RequestMapping(value = "/mfixsave", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String mfixlistSaveForm(@RequestParam Map<String, String> param,
                                   Model model, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


        String ls_dbnm = "";

        String ls_perid;
        String ls_pernm;


        param.forEach((key, values) -> {
            switch (key) {

                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;

                case "plandate":
                    String via = values.replaceAll("-","");
                    appMobPlanDto.setPlandate(via);
                    break;

                case "actcd":
                    appMobPlanDto.setActcd(values.toString());
                    break;
                case "actnm":
                    appMobPlanDto.setActnm(values.toString());
                    break;


                case "perid":
                    appMobPlanDto.setPerid(values.toString());
                    break;


                case "kcpernm":
                    appMobPlanDto.setKcpernm(values.toString());

                case "remark":
                    appMobPlanDto.setRemark(values.toString());
                    break;
                case "qty":
                    appMobPlanDto.setQty(values);
                    break;
                case "cltcd":
                    appMobPlanDto.setCltcd(values.toString());
                    break;
                case "kcspnm":
                    appMobPlanDto.setKcspnm(values.toString());
                    break;
                default:
                    break;
            }
        });

        ls_dbnm = userformDto.getDbnm();
        ls_perid = appMobPlanDto.getPerid();
        ls_pernm = appMobPlanDto.getKcpernm();

        String plandate = appMobPlanDto.getPlandate();
        appMobPlanDto.setEqupcd(Countequp(plandate));



        int stCnt = ls_perid.indexOf('[') + 1 ;
        int etCnt = ls_perid.indexOf(']');
        ls_perid = ls_perid.substring(stCnt, etCnt);

        ls_pernm = ls_pernm.substring(0, ls_pernm.indexOf('[')).trim();


        appMobPlanDto.setPerid(ls_perid);
        appMobPlanDto.setKcpernm(ls_pernm);

       /* stCnt = 0; etCnt = 0;
        stCnt = ls_regicd.indexOf('[') + 1 ;
        etCnt = ls_regicd.indexOf(']');
        ls_regicd = ls_regicd.substring(stCnt, etCnt);

        stCnt = 0; etCnt = 0;
        stCnt = ls_remocd.indexOf('[') + 1;
        etCnt = ls_remocd.indexOf(']');
        ls_remocd = ls_remocd.substring(stCnt, etCnt);*/


        switch (ls_dbnm){

            case "ELV_LRT":
                try {

                    appMobPlanDto.setCustcd("ELVLRT");
                    appMobPlanDto.setSpjangcd("ZZ");
                    appMobPlanDto.setIndate(getToDate());

                    log.info(userformDto.getDbnm());
                    log.info(appMobPlanDto.getPlandate());
                    log.info(appMobPlanDto.getActcd());
                    log.info(appMobPlanDto.getActnm());
                    log.info(appMobPlanDto.getEqupcd());
                    log.info(appMobPlanDto.getEqupnm());
                    log.info(appMobPlanDto.getPerid());
                    log.info(appMobPlanDto.getKcpernm());
                    log.info(appMobPlanDto.getRemark());
                    log.info(appMobPlanDto.getQty());
                    log.info(appMobPlanDto.getCltcd());

                    boolean result = app10ElvlrtMobService.Insertplan(appMobPlanDto);
                    if (!result) {
                        return "error";
                    }


                } catch (Exception e) {
                    System.out.println(e);
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
        return "success";
    }



    /**사업자 조회*/
    @RequestMapping(value = "/cltnmlist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object EListForm(@RequestParam Map<String, String> param,
                            Model model, HttpServletRequest request) throws Exception{


        String ls_dbnm = "";

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "cltnm":
                    appMobPlanDto.setCltnm(values.toString());
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

                try{
                    appMobplanDtoList = app10ElvlrtMobService.GetcltnmList(appMobPlanDto);
                    model.addAttribute("appMobplanDtoList", appMobplanDtoList);

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
        return appMobplanDtoList;
    }


    /**박광열 점검조치사항 삭제 **/
    @RequestMapping(value = "/delete", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String DeleteListForm(@RequestParam Map<String, String> param,
                                 Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


        /*업로드 파일 정보를 담을 리스트*/
        List<AttachDTO> attachList = new ArrayList<>();

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "fseq":
                    app07Dto.setFseq(values.toString());

                default:
                    break;
            }
        });

        ls_dbnm = userformDto.getDbnm();

        switch (ls_dbnm){
            case "ELV_LRT":


        try {

            boolean result = appService.DeleteMManu(app07Dto);


        } catch (Exception e) {
            System.out.println(e);
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
        return "success";
    }


    /**박광열 점검계획 삭제 **/
    @RequestMapping(value = "/mfixdelete", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String DeleteListForm2(@RequestParam Map<String, String> param,
                                 Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


        /*업로드 파일 정보를 담을 리스트*/
        List<AttachDTO> attachList = new ArrayList<>();

        String ls_dbnm = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "plandate":
                    appMobPlanDto.setPlandate(values.toString());
                    break;
                case "actcd":
                    appMobPlanDto.setActcd(values.toString());
                    break;
                case "equpcd":
                    appMobPlanDto.setEqupcd(values.toString());
                    break;
                default:
                    break;
            }
        });

        ls_dbnm = userformDto.getDbnm();

        switch (ls_dbnm){
            case "ELV_LRT":


                try {

                    boolean result = app10ElvlrtMobService.DeletePlan(appMobPlanDto);


                } catch (Exception e) {
                    System.out.println(e);
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
        return "success";
    }




    /**박광열 점검계획 수정 **/
    @RequestMapping(value = "/updateplan", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String UpdatePlanForm(@RequestParam Map<String, String> param,
                                 Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


        String ls_dbnm = "";
        String ls_perid = "";
        String ls_pernm = "";


        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "plandate":
                    String via = values.replaceAll("-","");
                    appMobPlanDto.setPlandate(via);
                    break;
                case "cltcd":
                    appMobPlanDto.setCltcd(values.toString());
                    break;
                case "actcd":
                    appMobPlanDto.setActcd(values.toString());
                    break;
                case "actnm":
                    appMobPlanDto.setActnm(values.toString());
                    break;
                /*case "equpcd":
                    appMobPlanDto.setEqupcd(values.toString());
                    break;
                case "equpnm":
                    appMobPlanDto.setEqupnm(values.toString());
                    break;*/
                case "kcpernm":
                    appMobPlanDto.setKcpernm(values.toString());
                    break;
                case "kcspnm":
                    appMobPlanDto.setKcspnm(values.toString());
                    break;
                case "remark":
                    appMobPlanDto.setRemark(values.toString());
                    break;
                case "perid":
                    appMobPlanDto.setPerid(values.toString());
                    break;
                case "indate":
                    appMobPlanDto.setIndate(values.toString());
                    break;
                case "qty":
                    appMobPlanDto.setQty(values.toString());
                    break;
                case "plandate2":
                    appMobPlanDto.setPlandate2(values.toString());
                    break;
                case "cltcd2":
                    appMobPlanDto.setCltcd2(values.toString());
                    break;
                case "actcd2":
                    appMobPlanDto.setActcd2(values.toString());
                    break;
                case "equpcd2":
                    appMobPlanDto.setEqupcd2(values.toString());
                    break;



                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();


        ls_perid = appMobPlanDto.getPerid();
        ls_pernm = appMobPlanDto.getKcpernm();



        int stCnt = ls_perid.indexOf('[') + 1 ;
        int etCnt = ls_perid.indexOf(']');
        ls_perid = ls_perid.substring(stCnt, etCnt);

        ls_pernm = ls_pernm.substring(0, ls_pernm.indexOf('[')).trim();


        appMobPlanDto.setPerid(ls_perid);
        appMobPlanDto.setKcpernm(ls_pernm);
        appMobPlanDto.setIndate(getToDate());


        switch (ls_dbnm) {
            case "ELV_LRT" :
            try {



                appMobPlanDto.setCustcd("ELVLRT");
                appMobPlanDto.setSpjangcd("ZZ");

                boolean result = app10ElvlrtMobService.UpdatePlan(appMobPlanDto);


            } catch (Exception e) {
                System.out.println(e);
            }

            case "ELV_KYOUNG":
                ls_custcd = "KYOUNG";
                break;
            case "hanyangs":
                ls_custcd = "hanyangs";
                break;
            default:
                break;
        }

        return "success";

    }


    /**점검조치사항 저장*/
    @RequestMapping(value = "/mfixbbssave", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String mfixbbslistSaveForm(@RequestParam Map<String, String> param,
                                   Model model, HttpServletRequest request, @RequestParam(value = "file", required = false)
                                      List<MultipartFile> file) throws Exception {

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


        String ls_dbnm = "";

        String ls_fileName = "";
        String ls_errmsg = "";
        String ls_yeare = "";
        String ls_mm = "";
        /*업로드 파일 정보를 담을 리스트*/
        List<AttachDTO> attachList = new ArrayList<>();

        param.forEach((key, values) -> {
            switch (key) {
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "fseq":
                    app07Dto.setFseq(values.toString());

                case "finputdate":
                    String via = values.replaceAll("-","");
                    app07Dto.setFinputdate(via);
                    break;
                case "fgroupcd":
                    app07Dto.setFgourpcd(values.toString());
                    break;
                case "fnsubject":
                    app07Dto.setFnsubject(values.toString());
                    break;
                case "fpernm":
                    app07Dto.setFpernm(values.toString());
                    break;

                case "fmemo":
                    app07Dto.setFmemo(values.toString());
                    break;


                case "fflag":
                    app07Dto.setFflag(values.toString());
                    break;

                default:
                    break;
            }
        });

        ls_dbnm = userformDto.getDbnm();
        String fseq = app07Dto.getFseq();



        File dir = new File(uploadPath);
        if(dir.exists() == false){
            dir.mkdirs();
        }

        switch (ls_dbnm){

            case "ELV_LRT":
                try {
                    app07Dto.setCustcd("ELVLRT");
                    app07Dto.setSpjangcd("ZZ");

                    String via2 = app07Dto.getFinputdate();
                    ls_yeare = via2.substring(0,4);
                    ls_mm = via2.substring(4,6);
                    fseq = "";
                    log.info(fseq);
                    log.info("check!!!!!!!!!!!!!!!!!!!!");


                    if(fseq == null || fseq.equals("")){
                        app07Dto.setFseq(CountSeq2(ls_yeare + ls_mm));
                    }else{
                        app07Dto.setFseq(fseq);
                    }
                    app07Dto.setYyyymm(ls_yeare + ls_mm);

                    log.info(app07Dto.getFseq());
                    log.info(app07Dto.getCustcd());
                    log.info(app07Dto.getSpjangcd());
                    log.info(app07Dto.getFinputdate());
                    log.info(app07Dto.getFgourpcd());
                    log.info(app07Dto.getFnsubject());
                    log.info(app07Dto.getFpernm());
                    log.info(app07Dto.getFmemo());
                    log.info(app07Dto.getFflag());

                    if(fseq == null || fseq.equals("")) {
                        boolean result = appService.InsertMManu(app07Dto);
                        if (!result) {
                            return "error";
                        }
                    }else{
                        boolean result = appService.UpdateMManu(app07Dto);
                        if(!result){
                            return "error";
                        }
                    }



                    for (MultipartFile multipartFile : file) {
//                log.info("================================================================");
//                log.info("upload file name : " + multipartFile.getOriginalFilename());
//                log.info("upload file name : " + multipartFile.getSize());
                        ls_fileName = multipartFile.getOriginalFilename();


                        // 파일이 비어있으면 비어있는 리스트 반환
                        if (multipartFile.getSize() < 1) {
                            ls_errmsg = "success";
                            return ls_errmsg;
                        }

                       // 파일 확장자
                        final String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

                        final String saveName = getRandomString() + "." + extension;

                       // 업로드 경로에 saveName과 동일한 이름을 가진 파일 생성
                        File target = new File(uploadPath, saveName);
                        multipartFile.transferTo(target);
                        String fseq1 = app07Dto.getFseq();
                      //   파일 정보 저장
                        AttachDTO attach = new AttachDTO();
                        attach.setBoardIdx(fseq1);
                        attach.setOriginalName(multipartFile.getOriginalFilename());
                        attach.setSaveName(saveName);
                        attach.setSize(multipartFile.getSize());
                        attach.setFlag("MF");
                        log.info(attach.getBoardIdx());
                       //  파일 정보 추가
                        attachList.add(attach);

                        boolean result = appServiceImpl.registerMManu(app07Dto, attachList);
                        if(result) {
                            log.info("true");
                        }
                        if (!result) {
                            return "error";
                        }

                    }


                }catch (DataAccessException e){
                    log.info("memberUpload DataAccessException ================================================================");
                    log.info(e.toString());
                    throw new AttachFileException("[" + ls_fileName + "] DataAccessException to save");
                    //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
                }  catch (Exception e) {
                    System.out.println("1231321321231231321321");
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
        return "success";
    }




    /**고장접수 조회*/

    @RequestMapping(value = "/recelist", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object RecelistForm(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);



        String ls_dbnm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "actnm":
                    popParmDto.setActnm(values.toString());
                case "perid":
                    popParmDto.setPerid(values.toString());
                    break;
                case "pernm":
                    popParmDto.setPernm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();

        log.info(popParmDto.getPernm() + " pernm");
        log.info(popParmDto.getPerid() + " perid");

        log.info(popParmDto.getPernm() + " pernm");
        //현재날짜기준 월초(1일) 구하기
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        String time2 = time.substring(0,6) + "01";

        popParmDto.setFrdate(time2);

        log.info(popParmDto.getFrdate());


        // 현재 날짜 구하기
        LocalDate today = LocalDate.now();

        // 이번 달의 월말 구하기
        LocalDate endOfMonth = today.withDayOfMonth(today.lengthOfMonth());
        String endday = endOfMonth.toString().replaceAll("-","");

        popParmDto.setTodate(endday);

        log.info(popParmDto.getTodate());

        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":

                try {

                    app03DtoList01 = service.GetApp01List001(popParmDto);
                    model.addAttribute("app03DtoList01",app03DtoList01);

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

        return app03DtoList01;
    }



    /**박광열 현장정보 리스트(점검계획 전용) **/
    @RequestMapping(value = "/tbe601list", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object TBE601ListForm(@RequestParam Map<String, String> param,
                                 Model model, HttpServletRequest request) throws Exception{

        String ls_dbnm = "";


        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);



        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "actnm":

                    popParmDto.setActnm(values.toString());
                    break;
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{
                    app26DtoList = service.GetAppMobListr_004_plan(popParmDto);
                    model.addAttribute("app26DtoList", app26DtoList);

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
        return app26DtoList;
    }


    /**박광열 현장정보 리스트(고장접수 전용) **/
    @RequestMapping(value = "/tbe601list_2", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public Object TBE601_2ListForm(@RequestParam Map<String, String> param,
                                 Model model, HttpServletRequest request) throws Exception{

        String ls_dbnm = "";


        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);



        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "actnm":

                    popParmDto.setActnm(values.toString());
                    break;
                default:
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{
                    app26DtoList = service.GetAppMobListr_004_e601(popParmDto);
                    model.addAttribute("app26DtoList", app26DtoList);

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
        return app26DtoList;
    }



/*

    */
/**박광열 고장접수 수정 */

    @RequestMapping(value = "/update_e401", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String Update_E401ListForm(@RequestParam Map<String, String> param,
                                 Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";

        String ls_hitchtime = "";
        String ls_recetime = "";

        String ls_contcd = "";
        String ls_perid  = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "recedate":
                    String via = values.toString().replaceAll("-","");
                    app10tDto.setRecedate(via);
                    break;
                case "hitchdate":
                    String via2 = values.toString().replaceAll("-","");
                    app10tDto.setHitchdate(via2);
                    break;
                case "hitchhour":
                    values = values.replaceAll(":","");
                    app10tDto.setHitchhour(values);
                    break;
                case "perid":
                    app10tDto.setPerid(values.toString());
                    break;
                case "cltcd":
                    app10tDto.setCltcd(values.toString());
                    break;
                case "actcd":
                    app10tDto.setActcd(values.toString());
                    break;
                case "actnm":
                    app10tDto.setActnm(values.toString());
                    break;
                case "equpcd":
                    app10tDto.setEqupcd(values.toString());
                    break;
                case "equpnm":
                    app10tDto.setEqupnm(values.toString());
                    break;
                case "contcd":
                    app10tDto.setContcd(values.toString());
                    break;
                case "contents":
                    app10tDto.setContents(values.toString());
                    break;
                case "remark":
                    app10tDto.setRemark(values.toString());
                    break;
                case "recetime":
                    values = values.replaceAll(":","");
                    app10tDto.setRecetime(values.toString());
                    break;
                case "recenum":
                    app10tDto.setRecenum(values.toString());
                    break;
                default:
                case "recedate2":
                    app10tDto.setRecedate2(values.toString());
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();

        ls_hitchtime = app10tDto.getHitchhour();
        ls_recetime = app10tDto.getRecetime();
        ls_contcd = app10tDto.getContcd();
        ls_perid = app10tDto.getPerid();





        int stCnt = ls_contcd.indexOf('[') + 1 ;
        int etCnt = ls_contcd.indexOf(']');
        ls_contcd = ls_contcd.substring(stCnt, etCnt);


        stCnt = 0; etCnt = 0;
        stCnt = ls_perid.indexOf('[') + 1 ;
        etCnt = ls_perid.indexOf(']');
        ls_perid = ls_perid.substring(stCnt, etCnt);


        final int PM_HOUR_OFFSET2 = 1200;
        final int MILITARY_TIME_LENGTH2 = 4;
        final String MIDNIGHT2 = "00";

        if(ls_hitchtime.contains("PM")){
            int hour = Integer.parseInt(ls_hitchtime.substring(0, 2));
            ls_hitchtime = ls_hitchtime.replace(":", "");
            ls_hitchtime = ls_hitchtime.substring(0, MILITARY_TIME_LENGTH2);
            if (hour != 12) {
                int militaryTime = Integer.parseInt(ls_hitchtime) + PM_HOUR_OFFSET2;
                ls_hitchtime = String.valueOf(militaryTime);
            }
        } else if (ls_hitchtime.contains("AM")) {
            int hour = Integer.parseInt(ls_hitchtime.substring(0, 2));
            ls_hitchtime = ls_hitchtime.replace(":", "");
            ls_hitchtime = ls_hitchtime.substring(0, MILITARY_TIME_LENGTH2);
            if (hour == 12) {
                ls_hitchtime = MIDNIGHT2 + ls_hitchtime.substring(2, 4);
            }
        }


        /**GPT가 짠 코드**/
        final int PM_HOUR_OFFSET = 1200;
        final int MILITARY_TIME_LENGTH = 4;
        final String MIDNIGHT = "00";

        if(ls_recetime.contains("PM")){
            int hour = Integer.parseInt(ls_recetime.substring(0, 2));
            ls_recetime = ls_recetime.replace(":", "");
            ls_recetime = ls_recetime.substring(0, MILITARY_TIME_LENGTH);
            if (hour != 12) {
                int militaryTime = Integer.parseInt(ls_recetime) + PM_HOUR_OFFSET;
                ls_recetime = String.valueOf(militaryTime);
            }
        } else if (ls_recetime.contains("AM")) {
            int hour = Integer.parseInt(ls_recetime.substring(0, 2));
            ls_recetime = ls_recetime.replace(":", "");
            ls_recetime = ls_recetime.substring(0, MILITARY_TIME_LENGTH);
            if (hour == 12) {
                ls_recetime = MIDNIGHT + ls_recetime.substring(2, 4);
            }
        }

        app10tDto.setHitchhour(ls_hitchtime);
        app10tDto.setRecetime(ls_recetime);
        app10tDto.setContcd(ls_contcd);
        app10tDto.setPerid(ls_perid);
        app10tDto.setReperid(ls_perid);

        log.info(app10tDto.getRecedate());
        log.info(app10tDto.getHitchhour());
        log.info(app10tDto.getPerid() + " perid");    //31
        log.info(app10tDto.getCltcd() + " cltcd");
        log.info(app10tDto.getActcd() + " actcd");
        log.info(app10tDto.getActnm() + " actnm");
        log.info(app10tDto.getEqupcd() + " equpcd");
        log.info(app10tDto.getEqupnm() + " equpnm");
        log.info(app10tDto.getContcd() + "contcd");
        log.info(app10tDto.getContents() + "  content");
        log.info(app10tDto.getRemark());
        log.info(app10tDto.getRecetime());
        log.info(app10tDto.getRecenum() + " recenum");
        log.info(app10tDto.getRecedate2() + " recedate2");

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{
                    try {

                        int queryResult = 1;
                        app10tDto.setCustcd("ELVLRT");
                        app10tDto.setSpjangcd("ZZ");
                        app10tDto.setDatetime(getToDate().substring(0,4) + "-" + getToDate().substring(4,6) + "-" + getToDate().substring(6,8) + " 00:00:00.000");
                        app10tDto.setDatetime2(getToDate().substring(0,4) + "-" + getToDate().substring(4,6) + "-" + getToDate().substring(6,8) + " 00:00:00.000");
                        app10tDto.setIndate(getToDate());


                            queryResult = service.UpdateE401(app10tDto);

                        if (queryResult == 1){
                            return "success";
                        }else{
                            return "fail";
                        }

                    }catch (IllegalStateException e){
                        model.addAttribute("errorMessage", e.getMessage());
                        return e.getMessage();
                    }
                }catch (Exception ex) {
//                dispatchException = ex;
                    log.info("App01001Tab01Form Exception ================================================================");
                    log.info("Exception =====>" + ex.toString());
                    return "fail";
//            log.debug("Exception =====>" + ex.toString() );
                }

            case "ELV_KYOUNG":
                ls_custcd = "KYOUNG";
                return "success";

            case "hanyangs":
                ls_custcd = "hanyangs";
                return "success";

            default:
                return "success";

        }


    }





    /**고장접수 저장*/
    @RequestMapping(value = "/save_e401", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String Save_E401ListForm(@RequestParam Map<String, String> param,
                                      Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";

        String ls_hitchtime = "";
        String ls_recetime = "";

        String ls_contcd = "";
        String ls_perid  = "";
        String ls_perid2 = "";

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "recedate":
                    String via = values.toString().replaceAll("-","");
                    app10tDto.setRecedate(via);
                    break;
                case "hitchdate":
                    String via2 = values.toString().replaceAll("-","");
                    app10tDto.setHitchdate(via2);
                    break;
                case "hitchhour":
                    values = values.replaceAll(":","");
                    app10tDto.setHitchhour(values);
                    break;
                case "perid":
                    app10tDto.setPerid(values.toString());
                    break;
                case "cltcd":
                    app10tDto.setCltcd(values.toString());
                    break;
                case "actcd":
                    app10tDto.setActcd(values.toString());
                    break;
                case "actnm":
                    app10tDto.setActnm(values.toString());
                    break;
                case "equpcd":
                    app10tDto.setEqupcd(values.toString());
                    break;
                case "equpnm":
                    app10tDto.setEqupnm(values.toString());
                    break;
                case "contcd":
                    app10tDto.setContcd(values.toString());
                    break;
                case "contents":
                    app10tDto.setContents(values.toString());
                    break;
                case "remark":
                    app10tDto.setRemark(values.toString());
                    break;
                case "recetime":
                    values = values.replaceAll(":","");
                    app10tDto.setRecetime(values.toString());
                    break;
                case "inperid":
                    app10tDto.setInperid(values.toString());
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();

        ls_hitchtime = app10tDto.getHitchhour();
        ls_recetime = app10tDto.getRecetime();
        ls_contcd = app10tDto.getContcd();
        ls_perid = app10tDto.getPerid();
        ls_perid2 = app10tDto.getInperid();




        int stCnt = ls_contcd.indexOf('[') + 1 ;
        int etCnt = ls_contcd.indexOf(']');
        ls_contcd = ls_contcd.substring(stCnt, etCnt);


        stCnt = 0; etCnt = 0;
        stCnt = ls_perid.indexOf('[') + 1 ;
        etCnt = ls_perid.indexOf(']');
        ls_perid = ls_perid.substring(stCnt, etCnt);

        stCnt = 0; etCnt = 0;
        stCnt = ls_perid2.indexOf('[') + 1 ;
        etCnt = ls_perid2.indexOf(']');
        ls_perid2 = ls_perid2.substring(stCnt, etCnt);


        final int PM_HOUR_OFFSET2 = 1200;
        final int MILITARY_TIME_LENGTH2 = 4;
        final String MIDNIGHT2 = "00";

        if(ls_hitchtime.contains("PM")){
            int hour = Integer.parseInt(ls_hitchtime.substring(0, 2));
            ls_hitchtime = ls_hitchtime.replace(":", "");
            ls_hitchtime = ls_hitchtime.substring(0, MILITARY_TIME_LENGTH2);
            if (hour != 12) {
                int militaryTime = Integer.parseInt(ls_hitchtime) + PM_HOUR_OFFSET2;
                ls_hitchtime = String.valueOf(militaryTime);
            }
        } else if (ls_hitchtime.contains("AM")) {
            int hour = Integer.parseInt(ls_hitchtime.substring(0, 2));
            ls_hitchtime = ls_hitchtime.replace(":", "");
            ls_hitchtime = ls_hitchtime.substring(0, MILITARY_TIME_LENGTH2);
            if (hour == 12) {
                ls_hitchtime = MIDNIGHT2 + ls_hitchtime.substring(2, 4);
            }
        }


        /**GPT가 짠 코드**/
        final int PM_HOUR_OFFSET = 1200;
        final int MILITARY_TIME_LENGTH = 4;
        final String MIDNIGHT = "00";

        if(ls_recetime.contains("PM")){
            int hour = Integer.parseInt(ls_recetime.substring(0, 2));
            ls_recetime = ls_recetime.replace(":", "");
            ls_recetime = ls_recetime.substring(0, MILITARY_TIME_LENGTH);
            if (hour != 12) {
                int militaryTime = Integer.parseInt(ls_recetime) + PM_HOUR_OFFSET;
                ls_recetime = String.valueOf(militaryTime);
            }
        } else if (ls_recetime.contains("AM")) {
            int hour = Integer.parseInt(ls_recetime.substring(0, 2));
            ls_recetime = ls_recetime.replace(":", "");
            ls_recetime = ls_recetime.substring(0, MILITARY_TIME_LENGTH);
            if (hour == 12) {
                ls_recetime = MIDNIGHT + ls_recetime.substring(2, 4);
            }
        }

        app10tDto.setHitchhour(ls_hitchtime);
        app10tDto.setRecetime(ls_recetime);
        app10tDto.setContcd(ls_contcd);
        app10tDto.setPerid(ls_perid);
        app10tDto.setReperid(ls_perid);
        app10tDto.setInperid(ls_perid2);

        log.info(app10tDto.getRecedate() + "recedate");
        log.info(app10tDto.getHitchhour() + "hitchhour");
        log.info(app10tDto.getHitchdate() + "hitchdate");

        log.info(app10tDto.getPerid() + " perid");    //31
        log.info(app10tDto.getCltcd() + " cltcd");
        log.info(app10tDto.getActcd() + " actcd");
        log.info(app10tDto.getActnm() + " actnm");
        log.info(app10tDto.getEqupcd() + " equpcd");
        log.info(app10tDto.getEqupnm() + " equpnm");
        log.info(app10tDto.getContcd() + " contcd");
        log.info(app10tDto.getContents() + "  content");
        log.info(app10tDto.getRemark()  + "  remark");
        log.info(app10tDto.getRecetime() + " recetime");
        log.info(app10tDto.getRecedate2() + " recedate2");
        log.info(app10tDto.getInperid() + " inperid");

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{
                    try {

                        int queryResult = 1;
                        app10tDto.setCustcd("ELVLRT");
                        app10tDto.setSpjangcd("ZZ");
                        app10tDto.setDatetime(getToDate().substring(0,4) + "-" + getToDate().substring(4,6) + "-" + getToDate().substring(6,8) + " 00:00:00.000");
                        app10tDto.setDatetime2(getToDate().substring(0,4) + "-" + getToDate().substring(4,6) + "-" + getToDate().substring(6,8) + " 00:00:00.000");
                        app10tDto.setIndate(getToDate());
                        log.info(app10tDto.getIndate() + "indate");


                            app10tDto.setRecenum(CountSeq01(app10tDto.getRecedate()));
                            log.info(app10tDto.getRecenum() + "recenum");

                            queryResult = service.InsertE401(app10tDto);

                        /*queryResult = service.UpdateE401(app10tDto);
*/
                        if (queryResult == 1){
                            return "success";
                        }else{
                            return "fail";
                        }

                    }catch (IllegalStateException e){
                        model.addAttribute("errorMessage", e.getMessage());
                        return e.getMessage();
                    }
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

    return "success";
    }




    public String CountSeq01(String yyyymm){
        String ls_recenum = "";
        ls_recenum = App01service.get10RecenumMaxSeq(yyyymm);
        int ll_mseq = 0;
        if(ls_recenum == null ){
            ls_recenum = "001";
        }else{
            ll_mseq = Integer.parseInt(ls_recenum);
            ls_recenum = Integer.toString(ll_mseq + 1 );
            switch (ls_recenum.length()){
                case 1:
                    ls_recenum = "00" + ls_recenum;
                    break;
                case 2:
                    ls_recenum = "0" + ls_recenum;
                    break;
                default:
                    break;
            }

        }
        return ls_recenum;
    }




    /**고장접수 삭제*/
    @RequestMapping(value = "/delete_e401", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String Delete_E401ListForm(@RequestParam Map<String, String> param,
                                    Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";


        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "recedate":
                    String via = values.toString().replaceAll("-","");
                    app10tDto.setRecedate(via);
                    break;
                case "recenum":
                    app10tDto.setRecenum(values.toString());

            }
        });
        ls_dbnm = userformDto.getDbnm();

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                try{
                    try {

                        int queryResult = 1;

                        queryResult = service.DeleteE401(app10tDto);
                        if (queryResult == 1){
                            return "success";
                        }else{
                            return "fail";
                        }

                    }catch (IllegalStateException e){
                        model.addAttribute("errorMessage", e.getMessage());
                        return e.getMessage();
                    }
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

        return "success";
    }




    /**처리 조회**/

    @RequestMapping(value = "/e411_list", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object E411listForm(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);


        String ls_dbnm = "";
        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "actnm":
                    popParmDto.setActnm(values.toString());
                    break;
                case "perid":
                    popParmDto.setPerid2(values.toString());
                    break;
                case "pernm":
                    popParmDto.setPernm(values.toString());
                    break;
                default:
                    break;
            }
        });
        ls_dbnm = userformDto.getDbnm();

        log.info(popParmDto.getPerid() + " perid");
        log.info(popParmDto.getPernm() + " pernm");


        //현재날짜기준 월초(1일) 구하기
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date  = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        String time2 = time.substring(0,6) + "01";



        // 현재 날짜 구하기
        LocalDate today = LocalDate.now();

        // 이번 달의 월말 구하기
        LocalDate endOfMonth = today.withDayOfMonth(today.lengthOfMonth());
        String endday = endOfMonth.toString().replaceAll("","");


        ls_spjangcd = "ZZ";
        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";


                popParmDto.setCustcd(ls_custcd);
                popParmDto.setSpjangcd(ls_spjangcd);
                popParmDto.setFrdate(time2);
                popParmDto.setTodate(endday);


                try {
                    app10DtoList = app10ElvlrtMobService.GetAppMobList002(popParmDto);
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

        return app10DtoList;
    }




    /**고장처리 삭제*/
    @RequestMapping(value = "/delete_e411", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String Delete_E411ListForm(@RequestParam Map<String, String> param,
                                      Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";


        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
                    break;
                case "compdate":
                    popParmDto.setCompdate(values.toString());
                    break;
                case "compnum":
                    popParmDto.setCompnum(values.toString());
                    break;
                case "recedate":
                    popParmDto.setRecedate(values.toString());
                    break;
                case "recenum":
                    popParmDto.setRecenum(values.toString());
                    break;

            }
        });
        ls_dbnm = userformDto.getDbnm();

        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                ls_spjangcd = "ZZ";

                popParmDto.setCustcd(ls_custcd);
                popParmDto.setSpjangcd(ls_spjangcd);

                try{
                    boolean result = app10ElvlrtMobService.DeleteList002(popParmDto);
                    if(!result){
                        log.info("error, 삭제불가능");
                        return "error";

                    }

                    boolean result2 = app10ElvlrtMobService.UpdateList002_rollback(popParmDto);
                    if (!result2) {
                        log.info("error, 수정불가능");
                        return "error";
                    }


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

        return "success";
    }






    /**박광열 고장처리 수정 **/
    @RequestMapping(value = "/e411_update", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String E411UpdateListForm(@RequestParam Map<String, String> param,
                                 Model model, HttpServletRequest request) throws Exception{

        HttpSession session = request.getSession();
        session.setAttribute("userformDto", userformDto);

        String ls_dbnm = "";
        String ls_gregicd = "";
        String ls_regicd = "";
        String ls_resucd = "";
        String ls_resultcd = "";
        String ls_perid = "";
        String ls_remocd = "";



        /*업로드 파일 정보를 담을 리스트*/
        List<AttachDTO> attachList = new ArrayList<>();

        String ls_custcd;
        String ls_spjangcd;

        param.forEach((key, values) -> {
            switch (key){
                case "dbnm":
                    userformDto.setDbnm(values.toString());
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
                    app10tDto.setResuremark(values.toString());
                    break;
                case "remocd":
                    app10tDto.setRemocd(values.toString());
                    break;
                case "perid":
                    app10tDto.setPerid(values.toString());
                    break;
                case "remoremark":
                    app10tDto.setRemoremark(values.toString());
                    break;
                case "compnum":
                    app10tDto.setCompnum(values.toString());
                    break;
                case "compdate":
                    app10tDto.setCompdate(values.toString());
                    break;
                case "recenum":
                    app10tDto.setRecenum(values.toString());
                    break;
                default:
                    break;
            }
        });

        ls_dbnm = userformDto.getDbnm();
        ls_gregicd = app10tDto.getGregicd();
        ls_regicd = app10tDto.getRegicd();
        ls_resucd = app10tDto.getResucd();
        ls_resultcd = app10tDto.getResultcd();
        ls_perid = app10tDto.getPerid();
        ls_remocd = app10tDto.getRemocd();

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

        stCnt = 0; etCnt = 0;
        stCnt = ls_remocd.indexOf('[') + 1;
        etCnt = ls_remocd.indexOf(']');
        ls_remocd = ls_remocd.substring(stCnt, etCnt);

        stCnt = 0; etCnt = 0;
        stCnt = ls_perid.indexOf('[') + 1;
        etCnt = ls_perid.indexOf(']');
        ls_perid = ls_perid.substring(stCnt, etCnt);





        switch (ls_dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                ls_spjangcd = "ZZ";

                app10tDto.setCustcd(ls_custcd);
                app10tDto.setSpjangcd(ls_spjangcd);

                app10tDto.setGregicd(ls_gregicd);
                app10tDto.setRegicd(ls_regicd);
                app10tDto.setResucd(ls_resucd);
                app10tDto.setResultcd(ls_resultcd);
                app10tDto.setPerid(ls_perid);
                app10tDto.setRemocd(ls_remocd);

                try{


                    log.info(app10tDto.getResultcd() + " resultcd");
                    log.info(app10tDto.getGregicd() + "gregicd") ;
                    log.info(app10tDto.getRegicd() + "regicd");
                    log.info(app10tDto.getRemocd() + "remocd");
                    log.info(app10tDto.getResucd() + "resucd");
                    log.info(app10tDto.getRemoremark() + "remoremark");
                    log.info(app10tDto.getResuremark() + "resuremark");
                    log.info(app10tDto.getRemark() + "remark");
                    log.info(app10tDto.getPerid() + "perid");
                    log.info(app10tDto.getUpdate_time() + "updatetime");









                    app10tDto.setUpdate_time(getToDate().substring(0,4) + "-" + getToDate().substring(4,6) + "-" + getToDate().substring(6,8) + " 00:00:00.000");

                    boolean result = app10ElvlrtMobService.Update10Manull(app10tDto);
                    if(!result){
                        log.info("error, 수정불가가가");
                        return "error";

                    }


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



        return "success";
    }



}
