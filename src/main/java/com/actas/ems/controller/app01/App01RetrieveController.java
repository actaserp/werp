package com.actas.ems.controller.app01;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppCallElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.elvlrt.App10ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app01mod", method = RequestMethod.POST)
public class App01RetrieveController {
    private final App01ElvlrtService service;
    App10ElvlrtDto app10tDto = new App10ElvlrtDto();
    AppCallElvlrtDto appCalltDto = new AppCallElvlrtDto();

    PopupDto popParmDto = new PopupDto();
    List<App03ElvlrtDto> app03DtoList01 = new ArrayList<>();

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
                return "success";
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

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }




}
