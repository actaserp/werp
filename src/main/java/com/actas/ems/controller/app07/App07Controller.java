package com.actas.ems.controller.app07;

import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App07ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.actas.ems.DTO.CommonDto;
import com.actas.ems.controller.SessionManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping(value = "/app07", method = RequestMethod.POST)
@Controller
@RequiredArgsConstructor
public class App07Controller {
    private final App07ElvlrtService service;
    UserFormDto userformDto = new UserFormDto();
    private final SessionManager sessionManager;
    List<App07ElvlrtDto> app07ListDto;
    List<CommonDto> com750Dto;

    App07ElvlrtDto app04Dto = new App07ElvlrtDto();

    protected Log log = LogFactory.getLog(this.getClass());



    //게시판 리스트 조회
    @GetMapping(value = "/index01")
    public String App07Form(Model model, HttpServletRequest request) throws  Exception{

        Date nowData = new Date();
        SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMdd");
        String indate = endDate.format(nowData).toString();
        app04Dto.setYyyymm(indate.substring(0, 6));
        app04Dto.setFinputdate(indate);

        try{
            model.addAttribute("app04Dto", service.GetMManulList(app04Dto));
        }catch (Exception ex){
            log.debug("Exception =====>" + ex.toString() );
        }try{
            com750Dto = service.GetComm750List();
            model.addAttribute("com750Dto", com750Dto);

        }catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }try{
            HttpSession session = request.getSession();
            /*session.setMaxInactiveInterval(10);*/
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");

            userformDto.setPagetree01("기술자료실");

            userformDto.setPagenm("점검조치사항");
            model.addAttribute("userformDto",userformDto);

        }catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }

        return "app07/app07list";
    }

    /*
    //글쓰기 페이지 이동
    @GetMapping("/bnoticeWrite")
        public String noticewrite(){
        return "bnoticeWrite";
    }

    //글쓰기 페이지에서 작성후 제출
    @PostMapping("/bnoticeWrite")
        public String noticewriteup(App07ElvlrtDto perm){
            service.uploadBoard(perm);
            return "redirect:/app07/bnotice";
    }
    //글 상세조회
    @GetMapping("/mnoticeView")
        public String noticeView(@RequestParam(value = "fseq") String fseq, Model model){

        model.addAttribute("view", service.GetNoticeView(fseq));

        return "bnoticeview";

    }
    //글 삭제
    @GetMapping(value = "/delete")
        public String deleteBoard(@RequestParam("fseq") String fseq){
        service.deleteBoard(fseq);
        return "redirect:/app07/bnotice";
    }
    //글 수정페이지
    @GetMapping(value = "/up")
        public String update(@RequestParam(value = "fseq")String fseq, Model model){
        model.addAttribute("view", service.GetNoticeView(fseq));
        return "updatenotice";
    }
    //글 수정기능
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBoard(App07ElvlrtDto dto){
        service.updateBoard(dto);

        return "redirect:/app07/bnotice";
    }

     */


}
