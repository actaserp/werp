package com.actas.ems.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AppAdmin01Dto {

    private String custcd;
    private String spjangcd;

    //공통 회사코드, 사업장코드
    private String mseq;
    private String minputdate;
    private String mgourpcd;
    private String msubject;
    private String mfilename;
    private String mpernm;
    private String memo;
    private String mflag;

    //부품 메뉴얼 dto

    private String dseq;
    private String dinputdate;
    private String dgourpcd;
    private String dsubject;
    private String dfilename;
    private String dpernm;
    private String dmemo;
    private String dflag;


    //부품 메뉴얼 eto

    private String eseq;
    private String einputdate;
    private String egroupcd;
    private String esubject;
    private String efilename;
    private String epernm;
    private String ememo;
    private String eflag;

    //
    private String setflag;

//공통
    private String yyyymm;
    private String cnam;
    private int attcnt;



}
