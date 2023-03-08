package com.actas.ems.Service.elvlrt;

import com.actas.ems.DTO.Elvlrt.App10ElvlrtDto;
import com.actas.ems.DTO.Popup.PopupDto;
import com.actas.ems.DTO.TBXa012VO;
import com.actas.ems.Mapper.Elvlrt.AppPopElvlrtMapper;
import com.actas.ems.Mapper.gaon.AppPopGaonMapper;
import com.actas.ems.Mapper.kyoung.AppPopKyoungMapper;
import com.actas.ems.Mapper.nm.AppPopNmyangMapper;
import com.actas.ems.util.UIUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service("AppPopElvlrtService")
public class AppPopElvlrtService {

    @Autowired
    AppPopElvlrtMapper appPopElvMapper;
    @Autowired
    AppPopGaonMapper appPopElvMapperG;
    @Autowired
    AppPopKyoungMapper appPopElvMapperK;
    @Autowired
    AppPopNmyangMapper appPopElvMapperN;
    @Autowired
    AppPopGaonMapper appPopElvMapperH;

    /** 현장명 조회 */
    public List<PopupDto> GetActnmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetActnmList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetActnmList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetActnmList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetActnmList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetActnmList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetActnmList(parm);}
    /** 고장내용 조회 */
    public List<PopupDto> GetContnmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetContnmList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetContnmList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetContnmList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetContnmList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetContnmList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetContnmList(parm);}
    /** 고장요인 조회 */
    public List<PopupDto> GetRemonmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetRemonmList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetRemonmList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetRemonmList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetRemonmList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetRemonmList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetRemonmList(parm);}
    /** 처리내용 조회 */
    public List<PopupDto> GetResunmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetResunmList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetResunmList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetResunmList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetResunmList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetResunmList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetResunmList(parm);}
    /** 고장부위 조회 */
    public List<PopupDto> GetGreginmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetGreginmList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetGreginmList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetGreginmList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetGreginmList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetGreginmList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetGreginmList(parm);}
    /** 처리방법 조회 */
    public List<PopupDto> GetResultnmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetResultnmList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetResultnmList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetResultnmList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetResultnmList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetResultnmList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetResultnmList(parm);}
    /** 담당부서 조회 */
    public List<PopupDto> GetDivinmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetDivinmList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetDivinmList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetDivinmList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetDivinmList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetDivinmList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetDivinmList(parm);}
    /** 담당자 조회 */
    public List<PopupDto> GetPernmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetPernmList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetPernmList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetPernmList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetPernmList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetPernmList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetPernmList(parm);}

    public List<PopupDto> GetPernmList2(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetPernmList2(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetPernmList2(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetPernmList2(parm);
            case "nmyang":
                return  appPopElvMapperN.GetPernmList2(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetPernmList2(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetPernmList2(parm);}

    /** 고장원인 조회 */
    public List<PopupDto> GetFacnmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetFacnmList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetFacnmList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetFacnmList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetFacnmList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetFacnmList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetFacnmList(parm);}

    public List<PopupDto> GetEqupList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetEqupList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetEqupList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetEqupList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetEqupList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetEqupList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetEqupList(parm);}

    /** 고장부위 조회 */
    public List<PopupDto> GetGreGicdList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetGreGicdList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetGreGicdList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetGreGicdList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetGreGicdList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetGreGicdList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetGreGicdList(parm);}

    /**고장원인*/
    public List<PopupDto> GetremoList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetremoList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetremoList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetremoList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetremoList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetremoList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetremoList(parm);}

    /**처리내용*/
    public List<PopupDto> GetresunmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetresunmList2(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetresunmList2(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetresunmList2(parm);
            case "nmyang":
                return  appPopElvMapperN.GetresunmList2(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetresunmList2(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetresunmList2(parm);}
    /** 고장부위 상세조회 */
    public List<PopupDto> GetReginmList(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetReginmList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetReginmList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetReginmList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetReginmList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetReginmList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetReginmList(parm);}

    public List<PopupDto> GetPernm3List(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetPernm3List(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetPernm3List(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetPernm3List(parm);
            case "nmyang":
                return  appPopElvMapperN.GetPernm3List(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetPernm3List(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetPernm3List(parm);}
    /** 담당자2 조회 */
    public List<PopupDto> GetPernm2List(PopupDto parm){
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetPernm2List(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetPernm2List(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetPernm2List(parm);
            case "nmyang":
                return  appPopElvMapperN.GetPernm2List(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetPernm2List(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetPernm2List(parm);}

    public List<PopupDto> GetWkactList(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetWkactList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetWkactList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetWkactList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetWkactList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetWkactList(parm);
            default:
                List<PopupDto> object = null;
                return object;
        }
    }
//    {return appPopElvMapper.GetWkactList(parm);}
//   sms 정보조회 */
    public PopupDto GetSmsInfoList(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetSmsInfoList(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetSmsInfoList(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetSmsInfoList(parm);
            case "nmyang":
                return  appPopElvMapperN.GetSmsInfoList(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetSmsInfoList(parm);
            default:
                PopupDto object = null;
                return object;
        }
    }

//    {return appPopElvMapper.GetSmsInfoList(parm);}

    //   사업장 정보조회 */
    public TBXa012VO GetXa012Info(PopupDto parm) {
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                return  appPopElvMapper.GetXa012Info(parm);
            case "ELV_KYOUNG":
                return  appPopElvMapperK.GetXa012Info(parm);
            case "ELV_GAON":
                return  appPopElvMapperG.GetXa012Info(parm);
            case "nmyang":
                return  appPopElvMapperN.GetXa012Info(parm);
            case "hanyangs":
                return  appPopElvMapperH.GetXa012Info(parm);
            default:
                TBXa012VO object = null;
                return object;
        }
    }



    public int UpdateXa012(TBXa012VO parm){
        int queryResult = 1;
        String ls_dbnm = UIUtils.getElvDataSourceNm();
        switch (ls_dbnm){
            case "ELV_LRT":
                queryResult = appPopElvMapper.UpdateXa012(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                queryResult = appPopElvMapper.UpdateXa011(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_GAON":
                queryResult = appPopElvMapperG.UpdateXa012(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                queryResult = appPopElvMapperG.UpdateXa011(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "ELV_KYOUNG":
                queryResult = appPopElvMapperK.UpdateXa012(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                queryResult = appPopElvMapperK.UpdateXa011(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "nmyang":
                queryResult = appPopElvMapperN.UpdateXa012(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                queryResult = appPopElvMapperN.UpdateXa011(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            case "hanyangs":
                queryResult = appPopElvMapperH.UpdateXa012(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                queryResult = appPopElvMapperH.UpdateXa011(parm);
                if(queryResult < 1){
                    queryResult = 0;
                }
                return queryResult;
            default:
                break;
        }
        return 1;
    }





}
