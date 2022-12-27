package com.actas.ems.controller.app09;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App09ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App09ElvlrtService;

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
@RequestMapping(value = "/app09mod", method = RequestMethod.POST)
public class App09CrudController {

    private final App09ElvlrtService appService;

    private final UIUtils utils;


    App09ElvlrtDto app09Dto = new App09ElvlrtDto();

    AttachDTO attachDTO = new AttachDTO();
    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    private static final Logger logger = LoggerFactory.getLogger(App09CrudController.class);

        @RequestMapping(value = "/saveboard")
    public String memberSave(@RequestParam("actfseqz") String fseq
            , @RequestParam("actfsubjectz") String fsubject
            , @RequestParam("actfmemoz") String fmemo
            , @RequestParam("actfflagz") String fflag
            , Model model, HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            String finputdate = getToDate();
            String ls_yeare = finputdate.substring(0,4);
            String ls_mm = finputdate.substring(4,6);
//            finputdate =  ls_yeare + ls_mm ; //추가함

            app09Dto.setCustcd(ls_custcd);
            app09Dto.setSpjangcd(ls_spjangcd);
            if(fseq == null || fseq.equals("")){
                app09Dto.setFseq(CountSeq(ls_yeare + ls_mm));
            }else{
                app09Dto.setFseq(fseq);
            }
            app09Dto.setFsubject(fsubject);
            app09Dto.setFmemo(fmemo);
            app09Dto.setFflag(fflag);
            app09Dto.setYyyymm(ls_yeare + ls_mm);
            app09Dto.setFpernm(userformDto.getUsername());
            log.info(app09Dto); //consolelog에 app04Dto 호출

//            if(fseq == null || fseq.equals("")){
//                appService.InsertMManu(app04Dto);
//            }else{
//                appService.UpdateMManu(app04Dto);
//            }

            if(fseq == null || fseq.equals("")){
                boolean result = appService.InsertFQManu(app09Dto);
                if (!result) {
                    return "error";
                }
            }else{
                boolean result = appService.UpdateFQManu(app09Dto);
                if (!result) {
                    return "error";
                }
            }
            model.addAttribute("userformDto",userformDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        String ls_fseq = app09Dto.getFseq();
        return ls_fseq;


    }


    @RequestMapping("/del")
    public String mmnualDelete(@RequestParam("actfseqz") String fseq, Model model, HttpServletRequest request,
                               @RequestParam("actflagz") String fflag){
        try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userFormDto.getCustcd();
            String ls_spjangcd = userFormDto.getSpjangcd();
            app09Dto.setFseq(fseq);
            app09Dto.setFflag(fflag);

            boolean result = appService.DeleteFQManu(app09Dto);
            if(!result){
                return "error";
            }

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }

        return "success";
    }

    public String CountSeq(String yyyymm){
        String ls_fseq = appService.getFQManualMaxSeq(yyyymm);
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
        Date date      = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

}
