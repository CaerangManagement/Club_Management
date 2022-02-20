package com.management.club.repository;

import com.management.club.model.NoticeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {

    //제목으로 검색
    Page<NoticeBoard> findByTitleContaining(String title, Pageable pageable);
    //작성자로 검색
    Page<NoticeBoard> findByWriterContaining(String writer, Pageable pageable);


    //상위 7개 게시물 index페이지에서 보여줄꺼
    List<NoticeBoard> findTop7ByOrderByIdDesc();
}
