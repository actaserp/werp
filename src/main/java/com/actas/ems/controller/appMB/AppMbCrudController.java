package com.actas.ems.controller.appMB;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App08_mbmanual;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App_mbmanualService.App_mbUploadService;
import com.actas.ems.Service.elvlrt.App_mbmanualService.App_mbUploadServiceImpl;
import com.actas.ems.Service.elvlrt.App_mbmanualService.App_mbmanualService;
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
@RequestMapping(value = "/app08mod", method = RequestMethod.POST)
public class AppMbCrudController {

    private final App_mbmanualService appService;

    private final App_mbUploadServiceImpl mbUploadServiceImpl;
    private final App_mbUploadService mbUploadService;
    private final UIUtils utils;


    App08_mbmanual app08_mbmanual = new App08_mbmanual();

    AttachDTO attachDTO = new AttachDTO();
    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    private static final Logger logger = LoggerFactory.getLogger(AppMbCrudController.class);

    private final String uploadPath = Paths.get("C:", "develop", "upload","mbmanual", getToDate()).toString();

    @RequestMapping(value = "/saveboard")
    public String memberSave(@RequestParam("actbseqz") String bseq
            , @RequestParam("actbinputdatez") String binputdate
            , @RequestParam("actbgourpcdz") String bgourpcd
            , @RequestParam("actbsubjectz") String bsubject
            , @RequestParam("actbfilenamez") String bfilename
            , @RequestParam("actbpernmz") String bpernm
            , @RequestParam("actbmemoz") String bmemo
            , @RequestParam("actbflagz") String bflag
            , Model model, HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            String ls_yeare = binputdate.substring(0,4);
            String ls_mm = binputdate.substring(5,7);
            String ls_dd = binputdate.substring(8,10);
            binputdate =  ls_yeare + ls_mm + ls_dd;

            app08_mbmanual.setCustcd(ls_custcd);
            app08_mbmanual.setSpjangcd(ls_spjangcd);
            if(bseq == null || bseq.equals("")){
                app08_mbmanual.setBseq(CountSeq(ls_yeare + ls_mm));
            }else{
                app08_mbmanual.setBseq(bseq);
            }

            app08_mbmanual.setBinputdate(binputdate);
            app08_mbmanual.setBgourpcd(bgourpcd);
            app08_mbmanual.setBsubject(bsubject);
            app08_mbmanual.setBfilename(bfilename);
            app08_mbmanual.setBpernm(bpernm);
            app08_mbmanual.setBmemo(bmemo);
            app08_mbmanual.setBflag(bflag);
            app08_mbmanual.setYyyymm(ls_yeare + ls_mm);
            app08_mbmanual.setBpernm(userformDto.getUsername());
            if(bseq == null || bseq.equals("")){
                appService.InsertMManu(app08_mbmanual);
            }else{
                appService.UpdateMManu(app08_mbmanual);
            }
            model.addAttribute("userformDto",userformDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        String ls_fseq = app08_mbmanual.getBseq();
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
                case "actbseqz":
                    app08_mbmanual.setBseq(values.toString());
                    break;
                case "actbinputdatez":
                    app08_mbmanual.setBinputdate(values.toString());
                    break;
                case "actbgroupcdz":
                    app08_mbmanual.setBgourpcd(values.toString());
                    break;
                case "actbsubjectz":
                    app08_mbmanual.setBsubject(values.toString());
                    break;
                case "actbpernmz":
                    app08_mbmanual.setBpernm(values.toString());
                    break;
                case "actbmemoz":
                    app08_mbmanual.setBmemo(values.toString());
                    break;
                case "actbflagz":
                    app08_mbmanual.setBflag(values.toString());
                    break;
                default:
                    break;
            }
        });
        String bseq = app08_mbmanual.getBseq();
        app08_mbmanual.setCustcd(ls_custcd);
        app08_mbmanual.setSpjangcd(ls_spjangcd);
        app08_mbmanual.setBpernm(userformDto.getUsername());
        String binputdate = app08_mbmanual.getBinputdate();
        String ls_yeare = binputdate.substring(0,4);
        String ls_mm = binputdate.substring(5,7);
        String ls_dd = binputdate.substring(8,10);
        binputdate =  ls_yeare + ls_mm + ls_dd;
        app08_mbmanual.setBinputdate(binputdate);
        if(bseq == null || bseq.equals("")){
            app08_mbmanual.setBseq(CountSeq(ls_yeare + ls_mm));
        }else{
            app08_mbmanual.setBseq(bseq);
        }
        app08_mbmanual.setYyyymm(ls_yeare + ls_mm);
        if(bseq == null || bseq.equals("")) {
            boolean result = appService.InsertMManu(app08_mbmanual);
            if (!result) {
                return "error";
            }
        }else{
            boolean result = appService.UpdateMManu(app08_mbmanual);
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
                String bseq1 = app08_mbmanual.getBseq();
                /* 파일 정보 저장 */
                AttachDTO attach = new AttachDTO();
                attach.setBoardIdx(bseq1);
                attach.setOriginalName(multipartFile.getOriginalFilename());
                attach.setSaveName(saveName);
                attach.setSize(multipartFile.getSize());
                attach.setFlag("MB");
                log.info(attach.getBoardIdx());
                /* 파일 정보 추가 */
                attachList.add(attach);



            }


            boolean result = mbUploadServiceImpl.registerMManu(app08_mbmanual, attachList);

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
    public String mmnualDelete(@RequestParam("actbseqz") String bseq, Model model, HttpServletRequest request, @RequestParam("actflagz") String bflag){
        try{
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userFormDto.getCustcd();
            String ls_spjangcd = userFormDto.getSpjangcd();
            app08_mbmanual.setBseq(bseq);
            app08_mbmanual.setBflag(bflag);

            boolean result = appService.DeleteMManu(app08_mbmanual);
            if(!result){
                return "error";
            }
            result = mbUploadServiceImpl.registerMManuDel(app08_mbmanual);
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
            ,@RequestParam("actbseqz") String bseq
            ,@RequestParam("actflagz") String bflag
            ,Model model, HttpServletRequest request){

        try {
            attachDTO.setIdx(idx);
            attachDTO.setBoardIdx(bseq);
            attachDTO.setFlag(bflag);

            boolean result = mbUploadServiceImpl.MManuFileDel(attachDTO);
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
    public Object mmnualFilelist(@RequestParam("actbseqz") String bseq
            ,@RequestParam("actflagz") String bflag
            , Model model, HttpServletRequest request){
        List<AttachDTO>  attach = new ArrayList<>();
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

            app08_mbmanual.setBseq(bseq);
            app08_mbmanual.setBflag(bflag);
            attach = mbUploadServiceImpl.MManuFilelist(app08_mbmanual);
            model.addAttribute("userformDto",userformDto);
            model.addAttribute("attachDto",attach);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return attach;
    }

    public String CountSeq(String yyyymm){
        String ls_bseq = appService.getMManualMaxSeq(yyyymm);
        int ll_bseq = 0;
        if(ls_bseq == null){
            ls_bseq = yyyymm + "001";
        }else{
            ll_bseq = Integer.parseInt(ls_bseq);
            ls_bseq = Integer.toString(ll_bseq + 1);
        }
        return ls_bseq;
    }

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }

}
