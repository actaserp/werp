package com.actas.ems.controller.app07;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App07ElvlrtService;
import com.actas.ems.Service.elvlrt.App07UploadService;
import com.actas.ems.Service.elvlrt.App07UploadServiceImpl;
import com.actas.ems.controller.SyFileM;
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
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app07mod", method = RequestMethod.POST)
public class App07CrudController {

    private final App07ElvlrtService appService;

    private final App07UploadServiceImpl appServiceImpl;
    private final App07UploadService app04UploadService;
    private final UIUtils utils;


    App07ElvlrtDto app04Dto = new App07ElvlrtDto();

    AttachDTO attachDTO = new AttachDTO();
    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    private static final Logger logger = LoggerFactory.getLogger(App07CrudController.class);



    private final String uploadPath = Paths.get("C:", "develop", "upload","mfix", getToDate()).toString();

    @RequestMapping(value = "/saveboard")
    public String memberSave(@RequestParam("actfseqz") String fseq
            ,@RequestParam("actfinputdatez") String finputdate
            , @RequestParam("actfgourpcdz") String fgourpcd
            , @RequestParam("actfnsubjectz") String fnsubject
            , @RequestParam("actffilenamez") String ffilename
            , @RequestParam("actfpernmz") String fpernm
            , @RequestParam("actfmemoz") String fmemo
            , @RequestParam("actfflagz") String fflag
            , Model model, HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            String ls_yeare = finputdate.substring(0,4);
            String ls_mm = finputdate.substring(5,7);
            String ls_dd = finputdate.substring(8,10);
            finputdate =  ls_yeare + ls_mm + ls_dd;

            app04Dto.setCustcd(ls_custcd);
            app04Dto.setSpjangcd(ls_spjangcd);
            if(fseq == null || fseq.equals("")){
                app04Dto.setFseq(CountSeq(ls_yeare + ls_mm));
            }else{
                app04Dto.setFseq(fseq);
            }

            app04Dto.setFinputdate(finputdate);
            app04Dto.setFgourpcd(fgourpcd);
            app04Dto.setFnsubject(fnsubject);
            app04Dto.setFfilename(ffilename);
            app04Dto.setFpernm(fpernm);
            app04Dto.setFmemo(fmemo);
            app04Dto.setFflag(fflag);
            app04Dto.setYyyymm(ls_yeare + ls_mm);
            app04Dto.setFpernm(userformDto.getUsername());
            if(fseq == null || fseq.equals("")){
                appService.InsertMManu(app04Dto);
            }else{
                appService.UpdateMManu(app04Dto);
            }
            model.addAttribute("userformDto",userformDto);
            log.info("sibab");

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        String ls_fseq = app04Dto.getFseq();
        return ls_fseq;


    }
    /**
     * 서버에 생성할 파일명을 처리할 랜덤 문자열 반환
     * @return 랜덤 문자열
     */
    private final String getRandomString() { return UUID.randomUUID().toString().replaceAll("-", "");}


    @RequestMapping("/save")
    public String mmnualUpload( @RequestPart(value = "key") Map<String, Object> param,
                                @RequestPart(value = "file",required = false) List<MultipartFile> file
            , Model model
            , HttpServletRequest request){

        String ls_fileName = "";
        String ls_errmsg = "";
        /*업로드 파일 정보를 담을 리스트*/
        List<AttachDTO> attachList = new ArrayList<>();

        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        String ls_custcd = userformDto.getCustcd();
        String ls_spjangcd = userformDto.getSpjangcd();

        param.forEach((key, values) -> {
            switch (key){
                case "actfseqz":
                    app04Dto.setFseq(values.toString());
                    break;
                case "actfinputdatez":
                    app04Dto.setFinputdate(values.toString());
                    break;
                case "actfgroupcdz":
                    app04Dto.setFgourpcd(values.toString());
                    break;
                case "actfnsubjectz":
                    app04Dto.setFnsubject(values.toString());
                    break;
                case "actfpernmz":
                    app04Dto.setFpernm(values.toString());
                    break;
                case "actfmemoz":
                    app04Dto.setFmemo(values.toString());
                    break;
                case "actfflagz":
                    app04Dto.setFflag(values.toString());
                    break;
                default:
                    break;
            }
        });
        String fseq = app04Dto.getFseq();
        app04Dto.setCustcd(ls_custcd);
        app04Dto.setSpjangcd(ls_spjangcd);
        app04Dto.setFpernm(userformDto.getUsername());
        String finputdate = app04Dto.getFinputdate();
        String ls_yeare = finputdate.substring(0,4);
        String ls_mm = finputdate.substring(5,7);
        String ls_dd = finputdate.substring(8,10);
        finputdate =  ls_yeare + ls_mm + ls_dd;
        app04Dto.setFinputdate(finputdate);
        if(fseq == null || fseq.equals("")){
            app04Dto.setFseq(CountSeq(ls_yeare + ls_mm));
        }else{
            app04Dto.setFseq(fseq);
        }
        app04Dto.setYyyymm(ls_yeare + ls_mm);
        if(fseq == null || fseq.equals("")) {
            boolean result = appService.InsertMManu(app04Dto);
            if (!result) {
                return "error";
            }
        }else{
            boolean result = appService.UpdateMManu(app04Dto);
            if(!result){
                return "error";
            }
        }
        model.addAttribute("userformDto", userformDto);

        File dir = new File(uploadPath);
        if(dir.exists() == false){
            dir.mkdirs();
        }
        try {
            for (MultipartFile multipartFile : file) {
//                log.info("================================================================");
//                log.info("upload file name : " + multipartFile.getOriginalFilename());
//                log.info("upload file name : " + multipartFile.getSize());
                ls_fileName = multipartFile.getOriginalFilename();


                /* 파일이 비어있으면 비어있는 리스트 반환 */
                if (multipartFile.getSize() < 1) {
                    ls_errmsg = "success";
                    return ls_errmsg;
                }

                /*파일 확장자*/
                final String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

                final String saveName = getRandomString() + "." + extension;

                /*업로드 경로에 saveName과 동일한 이름을 가진 파일 생성*/
                File target = new File(uploadPath, saveName);
                multipartFile.transferTo(target);
                String fseq1 = app04Dto.getFseq();
                /* 파일 정보 저장 */
                AttachDTO attach = new AttachDTO();
                attach.setBoardIdx(fseq1);
                attach.setOriginalName(multipartFile.getOriginalFilename());
                attach.setSaveName(saveName);
                attach.setSize(multipartFile.getSize());
                attach.setFlag("MF");
                log.info(attach.getBoardIdx());
                /* 파일 정보 추가 */
                attachList.add(attach);



            }
            log.info("true");

            boolean result = appServiceImpl.registerMManu(app04Dto, attachList);
            if(result) {
                log.info("true");
            }
            if (!result) {
                return "error";
            }
        }catch (DataAccessException e){
            log.info("memberUpload DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException("[" + ls_fileName + "] DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        } catch (Exception  e){
            // log.info("memberUpload Exception ================================================================");
            // log.info(attachDTO);
            // log.info(e.toString());
            // ls_errmsg = "[" + ls_fileName + "] failed to save";
            // throw new AttachFileException("[" + ls_fileName + "] failed to save");
            //utils.showMessageWithRedirect("시스템에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }/*
        finally {
            return "success";
        }*/

        return "success";
//        utils.showMessageWithRedirect("게시글 등록이 완료되었습니다", "/app04/app04list/", Method.GET, model);

    }






    @RequestMapping("/del")
    public String mmnualDelete(@RequestParam("actfseqz") String fseq, Model model, HttpServletRequest request, @RequestParam("actflagz") String fflag){
        try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userFormDto.getCustcd();
            String ls_spjangcd = userFormDto.getSpjangcd();
            app04Dto.setFseq(fseq);
            app04Dto.setFflag(fflag);

            boolean result = appService.DeleteMManu(app04Dto);
            if(!result){
                return "error";
            }
            result = appServiceImpl.registerMManuDel(app04Dto);
            if(!result){
                return  "error";
            }
            model.addAttribute("userformDto",userformDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        /*finally {
            return "success";
        }*/
        return "success";
    }

    @RequestMapping(value="/filedel")
    public String mmnualFileDelete(@RequestParam("actidxz") Long idx
            ,@RequestParam("actfseqz") String fseq
            ,@RequestParam("actflagz") String fflag
            ,Model model, HttpServletRequest request){

        try {
            attachDTO.setIdx(idx);
            attachDTO.setBoardIdx(fseq);
            attachDTO.setFlag(fflag);

            boolean result = appServiceImpl.MManuFileDel(attachDTO);
            if(!result){
                return  "error";
            }
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return "success";
    }

    @RequestMapping(value="/flist")
    public Object mmnualFilelist(@RequestParam("actfseqz") String fseq
            ,@RequestParam("actflagz") String fflag
            , Model model, HttpServletRequest request){
        List<AttachDTO>  attach = new ArrayList<>();
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

            app04Dto.setFseq(fseq);
            app04Dto.setFflag(fflag);
            attach = appServiceImpl.MManuFilelist(app04Dto);
            model.addAttribute("userformDto",userformDto);
            model.addAttribute("attachDto",attach);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return attach;
    }

    public String CountSeq(String yyyymm){
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
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }

}
