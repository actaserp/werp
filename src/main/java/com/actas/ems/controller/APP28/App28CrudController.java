package com.actas.ems.controller.APP28;


import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App28ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App28ElvlrtService;
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
@RequestMapping(value = "/app28mod", method = RequestMethod.POST)
public class App28CrudController {
    private final App28ElvlrtService appService;
    App28ElvlrtDto App28Dto = new App28ElvlrtDto();
    AttachDTO attachDTO = new AttachDTO();
    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    private static final Logger logger     = LoggerFactory.getLogger(App28CrudController.class);
    private final String uploadPath = Paths.get("C:", "develop", "upload","mnotice", getToDate()).toString();

    @RequestMapping(value="/saveboard")
    public String memberSave(@RequestParam("actnseqz") String nseq
            ,@RequestParam("actninputdatez") String ninputdate
            , @RequestParam("actngroupcdz") String ngroupcd
            , @RequestParam("actnsubjectz") String nsubject
            , @RequestParam("actnfilenamez") String nfilename
            , @RequestParam("actnpernmz") String npernm
            , @RequestParam("actnmemoz") String memo
            , @RequestParam("actnflagz") String nflag
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
            App28Dto.setCustcd(ls_custcd);
            App28Dto.setSpjangcd(ls_spjangcd);
            if(nseq == null || nseq.equals("")){
                App28Dto.setNseq(CountSeq(ls_yeare + ls_mm));
            }else{
                App28Dto.setNseq(nseq);
            }

            App28Dto.setNinputdate(ninputdate);
            App28Dto.setNgourpcd(ngroupcd);
            App28Dto.setNsubject(nsubject);
            App28Dto.setNfilename(nfilename);
            App28Dto.setNpernm(npernm);
            App28Dto.setNmemo(memo);
            App28Dto.setNflag(nflag);
            App28Dto.setYyyymm(ls_yeare + ls_mm);
            App28Dto.setNpernm(userformDto.getUsername());
            if(nseq == null || nseq.equals("")){
                appService.InsertMNotice(App28Dto);
            }else{
                appService.UpdateMNotice(App28Dto);
            }
            model.addAttribute("userformDto",userformDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        String ls_nseq = App28Dto.getNseq();
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
    public String mnoticeUpload ( @RequestPart(value = "key") Map<String, Object> param,
                                  @RequestPart(value = "file",required = false) List<MultipartFile> file
            , Model model
            , HttpServletRequest request){
        String ls_fileName = "";
        String ls_errmsg = "";
        /* 업로드 파일 정보를 담을 비어있는 리스트 */
        List<AttachDTO> attachList = new ArrayList<>();


        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        String ls_custcd = userformDto.getCustcd();
        String ls_spjangcd = userformDto.getSpjangcd();

        param.forEach((key, values) -> {
            switch (key){
                case "actnseqz":
                    App28Dto.setNseq(values.toString());
                    break;
                case "actninputdatez":
                    App28Dto.setNinputdate(values.toString());
                    break;
                case "actngroupcdz":
                    App28Dto.setNgourpcd(values.toString());
                    break;
                case "actnsubjectz":
                    App28Dto.setNsubject(values.toString());
                    break;
                case "actnpernmz":
                    App28Dto.setNpernm(values.toString());
                    break;
                case "actnmemoz":
                    App28Dto.setNmemo(values.toString());
                    break;
                case "actnflagz":
                    App28Dto.setNflag(values.toString());
                    break;
                default:
                    break;
            }
        });
        String nseq = App28Dto.getNseq();
        App28Dto.setCustcd(ls_custcd);
        App28Dto.setSpjangcd(ls_spjangcd);
        App28Dto.setNpernm(userformDto.getUsername());
        String ninputdate = App28Dto.getNinputdate();
        String ls_yeare = ninputdate.substring(0,4);
        String ls_mm = ninputdate.substring(5,7);
        String ls_dd = ninputdate.substring(8,10);
        ninputdate =  ls_yeare + ls_mm + ls_dd;
        App28Dto.setNinputdate(ninputdate);
        if(nseq == null || nseq.equals("")){
            App28Dto.setNseq(CountSeq(ls_yeare + ls_mm));
        }else{
            App28Dto.setNseq(nseq);
        }
        App28Dto.setYyyymm(ls_yeare + ls_mm);
        if(nseq == null || nseq.equals("")){
            boolean result = appService.InsertMNotice(App28Dto);
            if(!result){
                return  "error";
            }
        }else{
            boolean result = appService.UpdateMNotice(App28Dto);
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
                attach.setBoardIdx(nseq);
                attach.setOriginalName(multipartFile.getOriginalFilename());
                attach.setSaveName(saveName);
                attach.setSize(multipartFile.getSize());
                attach.setFlag("NN");
                /* 파일 정보 추가 */
                attachList.add(attach);
            }
            boolean result = false;
            if(!result){
                return  "error";
            }

        }catch (DataAccessException e){
            log.info("memberUpload DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException("[" + ls_fileName + "] DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/App28/App28list/", Method.GET, model);
        } catch (Exception  e){
            log.info("memberUpload Exception ================================================================");
            log.info(e.toString());
            ls_errmsg = "[" + ls_fileName + "] failed to save";
            throw new AttachFileException("[" + ls_fileName + "] failed to save");
            //utils.showMessageWithRedirect("시스템에 문제가 발생하였습니다", "/app28/App28list/", Method.GET, model);
        }

        return "success";
//        utils.showMessageWithRedirect("게시글 등록이 완료되었습니다", "/app28/App28list/", Method.GET, model);
    }


    @RequestMapping(value="/del")
    public String mnoticeDelete(@RequestParam("actnseqz") String nseq
            ,@RequestParam("actnflagz") String nflag
            ,Model model, HttpServletRequest request){

        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            App28Dto.setNseq(nseq);
            App28Dto.setNflag(nflag);

            boolean result = appService.DeleteMNotice(App28Dto);
            if(!result){
                return  "error";
            }
            result = false;
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
    public String mnoticeFileDelete(@RequestParam("actidxz") Long idx
            ,@RequestParam("actnseqz") String nseq
            ,@RequestParam("actnflagz") String nflag
            ,Model model, HttpServletRequest request){

        try {
            attachDTO.setIdx(idx);
            attachDTO.setBoardIdx(nseq);
            attachDTO.setFlag(nflag);

            boolean result = false;
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
    public Object mnoticeFilelist(@RequestParam("actnseqz") String nseq
            ,@RequestParam("actnflagz") String nflag
            , Model model, HttpServletRequest request){
        List<AttachDTO>  attach =new ArrayList<>();
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

            App28Dto.setNseq(nseq);
            App28Dto.setNflag(nflag);
            model.addAttribute("userformDto",userformDto);
            model.addAttribute("attachDto",attach);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return attach;
    }

    public String CountSeq(String yyyymm){
        String ls_nseq = appService.getMNoticeMaxSeq(yyyymm);
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
