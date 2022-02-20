package com.management.club.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {
    //폼으로 받은 회원정보를 매핑 시켜줄 객체
    private String email;
    private String name;
    private String password;
    private String auth;
}
