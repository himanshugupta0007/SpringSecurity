package com.springsecuirty.jwt.springsecurityjwt.modal;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    /**
     * @return String
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return Object
     */
    @Override
    public Object getCredentials() {
        return null;
    }

    /**
     * @return Object
     */
    @Override
    public Object getPrincipal() {
        return null;
    }

}
