package com.actas.ems.controller.app01;


import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app01mod", method = RequestMethod.POST)
public class App01RetrieveController {
    private final App01ElvlrtService service;

    PopupDto popParmDto = new PopupDto();
    List<App03ElvlrtDto> app03DtoList = new ArrayList<>();
    List<App03ElvlrtDto> app03DtoList01 = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    String clientId = "261b1f258775bb5dd9a70a3b938aed73"; //h2xhfxhh0l";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "KfBfPJEo8qB2lMFHTxdpg9OGkNbIwASFaElmM3gh";//애플리케이션 클라이언트 시크릿값";


    // 관제현황 > 접수조회
    @GetMapping(value="/getgeocode")
    public Object App01001GetgeoForm( @RequestParam("addrtext") String addrtext
            , Model model) throws  Exception{
        Object returnDto = "";
        try {
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
    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
