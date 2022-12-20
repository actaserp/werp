package com.actas.ems.controller.app04;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App04ElvlrtService;
import com.actas.ems.Service.elvlrt.App04UploadService;
import com.actas.ems.Service.elvlrt.App04UploadServiceImpl;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
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
import org.apache.commons.io.FilenameUtils;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app04mod", method = RequestMethod.POST)
public class App04CrudController {
    private final App04ElvlrtService appService;
    private final App04UploadServiceImpl appServiceImpl;
    private final App04UploadService appUploadService;
    private final UIUtils utils;

    App04ElvlrtDto app04Dto = new App04ElvlrtDto();
    AttachDTO attachDTO = new AttachDTO();
    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    private static final Logger logger     = LoggerFactory.getLogger(App04CrudController.class);
    private final String uploadPath = Paths.get("C:", "develop", "upload","mmanul", getToDate()).toString();

    @RequestMapping(value="/saveboard")   //save 시에 M Dto 수행문

    public String memberSave(@RequestParam("actmseqz") String mseq
            ,@RequestParam("actminputdatez") String minputdate
            , @RequestParam("actmgroupcdz") String mgroupcd
            , @RequestParam("actmsubjectz") String msubject
            , @RequestParam("actmfilenamez") String mfilename
            , @RequestParam("actmpernmz") String mpernm
            , @RequestParam("actmemoz") String memo
            , @RequestParam("actmflagz") String mflag
            , Model model, HttpServletRequest request){
//M Dto 수행문
        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            String ls_yeare = minputdate.substring(0,4);
            String ls_mm = minputdate.substring(5,7);
            String ls_dd = minputdate.substring(8,10);
            minputdate =  ls_yeare + ls_mm + ls_dd;
//        log.debug("minputdate==>" + minputdate);
            app04Dto.setCustcd(ls_custcd);
            app04Dto.setSpjangcd(ls_spjangcd);
            if(mseq == null || mseq.equals("")){
                app04Dto.setMseq(CountSeq(ls_yeare + ls_mm, app04Dto.getSetflag()));
            }else{
                app04Dto.setMseq(mseq);
            }

            app04Dto.setMinputdate(minputdate);
            app04Dto.setMgourpcd(mgroupcd);
            app04Dto.setMsubject(msubject);
            app04Dto.setMfilename(mfilename);
            app04Dto.setMpernm(mpernm);
            app04Dto.setMemo(memo);
            app04Dto.setMflag(mflag);
            app04Dto.setYyyymm(ls_yeare + ls_mm);
            app04Dto.setMpernm(userformDto.getUsername());
            if(mseq == null || mseq.equals("")){
                appService.InsertMManu(app04Dto);
            }else{
                appService.UpdateMManu(app04Dto);
            }
            model.addAttribute("userformDto",userformDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        String ls_mseq = app04Dto.getMseq();
        return ls_mseq;
    }



    /**
     * 서버에 생성할 파일명을 처리할 랜덤 문자열 반환
     * @return 랜덤 문자열
     */
    private final String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @RequestMapping(value="/save")
//저장시 M dto 수행문
    public String mmnualUpload ( @RequestPart(value = "key") Map<String, Object> param,
                                          @RequestPart(value = "file",required = false) List<MultipartFile> file
                                        , Model model
                                        , HttpServletRequest request){
        String ls_fileName = "";
        String ls_errmsg = "";
        boolean result = false;
        /* 업로드 파일 정보를 담을 비어있는 리스트 */
        List<AttachDTO> attachList = new ArrayList<>();


        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        String ls_custcd = userformDto.getCustcd();
        String ls_spjangcd = userformDto.getSpjangcd();

        param.forEach((key, values) -> {
            switch (key){
                case "actmseqz":
                    app04Dto.setMseq(values.toString());
                    break;
                case "actminputdatez":
                    app04Dto.setMinputdate(values.toString());
                    break;
                case "actmgroupcdz":
                    app04Dto.setMgourpcd(values.toString());
                    break;
                case "actmsubjectz":
                    app04Dto.setMsubject(values.toString());
                    break;
                case "actmpernmz":
                    app04Dto.setMpernm(values.toString());
                    break;
                case "actmemoz":
                    app04Dto.setMemo(values.toString());
                    break;
                case "actmflagz":
                    app04Dto.setMflag(values.toString());
                    break;
                case "actmsetflagz":
                    app04Dto.setSetflag(values.toString());
                    break;
                default:
                    break;
            }
        });
        String mseq = app04Dto.getMseq();
        app04Dto.setCustcd(ls_custcd);
        app04Dto.setSpjangcd(ls_spjangcd);
        app04Dto.setMpernm(userformDto.getUsername());
        String minputdate = app04Dto.getMinputdate();
        String ls_yeare = minputdate.substring(0,4);
        String ls_mm = minputdate.substring(5,7);
        String ls_dd = minputdate.substring(8,10);
        minputdate =  ls_yeare + ls_mm + ls_dd;
        app04Dto.setMinputdate(minputdate);
        if(mseq == null || mseq.equals("")){
            app04Dto.setMseq(CountSeq(ls_yeare + ls_mm, app04Dto.getSetflag()));
        }else{
            app04Dto.setMseq(mseq);
        }
        app04Dto.setYyyymm(ls_yeare + ls_mm);

        if(mseq == null || mseq.equals("")){

            switch (app04Dto.getSetflag()){
                case "MM":
                    result = appService.InsertMManu(app04Dto);
                    break;
                case  "DD" :
                    result = appService.InsertDManu(app04Dto);
                    break;
                default:
                    break;
            }
            if(!result){
                return  "error";
            }
        }else{
            switch (app04Dto.getSetflag()){
                case "MM":
                    result = appService.UpdateMManu(app04Dto);
                    break;
                case  "DD" :
                    result = appService.UpdateDManu(app04Dto);
                    break;
                default:
                    break;
            }
            if(!result){
                return  "error";
            }
        }
        model.addAttribute("userformDto",userformDto);

        /* uploadPath에 해당하는 디렉터리가 존재하지 않으면, 부모 디렉터리를 포함한 모든 디렉터리를 생성 */
        File dir = new File(uploadPath);
        if (dir.exists() == false) {
            dir.mkdirs();
        }
        try {
            if (file == null) {
                ls_errmsg = "success";
                return ls_errmsg;
            }

            for(MultipartFile multipartFile : file){
//                log.info("================================================================");
//                log.info("upload file name : " + multipartFile.getOriginalFilename());
//                log.info("upload file name : " + multipartFile.getSize());
                ls_fileName = multipartFile.getOriginalFilename();
                /* 파일이 비어있으면 비어있는 리스트 반환 */

                if (multipartFile.getSize() < 1) {
                    ls_errmsg = "success";
                    return ls_errmsg;
                }
                /* 파일 확장자 */
                final String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
                /* 서버에 저장할 파일명 (랜덤 문자열 + 확장자) */
                final String saveName = getRandomString() + "." + extension;

                /* 업로드 경로에 saveName과 동일한 이름을 가진 파일 생성 */
                File target = new File(uploadPath, saveName);
                multipartFile.transferTo(target);

                /* 파일 정보 저장 */
                AttachDTO attach = new AttachDTO();
                attach.setBoardIdx(mseq);
                attach.setOriginalName(multipartFile.getOriginalFilename());
                attach.setSaveName(saveName);
                attach.setSize(multipartFile.getSize());
                attach.setFlag("MM");
                /* 파일 정보 추가 */
                attachList.add(attach);
            }
                result  = appServiceImpl.registerMManu(app04Dto, attachList);
                if(!result){
                    return  "error";
                }

        }catch (DataAccessException e){
            log.info("memberUpload DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException("[" + ls_fileName + "] DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        } catch (Exception  e){
                log.info("memberUpload Exception ================================================================");
                log.info(e.toString());
                ls_errmsg = "[" + ls_fileName + "] failed to save";
                throw new AttachFileException("[" + ls_fileName + "] failed to save");
            //utils.showMessageWithRedirect("시스템에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }

        return "success";
//        utils.showMessageWithRedirect("게시글 등록이 완료되었습니다", "/app04/app04list/", Method.GET, model);
    }

    //저장시 D dto 수행문



    //게시글 내용 삭제 M dto 사용

//    안된 거 삭제
@RequestMapping(value="/del")
public String mmnualDelete(@RequestParam("actmseqz") String mseq
                          ,@RequestParam("actflagz") String mflag
                          ,Model model, HttpServletRequest request){

    boolean result = false;
    //result값 초기화

    try {
        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        String ls_custcd = userformDto.getCustcd();
        String ls_spjangcd = userformDto.getSpjangcd();
        //아래부터 param
        app04Dto.setMseq(mseq);        //도면자료 삭제쿼리
        app04Dto.setMflag(mflag);

        // 해당 flag의 data를 삭제한다.

        // Flag에 MM이 들어왔을 때 delete인데 지금 mflag는 param값이라 switch문 실행안됨
        switch (app04Dto.getMflag()) {
            case "MM":
                result = appService.DeleteMManu(app04Dto);
                break;
            case "DD":
                result = appService.DeleteDManu(app04Dto);
                break;
        }
        if(!result){
            return  "error";
        }
        result = appServiceImpl.registerMManuDel(app04Dto);

        model.addAttribute("userformDto",userformDto);

    }catch (IllegalStateException e){ //잘못된 접근 시에 에러 메시지 송출
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
    return "success";
}


    //파일 삭제시 M dto 사용
    @RequestMapping(value="/filedel")
    public String mmnualFileDelete(@RequestParam("actidxz") Long idx
                                   ,@RequestParam("actdseqz") String mseq
                                   ,@RequestParam("actflagz") String mflag
                                   ,Model model, HttpServletRequest request){

        try {
            attachDTO.setIdx(idx);
            attachDTO.setBoardIdx(mseq);
            attachDTO.setFlag(mflag);

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




    //파일 리스트 M dto

    @RequestMapping(value="/flist")
    public Object mmnualFilelist(@RequestParam("actmseqz") String mseq
                                ,@RequestParam("actflagz") String mflag
                                , Model model, HttpServletRequest request){
        List<AttachDTO>  attach =new ArrayList<>();
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

            app04Dto.setMseq(mseq);
            app04Dto.setMflag(mflag);
             attach = appServiceImpl.MManuFilelist(app04Dto);
            model.addAttribute("userformDto",userformDto);
            model.addAttribute("attachDto",attach);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return attach;
    }

    //날짜

    public String CountSeq(String yyyymm, String flag){
        String ls_mseq = "";
        switch (flag) {

            case "MM":
                //도면자료실
                ls_mseq = appService.getMManualMaxSeq(yyyymm);
                break;



            case "DD":
                // 부품자료실
                ls_mseq = appService.getDManualMaxSeq(yyyymm);
                break;
            default:
                break;
        }

        int ll_mseq = 0;
        if(ls_mseq == null ){
            ls_mseq = yyyymm + "001";
        }else{
            ll_mseq = Integer.parseInt(ls_mseq);
            ls_mseq = Integer.toString(ll_mseq + 1 );
        }
        return ls_mseq;
    }

    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
