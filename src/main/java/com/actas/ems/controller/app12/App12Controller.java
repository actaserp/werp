package com.actas.ems.controller.app12;

import com.actas.ems.DTO.CommonDto;
import com.actas.ems.DTO.Elvlrt.App03ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.App04ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App03ElvlrtService;
import com.actas.ems.Service.elvlrt.App04ElvlrtService;
import com.actas.ems.controller.SessionManager;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RequestMapping(value = "/app12", method = RequestMethod.POST)
@Controller
@RequiredArgsConstructor
public class App12Controller {
    UserFormDto userformDto = new UserFormDto();
    private final SessionManager sessionManager;

    protected Log log =  LogFactory.getLog(this.getClass());

    // 고장내용별현황 index
    @GetMapping(value="/index01")
    public String App03IndexForm(Model model, HttpServletRequest request) throws  Exception{
        try {
            HttpSession session = request.getSession();
            UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
            if(userformDto.getFlag().equals("CC")){
                userformDto.setPagetree01("고객지원센터");
            }else{
                userformDto.setPagetree01("통계관리");
            }
            userformDto.setPagenm("고장별수리현황");
            model.addAttribute("userformDto",userformDto);
        } catch (Exception ex) {
//                dispatchException = ex;
            log.debug("Exception =====>" + ex.toString() );
        }

        return "app12/app12list";
    }




}
