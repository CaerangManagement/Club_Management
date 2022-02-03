package com.management.club.model;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //동일한 패키지 내의 클래스에서만 객체를 생성할 수 있도록 제어한다.
@Entity
public class NoticeBoard{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="noticeBoardId")
    private Long id; //

    private String title;

    private String content;

    private String writer;

    private int hits;

    @ManyToOne(fetch = FetchType.EAGER) //유저는 하나밖에없으니 기본전략은 EAGER(가져온다)
    @JoinColumn(name="userId") //UserInfo객체의 Fk가 userId라는 필드명으로 들어감.
    private UserInfo userInfo;

    private LocalDateTime createdDate = LocalDateTime.now(); //생성일

    @Builder
    public NoticeBoard(String title, String content, String writer, int hits) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
    }

    //수정된 게시물을 담을 곳
    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = LocalDateTime.now();
    }
    /**
     * 조회 수 증가
     */
    public void increaseHits() {
        this.hits++;
    }





}

