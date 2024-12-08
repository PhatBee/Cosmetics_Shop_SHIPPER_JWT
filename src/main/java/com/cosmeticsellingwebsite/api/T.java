package com.cosmeticsellingwebsite.api;

import com.cosmeticsellingwebsite.util.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/t")
public class T {
    @GetMapping("")
    public String t(Principal principal){
        Logger.log( principal.getName());
        Logger.log(principal.toString());
        return "t";
    }
}
