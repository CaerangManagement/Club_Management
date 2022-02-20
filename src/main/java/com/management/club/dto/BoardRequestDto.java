package com.management.club.dto;

import com.management.club.model.Board;
import lombok.*;
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
        String username = authentication.getName();
        //작성자는 spring security에서 email을 가져옴.

        return Board.builder()
                .title(title)
                .content(content)
                .writer(username)
                .hits(0)
                .build();

    }


}
