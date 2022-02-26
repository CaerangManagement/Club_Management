package com.management.club.dto;

import com.management.club.model.Board;
import com.management.club.model.UserInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequestDto {

    private String title; // 제목
    private String content; // 내용

    public Board toEntity() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = (UserInfo) authentication.getPrincipal();
        String writer = userInfo.getName();


        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .hits(0)
                .build();

    }


}
