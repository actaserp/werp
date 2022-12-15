package com.actas.ems.controller;


import com.actas.ems.DTO.CommonDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class MainController {
    protected Log log =  LogFactory.getLog(this.getClass());
    CommonDto CommDto = new CommonDto();

    //@GetMapping({"","/"})
    @RequestMapping(value = {"", "/"}, method = {RequestMethod.GET})
    public  String index(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String select){
        //머스테치 기본폴더 src/main/resources/
        //머스테치 뷰리졸버 기본설정 templates(prefix), .mustache(suffix)   생략가능


        req.setAttribute("select", select);




        return "/loginForm"; //"index";

    }




    @GetMapping(value = "/mainframe")
    public  String main(){
        return "mainframe";
    }


    @GetMapping(value="/logout")
    public String logoutMember(){
        return "/logoutForm";
    }



}
