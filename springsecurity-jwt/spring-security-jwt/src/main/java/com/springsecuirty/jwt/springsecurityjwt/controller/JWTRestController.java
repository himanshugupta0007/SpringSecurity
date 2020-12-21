package com.springsecuirty.jwt.springsecurityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JWTRestController
 */
@RestController
@RequestMapping("/jwt")
public class JWTRestController {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello";
    }
    
}