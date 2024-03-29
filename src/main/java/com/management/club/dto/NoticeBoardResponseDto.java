package com.management.club.dto;

import com.management.club.model.Board;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NoticeBoardResponseDto {

    private Long id; // PK
    private String title; // 제목
    private String content; // 내용
    private String writer; // 작성자
    private int hits; // 조회 수
    private LocalDateTime createdDate; // 생성일
    private LocalDateTime modifiedDate; // 수정일

    public NoticeBoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.hits = entity.getHits();
        this.createdDate = entity.getCreatedDate();
    }

}
