package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.AttachDTO;
import com.actas.ems.DTO.Elvlrt.App28ElvlrtDto;
import com.actas.ems.DTO.Elvlrt.AppE038ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.Mapper.Elvlrt.AppE038ElvlrtMapper;
import com.actas.ems.Mapper.samjung.AppE038SamMapper;
import com.actas.ems.Mapper.sjilsan.AppE038SjilsanMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service("AppE038ElvlrtService")
public class AppE038ElvlrtService {

    @Autowired
    AppE038ElvlrtMapper appMapper;
    @Autowired
    AppE038SamMapper appMapperS;
    @Autowired
    AppE038SjilsanMapper appMapperSj;

    public List<AppE038ElvlrtDto> GetE038List(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return appMapper.GetE038List(parm);
            case "samjung":
                return appMapperS.GetE038List(parm);
            case "samjungilsan":
                return appMapperSj.GetE038List(parm);
            default:
                List<AppE038ElvlrtDto> object = null;
                return object;
        }

    }
    public List<AppE038ElvlrtDto> GetActList(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return appMapper.GetActList(parm);
            case "samjung":
                return appMapperS.GetActList(parm);
            case "samjungilsan":
                return appMapperSj.GetActList(parm);
            default:
                List<AppE038ElvlrtDto> object = null;
                return object;
        }
    }
    public List<AppE038ElvlrtDto> GetEqupList(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return appMapper.GetEqupList(parm);
            case "samjung":
                return appMapperS.GetEqupList(parm);
            case "samjungilsan":
                return appMapperSj.GetEqupList(parm);
            default:
                List<AppE038ElvlrtDto> object = null;
                return object;
        }
    }
    public List<AppE038ElvlrtDto> GetCarList(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return appMapper.GetCarList(parm);
            case "samjung":
                return appMapperS.GetCarList(parm);
            case "samjungilsan":
                return appMapperSj.GetCarList(parm);
            default:
                List<AppE038ElvlrtDto> object = null;
                return object;
        }
    }
    public boolean InsertE038(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return appMapper.InsertE038(parm);
            case "samjung":
                return appMapperS.InsertE038(parm);
            case "samjungilsan":
                return appMapperSj.InsertE038(parm);
            default:
                return true;
        }
    }
    public boolean UpdateE038(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return appMapper.UpdateE038(parm);
            case "samjung":
                return appMapperS.UpdateE038(parm);
            case "samjungilsan":
                return appMapperSj.UpdateE038(parm);
            default:
                return true;
        }
    }
    public boolean DeleteE038(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return appMapper.DeleteE038(parm);
            case "samjung":
                return appMapperS.DeleteE038(parm);
            case "samjungilsan":
                return appMapperSj.DeleteE038(parm);
            default:
                return true;
        }
    }
    public String getE038MaxSeq(String yyyymm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return appMapper.getE038MaxSeq(yyyymm);
            case "samjung":
                return appMapperS.getE038MaxSeq(yyyymm);
            case "samjungilsan":
                return appMapperSj.getE038MaxSeq(yyyymm);
            default:
                return "";
        }
    }
}
