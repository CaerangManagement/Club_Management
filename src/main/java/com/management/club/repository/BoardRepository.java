package com.management.club.repository;

import com.management.club.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    //제목으로 검색
    Page<Board> findByTitleContaining(String title, Pageable pageable);
    //작성자로 검색
    Page<Board> findByWriterContaining(String writer, Pageable pageable);


    //상위 4개 게시물
    List<Board> findTop4ByOrderByIdDesc();


}
