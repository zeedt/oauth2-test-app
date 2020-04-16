package com.zeed.oauth2.oauth2testapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MyController {

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }

}
