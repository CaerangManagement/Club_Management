package com.management.club.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    @ManyToOne //여러개의 답글은 하나의 게시글에 등록될수있다.
    @JoinColumn(name = "boardId") //Reply 테이블과 연관관계의 주인
    private Board board;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserInfo userInfo;

    @CreationTimestamp
    private Timestamp createDate;

}
