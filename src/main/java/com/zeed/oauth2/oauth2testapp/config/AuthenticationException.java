package com.zeed.oauth2.oauth2testapp.config;

public class AuthenticationException extends org.springframework.security.core.AuthenticationException {

    public AuthenticationException(String msg) {
        super(msg);
    }
}
