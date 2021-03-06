package com.zeed.oauth2.oauth2testapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;

@Configuration
@Order(1)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private TokenStore jdbcTokenStore;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        http.requestMatchers()
                .antMatchers("/login", "/oauth/authorize").and().authorizeRequests()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .maximumSessions(2)
                .sessionRegistry(sessionRegistry)
                .maxSessionsPreventsLogin(false)
                .and().sessionAuthenticationStrategy(new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry))
                .and()
                .formLogin().permitAll();
    }

    @Override
    @Bean(name = "userAuthenticationManager")
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);

    }

    @Bean
    @Primary
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(jdbcTokenStore);
        return defaultTokenServices;
    }
}
