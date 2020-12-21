package com.springsecuirty.jwt.springsecurityjwt.security;

import com.springsecuirty.jwt.springsecurityjwt.modal.Jwtuser;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

    private String secret = "youtube";

    public Jwtuser validate(String token){
        Jwtuser jwtUser = null;
        try {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        jwtUser = new Jwtuser();
        jwtUser.setUserName(body.getSubject());
        jwtUser.setId(Long.parseLong((String) body.get("userId")));
        jwtUser.setRole((String)body.get("role"));
        } catch (Exception e) {
            jwtUser = null;
        }
        return jwtUser;
    }

}
