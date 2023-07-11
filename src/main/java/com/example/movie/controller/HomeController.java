package com.example.movie.controller;

import com.example.movie.dto.LoginForm;
import com.example.movie.dto.SearchReq;
import com.example.movie.dto.UserDto;
import com.example.movie.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private final UserService userService;


    public HomeController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/movie/user/new")
    public String newUserForm(@Valid UserDto userdto){
        userService.createUser(userdto);

        return "redirect:/";
    }
    @GetMapping("/movie/user/new")
    public String newUser(){return "signup";}

    @GetMapping("/movie/user")
    public String member(){return "login";}
    @PostMapping("/movie/user")
    public String joinMember(@Valid LoginForm loginForm){
        if (userService.join(loginForm)){return "mypage";}
        else {return "redirect:/";}
    }

}