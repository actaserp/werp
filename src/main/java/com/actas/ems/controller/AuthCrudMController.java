package com.actas.ems.controller;

import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App01ElvlrtService;
import com.actas.ems.Service.master.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/authm", method = RequestMethod.POST)
public class AuthCrudMController {
    private final AuthService authService;
    private final App01ElvlrtService app01ElvlrtService;
    UserFormDto userformDto = new UserFormDto();
    App01ElvlrtDto app01ElvlrtDto = new App01ElvlrtDto();
    EncryptionController enc = new EncryptionController();
    protected Log log =  LogFactory.getLog(this.getClass());



    @RequestMapping(value = "/loginmchk", method = RequestMethod.POST,
            headers = ("content-type=multipart/*"),
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object memberLoginMchkForm(@RequestParam Map<String, String> param
            , Model model
            , HttpServletRequest request) throws Exception{
        param.forEach((key, values) -> {
            switch (key){
                case "userid":
                    userformDto.setUserid(values.toString());
                    String _userid = values.toString();
                    break;
                case "userpw":
                    userformDto.setPasswd1(values.toString());
                    String _userpw = values.toString();
                    break;
                case "pushid":
                    userformDto.setPushid(values.toString());
                    break;
                default:
                    break;
            }
        });
        userformDto.setFlag("AA");
        UserFormDto userReturnDto = authService.GetUserInfo(userformDto);

        if(userReturnDto.getWrongnum().equals("3")){
            return userReturnDto;
        }

        authService.TB_XUSERS_LOGSUCC(userReturnDto);

        String ls_dbnm = userReturnDto.getDbnm();
        model.addAttribute("UserInfo", userReturnDto );
        switch (ls_dbnm){
            case "ELV_LRT":      //한국엘레텍
                break;
            default:
                break;
        }

        String _pushid = userformDto.getPushid();
        userformDto =  authService.GetUserInfoDto(userformDto);
        userformDto.setPushid(_pushid);
//       String seq = String.valueOf(userformDto.getSeq());
//       userformDto.getSeq().toString();

        String dbnm = userformDto.getDbnm();
        String ls_custcd = "";
        String ls_spjangcd = "";

        switch (dbnm){
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
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
        ls_spjangcd = "ZZ";
        userformDto.setCustcd(ls_custcd);
        userformDto.setSpjangcd(ls_spjangcd);
        boolean result = authService.Updatepushid(userformDto);
        HttpSession session = request.getSession();
        session.setAttribute("userformDto",userformDto);


        return userReturnDto;
    }

}
