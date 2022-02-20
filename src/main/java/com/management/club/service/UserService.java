package com.management.club.service;

import com.management.club.dto.UserInfoDto;
import com.management.club.model.UserInfo;
import com.management.club.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Spring Security 필수 메소드 구현
     *
     * @param email 이메일
     * @return UserDetails 를 implements 한 UserInfo
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
    @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    public UserInfo loadUserByUsername(String email) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return userRepository.findByEmail(email);
                //.orElseThrow(() -> new UsernameNotFoundException((email)));
    }

    public Long save(UserInfoDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return userRepository.save(UserInfo.builder()
                .email(infoDto.getEmail())
                .name(infoDto.getName())
                .auth(infoDto.getAuth())
                .password(infoDto.getPassword()).build()).getCode(); //고유값인 code를 리턴
    }

    public int userIdCheck(String email){
        if(email.isEmpty()){
            return 3;
        }
        if (userRepository.existsByEmail(email)){
            return 1;
        }
        else{
            return 2;
        }

    }

//    public int userIdCheck(String user_id) {
//
//        userDao = userSqlSessin.getMapper(UserDaoInterface.class);
//
//        return userDao.checkOverId(user_id);
//    }
}



