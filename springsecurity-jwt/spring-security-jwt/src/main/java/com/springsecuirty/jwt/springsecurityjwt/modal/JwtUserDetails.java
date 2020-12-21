package com.springsecuirty.jwt.springsecurityjwt.modal;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * JwtUserDetails
 */
public class JwtUserDetails implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String username;
    private String token;
    private Long id;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(String userName, long id, String token, List<GrantedAuthority> grantedAuthorities) {
        this.username = userName;
        this.token = token;
        this.id = id;
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return null;
    }
}