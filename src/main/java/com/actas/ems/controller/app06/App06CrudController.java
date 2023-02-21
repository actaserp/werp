package com.actas.ems.controller.app06;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App06ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App06ElvlrtService;
import com.actas.ems.Service.elvlrt.App06UploadService;
import com.actas.ems.Service.elvlrt.App06UploadServiceImpl;
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
@RequestMapping(value = "/app06mod", method = RequestMethod.POST)
public class App06CrudController {
    private final App06ElvlrtService appService;
    private final App06UploadServiceImpl appServiceImpl;
    private final App06UploadService appUploadService;

    App06ElvlrtDto App06Dto = new App06ElvlrtDto();
    AttachDTO attachDTO = new AttachDTO();
    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    private static final Logger logger     = LoggerFactory.getLogger(App06CrudController.class);
    private final String uploadPath = Paths.get("C:", "develop", "upload","mhmanual", getToDate()).toString();

    @RequestMapping(value="/saveboard")
    public String memberSave(@RequestParam("acthseqz") String nseq
            ,@RequestParam("acthinputdatez") String ninputdate
            , @RequestParam("acthgroupcdz") String ngroupcd
            , @RequestParam("acthsubjectz") String nsubject
            , @RequestParam("acthfilenamez") String nfilename
            , @RequestParam("acthpernmz") String npernm
            , @RequestParam("acthmemoz") String memo
            , @RequestParam("acthflagz") String nflag
            , Model model, HttpServletRequest request){

        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            String ls_yeare = ninputdate.substring(0,4);
            String ls_mm = ninputdate.substring(5,7);
            String ls_dd = ninputdate.substring(8,10);
            ninputdate =  ls_yeare + ls_mm + ls_dd;
//        log.debug("ninputdate==>" + ninputdate);
            App06Dto.setCustcd(ls_custcd);
            App06Dto.setSpjangcd(ls_spjangcd);
            if(nseq == null || nseq.equals("")){
                App06Dto.setHseq(CountSeq(ls_yeare + ls_mm));
            }else{
                App06Dto.setHseq(nseq);
            }

            App06Dto.setHinputdate(ninputdate);
            App06Dto.setHgroupcd(ngroupcd);
            App06Dto.setHsubject(nsubject);
            App06Dto.setHfilename(nfilename);
            App06Dto.setHpernm(npernm);
            App06Dto.setHmemo(memo);
            App06Dto.setHflag(nflag);
            App06Dto.setYyyymm(ls_yeare + ls_mm);
            App06Dto.setHpernm(userformDto.getUsername());
            if(nseq == null || nseq.equals("")){
                appService.InsertMHManual(App06Dto);
            }else{
                appService.UpdateMHManual(App06Dto);
            }
            model.addAttribute("userformDto",userformDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        String ls_nseq = App06Dto.getHseq();
        return ls_nseq;
    }

    /**
     * 서버에 생성할 파일명을 처리할 랜덤 문자열 반환
     * @return 랜덤 문자열
     */
    private final String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @RequestMapping(value="/save")
    public String mhmanualUpload ( @RequestPart(value = "key") Map<String, Object> param,
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
                case "acthseqz":
                    App06Dto.setHseq(values.toString());
                    break;
                case "acthinputdatez":
                    App06Dto.setHinputdate(values.toString());
                    break;
                case "acthgroupcdz":
                    App06Dto.setHgroupcd(values.toString());
                    break;
                case "acthsubjectz":
                    App06Dto.setHsubject(values.toString());
                    break;
                case "acthpernmz":
                    App06Dto.setHpernm(values.toString());
                    break;
                case "acthmemoz":
                    App06Dto.setHmemo(values.toString());
                    break;
                case "acthflagz":
                    App06Dto.setHflag(values.toString());
                    break;
                default:
                    break;
            }
        });
        String hseq = App06Dto.getHseq();
        App06Dto.setCustcd(ls_custcd);
        App06Dto.setSpjangcd(ls_spjangcd);
        App06Dto.setHpernm(userformDto.getUsername());
        String hinputdate = App06Dto.getHinputdate();
        String ls_yeare = hinputdate.substring(0,4);
        String ls_mm = hinputdate.substring(5,7);
        String ls_dd = hinputdate.substring(8,10);
        hinputdate =  ls_yeare + ls_mm + ls_dd;
        App06Dto.setHinputdate(hinputdate);
        if(hseq == null || hseq.equals("")){
            App06Dto.setHseq(CountSeq(ls_yeare + ls_mm));
            //System.out.println(App06Dto.getHseq());
        }else{
            App06Dto.setHseq(hseq);
        }
        App06Dto.setYyyymm(ls_yeare + ls_mm);
        if(hseq == null || hseq.equals("")){
            result = appService.InsertMHManual(App06Dto);
            if(!result){
                return  "error";
            }
        }else{
            result = appService.UpdateMHManual(App06Dto);
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
                attach.setBoardIdx(App06Dto.getHseq());
                attach.setOriginalName(multipartFile.getOriginalFilename());
                attach.setSaveName(saveName);
                attach.setSize(multipartFile.getSize());
                attach.setFlag("MH");
                /* 파일 정보 추가 */
                attachList.add(attach);
            }
            result  = appServiceImpl.registerMHManual(App06Dto, attachList);
            if(!result){
                return  "error";
            }

        }catch (DataAccessException e){
            log.info("memberUpload DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException("[" + ls_fileName + "] DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/App06/App06list/", Method.GET, model);
        } catch (Exception  e){
            log.info("memberUpload Exception ================================================================");
            log.info(e.toString());
            ls_errmsg = "[" + ls_fileName + "] failed to save";
            throw new AttachFileException("[" + ls_fileName + "] failed to save");
            //utils.showMessageWithRedirect("시스템에 문제가 발생하였습니다", "/App06/App06list/", Method.GET, model);
        }

        return "success";
//        utils.showMessageWithRedirect("게시글 등록이 완료되었습니다", "/App06/App06list/", Method.GET, model);
    }


    @RequestMapping(value="/del")
    public String mhmanualDelete(@RequestParam("acthseqz") String nseq
            ,@RequestParam("acthflagz") String nflag
            ,Model model, HttpServletRequest request){

        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            App06Dto.setHseq(nseq);
            App06Dto.setHflag(nflag);

            boolean result = appService.DeleteMHManual(App06Dto);
            if(!result){
                return  "error";
            }
            result = appServiceImpl.registerMHManualDel(App06Dto);
            if(!result){
                return  "error";
            }
            model.addAttribute("userformDto",userformDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return "success";
    }


    @RequestMapping(value="/filedel")
    public String MHManualFileDelete(@RequestParam("actidxz") Long idx
            ,@RequestParam("acthseqz") String nseq
            ,@RequestParam("acthflagz") String nflag
            ,Model model, HttpServletRequest request){

        try {
            attachDTO.setIdx(idx);
            attachDTO.setBoardIdx(nseq);
            attachDTO.setFlag(nflag);

            boolean result = appServiceImpl.MHManualFileDel(attachDTO);
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
    public Object MHManualFilelist(@RequestParam("acthseqz") String hseq
            ,@RequestParam("acthflagz") String hflag
            , Model model, HttpServletRequest request){
        List<AttachDTO>  attach =new ArrayList<>();
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

            App06Dto.setHseq(hseq);
            App06Dto.setHflag(hflag);
            attach = appServiceImpl.MHManualFilelist(App06Dto);

            model.addAttribute("userformDto",userformDto);
            model.addAttribute("attachDto",attach);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return attach;
    }

    public String CountSeq(String yyyymm){
        String ls_nseq = appService.getMHManualMaxSeq(yyyymm);
        int ll_nseq = 0;
        if(ls_nseq == null ){
            ls_nseq = yyyymm + "001";
        }else{
            ll_nseq = Integer.parseInt(ls_nseq);
            ls_nseq = Integer.toString(ll_nseq + 1 );
        }
        return ls_nseq;
    }


    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
