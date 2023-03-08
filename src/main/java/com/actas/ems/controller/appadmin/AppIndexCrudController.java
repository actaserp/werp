package com.actas.ems.controller.appadmin;


import com.actas.ems.DTO.*;
import com.actas.ems.DTO.Elvlrt.App01ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.*;
import com.actas.ems.Service.master.AuthService;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/appadmod", method = RequestMethod.POST)
public class AppIndexCrudController {
    private final AuthService service;
    private final AppPopElvlrtService servicePop;
    List<UserFormDto> appUserFormListDto ;
    List<TBXLoginDTO> appUserLoginListDto ;
    UserFormDto appUserFormDto  = new UserFormDto();
    TBXa012VO appXa012Dto  = new TBXa012VO();
    TBXuserMenuDTO xusermenuDto = new TBXuserMenuDTO();
    private final App01ElvlrtService app01ElvlrtService;
    App01ElvlrtDto app01ElvlrtDto = new App01ElvlrtDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    private static final Logger logger     = LoggerFactory.getLogger(AppIndexCrudController.class);

    @RequestMapping(value="/id01mod")   //사용자 상태 수정
    public String UserUpdate(@RequestParam("actseqz") String userid
            ,@RequestParam("actuseynz") String useyn
            , Model model, HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            appUserFormDto.setCustcd(ls_custcd);
            appUserFormDto.setSpjangcd(ls_spjangcd);
            appUserFormDto.setUserid(userid);
            appUserFormDto.setUseyn(useyn);

            boolean result = service.UpdateUserInfo(appUserFormDto);
            if (!result) {
                return "error";
            }else{
                return "success";
            }
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }


    @RequestMapping(value="/id01menumod")   //사용자 메뉴 상태 수정
    public String UserMenuUpdate(@RequestParam("actuseridz") String userid
            ,@RequestParam("actmenuidz") String menuid
            ,@RequestParam("actviewz") String view
            , Model model, HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            xusermenuDto.setUserid(userid);
            xusermenuDto.setMenuid(menuid);
            xusermenuDto.setVisible(view);

            boolean result = service.UpdateUserMenuInfo(xusermenuDto);
            if (!result) {
                return "error";
            }else{
                return "success";
            }
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }


    @RequestMapping(value="/id01list")   //사용자 리스트 조회
    public Object UserList(@RequestParam("actusernamez") String usernm
            , Model model, HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            appUserFormDto.setCustcd(ls_custcd);
            appUserFormDto.setSpjangcd(ls_spjangcd);
            appUserFormDto.setUsername(usernm);
            appUserFormDto.setFlag("AA");
            appUserFormListDto = service.GetUserListDto(appUserFormDto);
            model.addAttribute("appUserFormListDto", appUserFormListDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return appUserFormListDto;
    }



    @RequestMapping(value="/id02mod")   //보수현장 상태 수정
    public String UserUpdate02(@RequestParam("actseqz") String userid
            ,@RequestParam("actuseynz") String useyn
            , Model model, HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            appUserFormDto.setCustcd(ls_custcd);
            appUserFormDto.setSpjangcd(ls_spjangcd);
            appUserFormDto.setUserid(userid);
            appUserFormDto.setUseyn(useyn);

            boolean result = service.UpdateUserInfo(appUserFormDto);
            if (!result) {
                return "error";
            }else{
                return "success";
            }
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }


    @RequestMapping(value="/id02list")   //사용자 리스트 조회
    public Object UserList02(@RequestParam("actusernamez") String usernm
            , Model model, HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            appUserFormDto.setCustcd(ls_custcd);
            appUserFormDto.setSpjangcd(ls_spjangcd);
            appUserFormDto.setUsername(usernm);
            appUserFormDto.setFlag("CC");
            appUserFormListDto = service.GetUserListDto(appUserFormDto);
            model.addAttribute("appUserFormListDto", appUserFormListDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return appUserFormListDto;
    }

    @RequestMapping(value="/id03list")   //사용자 리스트 조회
    public Object UserList03(@RequestParam("actusernamez") String usernm
            , Model model, HttpServletRequest request){
        try {
            appUserFormDto.setUserid(usernm);
            appUserLoginListDto = service.GetLogListDto(appUserFormDto);
            model.addAttribute("appUserFormListDto", appUserLoginListDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return appUserLoginListDto;
    }


    @RequestMapping(value="/id04mod")   //사업장정보 수정
    public String SpjangUpdate( @RequestPart(value = "key") Map<String, Object> param
            , Model model, HttpServletRequest request){

        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            appXa012Dto.setCustcd(ls_custcd);
            appXa012Dto.setSpjangcd("ZZ");

            int queryResult = 1;
            param.forEach((key, values) -> {
                switch (key) {
                    case "actsaupnumz":
                        appXa012Dto.setSaupnum(values.toString());
                        break;
                    case "actspjangnmz":
                        appXa012Dto.setSpjangnm(values.toString());
                        break;
                    case "actprenmz":
                        appXa012Dto.setPrenm(values.toString());
                        break;
                    case "actbiztypez":
                        appXa012Dto.setBiztype(values.toString());
                        break;
                    case "actitemz":
                        appXa012Dto.setItem(values.toString());
                        break;
                    case "acttel1z":
                        appXa012Dto.setTel1(values.toString());
                        break;
                    case "actagnertel1z":
                        appXa012Dto.setAgnertel1(values.toString());
                        break;
                    case "actagnertel2z":
                        appXa012Dto.setAgnertel2(values.toString());
                        break;
                    case "actemailadresz":
                        appXa012Dto.setEmailadres(values.toString());
                        break;
                    default:
                        break;
                }
            });

            queryResult = servicePop.UpdateXa012(appXa012Dto);

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

    @RequestMapping(value="/id05mod")   //사업장정보 수정
    public String ApicallUpdate( @RequestParam("actcalluseridz") String calluserid
            ,@RequestParam("actcalluserpwz") String calluserpw
            ,@RequestParam("actcallflagz") String callflag
            , Model model, HttpServletRequest request){

        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            app01ElvlrtDto.setCallflag(callflag);
            app01ElvlrtDto.setCalluserid(calluserid);
            app01ElvlrtDto.setCalluserpw(calluserpw);

            int queryResult = 0;
            queryResult = app01ElvlrtService.UpdateCallInfo(app01ElvlrtDto);

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

}
