package com.springsecuirty.jwt.springsecurityjwt.security;

import java.util.Date;

import com.springsecuirty.jwt.springsecurityjwt.modal.Jwtuser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenGenerator {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    public String generate(Jwtuser jwtUser) {
        Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());
        return Jwts.builder().setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .setIssuedAt(new Date(System.currentTimeMillis())).signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }

}
