package com.zeed.oauth2.oauth2testapp.service;

import com.zeed.oauth2.oauth2testapp.repository.OauthClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class OauthClientDetailsService implements ClientDetailsService {


    @Autowired
    private OauthClientDetailsRepository clientDetailsRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        return clientDetailsRepository.findTopByClientId(s);
    }
}
