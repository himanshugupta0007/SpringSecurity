package com.springsecuirty.jwt.springsecurityjwt.controller;

import com.springsecuirty.jwt.springsecurityjwt.modal.Jwtuser;
import com.springsecuirty.jwt.springsecurityjwt.security.JwtTokenGenerator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {
    
    @PostMapping("/")
    public String generate(@RequestBody final Jwtuser jwtUser){
        
        JwtTokenGenerator jwtGenerator = new JwtTokenGenerator();
        return jwtGenerator.generate(jwtUser);

    }
}
