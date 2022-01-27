package com.management.club.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //동일한 패키지 내의 클래스에서만 객체를 생성할 수 있도록 제어한다.
@Entity
public class Board{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="boardId")
    private Long id; //

    private String title;

    private String content;

    private String writer;

    private int hits;

    @ManyToOne(fetch = FetchType.EAGER) //유저는 하나밖에없으니 기본전략은 EAGER(가져온다)
    @JoinColumn(name="userId") //UserInfo객체의 Fk가 userId라는 필드명으로 들어감.
    private UserInfo userInfo;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //mappedBy가 있으면 연관관계의 주인이 아니다. (Fk가 아니다) reply 테이블에 board가 Fk임.
    @JsonIgnoreProperties({"board"}) //reply Entity에서 다시 board를 참조하는 것을 막아 무한참조를 방지함.
    @OrderBy("id desc")
    private List<Reply> replies; //board를 select할때 join해서 reply를 얻기위한 변수

    private LocalDateTime createdDate = LocalDateTime.now(); //생성일

    @Builder
    public Board(String title, String content, String writer, int hits) {
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
