package com.management.club.repository;

import com.management.club.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findByEmail(String email); //고유값인 email을통해 UserInfo객체 가져오기 
}

