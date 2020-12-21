package com.springsecuirty.jwt.springsecurityjwt.security;

import java.util.List;

import com.springsecuirty.jwt.springsecurityjwt.modal.JwtAuthenticationToken;
import com.springsecuirty.jwt.springsecurityjwt.modal.JwtUserDetails;
import com.springsecuirty.jwt.springsecurityjwt.modal.Jwtuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator jwtValidator;

    @Override
    public boolean supports(Class<?> arg0) {
        return (JwtAuthenticationToken.class.isAssignableFrom(arg0));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {}

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken passwordToken)
            throws AuthenticationException {
        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) passwordToken;
        String token = jwtToken.getToken();

        Jwtuser jwtUser = jwtValidator.validate(token);
        if (jwtUser == null) {
            throw new RuntimeException("JWT user is incorrect");
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(jwtUser.getRole());

        return new JwtUserDetails(jwtUser.getUserName(), jwtUser.getId(), token, grantedAuthorities);
    }

}
