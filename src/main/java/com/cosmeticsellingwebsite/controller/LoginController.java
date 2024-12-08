package com.cosmeticsellingwebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class LoginController {
    @GetMapping("/login")
    public String home() {
        return "shipper-login";
    }
}
