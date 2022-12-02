package com.actas.ems.controller.app04;


import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Service.elvlrt.App04ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app04mod", method = RequestMethod.POST)
public class App04CrudController {
    private final App04ElvlrtService appService;

    App04ElvlrtDto app04Dto = new App04ElvlrtDto();
    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    @RequestMapping(value="/save")
    public String memberSave(@RequestParam("actmseqz") String mseq
            ,@RequestParam("actminputdatez") String minputdate
            , @RequestParam("actmgroupcdz") String mgroupcd
            , @RequestParam("actmsubjectz") String msubject
            , @RequestParam("actmfilenamez") String mfilename
            , @RequestParam("actmpernmz") String mpernm
            , @RequestParam("actmemoz") String memo
            , @RequestParam("actmflagz") String mflag
            , Model model, HttpServletRequest request){

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
                app04Dto.setMseq(CountSeq(ls_yeare + ls_mm));
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
        return "success";
    }


    @RequestMapping(value="/del")
    public String memberSave(@RequestParam("actmseqz") String mseq
            , Model model, HttpServletRequest request){

        try {

            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            String ls_custcd = userformDto.getCustcd();
            String ls_spjangcd = userformDto.getSpjangcd();
            app04Dto.setMseq(mseq);
            appService.DeleteMManu(app04Dto);
            model.addAttribute("userformDto",userformDto);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return "success";
    }

    public String CountSeq(String yyyymm){
        String ls_mseq = appService.getMManualMaxSeq(yyyymm);
        int ll_mseq = 0;
        if(ls_mseq == null ){
            ls_mseq = yyyymm + "001";
        }else{
            ll_mseq = Integer.parseInt(ls_mseq);
            ls_mseq = Integer.toString(ll_mseq + 1 );
        }
        return ls_mseq;
    }
}
