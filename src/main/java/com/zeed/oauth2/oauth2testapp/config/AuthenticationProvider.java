package com.zeed.oauth2.oauth2testapp.config;

import com.zeed.oauth2.oauth2testapp.model.Authority;
import com.zeed.oauth2.oauth2testapp.model.TestUser;
import com.zeed.oauth2.oauth2testapp.repository.TestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Collections;
import java.util.List;

@Configuration
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    @Autowired
    private TestUserRepository testUserRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        TestUser testUser = testUserRepository.findTopByUsername(authentication.getName());
        List<Authority> authorities = Collections.singletonList(new Authority("USER"));
        if (testUser == null) {
            throw new com.zeed.oauth2.oauth2testapp.config.AuthenticationException("User not found/Bad credentials");
        }

        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
