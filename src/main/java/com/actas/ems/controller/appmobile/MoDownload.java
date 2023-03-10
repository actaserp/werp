package com.actas.ems.controller.appmobile;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App06UploadServiceImpl;
import com.actas.ems.Service.elvlrt.App_mbmanualService.App_mbUploadServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/mobile", method = RequestMethod.GET)
public class MoDownload {
    String ls_spjangcd = "";
    String ls_custcd = "";


    AttachDTO attachDTO = new AttachDTO();
    UserFormDto userformDto = new UserFormDto();
    private final App06UploadServiceImpl appServiceImpl;

    public MoDownload(App06UploadServiceImpl appServiceImpl) {
        this.appServiceImpl = appServiceImpl;
    }

    @RequestMapping(value="/download")
    public void mbdownMob(@RequestParam("dbnm") String dbnm,
                          @RequestParam("flag") String flag,
                          @RequestParam("boardIdx") String boardIdx,
                          @RequestParam("idx") String idx,
            @RequestParam("inputdate") String inputdate,
                          @RequestParam("svn") String svn,
                          @RequestParam("ori") String ori
            , Model model, HttpServletResponse response , HttpServletRequest request) {
        String ls_dbnm = "";
        ls_dbnm = "ELV_LRT";
        attachDTO.setIdx(Long.parseLong(idx));
        attachDTO.setBoardIdx(boardIdx);
        attachDTO.setFlag(flag);
        attachDTO.setSaveName(svn);
        attachDTO.setOriginalName(ori);
        HttpSession session = request.getSession();

        userformDto.setDbnm(ls_dbnm);
        attachDTO.setInserttime(inputdate);
        session.setAttribute("userformDto", userformDto);
        ls_spjangcd = "ZZ";
        switch (ls_dbnm) {
            case "ELV_LRT":
                ls_custcd = "ELVLRT";
                attachDTO = appServiceImpl.selectAttachDeteil(attachDTO);
                if (attachDTO == null) {
                    throw new RuntimeException("파일 정보를 찾을 수 없습니다.");
                }
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
        switch (flag) {
            case "MM":
                flag = "mmanul";
                break;
            case "DD":
                flag = "mdevmanual";
                break;
            case "EE":
                flag = "metcmanual";
            case "MH":
                flag = "mhmanual";
                break;
            case "MB":
                flag = "mbmanual";
                break;
            case "MF":
                flag = "mfix";
                break;
            case "NN":
                flag = "mnotice";
                break;
            default:
                flag = "mmanul";
                break;
        }
        String uploadPath = Paths.get("C:", "develop", "upload", flag, inputdate).toString();

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
}


