package com.example.springbootstrap312.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String startPage() {
        System.out.println("Login Page opening..");
        return "login";
    }
}
