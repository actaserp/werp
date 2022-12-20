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
    private String actpernm;        //담당자
    private String contcd;        //고장내용코드
    private String contnm;        //고장내용

}