package com.actas.ems.controller.app07;

import com.actas.ems.DTO.Elvlrt.App07ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.SearchDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App07ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/app07")
@Controller
@RequiredArgsConstructor
public class App07Controller {
    private final App07ElvlrtService service;
    UserFormDto userFormDto = new UserFormDto();

    //게시판 리스트 조회
    @GetMapping(value = "/bnotice")
    public String GetNoticeList(Model model, @ModelAttribute("params") final SearchDto params){
        List<App07ElvlrtDto> noticeList = service.GetNoticeList(params);

        model.addAttribute("list", noticeList);

        return "bnoticelist";
    }
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


}
