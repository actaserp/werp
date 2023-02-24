package com.actas.ems.controller.app01;


import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppCall601ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppCallElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.elvlrt.AppPopElvlrtService;
import com.actas.ems.Service.elvlrt.AppSmsMcsService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.sun.el.lang.ELArithmetic.isNumber;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app01mod", method = RequestMethod.POST)
public class App01RetrieveController {
    private final App01ElvlrtService service;
    private final AppSmsMcsService serviceSMS;
    private final AppPopElvlrtService appPopElvlrtService;
    App10ElvlrtDto app10tDto = new App10ElvlrtDto();
    AppCallElvlrtDto appCalltDto = new AppCallElvlrtDto();
    AppCall601ElvlrtDto app601callDto = new AppCall601ElvlrtDto();
    List<AppCall601ElvlrtDto>  app601callListDto = new ArrayList<>();
    PopupDto popParmDto = new PopupDto();
    List<App03ElvlrtDto> app03DtoList01 = new ArrayList<>();
    AppCallElvlrtDto appCallDto = new AppCallElvlrtDto();
    List<AppCallElvlrtDto> appCallDtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    String clientId = "261b1f258775bb5dd9a70a3b938aed73"; //h2xhfxhh0l";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "KfBfPJEo8qB2lMFHTxdpg9OGkNbIwASFaElmM3gh";//애플리케이션 클라이언트 시크릿값";


    // 관제현황 > 접수조회
    @GetMapping(value="/getgeocode")
    public Object App01001GetgeoForm( @RequestParam("addrtext") String addrtext
            , Model model, HttpServletRequest request) throws  Exception{
        Object returnDto = "";
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");


            String text = URLEncoder.encode(addrtext, "UTF-8");
            String apiURL = "https://dapi.kakao.com/v2/local/search/address.json";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "KakaoAK " + clientId);
//            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            String postParams = "query=" + text;

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
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


    // 관제현황 > 라인조회
    @GetMapping(value="/getlinecode")
    public Object App01001GetlineForm( @RequestParam("phone") String phone
            , Model model) throws  Exception{
        Object returnDto = "";
        try {
            String todate = getToDate();
            String frdate =  getToDate();
            popParmDto.setFrdate(frdate);
            popParmDto.setTodate(todate);
            popParmDto.setActcd("%");
            popParmDto.setHandphone(phone);
            app03DtoList01 = service.GetApp01List004(popParmDto);
            model.addAttribute("app03DtoList",app03DtoList01);
        } catch (Exception e) {
            System.out.println(e);
        }
        return app03DtoList01;
    }

    // 고객상담센터 > 승강기번호조회
    @GetMapping(value="/getelvinfo")
    public Object App01001GetElvInfoForm( @RequestParam("elvnum") String elvnum
            , Model model) throws  Exception{
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

    // 고장접수현황 > 접수등록
    @RequestMapping(value="/savee401")
    public String saveE401Rtn ( @RequestPart(value = "key") Map<String, Object> param
            , Model model
            , HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            app10tDto.setCustcd(ls_custcd);
            app10tDto.setSpjangcd(ls_spjangcd);

            int queryResult = 1;
            param.forEach((key, values) -> {
                switch (key) {
                    case "actrecedatez":
                        app10tDto.setRecedate(values.toString());
                        break;
                    case "actrecenumz":
                        app10tDto.setRecenum(values.toString());
                        break;
                    case "actrecetimez":
                        app10tDto.setRecetime(values.toString());
                        break;
                    case "acthitchdatez":
                        app10tDto.setHitchdate(values.toString());
                        break;
                    case "acthitchhourz":
                        app10tDto.setHitchhour(values.toString());
                        break;
                    case "actactcdz":
                        app10tDto.setActcd(values.toString());
                        break;
                    case "actequpcdz":
                        app10tDto.setEqupcd(values.toString());
                        break;
                    case "actreperidz":
                        app10tDto.setReperid(values.toString());
                        break;
                    case "actperidz":
                        app10tDto.setPerid(values.toString());
                        break;
                    case "actcontcdz":
                        app10tDto.setContcd(values.toString());
                        break;
                    case "actcontentsz":
                        app10tDto.setContents(values.toString());
                        break;
                    case "actremarkz":
                        app10tDto.setRemark(values.toString());
                        break;
                    default:
                        break;
                }
            });

            String ls_recedate = "";
            String ls_hitchdate = "";
            String ls_recenum = "";
            app10tDto.setIndate(getToDate());
            app10tDto.setInperid(userformDto.getUsername());
            ls_recedate = app10tDto.getRecedate();
            ls_recenum = app10tDto.getRecenum();
            ls_hitchdate = app10tDto.getHitchdate();
            String ls_yeare = ls_recedate.substring(0,4);
            String ls_mm = ls_recedate.substring(5,7);
            String ls_dd = ls_recedate.substring(8,10);
            ls_recedate =  ls_yeare + ls_mm + ls_dd;


            ls_yeare = ls_hitchdate.substring(0,4);
            ls_mm = ls_hitchdate.substring(5,7);
            ls_dd = ls_hitchdate.substring(8,10);
            ls_hitchdate =  ls_yeare + ls_mm + ls_dd;

            app10tDto.setRecedate(ls_recedate);
            app10tDto.setHitchdate(ls_hitchdate);
            if(ls_recenum == null || ls_recenum.equals("")){
                app10tDto.setRecenum(CountSeq(ls_recedate));
                queryResult = service.InsertE401(app10tDto);
            }else{
                queryResult = service.UpdateE401(app10tDto);
            }
            if (queryResult == 1){
                return "success";
            }else{
                return "fail";
            }

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return e.getMessage();
        }



    }
    // 고장접수현황 > 접수삭제
    @GetMapping(value="/deletee401")
    public Object deleteE401Rtn( @RequestParam("actrecedatez") String recedate
            ,@RequestParam("actrecenumz") String recenum
            , Model model
            , HttpServletRequest request) throws  Exception{
        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        try {
            String ls_recedate = "";
            String ls_recenum = "";
            int queryResult = 1;
            app10tDto.setIndate(getToDate());
            app10tDto.setInperid(userformDto.getUsername());
            ls_recedate = recedate;
            ls_recenum = recenum;
            String ls_yeare = ls_recedate.substring(0,4);
            String ls_mm = ls_recedate.substring(5,7);
            String ls_dd = ls_recedate.substring(8,10);
            ls_recedate =  ls_yeare + ls_mm + ls_dd;

            app10tDto.setRecedate(ls_recedate);
            app10tDto.setRecenum(ls_recenum);


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
    }

    // 고장접수현황 > 통화메모등록
    @RequestMapping(value="/savecall")
    public String saveCallRtn ( @RequestPart(value = "key") Map<String, Object> param
            , Model model
            , HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

        try {

            int queryResult = 1;
            param.forEach((key, values) -> {
                switch (key) {
                    case "actcalldatez":
                        appCalltDto.setCalldate(values.toString());
                        break;
                    case "actcalltimez":
                        appCalltDto.setCalltime(values.toString());
                        break;
                    case "actseqz":
                        appCalltDto.setSeq(values.toString());
                        break;
                    case "actcallnmz":
                        appCalltDto.setCallnm(values.toString());
                        break;
                    case "actcallnumz":
                        appCalltDto.setCallnum(values.toString());
                        break;
                    case "callbackflag":
                        appCalltDto.setCallbackflag(values.toString());
                        break;
                    case "actcallbacktimez":
                        appCalltDto.setCallbacktime(values.toString());
                        break;
                    case "actcallbackmemoz":
                        appCalltDto.setCallbackmemo(values.toString());
                        break;
                    case "actcallmemoz":
                        appCalltDto.setCallmemo(values.toString());
                        break;
                    case "actcallendmemoz":
                        appCalltDto.setCallendmemo(values.toString());
                        break;
                    default:
                        break;
                }
            });

            String ls_calldate = "";
            String ls_seq = "";
            appCalltDto.setRegdate(getToDate());
            appCalltDto.setPernm(userformDto.getUsername());
            ls_calldate = appCalltDto.getCalldate();
            ls_seq = appCalltDto.getSeq();
            String ls_yeare = ls_calldate.substring(0,4);
            String ls_mm = ls_calldate.substring(5,7);
            String ls_dd = ls_calldate.substring(8,10);
            ls_calldate =  ls_yeare + ls_mm + ls_dd;


            appCalltDto.setCalldate(ls_calldate);
            if(ls_seq == null || ls_seq.equals("")){
                appCalltDto.setSeq(CountCallSeq(ls_calldate.substring(0,6)));
                queryResult = service.InsertCall(appCalltDto);
            }else{
                queryResult = service.UpdateCall(appCalltDto);
            }
            if (queryResult == 1){

                String ls_callnm = service.getE601CallNM(appCalltDto.getCallnum());
                if(ls_callnm == null || ls_callnm.equals("")){
                    if(appCalltDto.getCallnm().length() > 0){
                        app601callDto.setCustcd(userformDto.getCustcd());
                        app601callDto.setSpjangcd(userformDto.getSpjangcd());
                        app601callDto.setActcd(CountCall601Seq(ls_calldate.substring(0,6)));
                        app601callDto.setSeq("01");
                        app601callDto.setRegdate(getToDate());
                        app601callDto.setTel(appCalltDto.getCallnum());
                        app601callDto.setActmail(appCalltDto.getCallnm());
                        queryResult = service.InsertE601CALL(app601callDto);
                        if (queryResult == 1){
                            queryResult = service.InsertE601CALL01(app601callDto);
                            if (queryResult == 1){
                                return "success";
                            }else{
                                return "fail";
                            }
                        }else{
                            return "fail";
                        }
                    }

                }
                return "success";
            }else{
                return "fail";
            }

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return e.getMessage();
        }
    }

    // 고장접수현황 > 문자전송등록
    @RequestMapping(value="/savesms01")
    public String saveSMS01Rtn ( @RequestPart(value = "smsdata") Map<String, Object> param
            , Model model
            , HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

        try {

            int queryResult = 1;
            param.forEach((key, values) -> {
                switch (key) {
                    case "smscaller":
                        appCalltDto.setSmscaller(FillString(10, values.toString(), "R"));
                        break;
                    case "smstel":
                        appCalltDto.setSmshandphone(values.toString());
                        appCalltDto.setSmstel(FillNumber(values.toString()));
                        break;
                    case "smschk":
                        appCalltDto.setSmschk(values.toString());
                        break;
                    case "smsrepernm":
                        appCalltDto.setSmsrepernm(values.toString());
                        break;
                    case "smspernm":
                        appCalltDto.setSmspernm(values.toString());
                        break;
                    case "smssubject":
                        appCalltDto.setSmssubject(values.toString());
                        break;
                    case "smsmsg":
                        appCalltDto.setSmstext(values.toString());
                        appCalltDto.setSmsmsg(FillString(80, values.toString(), "R"));
                        break;
                    case "recedate":
                        appCalltDto.setSmsrecedate(values.toString());
                        break;
                    case "recenum":
                        appCalltDto.setSmsrecenum(values.toString());
                        break;
                    case "actactcdz":
                        appCalltDto.setSmsactcd(values.toString());
                        break;
                    case "actequpcdz":
                        appCalltDto.setSmsequpcd(values.toString());
                        break;
                    case "actrecetimez":
                        appCalltDto.setSmsrecetime(values.toString());
                        break;

                    default:
                        break;
                }
            });

            popParmDto = appPopElvlrtService.GetSmsInfoList(popParmDto);
            appCalltDto.setCustcd(userformDto.getCustcd());
            appCalltDto.setSpjangcd(userformDto.getSpjangcd());
            appCalltDto.setRegdate(getToDate());
            appCalltDto.setPernm(userformDto.getUsername());
            appCalltDto.setMsgtype("01");
            appCalltDto.setMsglen("0144");
            appCalltDto.setSmsid(FillString(10, popParmDto.getSms_id(), "R"));
            appCalltDto.setSmsps(FillString(10, popParmDto.getSms_ps(), "R"));
            appCalltDto.setSmsip(popParmDto.getSms_ip());
            appCalltDto.setSmssetcolumn("sms_text");
            appCalltDto.setSmsfport(popParmDto.getSms_fport());
            appCalltDto.setSmsfport(popParmDto.getSms_tport());
            appCalltDto.setSmscallback(FillNumber(appCalltDto.getSmscaller()));
            appCalltDto.setSmsdestinfo(appCalltDto.getSmspernm() + "^" + appCalltDto.getSmstel() + "|");


            Integer ll_end = 0, ll_cnt = 1, ll_rnd = 0, ll_fport = 0;
            String [] ls_port = {"7191","7192","7193","7194","7195"};
            String ls_recedate = "";
            Random random = new Random();

            ls_recedate = appCalltDto.getSmsrecedate();
            String ls_yeare = ls_recedate.substring(0,4);
            String ls_mm = ls_recedate.substring(5,7);
            String ls_dd = ls_recedate.substring(8,10);
            ls_recedate =  ls_yeare + ls_mm + ls_dd;
            appCalltDto.setSmsrecedate(ls_recedate);
            appCalltDto.setCalldate(ls_recedate + appCalltDto.getSmsrecetime());



            ll_fport = Integer.parseInt(popParmDto.getSms_fport());
            ll_end = Integer.parseInt(popParmDto.getSms_tport()) - Integer.parseInt(popParmDto.getSms_fport()) + 1;
            if(ll_end == 1){
                appCalltDto.setSmsport(popParmDto.getSms_fport());
            }else {
                ll_rnd = random.nextInt(5);
                appCalltDto.setSmsport(ls_port[ll_rnd]);
            }

            appCalltDto.setSmsredata01(userformDto.getSpjangcd() + "^" + appCalltDto.getSmsrecedate() + appCalltDto.getSmsrecenum() );
            appCalltDto.setSmsredata02(userformDto.getSpjangcd() + "^" + "W|" + appCalltDto.getSmsactcd());
            appCalltDto.setSmsredata03(appCalltDto.getSmspernm());
            appCalltDto.setSmsredata04(userformDto.getSpjangcd() + "^" + appCalltDto.getSmspernm() );
            appCalltDto.setSmsredata05(appCalltDto.getSmsrepernm());
            if(appCalltDto.getSmschk().equals("S")){
                queryResult = serviceSMS.InsertShortSms(appCalltDto);
            }else{
                queryResult = serviceSMS.InsertLongSms(appCalltDto);
            }
            appCalltDto.setSmsresult(Integer.toString(queryResult));

            if (queryResult == 1){
                appCalltDto.setSmsmsgid(CountSmsSeq(ls_yeare + ls_mm));
                queryResult = service.InsertE401Sms(appCalltDto);
                if (queryResult == 1){
                    return "success";
                }else{
                    return "fail";
                }
            }else{
                return "fail";
            }

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return e.getMessage();
        }
    }



    // 고장접수현황 >  전화수신삭제
    @GetMapping(value="/deletecall")
    public Object deleteCallRtn( @RequestParam("actseqz") String seq
            , Model model
            , HttpServletRequest request) throws  Exception{
        try {
            int queryResult = 1;
            appCalltDto.setSeq(seq);
            queryResult = service.DeleteCall(appCalltDto);
            if (queryResult == 1){
                return "success";
            }else{
                return "fail";
            }
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return e.getMessage();
        }
    }




    //  고객상담 > 콜백리스트
    @GetMapping(value="/wcallbacklist")
    public Object App01CallBacklistForm( @RequestParam("searchtxt") String callflag
            , Model model) throws  Exception{

        appCallDto.setCallbackflag(callflag);
        try {
            appCallDtoList = service.GetCallBackList(appCallDto);
            model.addAttribute("app03TelList",appCallDtoList);
        }catch (DataAccessException e) {
            log.info("App01CallBacklistForm DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App01CallBacklistForm Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return appCallDtoList;

    }


    //  고객상담 > 콜백업데이트
    @GetMapping(value="/wcallbackflag")
    public String App01CallBackUpdateForm( @RequestParam("seq") String seq
            , Model model) throws  Exception{
        appCallDto.setSeq(seq);
        appCallDto.setCallbackflag("0");
        try {
            int queryResult = service.UpdateCall(appCallDto);
            if(queryResult == 1){
                return "success";
            }else{
                return "fail";
            }
        }catch (DataAccessException e) {
            log.info("App01CallBacklistForm DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App01CallBacklistForm Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return "success";

    }


    //  고객상담 > 전화번호부리스트
    @GetMapping(value="/wpbooklist")
    public Object App01PhoneBooklistForm( @RequestParam("searchtxt") String actmail
            , Model model) throws  Exception{
        app601callDto.setActmail(actmail);
        try {
            app601callListDto = service.GetPhonebookList(app601callDto);
            model.addAttribute("app601callListDto",app601callListDto);
        }catch (DataAccessException e) {
            log.info("App01CallBacklistForm DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App01CallBacklistForm Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app601callListDto;

    }


    // 고장접수현황 >  전화번호수정
    @GetMapping(value="/updatepbook")
    public Object updatePhoneBookRtn( @RequestParam("actactmailz") String actmail
            ,@RequestParam("actactcdz") String actcd
            ,@RequestParam("actseqz") String seq
            ,@RequestParam("acttelz") String tel
            ,@RequestParam("actremarkz") String remark
            , Model model
            , HttpServletRequest request) throws  Exception{
        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            int queryResult = 1;
            String ls_today = getToDate();
            app601callDto.setActmail(actmail);
            app601callDto.setActcd(actcd);
            app601callDto.setSeq(seq);
            app601callDto.setTel(tel);
            app601callDto.setRemark(remark);
            app601callDto.setRegdate(ls_today);
            String ls_seq = app601callDto.getSeq();
            if(ls_seq == null || ls_seq.equals("")){
                app601callDto.setCustcd(userformDto.getCustcd());
                app601callDto.setSpjangcd(userformDto.getSpjangcd());
                app601callDto.setActcd(CountCall601Seq(ls_today.substring(0,6)));
                app601callDto.setSeq("01");
                app601callDto.setRegdate(getToDate());
                queryResult = service.InsertE601CALL(app601callDto);
                if (queryResult == 1){
                    queryResult = service.InsertE601CALL01(app601callDto);
                    if (queryResult == 1){
                        return "success";
                    }else{
                        return "fail";
                    }
                }else{
                    return "fail";
                }
            }else{
                queryResult = service.UpdateE601CALL(app601callDto);
                if (queryResult == 1){
                    queryResult = service.UpdateE601CALL01(app601callDto);
                    if (queryResult == 1){
                        return "success";
                    }else{
                        return "fail";
                    }
                }else{
                    return "fail";
                }

            }
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return e.getMessage();
        }
    }

    // 고장접수현황 >  전화번호삭제
    @GetMapping(value="/deletepbook")
    public Object deletePhoneBookRtn( @RequestParam("actactcdz") String actcd
            ,@RequestParam("actseqz") String seq
            , Model model
            , HttpServletRequest request) throws  Exception{
        try {
            int queryResult = 1;
            app601callDto.setActcd(actcd);
            app601callDto.setSeq(seq);
            queryResult = service.DeleteE601CALL01(app601callDto);
            if (queryResult == 1){
                queryResult = service.DeleteE601CALL(app601callDto);
                if (queryResult == 1){
                    return "success";
                }else{
                    return "fail";
                }
            }else{
                return "fail";
            }
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return e.getMessage();
        }
    }


    public String CountSeq(String yyyymm){
        String ls_recenum = "";
        ls_recenum = service.get10RecenumMaxSeq(yyyymm);
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


    public String CountCallSeq(String yyyymm){
        String ls_seq = "";
        ls_seq = service.getCllMaxSeq(yyyymm);
        int ll_mseq = 0;
        if(ls_seq == null ){
            ls_seq = yyyymm + "0001";
        }else{
            ll_mseq = Integer.parseInt(ls_seq);
            ls_seq = Integer.toString(ll_mseq + 1 );

        }
        return ls_seq;
    }

    public String CountSmsSeq(String yyyymm){
        String ls_seq = "";
        ls_seq = service.getSmsMaxSeq(yyyymm);
        int ll_mseq = 0;
        if(ls_seq == null ){
            ls_seq = yyyymm + "0001";
        }else{
            ll_mseq = Integer.parseInt(ls_seq);
            ls_seq = Integer.toString(ll_mseq + 1 );

        }
        return ls_seq;
    }


    public String CountCall601Seq(String yyyymm){
        String ls_seq = "";
        ls_seq = service.gete601CallMaxSeq(yyyymm);
        int ll_mseq = 0;
        if(ls_seq == null ){
            ls_seq = "30000001";
        }else{
            ll_mseq = Integer.parseInt(ls_seq);
            ls_seq = Integer.toString(ll_mseq + 1 );

        }
        return ls_seq;
    }


    public String FillString(Integer as_len, String as_str, String as_flag){
        String result = "", ls_str = "";

        if(as_str.length() >= as_len){
            if (as_flag == "R"){
                result = as_str.substring(0, as_len) + ls_str;
            }else{
                result = ls_str + as_str.substring(0, as_len) ;
            }
        }else{
            int cnt = as_len - as_str.length();
            for (int h= 0; h < cnt; h++){
                ls_str += " ";
            }
            if (as_flag == "R"){
                result = as_str + ls_str;
            }else{
                result =  ls_str + as_str;
            }
        }
        return result  ;
    }
    public String FillNumber(String as_str){
        String result = "", ls_numchk = "";
        Integer ll_len = as_str.length();
        CheckNum chkrtn = new CheckNum();
        for (int i = 0; i < ll_len; i++ ){
            ls_numchk = as_str.substring(i, i+1);
            if( chkrtn.isNumber(ls_numchk) ){
                result = result + ls_numchk;
            }
        }
        return result  ;
    }

    class CheckNum{
        public boolean isNumber(String str_num) {
            try {
                double str = Double.parseDouble(str_num);
            }
            catch(NumberFormatException e) {
                return false;
            }
            return true;
        }
    }

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }




}
