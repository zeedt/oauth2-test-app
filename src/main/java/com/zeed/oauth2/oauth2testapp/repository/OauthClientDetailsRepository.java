package com.zeed.oauth2.oauth2testapp.repository;

import com.zeed.oauth2.oauth2testapp.model.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthClientDetailsRepository extends JpaRepository<OauthClientDetails, Long> {

    OauthClientDetails findTopByClientId(String clientId);

}
