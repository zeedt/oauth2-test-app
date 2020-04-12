package com.zeed.oauth2.oauth2testapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCOntroller {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
