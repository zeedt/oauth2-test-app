package com.zeed.oauth2.oauth2testapp.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    public String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
