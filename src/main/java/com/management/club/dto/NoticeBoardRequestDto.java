package com.management.club.dto;

import com.management.club.model.NoticeBoard;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeBoardRequestDto {

    private String title; // 제목
    private String content; // 내용

    public NoticeBoard toEntity() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        //작성자는 spring security에서 email을 가져옴.

        return NoticeBoard.builder()
                .title(title)
                .content(content)
                .writer(username)
                .hits(0)
                .build();

    }
}
