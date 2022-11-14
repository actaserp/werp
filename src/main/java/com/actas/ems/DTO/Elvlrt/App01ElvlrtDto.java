package com.actas.ems.DTO.Elvlrt;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class App01ElvlrtDto {
    /** callflag  */
    private String callflag;
    /** 콜 아이디  */
    private String calluserid;
    /** 콜 패스워드  */
    private String calluserpw;



}
