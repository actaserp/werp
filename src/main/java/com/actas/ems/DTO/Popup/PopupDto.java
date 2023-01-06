package com.actas.ems.DTO.Popup;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PopupDto {
    private String frdate;        //시작일자
    private String todate;        //종료일자
    private String actcd;        //현장코드
    private String actnm;        //현장명
    private String hpno;        //핸드폰
    private String telno;        //전화번호
    private String addr;        //주소
    private String cltcd;        //거래처코드
    private String cltnm;        //거래처명
    private String contflag;        //계약구분
    
    private String actperid; //담당자코드
    private String actpernm;        //담당자
    private String contcd;        //고장내용코드
    private String contnm;        //고장내용
    private String remocd;          //고장요인코드
    private String remonm;          //고장요인

    private String faccd; //고장원인코드
    private String facnm; //고장원인
    private String resucd;          //처리내용코드
    private String resunm;          //처리내용
    private String gregicd;         //고장부위코드
    private String greginm;         //고장부위
    private String resultnm;        //처리방법
    private String resultcd;        //처리코드
    private String divicd;          //담당부서코드
    private String divinm;          //담당부서명
    private String perid;           //사원코드
    private String pernm;           //사원명
    private String rtclafi;         //재/퇴직 구분
    private String custcd;
    private String spjangcd;
    private int qty;
    private String handphone;        //처리코드

}
