package com.actas.ems.controller.app14;

import com.actas.ems.DTO.Elvlrt.App14ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Exception.AttachFileException;
import com.actas.ems.Service.elvlrt.App14ElvlrtService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app14", method = RequestMethod.POST)
public class App14RetrieveController {
    private final App14ElvlrtService service;

    PopupDto popParmDto = new PopupDto();
    List<App14ElvlrtDto> app14DtoList = new ArrayList<>();

    UserFormDto userFormDto = new UserFormDto();
    protected Log log =  LogFactory.getLog(this.getClass());

    // 보수기사목록
    @GetMapping(value="/p001tab01")
    public Object App03001Tab01Form( @RequestParam("actdivicdz") String divicd,
                                     @RequestParam("actperidz") String perid,
                                     @RequestParam("actrtclafiz") String rtclafi
            , Model model, HttpServletRequest request) throws  Exception{
        HttpSession session = request.getSession();
        UserFormDto userformDto = (UserFormDto) session.getAttribute("userformDto");
        popParmDto.setDivicd("AA"+divicd);
        popParmDto.setPerid('p'+perid);
        popParmDto.setRtclafi(rtclafi);
//        System.out.println(popParmDto.getDivicd() + popParmDto.getPerid() + popParmDto.getRtclafi());
//        System.out.println("------1");

        try {

            app14DtoList = service.GetApp14List001(popParmDto);
            for(int i=0; i< app14DtoList.size(); i++) {
                if(app14DtoList.get(i).getRtclafi().equals("001")){
                    app14DtoList.get(i).setRtclafi("재직");
                }else{
                    app14DtoList.get(i).setRtclafi("퇴사");
                }
            }
            model.addAttribute("app14DtoList",app14DtoList);

            for(int i=0; i< app14DtoList.size(); i++){
                System.out.println(app14DtoList.get(i).getPernm()+"i");
            }
            
        }catch (DataAccessException e) {
            log.info("App14001Tab01Form DataAccessException ================================================================");
            log.info(e.toString());
            throw new AttachFileException(" DataAccessException to save");
            //utils.showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다", "/app04/app04list/", Method.GET, model);
        }catch (Exception ex) {
//                dispatchException = ex;
            log.info("App14001Tab01Form Exception ================================================================");
            log.info("Exception =====>" + ex.toString());
//            log.debug("Exception =====>" + ex.toString() );
        }
        return app14DtoList;
    }

}
