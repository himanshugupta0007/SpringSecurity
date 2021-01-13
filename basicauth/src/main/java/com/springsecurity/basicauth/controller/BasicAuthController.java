package com.springsecurity.basicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class BasicAuthController {
    
    @GetMapping("/role/user")
    public String getBasicAuthUserRole(){
        return "ROLE_USER";
    }
}
