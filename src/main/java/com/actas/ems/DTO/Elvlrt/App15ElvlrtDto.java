package com.actas.ems.DTO.Elvlrt;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class App15ElvlrtDto {

    private String comp1;
    private String comp2;
    private String comp3;
    private String comp4;
    private String comp5;
    private String comp6;
    private String comp7;
    private String comp8;
    private String comp9;
    private String comp10;
    private String comp11;
    private String comp12;
    private String frdate;
    private String todate;
    private String actcd;
    private String equpcd;
    private int qty;
    private String equpnm;


    //메인화면 당월점검현황
    private String plandate;
    private String plantime;
    private String actnm;
    private String gubun;
    private String kcpernm;
    private String remark;
    private String kcspnm;


    //메인화면 계약만료현장
    private String contdate;
    private String stdate;
    private String enddate;

    // 메인화면 고장다발현장
    private String pernm;
    private String contnm;
    private String contents;

    //고객메인화면 고장다발현장그래프
    private int cnt;






}
