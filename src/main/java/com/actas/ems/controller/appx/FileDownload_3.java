package com.actas.ems.controller.appx;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.Service.elvlrt.App_mbmanualService.App_mbUploadServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/appx3", method = RequestMethod.GET)
public class FileDownload_3 {

    AttachDTO attachDTO = new AttachDTO();

    private final App_mbUploadServiceImpl appServiceImpl;

    public FileDownload_3(App_mbUploadServiceImpl appServiceImpl) {
        this.appServiceImpl = appServiceImpl;
    }

    @RequestMapping(value="/download3")
    public void mmnualFileDownload(@RequestParam("actidxz") Long idx
            , @RequestParam("actboardz") String bseq
            , @RequestParam("actflagz") String bflag
            , Model model, HttpServletResponse response){
        if (idx == null) throw new RuntimeException("올바르지 않은 접근입니다.");
        attachDTO.setIdx(idx);
        attachDTO.setBoardIdx(bseq);
        attachDTO.setFlag(bflag);

        attachDTO  = appServiceImpl.selectAttachDeteil(attachDTO);
        if (attachDTO == null ) {
            throw new RuntimeException("파일 정보를 찾을 수 없습니다.");
        }

        switch (bflag){
            case "MB":
                bflag = "mbmanual";
                break;
            default:
                bflag = "mbmanual";
                break;
        }
        String uploadDate = attachDTO.getInserttime();

        String ls_yeare = uploadDate.substring(0,4);
        String ls_mm = uploadDate.substring(5,7);
        String ls_dd = uploadDate.substring(8,10);
        uploadDate =  ls_yeare + ls_mm + ls_dd;

        String uploadPath = Paths.get("C:", "develop", "upload", bflag, uploadDate).toString();

        String filename = attachDTO.getOriginalName();
        File file = new File(uploadPath, attachDTO.getSaveName());

        try {
            byte[] data =   FileUtils.readFileToByteArray(file);
            response.setContentType("application/octet-stream");
            response.setContentLength(data.length);
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(filename, "UTF-8") + "\";");

            response.getOutputStream().write(data);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            throw new RuntimeException("파일 다운로드에 실패하였습니다.");

        } catch (Exception e) {
            throw new RuntimeException("시스템에 문제가 발생하였습니다.");
        }
    }
    private String getToDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date      = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }
}
