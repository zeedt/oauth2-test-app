package com.zeed.oauth2.oauth2testapp.repository;

import com.zeed.oauth2.oauth2testapp.model.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends JpaRepository<TestUser, Long> {

    TestUser findTopByUsername(String username);

}
