package com.management.club.config;

import com.management.club.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@RequiredArgsConstructor
@EnableWebSecurity // 1
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { // 2

    private final UserService userService; // 3

    /* 로그인 실패 핸들러 의존성 주입 */ 
    private final AuthenticationFailureHandler customFailurHandler;

    @Override
    public void configure(WebSecurity web) { // 4
        web.ignoring().antMatchers("/bxslider-4-4.2.12/**", "/css/**", "/js/**", "/img/**", "/summernote/**", "/OwlCarousel2-2.3.4/**","/error");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { // 5
        http
//                .csrf().disable()
//                .headers().frameOptions().disable();
                .authorizeRequests() // 6
                .antMatchers("/login/**", "/signup", "/index/**", "/intro", "/user/**", "/auth/**","/test").permitAll()
                .antMatchers("/").hasRole("USER") // USER, ADMIN만 접근 가능
                .antMatchers("/member/**", "/notice/board/add", "/notice/board/modify/**").hasRole("ADMIN") // ADMIN만 접근 가능
                .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
                .and()
                .formLogin() // 7
                .loginPage("/login") // 로그인 페이지 링크
                .failureHandler(customFailurHandler) //로그인 실패 핸들러
                .defaultSuccessUrl("/index") // 로그인 성공 후 리다이렉트 주소
                .and()
                .logout() // 8
                .logoutSuccessUrl("/index") // 로그아웃 성공시 리다이렉트 주소
                .invalidateHttpSession(true); // 세션 초기화
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { // 9
                auth.userDetailsService(userService)
                // 해당 서비스(userService)에서는 UserDetailsService를 implements해서
                // loadUserByUsername() 구현해야함 (서비스 참고)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
