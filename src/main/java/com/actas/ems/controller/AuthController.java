package com.actas.ems.controller;

import com.actas.ems.DTO.UserFormDto;
import com.actas.ems.Entity.User;
import com.actas.ems.Service.auth.AuthService;
import com.actas.ems.auth.PrincipalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/auth")
@Controller
@RequiredArgsConstructor
public class AuthController {
    UserFormDto userformDto = new UserFormDto();
    @GetMapping(value="/cltcdnew")
    public String memberForm(Model model){
        userformDto.setFlag("AA");
        model.addAttribute("userFormDto", userformDto);
        return "register";
    }
    @GetMapping(value="/actcdnew")
    public String memberActcdForm(Model model){
        userformDto.setFlag("CC");
        model.addAttribute("userFormDto", userformDto);
        return "registeractcd";
    }



}
