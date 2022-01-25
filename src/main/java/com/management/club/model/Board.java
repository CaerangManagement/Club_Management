package com.management.club.model;



import javax.persistence.*;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //동일한 패키지 내의 클래스에서만 객체를 생성할 수 있도록 제어한다.
@Entity
public class Board{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //

    private String title;

    private String content;

    private String writer;

    private int hits;

    private char deleteYn; //삭제 여부

    private LocalDateTime createdDate = LocalDateTime.now(); //생성일

    private LocalDateTime modifiedDate; // 수정일


    @Builder
    public Board(String title, String content, String writer, int hits, char deleteYn, String fileName, MultipartFile uploadFile) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.deleteYn = deleteYn;
    }

    //수정된 게시물을 담을 곳
    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.modifiedDate = LocalDateTime.now();
    }
    /**
     * 조회 수 증가
     */
    public void increaseHits() {
        this.hits++;
    }

    /**
     * 게시글 삭제
     */
    public void delete() {
        this.deleteYn = 'Y';
    }


}
