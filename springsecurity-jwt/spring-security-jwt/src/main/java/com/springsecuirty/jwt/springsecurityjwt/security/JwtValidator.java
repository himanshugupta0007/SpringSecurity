package com.springsecuirty.jwt.springsecurityjwt.security;

import java.util.Date;

import com.springsecuirty.jwt.springsecurityjwt.modal.Jwtuser;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

    private String secret = "youtube";

    
    /** 
     * @param token
     * @return Jwtuser
     */
    public Jwtuser validate(String token) {
        Jwtuser jwtUser = null;
        try {
            Claims body = getTokenBody(token);
            jwtUser = new Jwtuser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        } catch (Exception e) {
            jwtUser = null;
        }
        return jwtUser;
    }

    
    /** 
     * @param token
     * @return Boolean
     */
    public Boolean isTokenExpired(String token) {
        final Date expiration = getTokenBody(token).getExpiration();
        return expiration.before(new Date());
    }

    
    /** 
     * @param token
     * @return Claims
     */
    private Claims getTokenBody(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}
