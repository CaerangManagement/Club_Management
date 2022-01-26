package com.management.club.repository;

import com.management.club.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {


    UserInfo findByEmail(String email); //고유값인 email을통해 UserInfo객체 가져오기

    boolean existsByEmail(String email);


}

